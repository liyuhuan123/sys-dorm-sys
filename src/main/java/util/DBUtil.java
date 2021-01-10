//工具类
package util;
//创建数据库连接以及释放资源类
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    //因为要使用双校验锁的方式创建数据库连接,所以要加上volatile关键字修饰
    private static volatile DataSource DS;
    //本项目数据库的URL
    private static final String URL = "jdbc:mysql://localhost:3306/stu_dorm";
    //数据库用户名
    private static final String USERNAME = "root";
    //数据库密码
    private static final String PASSWORD = "20000404lyh";
    //私有的构造方法
    private DBUtil(){ }
    //创建数据库连接池
    private static DataSource getDS(){
        //双重校验锁的形式创建数据库连接
        if(DS == null){
            synchronized(DBUtil.class){
                if(DS == null){
                    DS = new MysqlDataSource();
                    //设置URL
                    ((MysqlDataSource) DS).setUrl(URL);
                    //设置用户名
                    ((MysqlDataSource) DS).setUser(USERNAME);
                    //设置密码
                    ((MysqlDataSource) DS).setPassword(PASSWORD);
                }
            }
        }
        return DS;
    }
    //获取数据库连接对象
    public static Connection getConnection(){
        try {
            return getDS().getConnection();
        } catch (SQLException e) {
            //自定义异常,并打印捕获到的异常
            throw new RuntimeException("获取数据库连接失败",e);
        }
    }
    //释放数据库资源
    //Connection c:数据库连接对象
    //Statement s:数据库操作命令对象
    //ResultSet r:数据库结果集对象
    public static void close(Connection c, Statement s, ResultSet r){
        //释放的时候反向释放
        try {
            if(r != null){
                r.close();
            }
            if(s != null){
                s.close();
            }
            if(c != null){
                c.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("释放数据库资源失败",e);
        }
    }
    //不是进行查询操作的时候(为了提高效率)
    //重载方法(释放数据库资源操作)
    public static void close(Connection c, Statement s){
        close(c,s,null);
    }
}
