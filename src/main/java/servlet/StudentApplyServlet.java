package servlet;

import dao.StudentDAO;
import model.Student;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student/apply")
public class StudentApplyServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //解析JSON对象
        Student s = JSONUtil.read(req.getInputStream(),Student.class);
        int num = StudentDAO.apply(s);
        return null;
    }
}
