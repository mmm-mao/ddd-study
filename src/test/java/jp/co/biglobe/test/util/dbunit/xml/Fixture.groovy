package jp.co.biglobe.test.util.dbunit.xml

import com.rits.cloning.Cloner

class Fixture {

    public static String convertXmlFormat(final Map fixture){

        def sqlXml = "<dataset>"
        fixture.collect {table->
            table.value.collect{count->
                sqlXml <<= "<" + table.key
                count.value.collect{line->
                    sqlXml <<= " $line.key =\"$line.value\""
                }
                sqlXml <<= "/>"
            }
        }


        sqlXml <<= "</dataset>"
        return sqlXml
    }

    public static Map changeValueForString(final Map fixture, FixtureChangeTarget target, String afterValue){

        Cloner cloner = new Cloner();
        Map tempMap = cloner.deepClone(fixture)
        tempMap.get(target.tableName).get(target.count).put(target.columnName, afterValue)
        return tempMap;
    }

    public static Map changeValueListForString(final Map fixture, Map<FixtureChangeTarget, String> map){

        Cloner cloner = new Cloner();
        Map tempMap = cloner.deepClone(fixture)
        for(Map.Entry<FixtureChangeTarget, String> e : map.entrySet()) {
            tempMap.get(e.key.tableName).get(e.key.count).put(e.key.columnName, e.value)
        }
        return tempMap;
    }

    public static Map joinTable(final Map fixture1, final Map fixture2) {

        Cloner cloner = new Cloner();
        Map tempMap = cloner.deepClone(fixture1)
        Map tempMap2 = cloner.deepClone(fixture2)


        for (Map.Entry<String, Map> e : tempMap2.entrySet()) {
            for (Map.Entry<Integer, Map> f : e.getValue().entrySet()) {

                tempMap.get(e.key).put(f.key, f.value)
            }
        }


        return tempMap;
    }

}
