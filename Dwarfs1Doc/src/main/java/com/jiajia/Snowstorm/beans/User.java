package com.jiajia.Snowstorm.beans;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by evenj on 2016/12/23.
 */
@Entity
@Table(name = "user")
public class User {
    private String username;

    private String passwords;

    private String tel;

    private String address;

    private String sex;

    private Integer id;

    private Float money;

    @Column(name = "money")
    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "passwords")
    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Id
    @Column(name = "id" ,nullable = false,length = 11,unique = true)
    @GenericGenerator(name = "idGenerator",strategy = "increment")
    @GeneratedValue(generator = "idGenerator")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
