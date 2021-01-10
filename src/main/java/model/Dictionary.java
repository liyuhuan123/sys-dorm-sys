package model;

import java.util.Date;

public class Dictionary {
    private Integer id;
    private String dictionaryKey;
    private String dictionaryValue;
    private String dictionaryDesc;
    private Date createTime;

    @Override
    public String toString() {
        return "Dictionary{" +
                "id=" + id +
                ", dictionaryKey='" + dictionaryKey + '\'' +
                ", dictionaryValue='" + dictionaryValue + '\'' +
                ", dictionaryDesc='" + dictionaryDesc + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictionaryKey() {
        return dictionaryKey;
    }

    public void setDictionaryKey(String dictionaryKey) {
        this.dictionaryKey = dictionaryKey;
    }

    public String getDictionaryValue() {
        return dictionaryValue;
    }

    public void setDictionaryValue(String dictionaryValue) {
        this.dictionaryValue = dictionaryValue;
    }

    public String getDictionaryDesc() {
        return dictionaryDesc;
    }

    public void setDictionaryDesc(String dictionaryDesc) {
        this.dictionaryDesc = dictionaryDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
