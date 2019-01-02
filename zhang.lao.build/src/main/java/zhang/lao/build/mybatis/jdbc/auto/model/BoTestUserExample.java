package zhang.lao.build.mybatis.jdbc.auto.model;

import java.util.ArrayList;
import java.util.List;

public class BoTestUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoTestUserExample() {
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
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgIsNull() {
            addCriterion("user_head_img is null");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgIsNotNull() {
            addCriterion("user_head_img is not null");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgEqualTo(String value) {
            addCriterion("user_head_img =", value, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgNotEqualTo(String value) {
            addCriterion("user_head_img <>", value, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgGreaterThan(String value) {
            addCriterion("user_head_img >", value, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgGreaterThanOrEqualTo(String value) {
            addCriterion("user_head_img >=", value, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgLessThan(String value) {
            addCriterion("user_head_img <", value, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgLessThanOrEqualTo(String value) {
            addCriterion("user_head_img <=", value, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgLike(String value) {
            addCriterion("user_head_img like", value, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgNotLike(String value) {
            addCriterion("user_head_img not like", value, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgIn(List<String> values) {
            addCriterion("user_head_img in", values, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgNotIn(List<String> values) {
            addCriterion("user_head_img not in", values, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgBetween(String value1, String value2) {
            addCriterion("user_head_img between", value1, value2, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserHeadImgNotBetween(String value1, String value2) {
            addCriterion("user_head_img not between", value1, value2, "userHeadImg");
            return (Criteria) this;
        }

        public Criteria andUserFileIsNull() {
            addCriterion("user_file is null");
            return (Criteria) this;
        }

        public Criteria andUserFileIsNotNull() {
            addCriterion("user_file is not null");
            return (Criteria) this;
        }

        public Criteria andUserFileEqualTo(String value) {
            addCriterion("user_file =", value, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserFileNotEqualTo(String value) {
            addCriterion("user_file <>", value, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserFileGreaterThan(String value) {
            addCriterion("user_file >", value, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserFileGreaterThanOrEqualTo(String value) {
            addCriterion("user_file >=", value, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserFileLessThan(String value) {
            addCriterion("user_file <", value, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserFileLessThanOrEqualTo(String value) {
            addCriterion("user_file <=", value, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserFileLike(String value) {
            addCriterion("user_file like", value, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserFileNotLike(String value) {
            addCriterion("user_file not like", value, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserFileIn(List<String> values) {
            addCriterion("user_file in", values, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserFileNotIn(List<String> values) {
            addCriterion("user_file not in", values, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserFileBetween(String value1, String value2) {
            addCriterion("user_file between", value1, value2, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserFileNotBetween(String value1, String value2) {
            addCriterion("user_file not between", value1, value2, "userFile");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (Criteria) this;
        }

        public Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUserSexEqualTo(Integer value) {
            addCriterion("user_sex =", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotEqualTo(Integer value) {
            addCriterion("user_sex <>", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThan(Integer value) {
            addCriterion("user_sex >", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_sex >=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThan(Integer value) {
            addCriterion("user_sex <", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexLessThanOrEqualTo(Integer value) {
            addCriterion("user_sex <=", value, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexIn(List<Integer> values) {
            addCriterion("user_sex in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotIn(List<Integer> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexBetween(Integer value1, Integer value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSexNotBetween(Integer value1, Integer value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeIsNull() {
            addCriterion("user_school_grade is null");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeIsNotNull() {
            addCriterion("user_school_grade is not null");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeEqualTo(String value) {
            addCriterion("user_school_grade =", value, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeNotEqualTo(String value) {
            addCriterion("user_school_grade <>", value, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeGreaterThan(String value) {
            addCriterion("user_school_grade >", value, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeGreaterThanOrEqualTo(String value) {
            addCriterion("user_school_grade >=", value, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeLessThan(String value) {
            addCriterion("user_school_grade <", value, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeLessThanOrEqualTo(String value) {
            addCriterion("user_school_grade <=", value, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeLike(String value) {
            addCriterion("user_school_grade like", value, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeNotLike(String value) {
            addCriterion("user_school_grade not like", value, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeIn(List<String> values) {
            addCriterion("user_school_grade in", values, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeNotIn(List<String> values) {
            addCriterion("user_school_grade not in", values, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeBetween(String value1, String value2) {
            addCriterion("user_school_grade between", value1, value2, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserSchoolGradeNotBetween(String value1, String value2) {
            addCriterion("user_school_grade not between", value1, value2, "userSchoolGrade");
            return (Criteria) this;
        }

        public Criteria andUserDesIsNull() {
            addCriterion("user_des is null");
            return (Criteria) this;
        }

        public Criteria andUserDesIsNotNull() {
            addCriterion("user_des is not null");
            return (Criteria) this;
        }

        public Criteria andUserDesEqualTo(String value) {
            addCriterion("user_des =", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesNotEqualTo(String value) {
            addCriterion("user_des <>", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesGreaterThan(String value) {
            addCriterion("user_des >", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesGreaterThanOrEqualTo(String value) {
            addCriterion("user_des >=", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesLessThan(String value) {
            addCriterion("user_des <", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesLessThanOrEqualTo(String value) {
            addCriterion("user_des <=", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesLike(String value) {
            addCriterion("user_des like", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesNotLike(String value) {
            addCriterion("user_des not like", value, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesIn(List<String> values) {
            addCriterion("user_des in", values, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesNotIn(List<String> values) {
            addCriterion("user_des not in", values, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesBetween(String value1, String value2) {
            addCriterion("user_des between", value1, value2, "userDes");
            return (Criteria) this;
        }

        public Criteria andUserDesNotBetween(String value1, String value2) {
            addCriterion("user_des not between", value1, value2, "userDes");
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