import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

import java.nio.charset.Charset

import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.TRACE


/**
 * プロジェクトごとにユニークな名前
 */
def LOG_DIR_NAME = "sample"

// ログ出力先ファイルパス
def logFile = "/var/log/blc/tomcat/BIG0116_01/${LOG_DIR_NAME}/logs/application.log"

// ログレベル
def logLevel = DEBUG

// ログの出力フォーマット
def LOG_FORMAT = "%d{yyyy/MM/dd HH:mm:ss.SSS} [%level] [%thread] [%logger{0}] %message [%logger] %n"

// ログのデフォルト文字コード
def DEFAULT_CHARSET = Charset.forName("UTF-8")

// ローカルだけ設定を変更
if (System.getProperty("os.name").startsWith("Mac")) {
    logFile = "build/tomcat/logs/${LOG_DIR_NAME}-application.log"
    logLevel = TRACE
}

// ログファイルへのログ出力設定
appender("FILE", RollingFileAppender) {
    file = logFile

    encoder(PatternLayoutEncoder) {
        charset = DEFAULT_CHARSET
        pattern = LOG_FORMAT
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = file + ".%d{yyyy-MM-dd}"
    }
}

// 標準出力へのログ出力設定
appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        charset = DEFAULT_CHARSET
        pattern = LOG_FORMAT
    }
}

// ログレベル設定
root(logLevel, ["FILE", "STDOUT"])
