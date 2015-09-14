package jp.co.biglobe.isp.datasource.course.assertion;

import jp.co.biglobe.isp.datasource.course.fixture.FixtureCourse;
import jp.co.biglobe.test.util.dbunit.DbUnitTester;
import jp.co.biglobe.test.util.dbunit.assertion.DatabaseAssert;

import java.util.Map;

public class CourseAssert {

    private DbUnitTester dbUnitTester;

    private final String[] sortColumns = new String[]{FixtureCourse.EVENT_ID};

    String[] excludeColumns = new String[]{FixtureCourse.SYSTEM_RECEIPT_DATE_TIME};

    public CourseAssert(DbUnitTester dbUnitTester) {
        this.dbUnitTester = dbUnitTester;
    }

    public void assertTableWithAllColumns(Map expectedData) throws Exception {
        assertReceipt(expectedData);
    }

    private void assertReceipt(Map expectedData) throws Exception {
        DatabaseAssert databaseAssert = new DatabaseAssert(dbUnitTester.getConnection());
        databaseAssert.assertTableWithExcludeColumns(expectedData, FixtureCourse.RECEIPT_TABLE_NAME, sortColumns, excludeColumns);
    }




}
