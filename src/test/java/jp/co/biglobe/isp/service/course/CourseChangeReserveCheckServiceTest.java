package jp.co.biglobe.isp.service.course;


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
import jp.co.biglobe.isp.domain.auth.UserPassword;
import jp.co.biglobe.isp.domain.auth.ValidAuth;
import jp.co.biglobe.isp.domain.course.CourseName;
import jp.co.biglobe.isp.domain.course.CurrentCourse;
import jp.co.biglobe.isp.domain.course.change_reserve.ChangeReserveCourse;
import jp.co.biglobe.isp.domain.credit_card.CreditCard;
import jp.co.biglobe.isp.domain.credit_card.CreditCardNumber;
import jp.co.biglobe.isp.domain.credit_card.EffectiveMonth;
import jp.co.biglobe.isp.domain.credit_card.SecurityNumber;
import jp.co.biglobe.isp.domain.member.UserId;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.HopeMailAddress;
import jp.co.biglobe.isp.domain.member.member_life_cycle.sign_up.SignUpRequest;
import jp.co.biglobe.isp.domain.member_profile.profile.*;
import jp.co.biglobe.isp.domain.member_profile.profile.address.Address;
import jp.co.biglobe.isp.domain.member_profile.profile.address.AddressText;
import jp.co.biglobe.isp.domain.member_profile.profile.address.ZipCode;
import jp.co.biglobe.isp.domain.member_profile.profile.phone_number.ContractPhoneNumber;
import jp.co.biglobe.isp.domain.member_profile.profile.phone_number.DaytimePhoneNumber;
import jp.co.biglobe.isp.domain.member_profile.profile.phone_number.PhoneNumber;
import jp.co.biglobe.isp.service.member.SignUpService;
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
public class CourseChangeReserveCheckServiceTest {

    @Autowired
    public DbUnitTester tester;

    @Autowired
    private CourseChangeReserveCheckService courseChangeReserveCheckService;



    @Test
    public void 違うコースへの変更なのでOK() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.入会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());
        tester.cleanInsertQuery(FixtureCourse.One.受付済み());


        ValidAuth validAuth = new ValidAuth(new UserId("abc12345"), new UserPassword("password"));
        ChangeReserveCourse changeReserveCourse = new ChangeReserveCourse(CourseName.ニコニコ);


        courseChangeReserveCheckService.検証する(validAuth, changeReserveCourse);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void 同じコースへの変更なのでNG() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.入会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());
        tester.cleanInsertQuery(FixtureCourse.One.受付済み());

        ValidAuth validAuth = new ValidAuth(new UserId("abc12345"), new UserPassword("password"));
        ChangeReserveCourse changeReserveCourse = new ChangeReserveCourse(CourseName.ベーシック);


        courseChangeReserveCheckService.検証する(validAuth, changeReserveCourse);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void 退会済みなのでNG() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.退会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());
        tester.cleanInsertQuery(FixtureCourse.One.受付済み());

        ValidAuth validAuth = new ValidAuth(new UserId("abc12345"), new UserPassword("password"));
        ChangeReserveCourse changeReserveCourse = new ChangeReserveCourse(CourseName.ベーシック);


        courseChangeReserveCheckService.検証する(validAuth, changeReserveCourse);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void コース変更予約中なのでNG() throws Exception {

        tester.cleanInsertQuery(FixtureAuth.One.登録済み());
        tester.cleanInsertQuery(FixtureMember.One.入会済み());
        tester.cleanInsertQuery(FixtureCredit.One.有効で登録済み());
        tester.cleanInsertQuery(FixtureCourse.Two.コース変更予約中());

        ValidAuth validAuth = new ValidAuth(new UserId("abc12345"), new UserPassword("password"));
        ChangeReserveCourse changeReserveCourse = new ChangeReserveCourse(CourseName.ベーシック);


        courseChangeReserveCheckService.検証する(validAuth, changeReserveCourse);

    }




}
