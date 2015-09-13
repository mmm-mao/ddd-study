package jp.co.biglobe.test.util.dbunit;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.SortedTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DbUnitTester {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Autowired
    private DbUnitTesterProperty dbUnitTesterProperty;

    private DbConnector dbConnector;

    private TestDataMaker testDataMaker;


    /**
     * コネクションオブジェクトを取得する
     *
     * @return IDatabaseConnection
     * @throws Exception
     */
    public IDatabaseConnection getConnection() throws Exception {
        return dbConnector.getDbConnection();
    }

    /**
     * オブジェクト生成後の初期化処理
     */
    @PostConstruct
    public void init() {
        this.dbConnector = new DbConnector(dataSource, dbUnitTesterProperty);
        this.testDataMaker = new TestDataMaker(dbConnector);
    }

    /**
     * 対象のMapオブジェクトをInsertする
     * @param sqlByXml
     */
    public void cleanInsertQuery(Map sqlByXml) {

        try {
            for (String tableName : ((Map<String, Map>) sqlByXml).keySet()) {
                Map w = ((Map<String, Map>) sqlByXml).get(tableName);
                for (Object o : w.keySet()) {
                    Map<String, String> d = (Map<String, String>) w.get(o);
                }
            }
            execute(sqlByXml);
            return;
        } catch (ClassCastException | SQLException | DatabaseUnitException e) {
            // Continue
        }
        testDataMaker.cleanInsertQuery(sqlByXml);
    }

    private void execute(Map sqlByXml) throws SQLException, DatabaseUnitException {
        Connection conn = null;
        try {
            conn = this.dbConnector.getDbConnection().getConnection();
            conn.setAutoCommit(false);
            execute(conn, sqlByXml);
            conn.commit();
        } finally {
            if (conn != null) {
                conn.rollback();
                conn.close();
            }
        }
    }

    private void execute(Connection conn, Map sqlByXml) throws DatabaseUnitException, SQLException {
        for (String tableName : ((Map<String, Map>) sqlByXml).keySet()) {
            Map w = ((Map<String, Map>) sqlByXml).get(tableName);
            for (Object o : w.keySet()) {
                Map<String, String> columnMap = (Map<String, String>) w.get(o);
                execute(conn, tableName, columnMap);
            }
        }
    }

    private void execute(Connection conn, String tableName, Map<String, String> columnMap) throws SQLException {
        StringBuilder enumColumn = new StringBuilder();
        StringBuilder enumValue = new StringBuilder();
        for (String column : columnMap.keySet()) {
            if (enumColumn.length() > 0) {
                enumColumn.append(',');
                enumValue.append(',');
            }
            enumColumn.append(column);
            if(columnMap.get(column) != null){
                enumValue.append("'");
                enumValue.append(columnMap.get(column));
                enumValue.append("'");
            }
        }
        String sql = "INSERT INTO " + tableName + " ( " + enumColumn + " ) VALUES ( " + enumValue + " )";
        conn.createStatement().execute(sql);
    }


}
