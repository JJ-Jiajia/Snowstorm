package com.jiajia.Snowstorm.beans;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jim on 17-3-12.
 */
@Entity
@Table(name = "goods")
public class Goods {

    @Id
    @Column(name = "l_goodcode" ,nullable = false,length = 11,unique = true)
    @GenericGenerator(name = "idGenerator",strategy = "increment")
    @GeneratedValue(generator = "idGenerator")
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

    @Column(name = "l_userid")
    private Integer userId;

    @Column(name = "d_tradingDate")
    private Date tradingDate;

    @Column(name = "c_tradingStatus")
    private String tradingStatus;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTradingDate() {
        return tradingDate;
    }

    public void setTradingDate(Date tradingDate) {
        this.tradingDate = tradingDate;
    }

    public String getTradingStatus() {
        return tradingStatus;
    }

    public void setTradingStatus(String tradingStatus) {
        this.tradingStatus = tradingStatus;
    }

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
