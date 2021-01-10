package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
//JSON工具类
public class JSONUtil {
    //ObjectMapper类是Jackson库的主要类,它提供一些功能将转换成Java对象匹配JSON结构
    private static final ObjectMapper MAPPER = new ObjectMapper();
    //设置日期类型
    static{
        //设置日期格式,年-月-日 时:分:秒
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    //反序列化输入流中的json字符串为java对象
    //http请求发送json数据,请求头Content-Type=application.json
    //httpServletRequest获取json字符串,只能通过输入流获取
    public static <T> T read(InputStream is,Class<T> clazz){
        try {
            return MAPPER.readValue(is,clazz);
        } catch (IOException e) {
            throw new RuntimeException("json反序列化失败",e);
        }
    }
    //序列化操作:把某一个java类序列化为字符串
    public static String write(Object o){
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json序列化失败",e);
        }
    }
}
