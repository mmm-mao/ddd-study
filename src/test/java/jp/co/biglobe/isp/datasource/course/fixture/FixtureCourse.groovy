package jp.co.biglobe.isp.datasource.course.fixture

import jp.co.biglobe.test.util.dbunit.xml.Fixture
import jp.co.biglobe.test.util.dbunit.xml.FixtureChangeTarget

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FixtureCourse {

    public static final String RECEIPT_TABLE_NAME = "course_receipt_event"

    public static final String EVENT_ID = "course_receipt_event_id"
    public static final String SYSTEM_RECEIPT_DATE_TIME = "system_receipt_date_time"

    public static class ReceiptInitialData {

        public static final String USER_ID = "user_id"
        public static final String COURSE = "course"
        public static final String SWITCHING_DATE = "switching_date"


        private final static Map defaultValue = [
                (EVENT_ID)  : "1",
                (USER_ID): "abc12345",
                (COURSE): "ベーシック",
                (SWITCHING_DATE): LocalDate.now().format(DateTimeFormatter.ofPattern("uuuu-MM-dd")),
                (SYSTEM_RECEIPT_DATE_TIME)  : "2014-01-01 00:00:00",
        ]

    }

    public static class Nothing {



    }

    public static class Default {

        public static Map 受付済み(int rowCount, int eventId) {
            Map<FixtureChangeTarget, String> map = new HashMap<FixtureChangeTarget, String>()
            map.put(new FixtureChangeTarget(RECEIPT_TABLE_NAME, rowCount, EVENT_ID), eventId)

            return Fixture.changeValueListForString([(RECEIPT_TABLE_NAME): [(rowCount): ReceiptInitialData.defaultValue]], map)

        }

        public static Map コース変更予約中(int rowCount, int eventId) {
            Map<FixtureChangeTarget, String> map = new HashMap<FixtureChangeTarget, String>()
            map.put(new FixtureChangeTarget(RECEIPT_TABLE_NAME, rowCount, EVENT_ID), eventId)
            map.put(new FixtureChangeTarget(RECEIPT_TABLE_NAME, rowCount, ReceiptInitialData.SWITCHING_DATE), LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("uuuu-MM-dd")),)

            return Fixture.changeValueListForString([(RECEIPT_TABLE_NAME): [(rowCount): ReceiptInitialData.defaultValue]], map)

        }

    }


    public static class One {

        private static int oneRowCount = 1;
        private static int eventId = 1


        public static Map 受付済み() {
            return Default.受付済み(oneRowCount, eventId)
        }

    }

    public static class Two {

        private static int oneRowCount = 1;
        private static int oneEventId = 1

        private static int twoRowCount = 2;
        private static int twoEventId = 2


        public static Map コース変更予約中() {
            return Fixture.joinTable(Default.受付済み(oneRowCount, oneEventId), Default.コース変更予約中(twoRowCount, twoEventId));
        }

    }



}