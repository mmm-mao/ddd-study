package jp.co.biglobe.test.util.dbunit;

import jp.co.biglobe.test.util.dbunit.xml.Fixture;
import org.dbunit.AbstractDatabaseTester;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.SortedTable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * DBにテストデータを格納したり、取得する
 */
public class TestDataMaker extends AbstractDatabaseTester {

    private final DbConnector dbConnector;

    public TestDataMaker(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public IDatabaseConnection getConnection() throws Exception {
        return this.dbConnector.getDbConnection();
    }

    /**
     * Map型のデータをデータベースに格納する。
     * @param sqlByXml
     */
    public void cleanInsertQuery(Map sqlByXml) {

        InputSource is = new InputSource(new StringReader(Fixture.convertXmlFormat(sqlByXml)));
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        builder.setColumnSensing(true);

        try {
            ReplacementDataSet replacementDataSet = new ReplacementDataSet(builder.build(is));
            replacementDataSet.addReplacementObject("null", null);
            setDataSet(replacementDataSet);
            setSetUpOperation(DatabaseOperation.INSERT);
            onSetup();
            closeConnection(dbConnector.getDbConnection());
        } catch (DataSetException e) {
            throw new RuntimeException(e.getMessage() + e.getCause() + e.getStackTrace());
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage() + e.getSQLState() + e.getCause());
        } catch (DatabaseUnitException e) {
            throw new RuntimeException(e.getMessage() + e.getCause() + e.getStackTrace());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() + e.getCause() + e.getStackTrace());
        }
    }

}
