package servlet;

import dao.StudentDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//删除学生住宿信息接口
@WebServlet("/student/delete")
public class StudentDeleteServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //相同的key有多个,可以获取到value数组
        //通过req.getParameterValues()获取多个
        String[] ids = req.getParameterValues("ids");
        int num = StudentDAO.delete(ids);
        return null;
    }
}
