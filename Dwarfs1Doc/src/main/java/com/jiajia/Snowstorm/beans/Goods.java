package com.jiajia.Snowstorm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by jim on 17-3-12.
 */
@Entity
@Table(name = "goods")
public class Goods {

    @Id
    @Column(name = "c_goodcode")
    private Integer goodcode;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_class")
    private String goodClass;

    @Column(name = "c_picture")
    private String picture;

    @Column(name = "c_memo")
    private String memo;

    @Column(name = "d_createtime")
    private Date createtime;

    @Column(name = "c_ownername")
    private String ownername;

    public Integer getGoodcode() {
        return goodcode;
    }

    public void setGoodcode(Integer goodcode) {
        this.goodcode = goodcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoodClass() {
        return goodClass;
    }

    public void setGoodClass(String goodClass) {
        this.goodClass = goodClass;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }
}
