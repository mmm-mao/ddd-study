package jp.co.biglobe.isp.datasource.member.assertion;

import jp.co.biglobe.isp.datasource.member.fixture.FixtureMember;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import jp.co.biglobe.test.util.dbunit.assertion.DatabaseAssert;

import java.util.Map;

public class MemberAssert {

    private DbUnitTester dbUnitTester;

    private final String[] sortColumns = new String[]{FixtureMember.USER_ID};

    String[] excludeColumns = new String[]{FixtureMember.SYSTEM_RECEIPT_DATE_TIME};

    public MemberAssert(DbUnitTester dbUnitTester) {
        this.dbUnitTester = dbUnitTester;
    }

    public void assertTableWithAllColumns(Map expectedData) throws Exception {
        assertRegister(expectedData);
        assertValidRegister(expectedData);
    }

    private void assertRegister(Map expectedData) throws Exception {
        DatabaseAssert databaseAssert = new DatabaseAssert(dbUnitTester.getConnection());
        databaseAssert.assertTableWithExcludeColumns(expectedData, FixtureMember.SIGN_UP_TABLE_NAME, sortColumns, excludeColumns);
    }

    private void assertValidRegister(Map expectedData) throws Exception {
        DatabaseAssert databaseAssert = new DatabaseAssert(dbUnitTester.getConnection());
        databaseAssert.assertTableWithExcludeColumnsOrNoCount(FixtureMember.WITHDRAW_TABLE_NAME, FixtureMember.Nothing.退会イベントなし(), expectedData,  sortColumns, excludeColumns);
    }


}
