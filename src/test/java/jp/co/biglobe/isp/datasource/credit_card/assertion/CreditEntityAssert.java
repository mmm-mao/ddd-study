package jp.co.biglobe.isp.datasource.credit_card.assertion;

import jp.co.biglobe.isp.datasource.credit_card.fixture.FixtureCredit;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import jp.co.biglobe.test.util.dbunit.assertion.DatabaseAssert;

import java.util.Map;

public class CreditEntityAssert {

    private DbUnitTester dbUnitTester;

    private final String[] sortColumns = new String[]{FixtureCredit.CREDIT_CARD_NUMBER};

    String[] excludeColumns = new String[]{FixtureCredit.SYSTEM_RECEIPT_DATE_TIME};

    public CreditEntityAssert(DbUnitTester dbUnitTester) {
        this.dbUnitTester = dbUnitTester;
    }

    public void assertTableWithAllColumns(Map expectedData) throws Exception {
        assertReceipt(expectedData);
    }

    private void assertReceipt(Map expectedData) throws Exception {
        DatabaseAssert databaseAssert = new DatabaseAssert(dbUnitTester.getConnection());
        databaseAssert.assertTableWithExcludeColumns(expectedData, FixtureCredit.REGISTER_TABLE_NAME, sortColumns, excludeColumns);
    }

//    private void assertOk(Map expectedData) throws Exception {
//        DatabaseAssert databaseAssert = new DatabaseAssert(dbUnitTester.getConnection());
//        databaseAssert.assertTableWithExcludeColumnsOrNoCount(
//                FixtureNewOrderEntity.OK_TABLE_NAME, FixtureNewOrderEntity.Nothing.受付結果OKイベントなし(), expectedData, sortColumns, excludeColumns);
//    }


}
