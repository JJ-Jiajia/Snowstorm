package com.jiajia.Snowstorm.beans;

/**
 * Created by jim on 17-3-19.
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "goods_wanted")
public class GoodWanted {

    @Id
    @Column(name = "l_wantedid" ,nullable = false,length = 11,unique = true)
    @GenericGenerator(name = "idGenerator",strategy = "increment")
    @GeneratedValue(generator = "idGenerator")
    private Integer wantedId;

    @Column(name = "c_goodcode")
    private Integer goodCode;

    @Column(name = "l_userid")
    private Integer userId;

    @Column(name = "c_status")
    private Integer status;

    public Integer getWantedId() {
        return wantedId;
    }

    public void setWantedId(Integer wantedId) {
        this.wantedId = wantedId;
    }

    public Integer getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(Integer goodCode) {
        this.goodCode = goodCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
