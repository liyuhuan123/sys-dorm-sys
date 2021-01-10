package dao;

import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public static User query(User user) {
        //查询出来的User
        User queryUser = null;
        //定义数据库查询JDBC需要用到的三个对象
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取数据库连接操作
            c = DBUtil.getConnection();
            String sql = "select id,nickname,email from user where username=? and password=?";
            //通过数据库连接获取ps对象
            ps = c.prepareStatement(sql);
            //设置占位符
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            //获取结果集(无参的)
            rs = ps.executeQuery();
            //处理结果集
            while(rs.next()){
                queryUser = user;
                queryUser.setId(rs.getInt("id"));
                queryUser.setNickname(rs.getString("nickname"));
                queryUser.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            throw new RuntimeException("登录校验用户名密码出错",e);
        } finally {
            //释放资源
            DBUtil.close(c,ps,rs);
        }
        return queryUser;
    }
}
