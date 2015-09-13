package jp.co.biglobe.isp.datasource.credit_card.fixture

import jp.co.biglobe.test.util.dbunit.xml.Fixture
import jp.co.biglobe.test.util.dbunit.xml.FixtureChangeTarget

class FixtureCredit {

    public static final String REGISTER_TABLE_NAME = "credit_register_event"

    public static final String CREDIT_CARD_NUMBER = "credit_card_number"
    public static final String SYSTEM_RECEIPT_DATE_TIME = "system_receipt_date_time"

    public static class RegisterInitialData {

        public static final String CREDIT_CARD_NUMBER = "credit_card_number"
        public static final String USER_ID = "user_id"
        public static final String VALID_CREDIT_CARD_STATUS = "valid_credit_card_status"


        private final static Map defaultValue = [
                (CREDIT_CARD_NUMBER)  : "111-111-1111",
                (USER_ID): "abc12345",
                (VALID_CREDIT_CARD_STATUS)  : "有効",
                (SYSTEM_RECEIPT_DATE_TIME)  : "2014-01-01 00:00:00",
        ]

    }



    public static class Nothing {



    }

    public static class Default {

        public static Map 登録済み(int rowCount, String creditCardNumber) {
            Map<FixtureChangeTarget, String> map = new HashMap<FixtureChangeTarget, String>()
            map.put(new FixtureChangeTarget(REGISTER_TABLE_NAME, rowCount, CREDIT_CARD_NUMBER), creditCardNumber)

            return Fixture.changeValueListForString([(REGISTER_TABLE_NAME): [(rowCount): RegisterInitialData.defaultValue]], map)
        }



    }


    public static class One {

        private static int oneRowCount = 1;
        private static String creditCardNumber = "111-111-1111"


        public static Map 登録済み() {
            return Default.登録済み(oneRowCount, creditCardNumber)
        }



    }



}