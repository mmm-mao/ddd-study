package jp.co.biglobe.isp.datasource.credit_card.fixture

import jp.co.biglobe.test.util.dbunit.xml.Fixture
import jp.co.biglobe.test.util.dbunit.xml.FixtureChangeTarget

class FixtureCredit {

    public static final String REGISTER_TABLE_NAME = "credit_register_event"
    public static final String VALID_TABLE_NAME = "credit_valid_event"

    public static final String CREDIT_CARD_NUMBER = "credit_card_number"
    public static final String SYSTEM_RECEIPT_DATE_TIME = "system_receipt_date_time"

    public static class RegisterInitialData {

        public static final String CREDIT_CARD_NUMBER = "credit_card_number"
        public static final String USER_ID = "user_id"
        public static final String VALID_CREDIT_CARD_STATUS = "valid_credit_card_status"


        private final static Map defaultValue = [
                (CREDIT_CARD_NUMBER)  : "111-111-1111",
                (USER_ID): "abc12345",
                (SYSTEM_RECEIPT_DATE_TIME)  : "2014-01-01 00:00:00",
        ]

    }

    public static class ValidInitialData {

        public static final String CREDIT_VALID_EVENT_ID = "credit_valid_event_id"
        public static final String VALID_CREDIT_CARD_STATUS = "valid_credit_card_status"


        private final static Map defaultValue = [
                (CREDIT_VALID_EVENT_ID)  : "1",
                (CREDIT_CARD_NUMBER)  : "111-111-1111",
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

        public static Map 有効で登録済み(int rowCount, String creditCardNumber, String validEventId){

            Map<FixtureChangeTarget, String> map = new HashMap<FixtureChangeTarget, String>()
            map.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount, CREDIT_CARD_NUMBER), creditCardNumber)
            map.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount, ValidInitialData.CREDIT_VALID_EVENT_ID), validEventId)

            return 登録済み(rowCount, creditCardNumber) +
                    Fixture.changeValueListForString([(VALID_TABLE_NAME): [(rowCount): ValidInitialData.defaultValue]], map)
        }

        public static Map 無効にする(int rowCount, String creditCardNumber, String validEventId){

            Map<FixtureChangeTarget, String> map1 = new HashMap<FixtureChangeTarget, String>()
            map1.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount, CREDIT_CARD_NUMBER), creditCardNumber)
            map1.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount, ValidInitialData.CREDIT_VALID_EVENT_ID), validEventId)

            Map<FixtureChangeTarget, String> map2 = new HashMap<FixtureChangeTarget, String>()
            map2.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount + 1, CREDIT_CARD_NUMBER), creditCardNumber)
            map2.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount + 1, ValidInitialData.CREDIT_VALID_EVENT_ID), Integer.parseInt(validEventId) + 1)
            map2.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount + 1, ValidInitialData.VALID_CREDIT_CARD_STATUS), "無効")

            return 登録済み(rowCount, creditCardNumber) +
                    Fixture.joinTable(
                            Fixture.changeValueListForString([(VALID_TABLE_NAME): [(rowCount): ValidInitialData.defaultValue]], map1),
                            Fixture.changeValueListForString([(VALID_TABLE_NAME): [(rowCount + 1): ValidInitialData.defaultValue]], map2)
                    )
        }

        public static Map 有効に戻す(int rowCount, String creditCardNumber, String validEventId){

            Map<FixtureChangeTarget, String> map1 = new HashMap<FixtureChangeTarget, String>()
            map1.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount, CREDIT_CARD_NUMBER), creditCardNumber)
            map1.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount, ValidInitialData.CREDIT_VALID_EVENT_ID), validEventId)

            Map<FixtureChangeTarget, String> map2 = new HashMap<FixtureChangeTarget, String>()
            map2.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount + 1, CREDIT_CARD_NUMBER), creditCardNumber)
            map2.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount + 1, ValidInitialData.CREDIT_VALID_EVENT_ID), Integer.parseInt(validEventId) + 1)
            map2.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount + 1, ValidInitialData.VALID_CREDIT_CARD_STATUS), "無効")


            Map<FixtureChangeTarget, String> map3 = new HashMap<FixtureChangeTarget, String>()
            map3.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount + 2, CREDIT_CARD_NUMBER), creditCardNumber)
            map3.put(new FixtureChangeTarget(VALID_TABLE_NAME, rowCount + 2, ValidInitialData.CREDIT_VALID_EVENT_ID), Integer.parseInt(validEventId) + 2)

            return 登録済み(rowCount, creditCardNumber) +
                    Fixture.joinTable(
                            Fixture.joinTable(
                                    Fixture.changeValueListForString([(VALID_TABLE_NAME): [(rowCount): ValidInitialData.defaultValue]], map1),
                                    Fixture.changeValueListForString([(VALID_TABLE_NAME): [(rowCount + 1): ValidInitialData.defaultValue]], map2)
                            ),
                            Fixture.changeValueListForString([(VALID_TABLE_NAME): [(rowCount + 2): ValidInitialData.defaultValue]], map3)

                    )

        }


    }


    public static class One {

        private static int oneRowCount = 1;
        private static String creditCardNumber = "111-111-1111"
        private static String creditValidEventId = "1"


        public static Map 有効で登録済み() {
            return Default.有効で登録済み(oneRowCount, creditCardNumber, creditValidEventId)
        }

        public static Map 有効で変更済み() {
            return Default.有効で登録済み(oneRowCount, "111-111-1112", "2")
        }

        public static Map 無効にする() {
            return Default.無効にする(oneRowCount, creditCardNumber, creditValidEventId)
        }

        public static Map 有効に戻す() {
            return Default.有効に戻す(oneRowCount, creditCardNumber, creditValidEventId)
        }





    }



}