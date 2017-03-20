package com.jiajia.Snowstorm.beans;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by jim on 17-3-19.
 */
@Entity
@Table(name = "good_picture")
public class GoodPicture {

    @Id
    @Column(name = "l_pictureId" ,nullable = false,length = 11,unique = true)
    @GenericGenerator(name = "idGenerator",strategy = "increment")
    @GeneratedValue(generator = "idGenerator")
    private Integer pictureId;

    @Column(name = "f_picturepath")
    private String picturePath;

    @Column(name = "c_goodcode")
    private Integer goodCode;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Integer getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(Integer goodCode) {
        this.goodCode = goodCode;
    }
}
