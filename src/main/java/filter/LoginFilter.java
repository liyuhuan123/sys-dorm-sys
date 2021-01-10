package filter;

import model.Response;
import util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//  /*代表所有路径都进行拦截
//过滤器:http请求的url匹配过滤器路径规则,才会过滤(调用filter中的方法)
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //把Servlet类型的强制转为HTTPServlet类型的
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        /**
         * 页面的静态资源,后台服务
         * 需要处理的敏感资源:
         * 1.首页:/public/page/main.html.没有登录重定向到登录页面
         * 2.后端服务资源:除登录接口/user/login以外,其他接口,没有登录,返回没有登录的json信息
         */
        //获取Session信息
        HttpSession session = req.getSession(false);//没有Session时.返回null
        if(session == null){//没有登录
            //获取当前http请求的路径
            String uri = req.getServletPath();
            if("/public/page/main.html".equals(uri)){//首页没有登录就重定向
                //重定向必须写全路径
                String schema = req.getScheme();//http
                String host = req.getServerName();//服务器域名或ip
                int port = req.getServerPort();//服务器端口号
                String contextPath = req.getContextPath();//项目部署名(部署路径)
                String basePath = schema+"://"+host+":"+port+contextPath;//作为前缀
                res.sendRedirect(basePath+"/public/index.html");//重定向
                return;
            }else if(!"/user/login".equals(uri) && !uri.startsWith("/public/")
                    && !uri.startsWith("/static/")){//既不是登录接口,也不是/public.开头的静态资源,也不是/static/开头的静态资源,所以一定要返回错误的json数据
                //统一的编码格式
                req.setCharacterEncoding("UTF-8");//设置请求数据的编码格式:
                res.setCharacterEncoding("UTF-8");//设置响应数据的编码格式
                res.setContentType("application/json");//设置响应的数据格式为json格式
                Response r = new Response();
                r.setCode("301");//不是响应的状态码,是响应体的字段
                r.setMessage("未授权的http请求");
                //再把数据序列化成json字符串返回到输出流里面
                PrintWriter pw = res.getWriter();
                //输出流打印内容,
                pw.println(JSONUtil.write(r));
                pw.flush();
                return;
            }
        }
        //FilterChain chain(过滤器链)
        //如果没有该方法调用,不会往下传递
        chain.doFilter(request,response);//过滤器向下调用再次过滤
    }

    @Override
    public void destroy() {

    }
}
