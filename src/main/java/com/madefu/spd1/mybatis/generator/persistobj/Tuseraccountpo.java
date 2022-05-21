package com.madefu.spd1.mybatis.generator.persistobj;

import com.madefu.spd1.mybatis.generator.type.PersonInfoType;
import com.madefu.spd1.mybatis.generator.type.SexType;
import java.io.Serializable;
import java.util.Date;

public class Tuseraccountpo implements Serializable {
    private Long id;

    private String userName;

    private String password;

    private Date createAt;

    private Date updateAt;

    private PersonInfoType personalInfo;

    private SexType sexEnum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public Tuseraccountpo withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public Tuseraccountpo withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public Tuseraccountpo withPassword(String password) {
        this.setPassword(password);
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Tuseraccountpo withCreateAt(Date createAt) {
        this.setCreateAt(createAt);
        return this;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public Tuseraccountpo withUpdateAt(Date updateAt) {
        this.setUpdateAt(updateAt);
        return this;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public PersonInfoType getPersonalInfo() {
        return personalInfo;
    }

    public Tuseraccountpo withPersonalInfo(PersonInfoType personalInfo) {
        this.setPersonalInfo(personalInfo);
        return this;
    }

    public void setPersonalInfo(PersonInfoType personalInfo) {
        this.personalInfo = personalInfo;
    }

    public SexType getSexEnum() {
        return sexEnum;
    }

    public Tuseraccountpo withSexEnum(SexType sexEnum) {
        this.setSexEnum(sexEnum);
        return this;
    }

    public void setSexEnum(SexType sexEnum) {
        this.sexEnum = sexEnum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", personalInfo=").append(personalInfo);
        sb.append(", sexEnum=").append(sexEnum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}