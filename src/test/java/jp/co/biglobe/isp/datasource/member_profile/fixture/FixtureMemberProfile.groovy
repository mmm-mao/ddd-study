package jp.co.biglobe.isp.datasource.member_profile.fixture

import jp.co.biglobe.test.util.dbunit.xml.Fixture
import jp.co.biglobe.test.util.dbunit.xml.FixtureChangeTarget

import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class FixtureMemberProfile {

    public static final String REGISTER_TABLE_NAME = "member_profile_register_event"

    public static final String EVENT_ID = "profile_register_event_id"
    public static final String SYSTEM_RECEIPT_DATE_TIME = "system_receipt_date_time"

    public static class RegisterInitialData {

        public static final String USER_ID = "user_id"
        public static final String NAME = "name"
        public static final String NAME_KANA = "name_kana"
        public static final String GENDER = "gender"
        public static final String BIRTHDAY = "birthday"
        public static final String ZIP_CODE = "zip_code"
        public static final String ADDRESS = "address"

        private final static Map defaultValue = [
                (EVENT_ID) : 1,
                (USER_ID): "abc12345",
                (NAME): "テスト　太郎",
                (NAME_KANA): "てすと　たろう",
                (GENDER): "男性",
                (BIRTHDAY): "1980-01-01",
                (ZIP_CODE): "251-0043",
                (ADDRESS): "神奈川県川崎幸区２−９−１５",
                (SYSTEM_RECEIPT_DATE_TIME)  : "2014-01-01 00:00:00",
        ]

    }




    public static class Nothing {


    }

    public static class Default {

        public static Map 登録済み(int rowCount, int eventId) {
            Map<FixtureChangeTarget, String> map = new HashMap<FixtureChangeTarget, String>()
            map.put(new FixtureChangeTarget(REGISTER_TABLE_NAME, rowCount, EVENT_ID), eventId)

            return Fixture.changeValueListForString([(REGISTER_TABLE_NAME): [(rowCount): RegisterInitialData.defaultValue]], map)

        }

    }


    public static class One {

        private static int oneRowCount = 1;
        private static int eventId = 1;

        public static Map 登録済み() {
            return Default.登録済み(oneRowCount, eventId,)
        }



    }



}