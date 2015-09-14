package jp.co.biglobe.isp.datasource.member_profile.fixture

import jp.co.biglobe.test.util.dbunit.xml.Fixture
import jp.co.biglobe.test.util.dbunit.xml.FixtureChangeTarget

class FixtureMemberProfile {

    public static final String REGISTER_TABLE_NAME = "member_profile_register_event"
    public static final String MAIL_ADDRESS_REGISTER_TABLE_NAME = "member_mail_address_register_event"

    public static final String REGISTER_EVENT_ID = "profile_register_event_id"
    public static final String MAIL_ADDRESS_REGISTER_EVENT_ID = "mail_address_register_event_id"
    public static final String SYSTEM_RECEIPT_DATE_TIME = "system_receipt_date_time"

    public static class RegisterInitialData {

        public static final String USER_ID = "user_id"
        public static final String NAME = "name"
        public static final String NAME_KANA = "name_kana"
        public static final String GENDER = "gender"
        public static final String BIRTHDAY = "birthday"
        public static final String ZIP_CODE = "zip_code"
        public static final String ADDRESS = "address"
        public static final String CONTRACT_PHONE_NUMBER = "contract_phone_number"
        public static final String DAYTIME_PHONE_NUMBER = "daytime_phone_number"

        private final static Map defaultValue = [
                (REGISTER_EVENT_ID) : 1,
                (USER_ID): "abc12345",
                (NAME): "テスト　太郎",
                (NAME_KANA): "てすと　たろう",
                (GENDER): "男性",
                (BIRTHDAY): "1980-01-01",
                (ZIP_CODE): "251-0043",
                (ADDRESS): "神奈川県川崎幸区２−９−１５",
                (CONTRACT_PHONE_NUMBER): "090-1234-5678",
                (DAYTIME_PHONE_NUMBER): "090-1234-5678",
                (SYSTEM_RECEIPT_DATE_TIME)  : "2014-01-01 00:00:00",
        ]

    }

    public static class MailAddressRegisterInitialData {

        public static final String USER_ID = "user_id"
        public static final String MAIL_ADDRESS = "mail_address"

        private final static Map defaultValue = [
                (MAIL_ADDRESS_REGISTER_EVENT_ID) : 1,
                (USER_ID): "abc12345",
                (MAIL_ADDRESS): "test-mail@test.co.jp",
                (SYSTEM_RECEIPT_DATE_TIME)  : "2014-01-01 00:00:00",
        ]

    }




    public static class Nothing {


    }

    public static class Default {

        public static Map プロフィール登録済み(int rowCount, int eventId) {
            Map<FixtureChangeTarget, String> map = new HashMap<FixtureChangeTarget, String>()
            map.put(new FixtureChangeTarget(REGISTER_TABLE_NAME, rowCount, REGISTER_EVENT_ID), eventId)

            return Fixture.changeValueListForString([(REGISTER_TABLE_NAME): [(rowCount): RegisterInitialData.defaultValue]], map)

        }

        public static Map メールアドレス登録済み(int rowCount, int eventId) {
            Map<FixtureChangeTarget, String> map = new HashMap<FixtureChangeTarget, String>()
            map.put(new FixtureChangeTarget(MAIL_ADDRESS_REGISTER_TABLE_NAME, rowCount, MAIL_ADDRESS_REGISTER_EVENT_ID), eventId)

            return Fixture.changeValueListForString([(MAIL_ADDRESS_REGISTER_TABLE_NAME): [(rowCount): MailAddressRegisterInitialData.defaultValue]], map)

        }



    }


    public static class One {

        private static int oneRowCount = 1;
        private static int eventId = 1;

        public static Map 登録済み() {
            return Default.プロフィール登録済み(oneRowCount, eventId,) + Default.メールアドレス登録済み(oneRowCount, eventId)
        }



    }



}