package jp.co.biglobe.isp.datasource.member_profile.assertion;

import jp.co.biglobe.isp.datasource.member_profile.fixture.FixtureMemberProfile;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import jp.co.biglobe.test.util.dbunit.assertion.DatabaseAssert;

import java.util.Map;

public class MemberProfileAssert {

    private DbUnitTester dbUnitTester;

    private final String[] sortProfileColumns = new String[]{FixtureMemberProfile.REGISTER_EVENT_ID};

    private final String[] sortMailAddressColumns = new String[]{FixtureMemberProfile.MAIL_ADDRESS_REGISTER_EVENT_ID};

    String[] excludeColumns = new String[]{FixtureMemberProfile.SYSTEM_RECEIPT_DATE_TIME};

    public MemberProfileAssert(DbUnitTester dbUnitTester) {
        this.dbUnitTester = dbUnitTester;
    }

    public void assertTableWithAllColumns(Map expectedData) throws Exception {
        assertProfileRegister(expectedData);
        assertMailAddressRegister(expectedData);
    }

    private void assertProfileRegister(Map expectedData) throws Exception {
        DatabaseAssert databaseAssert = new DatabaseAssert(dbUnitTester.getConnection());
        databaseAssert.assertTableWithExcludeColumns(expectedData, FixtureMemberProfile.REGISTER_TABLE_NAME, sortProfileColumns, excludeColumns);
    }

    private void assertMailAddressRegister(Map expectedData) throws Exception {
        DatabaseAssert databaseAssert = new DatabaseAssert(dbUnitTester.getConnection());
        databaseAssert.assertTableWithExcludeColumns(expectedData, FixtureMemberProfile.MAIL_ADDRESS_REGISTER_TABLE_NAME, sortMailAddressColumns, excludeColumns);
    }




}
