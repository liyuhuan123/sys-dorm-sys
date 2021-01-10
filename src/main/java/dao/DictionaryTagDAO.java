package dao;
//字典查询操作
import model.DictionaryTag;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DictionaryTagDAO {

    public static List<DictionaryTag> query(String key) {
        List<DictionaryTag> list = new ArrayList<>();
        //定义数据库查询JDBC需要用到的三个对象
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取数据库连接操作
            c = DBUtil.getConnection();
            String sql = "select concat(d.dictionary_key, dt.dictionary_tag_key) dictionary_tag_key," +
                    "       dt.dictionary_tag_value" +
                    "   from dictionary d" +
                    "         join dictionary_tag dt ON d.id = dt.dictionary_id" +
                    "   where d.dictionary_key = ?";
            //通过数据库连接获取ps对象
            ps = c.prepareStatement(sql);
            //替换占位符(?)
            ps.setString(1,key);
            //获取结果集(无参的)
            rs = ps.executeQuery();
            //处理结果集
            while(rs.next()){
                DictionaryTag tag = new DictionaryTag();
                tag.setDictionaryTagKey(rs.getString("dictionary_tag_key"));
                tag.setDictionaryTagValue(rs.getString("dictionary_tag_value"));
                list.add(tag);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询数据字典标签出错",e);
        } finally {
            //释放资源
            DBUtil.close(c,ps,rs);
        }
        return list;
    }
}
