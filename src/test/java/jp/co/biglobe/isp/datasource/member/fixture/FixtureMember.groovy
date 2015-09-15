package jp.co.biglobe.isp.datasource.member.fixture

import jp.co.biglobe.test.util.dbunit.xml.Fixture
import jp.co.biglobe.test.util.dbunit.xml.FixtureChangeTarget

import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

class FixtureMember {

    public static final String SIGN_UP_TABLE_NAME = "member_sign_up_event"
    public static final String WITHDRAW_TABLE_NAME = "member_withdraw_event"

    public static final String USER_ID = "user_id"
    public static final String SYSTEM_RECEIPT_DATE_TIME = "system_receipt_date_time"

    public static class SignUpInitialData {

        public static final String SIGN_UP_DATE = "sign_up_date"


        private final static Map defaultValue = [
                (USER_ID): "abc12345",
                (SIGN_UP_DATE): LocalDate.now().format(DateTimeFormatter.ofPattern("uuuu-MM-dd")),
                (SYSTEM_RECEIPT_DATE_TIME)  : "2014-01-01 00:00:00",
        ]

    }

    public static class WithdrawInitialData {

        public static final String WITHDRAWAL_DATE = "withdrawal_date"


        private final static Map defaultValue = [
                (USER_ID): "abc12345",
                (WITHDRAWAL_DATE): YearMonth.now().atEndOfMonth().format(DateTimeFormatter.ofPattern("uuuu-MM-dd")),
                (SYSTEM_RECEIPT_DATE_TIME)  : "2014-01-01 00:00:00",
        ]

    }



    public static class Nothing {

        public static Map 退会イベントなし() {
            return [(WITHDRAW_TABLE_NAME): [1: []]]
        }


    }

    public static class Default {

        public static Map 入会済み(int rowCount, String userId) {
            Map<FixtureChangeTarget, String> map = new HashMap<FixtureChangeTarget, String>()
            map.put(new FixtureChangeTarget(SIGN_UP_TABLE_NAME, rowCount, USER_ID), userId)

            return Fixture.changeValueListForString([(SIGN_UP_TABLE_NAME): [(rowCount): SignUpInitialData.defaultValue]], map)

        }

        public static Map 退会予約中(int rowCount, String userId){

            Map<FixtureChangeTarget, String> map = new HashMap<FixtureChangeTarget, String>()
            map.put(new FixtureChangeTarget(WITHDRAW_TABLE_NAME, rowCount, USER_ID), userId)

            return 入会済み(rowCount, userId) +
                    Fixture.changeValueListForString([(WITHDRAW_TABLE_NAME): [(rowCount): WithdrawInitialData.defaultValue]], map)
        }

        public static Map 退会済み(int rowCount, String userId){

            Map<FixtureChangeTarget, String> map = new HashMap<FixtureChangeTarget, String>()
            map.put(new FixtureChangeTarget(WITHDRAW_TABLE_NAME, rowCount, USER_ID), userId)
            map.put(new FixtureChangeTarget(WITHDRAW_TABLE_NAME, rowCount, WithdrawInitialData.WITHDRAWAL_DATE), YearMonth.now().minusMonths(1).atEndOfMonth().format(DateTimeFormatter.ofPattern("uuuu-MM-dd")),)

            return 入会済み(rowCount, userId) +
                    Fixture.changeValueListForString([(WITHDRAW_TABLE_NAME): [(rowCount): WithdrawInitialData.defaultValue]], map)
        }



    }


    public static class One {

        private static int oneRowCount = 1;
        private static String userId = "abc12345"


        public static Map 入会済み() {
            return Default.入会済み(oneRowCount, userId,)
        }


        public static Map 退会済み() {
            return Default.退会済み(oneRowCount, userId,)
        }



    }



}