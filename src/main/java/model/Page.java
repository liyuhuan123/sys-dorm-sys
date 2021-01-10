package model;
//分页用的实体类

import javax.servlet.http.HttpServletRequest;

public class Page {
    private String searchText;//搜索的内容
    private String sortOrder;//排序的方式:升序,降序
    private Integer pageSize;//每页的数量
    private Integer pageNumber;//当前的页码


    @Override
    public String toString() {
        return "Page{" +
                "searchText='" + searchText + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                '}';
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**request输入流只能获取请求体的数据,依赖程序自己解析
     * request.getParameter可以获取url和请求体中的数据:k1=v1&k2=v2...
     * @param req
     * @return
     */
    //转换request为实体类
    public static Page parse(HttpServletRequest req){
        //这里不能使用json的方式解析请求数据
        Page p = new Page();
        p.searchText = req.getParameter("searchText");
        p.sortOrder = req.getParameter("sortOrder");
        p.pageSize = Integer.parseInt(req.getParameter("pageSize"));
        p.pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
        return p;
    }
}
