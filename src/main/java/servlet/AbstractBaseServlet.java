package servlet;

import model.Response;
import util.JSONUtil;
import util.ThreadLocalHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //统一的编码格式
        req.setCharacterEncoding("UTF-8");//设置请求数据的编码格式:
        resp.setCharacterEncoding("UTF-8");//设置响应数据的编码格式
        resp.setContentType("application/json");//设置响应的数据格式为json格式
        //统一返回格式
        Response response = new Response();
        try {
            //子类调用process方法
            Object o = process(req,resp);
            response.setSuccess(true);
            response.setCode("200");
            response.setMessage("操作成功");
            response.setTotal(ThreadLocalHolder.get().get());//获取当前线程设置的count变量
            //把子类的返回值设置到Data里去
            response.setData(o);
        } catch (Exception e) {
            response.setCode("500");
            //设置消息,从Exception获取
            response.setMessage(e.getMessage());
            //设置堆栈日志
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            //获取堆栈日志
            String stackTrace = sw.toString();
            System.err.println(stackTrace);
            response.setStackTrace(stackTrace);
        }finally{
            ThreadLocalHolder.get().remove();//一定记住使用完ThreadLocal在线程结束前remove删除变量(否则可能引起内存泄漏)
        }
        PrintWriter pw = resp.getWriter();
        //序列化为一个字符串,输出到http响应里去
        pw.println(JSONUtil.write(response));
        pw.flush();
    }
    public abstract Object process (HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
