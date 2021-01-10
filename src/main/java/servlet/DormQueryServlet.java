package servlet;

import dao.DormDAO;
import model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@WebServlet("/dorm/queryAsDict")
public class DormQueryServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //请求数据,根据宿舍楼id查找寝室
        String key = req.getParameter("dictionaryKey");
        //把得到的String类型转成int类型,作为宿舍楼ID
        List<DictionaryTag> tags = DormDAO.query(Integer.parseInt(key));
        return tags;
    }
}
