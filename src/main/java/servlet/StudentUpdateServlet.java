package servlet;

import dao.StudentDAO;
import model.Student;
import util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//修改学生信息接口
@WebServlet("/student/update")
public class StudentUpdateServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //解析
        Student s = JSONUtil.read(req.getInputStream(),Student.class);
        int num = StudentDAO.update(s);
        return null;
    }
}
