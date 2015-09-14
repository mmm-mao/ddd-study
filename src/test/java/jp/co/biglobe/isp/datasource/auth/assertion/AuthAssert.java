package jp.co.biglobe.isp.datasource.auth.assertion;

import jp.co.biglobe.isp.datasource.auth.fixture.FixtureAuth;
import jp.co.biglobe.isp.datasource.credit_card.fixture.FixtureCredit;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import jp.co.biglobe.test.util.dbunit.assertion.DatabaseAssert;

import java.util.Map;

public class AuthAssert {

    private DbUnitTester dbUnitTester;

    private final String[] sortColumns = new String[]{FixtureAuth.AUTH_EVENT_ID};

    String[] excludeColumns = new String[]{FixtureAuth.SYSTEM_RECEIPT_DATE_TIME};

    public AuthAssert(DbUnitTester dbUnitTester) {
        this.dbUnitTester = dbUnitTester;
    }

    public void assertTableWithAllColumns(Map expectedData) throws Exception {
        assertRegister(expectedData);
    }

    private void assertRegister(Map expectedData) throws Exception {
        DatabaseAssert databaseAssert = new DatabaseAssert(dbUnitTester.getConnection());
        databaseAssert.assertTableWithExcludeColumns(expectedData, FixtureAuth.AUTH_TABLE_NAME, sortColumns, excludeColumns);
    }




}
