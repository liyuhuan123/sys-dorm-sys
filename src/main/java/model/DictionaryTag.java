package model;

import java.util.Date;

public class DictionaryTag {
    private Integer id;
    private String dictionaryTagKey;
    private String dictionaryTagValue;
    private String dictionaryTagDesc;
    private Integer dictionaryId;
    private Date createTime;

    @Override
    public String toString() {
        return "DictionaryTag{" +
                "id=" + id +
                ", dictionaryTagKey='" + dictionaryTagKey + '\'' +
                ", dictionaryTagValue='" + dictionaryTagValue + '\'' +
                ", dictionaryTagDesc='" + dictionaryTagDesc + '\'' +
                ", dictionaryId=" + dictionaryId +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictionaryTagKey() {
        return dictionaryTagKey;
    }

    public void setDictionaryTagKey(String dictionaryTagKey) {
        this.dictionaryTagKey = dictionaryTagKey;
    }

    public String getDictionaryTagValue() {
        return dictionaryTagValue;
    }

    public void setDictionaryTagValue(String dictionaryTagValue) {
        this.dictionaryTagValue = dictionaryTagValue;
    }

    public String getDictionaryTagDesc() {
        return dictionaryTagDesc;
    }

    public void setDictionaryTagDesc(String dictionaryTagDesc) {
        this.dictionaryTagDesc = dictionaryTagDesc;
    }

    public Integer getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Integer dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
