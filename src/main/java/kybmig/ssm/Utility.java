package kybmig.ssm;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class Utility {
    public static Long getUnixTime() {
        Long unixTime = System.currentTimeMillis() / 1000L;
        return unixTime;
    }

    private static Logger logger = LoggerFactory.getLogger(Utility.class);

//    public  static MysqlDataSource getDataSource() {
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setUser("root");
//        dataSource.setPassword("12345");
//        dataSource.setServerName("127.0.0.1");
//        dataSource.setDatabaseName("ssm");
//
//        // 用来设置时区和数据库连接的编码
//        try {
//            dataSource.setCharacterEncoding("UTF-8");
//            dataSource.setServerTimezone("Asia/Shanghai");
//
//            Utility.log("url: %s", dataSource);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return dataSource;
//    }

    static public void log(String format, Object... args) {
        logger.info(String.format(format, args));
    }
}
