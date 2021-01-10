package model;

import java.util.Date;

public class building {
    private Integer id;
    private String buildingName;
    private String buildingDesc;
    private Date createTime;

    @Override
    public String toString() {
        return "building{" +
                "id=" + id +
                ", buildingName='" + buildingName + '\'' +
                ", buildingDesc='" + buildingDesc + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingDesc() {
        return buildingDesc;
    }

    public void setBuildingDesc(String buildingDesc) {
        this.buildingDesc = buildingDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
