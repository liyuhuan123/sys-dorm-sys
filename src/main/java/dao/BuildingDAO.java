package dao;

import model.DictionaryTag;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BuildingDAO {
    public static List<DictionaryTag> query() {
        List<DictionaryTag> list = new ArrayList<>();
        //定义数据库查询JDBC需要用到的三个对象
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取数据库连接操作
            c = DBUtil.getConnection();
            String sql = "select id,building_name from building";
            //通过数据库连接获取ps对象
            ps = c.prepareStatement(sql);
            //获取结果集(无参的)
            rs = ps.executeQuery();
            //处理结果集
            while(rs.next()){
                DictionaryTag tag = new DictionaryTag();
                tag.setDictionaryTagKey(rs.getString("id"));
                tag.setDictionaryTagValue(rs.getString("building_name"));
                list.add(tag);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询宿舍楼数据字典出错",e);
        } finally {
            //释放资源
            DBUtil.close(c,ps,rs);
        }
        return list;
    }
}
