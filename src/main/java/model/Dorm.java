package model;

import java.util.Date;

//实体类,映射到dorm这张表
public class Dorm {
    private Integer id;
    private String dormNo;
    //描述信息
    private String dormDesc;
    private Integer buildingId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "id=" + id +
                ", dormNo='" + dormNo + '\'' +
                ", dormDesc='" + dormDesc + '\'' +
                ", buildingId=" + buildingId +
                ", createTime=" + createTime +
                '}';
    }

    public String getDormNo() {
        return dormNo;
    }

    public void setDormNo(String dormNo) {
        this.dormNo = dormNo;
    }

    public String getDormDesc() {
        return dormDesc;
    }

    public void setDormDesc(String dormDesc) {
        this.dormDesc = dormDesc;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
