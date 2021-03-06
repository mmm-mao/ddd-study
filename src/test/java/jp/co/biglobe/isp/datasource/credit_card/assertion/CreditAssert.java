package jp.co.biglobe.isp.datasource.credit_card.assertion;

import jp.co.biglobe.isp.datasource.credit_card.fixture.FixtureCredit;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import jp.co.biglobe.test.util.dbunit.assertion.DatabaseAssert;

import java.util.Map;

public class CreditAssert {

    private DbUnitTester dbUnitTester;

    private final String[] sortColumns = new String[]{FixtureCredit.CREDIT_CARD_NUMBER};

    String[] excludeColumns = new String[]{FixtureCredit.SYSTEM_RECEIPT_DATE_TIME};

    public CreditAssert(DbUnitTester dbUnitTester) {
        this.dbUnitTester = dbUnitTester;
    }

    public void assertTableWithAllColumns(Map expectedData) throws Exception {
        assertRegister(expectedData);
        assertValidRegister(expectedData);
    }

    private void assertRegister(Map expectedData) throws Exception {
        DatabaseAssert databaseAssert = new DatabaseAssert(dbUnitTester.getConnection());
        databaseAssert.assertTableWithExcludeColumns(expectedData, FixtureCredit.REGISTER_TABLE_NAME, sortColumns, excludeColumns);
    }

    private void assertValidRegister(Map expectedData) throws Exception {
        DatabaseAssert databaseAssert = new DatabaseAssert(dbUnitTester.getConnection());
        databaseAssert.assertTableWithExcludeColumns(expectedData, FixtureCredit.VALID_TABLE_NAME, sortColumns, excludeColumns);
    }



}
