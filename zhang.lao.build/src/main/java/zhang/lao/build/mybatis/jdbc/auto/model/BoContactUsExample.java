package zhang.lao.build.mybatis.jdbc.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoContactUsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoContactUsExample() {
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

        public Criteria andLinkNameIsNull() {
            addCriterion("link_name is null");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNotNull() {
            addCriterion("link_name is not null");
            return (Criteria) this;
        }

        public Criteria andLinkNameEqualTo(String value) {
            addCriterion("link_name =", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotEqualTo(String value) {
            addCriterion("link_name <>", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThan(String value) {
            addCriterion("link_name >", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThanOrEqualTo(String value) {
            addCriterion("link_name >=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThan(String value) {
            addCriterion("link_name <", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThanOrEqualTo(String value) {
            addCriterion("link_name <=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLike(String value) {
            addCriterion("link_name like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotLike(String value) {
            addCriterion("link_name not like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameIn(List<String> values) {
            addCriterion("link_name in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotIn(List<String> values) {
            addCriterion("link_name not in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameBetween(String value1, String value2) {
            addCriterion("link_name between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotBetween(String value1, String value2) {
            addCriterion("link_name not between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNull() {
            addCriterion("link_phone is null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIsNotNull() {
            addCriterion("link_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneEqualTo(String value) {
            addCriterion("link_phone =", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotEqualTo(String value) {
            addCriterion("link_phone <>", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThan(String value) {
            addCriterion("link_phone >", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("link_phone >=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThan(String value) {
            addCriterion("link_phone <", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLessThanOrEqualTo(String value) {
            addCriterion("link_phone <=", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneLike(String value) {
            addCriterion("link_phone like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotLike(String value) {
            addCriterion("link_phone not like", value, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneIn(List<String> values) {
            addCriterion("link_phone in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotIn(List<String> values) {
            addCriterion("link_phone not in", values, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneBetween(String value1, String value2) {
            addCriterion("link_phone between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkPhoneNotBetween(String value1, String value2) {
            addCriterion("link_phone not between", value1, value2, "linkPhone");
            return (Criteria) this;
        }

        public Criteria andLinkSubIsNull() {
            addCriterion("link_sub is null");
            return (Criteria) this;
        }

        public Criteria andLinkSubIsNotNull() {
            addCriterion("link_sub is not null");
            return (Criteria) this;
        }

        public Criteria andLinkSubEqualTo(String value) {
            addCriterion("link_sub =", value, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkSubNotEqualTo(String value) {
            addCriterion("link_sub <>", value, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkSubGreaterThan(String value) {
            addCriterion("link_sub >", value, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkSubGreaterThanOrEqualTo(String value) {
            addCriterion("link_sub >=", value, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkSubLessThan(String value) {
            addCriterion("link_sub <", value, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkSubLessThanOrEqualTo(String value) {
            addCriterion("link_sub <=", value, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkSubLike(String value) {
            addCriterion("link_sub like", value, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkSubNotLike(String value) {
            addCriterion("link_sub not like", value, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkSubIn(List<String> values) {
            addCriterion("link_sub in", values, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkSubNotIn(List<String> values) {
            addCriterion("link_sub not in", values, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkSubBetween(String value1, String value2) {
            addCriterion("link_sub between", value1, value2, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkSubNotBetween(String value1, String value2) {
            addCriterion("link_sub not between", value1, value2, "linkSub");
            return (Criteria) this;
        }

        public Criteria andLinkContentIsNull() {
            addCriterion("link_content is null");
            return (Criteria) this;
        }

        public Criteria andLinkContentIsNotNull() {
            addCriterion("link_content is not null");
            return (Criteria) this;
        }

        public Criteria andLinkContentEqualTo(String value) {
            addCriterion("link_content =", value, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkContentNotEqualTo(String value) {
            addCriterion("link_content <>", value, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkContentGreaterThan(String value) {
            addCriterion("link_content >", value, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkContentGreaterThanOrEqualTo(String value) {
            addCriterion("link_content >=", value, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkContentLessThan(String value) {
            addCriterion("link_content <", value, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkContentLessThanOrEqualTo(String value) {
            addCriterion("link_content <=", value, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkContentLike(String value) {
            addCriterion("link_content like", value, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkContentNotLike(String value) {
            addCriterion("link_content not like", value, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkContentIn(List<String> values) {
            addCriterion("link_content in", values, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkContentNotIn(List<String> values) {
            addCriterion("link_content not in", values, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkContentBetween(String value1, String value2) {
            addCriterion("link_content between", value1, value2, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkContentNotBetween(String value1, String value2) {
            addCriterion("link_content not between", value1, value2, "linkContent");
            return (Criteria) this;
        }

        public Criteria andLinkTimeIsNull() {
            addCriterion("link_time is null");
            return (Criteria) this;
        }

        public Criteria andLinkTimeIsNotNull() {
            addCriterion("link_time is not null");
            return (Criteria) this;
        }

        public Criteria andLinkTimeEqualTo(Date value) {
            addCriterion("link_time =", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeNotEqualTo(Date value) {
            addCriterion("link_time <>", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeGreaterThan(Date value) {
            addCriterion("link_time >", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("link_time >=", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeLessThan(Date value) {
            addCriterion("link_time <", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeLessThanOrEqualTo(Date value) {
            addCriterion("link_time <=", value, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeIn(List<Date> values) {
            addCriterion("link_time in", values, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeNotIn(List<Date> values) {
            addCriterion("link_time not in", values, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeBetween(Date value1, Date value2) {
            addCriterion("link_time between", value1, value2, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkTimeNotBetween(Date value1, Date value2) {
            addCriterion("link_time not between", value1, value2, "linkTime");
            return (Criteria) this;
        }

        public Criteria andLinkMailIsNull() {
            addCriterion("link_mail is null");
            return (Criteria) this;
        }

        public Criteria andLinkMailIsNotNull() {
            addCriterion("link_mail is not null");
            return (Criteria) this;
        }

        public Criteria andLinkMailEqualTo(String value) {
            addCriterion("link_mail =", value, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkMailNotEqualTo(String value) {
            addCriterion("link_mail <>", value, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkMailGreaterThan(String value) {
            addCriterion("link_mail >", value, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkMailGreaterThanOrEqualTo(String value) {
            addCriterion("link_mail >=", value, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkMailLessThan(String value) {
            addCriterion("link_mail <", value, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkMailLessThanOrEqualTo(String value) {
            addCriterion("link_mail <=", value, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkMailLike(String value) {
            addCriterion("link_mail like", value, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkMailNotLike(String value) {
            addCriterion("link_mail not like", value, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkMailIn(List<String> values) {
            addCriterion("link_mail in", values, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkMailNotIn(List<String> values) {
            addCriterion("link_mail not in", values, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkMailBetween(String value1, String value2) {
            addCriterion("link_mail between", value1, value2, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkMailNotBetween(String value1, String value2) {
            addCriterion("link_mail not between", value1, value2, "linkMail");
            return (Criteria) this;
        }

        public Criteria andLinkStateIsNull() {
            addCriterion("link_state is null");
            return (Criteria) this;
        }

        public Criteria andLinkStateIsNotNull() {
            addCriterion("link_state is not null");
            return (Criteria) this;
        }

        public Criteria andLinkStateEqualTo(Integer value) {
            addCriterion("link_state =", value, "linkState");
            return (Criteria) this;
        }

        public Criteria andLinkStateNotEqualTo(Integer value) {
            addCriterion("link_state <>", value, "linkState");
            return (Criteria) this;
        }

        public Criteria andLinkStateGreaterThan(Integer value) {
            addCriterion("link_state >", value, "linkState");
            return (Criteria) this;
        }

        public Criteria andLinkStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("link_state >=", value, "linkState");
            return (Criteria) this;
        }

        public Criteria andLinkStateLessThan(Integer value) {
            addCriterion("link_state <", value, "linkState");
            return (Criteria) this;
        }

        public Criteria andLinkStateLessThanOrEqualTo(Integer value) {
            addCriterion("link_state <=", value, "linkState");
            return (Criteria) this;
        }

        public Criteria andLinkStateIn(List<Integer> values) {
            addCriterion("link_state in", values, "linkState");
            return (Criteria) this;
        }

        public Criteria andLinkStateNotIn(List<Integer> values) {
            addCriterion("link_state not in", values, "linkState");
            return (Criteria) this;
        }

        public Criteria andLinkStateBetween(Integer value1, Integer value2) {
            addCriterion("link_state between", value1, value2, "linkState");
            return (Criteria) this;
        }

        public Criteria andLinkStateNotBetween(Integer value1, Integer value2) {
            addCriterion("link_state not between", value1, value2, "linkState");
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