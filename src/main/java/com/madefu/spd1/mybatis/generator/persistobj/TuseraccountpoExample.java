package com.madefu.spd1.mybatis.generator.persistobj;

import com.madefu.spd1.mybatis.generator.type.PersonInfoType;
import com.madefu.spd1.mybatis.generator.type.SexType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TuseraccountpoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TuseraccountpoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> personalInfoCriteria;

        protected List<Criterion> sexEnumCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            personalInfoCriteria = new ArrayList<Criterion>();
            sexEnumCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getPersonalInfoCriteria() {
            return personalInfoCriteria;
        }

        protected void addPersonalInfoCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            personalInfoCriteria.add(new Criterion(condition, value, "com.madefu.spd1.mybatis.generator.type.handler.PersonInfoTypeHandler"));
            allCriteria = null;
        }

        protected void addPersonalInfoCriterion(String condition, PersonInfoType value1, PersonInfoType value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            personalInfoCriteria.add(new Criterion(condition, value1, value2, "com.madefu.spd1.mybatis.generator.type.handler.PersonInfoTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getSexEnumCriteria() {
            return sexEnumCriteria;
        }

        protected void addSexEnumCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            sexEnumCriteria.add(new Criterion(condition, value, "com.madefu.spd1.mybatis.generator.type.handler.SexTypeTypeHandler"));
            allCriteria = null;
        }

        protected void addSexEnumCriterion(String condition, SexType value1, SexType value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            sexEnumCriteria.add(new Criterion(condition, value1, value2, "com.madefu.spd1.mybatis.generator.type.handler.SexTypeTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || personalInfoCriteria.size() > 0
                || sexEnumCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(personalInfoCriteria);
                allCriteria.addAll(sexEnumCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Date value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Date> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Date> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Date value1, Date value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoIsNull() {
            addCriterion("personal_Info is null");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoIsNotNull() {
            addCriterion("personal_Info is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoEqualTo(PersonInfoType value) {
            addPersonalInfoCriterion("personal_Info =", value, "personalInfo");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoNotEqualTo(PersonInfoType value) {
            addPersonalInfoCriterion("personal_Info <>", value, "personalInfo");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoGreaterThan(PersonInfoType value) {
            addPersonalInfoCriterion("personal_Info >", value, "personalInfo");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoGreaterThanOrEqualTo(PersonInfoType value) {
            addPersonalInfoCriterion("personal_Info >=", value, "personalInfo");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoLessThan(PersonInfoType value) {
            addPersonalInfoCriterion("personal_Info <", value, "personalInfo");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoLessThanOrEqualTo(PersonInfoType value) {
            addPersonalInfoCriterion("personal_Info <=", value, "personalInfo");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoIn(List<PersonInfoType> values) {
            addPersonalInfoCriterion("personal_Info in", values, "personalInfo");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoNotIn(List<PersonInfoType> values) {
            addPersonalInfoCriterion("personal_Info not in", values, "personalInfo");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoBetween(PersonInfoType value1, PersonInfoType value2) {
            addPersonalInfoCriterion("personal_Info between", value1, value2, "personalInfo");
            return (Criteria) this;
        }

        public Criteria andPersonalInfoNotBetween(PersonInfoType value1, PersonInfoType value2) {
            addPersonalInfoCriterion("personal_Info not between", value1, value2, "personalInfo");
            return (Criteria) this;
        }

        public Criteria andSexEnumIsNull() {
            addCriterion("sex_enum is null");
            return (Criteria) this;
        }

        public Criteria andSexEnumIsNotNull() {
            addCriterion("sex_enum is not null");
            return (Criteria) this;
        }

        public Criteria andSexEnumEqualTo(SexType value) {
            addSexEnumCriterion("sex_enum =", value, "sexEnum");
            return (Criteria) this;
        }

        public Criteria andSexEnumNotEqualTo(SexType value) {
            addSexEnumCriterion("sex_enum <>", value, "sexEnum");
            return (Criteria) this;
        }

        public Criteria andSexEnumGreaterThan(SexType value) {
            addSexEnumCriterion("sex_enum >", value, "sexEnum");
            return (Criteria) this;
        }

        public Criteria andSexEnumGreaterThanOrEqualTo(SexType value) {
            addSexEnumCriterion("sex_enum >=", value, "sexEnum");
            return (Criteria) this;
        }

        public Criteria andSexEnumLessThan(SexType value) {
            addSexEnumCriterion("sex_enum <", value, "sexEnum");
            return (Criteria) this;
        }

        public Criteria andSexEnumLessThanOrEqualTo(SexType value) {
            addSexEnumCriterion("sex_enum <=", value, "sexEnum");
            return (Criteria) this;
        }

        public Criteria andSexEnumIn(List<SexType> values) {
            addSexEnumCriterion("sex_enum in", values, "sexEnum");
            return (Criteria) this;
        }

        public Criteria andSexEnumNotIn(List<SexType> values) {
            addSexEnumCriterion("sex_enum not in", values, "sexEnum");
            return (Criteria) this;
        }

        public Criteria andSexEnumBetween(SexType value1, SexType value2) {
            addSexEnumCriterion("sex_enum between", value1, value2, "sexEnum");
            return (Criteria) this;
        }

        public Criteria andSexEnumNotBetween(SexType value1, SexType value2) {
            addSexEnumCriterion("sex_enum not between", value1, value2, "sexEnum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}