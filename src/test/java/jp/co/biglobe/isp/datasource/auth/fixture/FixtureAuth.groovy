package jp.co.biglobe.isp.datasource.auth.fixture

import jp.co.biglobe.test.util.dbunit.xml.Fixture
import jp.co.biglobe.test.util.dbunit.xml.FixtureChangeTarget

class FixtureAuth {

    public static final String AUTH_TABLE_NAME = "auth_event"

    public static final String AUTH_EVENT_ID = "auth_event_id"
    public static final String SYSTEM_RECEIPT_DATE_TIME = "system_receipt_date_time"

    public static class AuthInitialData {

        public static final String USER_ID = "user_id"
        public static final String USER_PASSWORD = "user_password"


        private final static Map defaultValue = [
                (AUTH_EVENT_ID)  : "1",
                (USER_ID): "abc12345",
                (USER_PASSWORD): "password",
                (SYSTEM_RECEIPT_DATE_TIME)  : "2014-01-01 00:00:00",
        ]

    }

    public static class Nothing {



    }

    public static class Default {

        public static Map 登録済み(int rowCount, String eventId) {
            Map<FixtureChangeTarget, String> map = new HashMap<FixtureChangeTarget, String>()
            map.put(new FixtureChangeTarget(AUTH_TABLE_NAME, rowCount, AUTH_EVENT_ID), eventId)



            return Fixture.changeValueListForString([(AUTH_TABLE_NAME): [(rowCount): AuthInitialData.defaultValue]], map)

        }

    }


    public static class One {

        private static int oneRowCount = 1;
        private static String eventId = "1"


        public static Map 登録済み() {
            return Default.登録済み(oneRowCount, eventId)
        }



    }



}