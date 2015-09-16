package jp.co.biglobe.isp.service.member;


import jp.co.biglobe.isp.datasource.auth.assertion.AuthAssert;
import jp.co.biglobe.isp.datasource.auth.fixture.FixtureAuth;
import jp.co.biglobe.isp.datasource.course.assertion.CourseAssert;
import jp.co.biglobe.isp.datasource.course.fixture.FixtureCourse;
import jp.co.biglobe.isp.datasource.credit_card.assertion.CreditAssert;
import jp.co.biglobe.isp.datasource.credit_card.fixture.FixtureCredit;
import jp.co.biglobe.isp.datasource.member.assertion.MemberAssert;
import jp.co.biglobe.isp.datasource.member.fixture.FixtureMember;
import jp.co.biglobe.isp.datasource.member_profile.assertion.MemberProfileAssert;
import jp.co.biglobe.isp.datasource.member_profile.fixture.FixtureMemberProfile;
import jp.co.biglobe.isp.domain.auth.Password;
import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.course.CourseName;
import jp.co.biglobe.isp.domain.course.CurrentCourse;
import jp.co.biglobe.isp.domain.credit_card.*;
import jp.co.biglobe.isp.domain.member.BiglobeId;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.HopeMailAddress;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.SignUpRequest;
import jp.co.biglobe.isp.domain.member_profile.profile.*;
import jp.co.biglobe.isp.domain.member_profile.profile.address.Address;
import jp.co.biglobe.isp.domain.member_profile.profile.address.AddressText;
import jp.co.biglobe.isp.domain.member_profile.profile.address.ZipCode;
import jp.co.biglobe.isp.domain.member_profile.profile.phone_number.ContractPhoneNumber;
import jp.co.biglobe.isp.domain.member_profile.profile.phone_number.DaytimePhoneNumber;
import jp.co.biglobe.isp.domain.member_profile.profile.phone_number.PhoneNumber;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.YearMonth;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
@Sql(scripts = {
        "/sql/drop-tables.sql",
        "/db/V1_create-schema.sql",
}, config = @SqlConfig(encoding = "UTF-8"))
public class SignUpServiceTest {

    @Autowired
    public DbUnitTester tester;

    @Autowired
    private SignUpService signUpService;


    @Test
    public void 審査OKで入会する() throws Exception {

        SignUpRequest signUpRequest = new SignUpRequest(
                new Profile(
                        new Name("テスト　太郎"),
                        new NameKana("てすと　たろう"),
                        Gender.男性,
                        new Birthday(LocalDate.of(1980, 1, 1)),
                        new Address(new ZipCode("251-0043"), new AddressText("神奈川県川崎幸区２−９−１５")),
                        new PhoneNumber(new ContractPhoneNumber("090-1234-5678"), new DaytimePhoneNumber("090-1234-5678"))
                ),
                new CreditCard(
                        new CreditCardNumber("111-111-1111"),
                        new EffectiveMonth(YearMonth.now()),
                        new SecurityNumber(123456789)
                ),
                new CurrentCourse(CourseName.ベーシック),
                new HopeMailAddress("test-mail")
        );


        ValidAuth actual =  signUpService.受け付ける(signUpRequest);

        assertThat(actual, is(new ValidAuth(new BiglobeId("abc12345"), new Password("password"))));

        MemberAssert memberAssert = new MemberAssert(tester);
        memberAssert.assertTableWithAllColumns(FixtureMember.One.入会済み());

        MemberProfileAssert memberProfileAssert = new MemberProfileAssert(tester);
        memberProfileAssert.assertTableWithAllColumns(FixtureMemberProfile.One.登録済み());

        CreditAssert creditAssert = new CreditAssert(tester);
        creditAssert.assertTableWithAllColumns(FixtureCredit.One.有効で登録済み());

        CourseAssert courseAssert = new CourseAssert(tester);
        courseAssert.assertTableWithAllColumns(FixtureCourse.One.受付済み());

        AuthAssert authAssert = new AuthAssert(tester);
        authAssert.assertTableWithAllColumns(FixtureAuth.One.登録済み());
    }


    @Test(expected = UnsupportedOperationException.class)
    public void _２０歳未満のため審査NG() throws Exception {

        SignUpRequest signUpRequest = new SignUpRequest(
                new Profile(
                        new Name("テスト　太郎"),
                        new NameKana("てすと　たろう"),
                        Gender.男性,
                        new Birthday(LocalDate.of(2015, 1, 1)),
                        new Address(new ZipCode("251-0043"), new AddressText("神奈川県川崎幸区２−９−１５")),
                        new PhoneNumber(new ContractPhoneNumber("090-1234-5678"), new DaytimePhoneNumber("090-1234-5678"))
                ),
                new CreditCard(
                        new CreditCardNumber("111-111-1111"),
                        new EffectiveMonth(YearMonth.now()),
                        new SecurityNumber(123456789)
                ),
                new CurrentCourse(CourseName.ベーシック),
                new HopeMailAddress("test-mail")
        );


        signUpService.受け付ける(signUpRequest);

    }

}
