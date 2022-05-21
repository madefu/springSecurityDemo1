package com.madefu.spd1.mybatis.generator.persistobj;

import java.io.Serializable;

public class Tuseraccountdetailpo implements Serializable {
    private Long id;

    private Long userId;

    private Short age;

    private String address;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public Tuseraccountdetailpo withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public Tuseraccountdetailpo withUserId(Long userId) {
        this.setUserId(userId);
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Short getAge() {
        return age;
    }

    public Tuseraccountdetailpo withAge(Short age) {
        this.setAge(age);
        return this;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public Tuseraccountdetailpo withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", userId=" + userId +
                ", age=" + age +
                ", address=" + address +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}