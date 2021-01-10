package servlet;

import dao.StudentDAO;
import model.Page;
import model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//学生住宿信息查询接口
@WebServlet("/student/query")
public class StudentQueryServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //解析searchText=&sortOrder=asc&pageSize=7&pageNumber=1
        Page p = Page.parse(req);
        //获取学生住宿信息JDBC操作,获取为一个List
        List<Student> students = StudentDAO.query(p);
        //返回给前端
        return students;
    }
}
