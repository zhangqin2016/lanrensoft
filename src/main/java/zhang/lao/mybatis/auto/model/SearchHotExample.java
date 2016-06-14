package zhang.lao.mybatis.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchHotExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SearchHotExample() {
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

        public Criteria andKeyworldIsNull() {
            addCriterion("keyworld is null");
            return (Criteria) this;
        }

        public Criteria andKeyworldIsNotNull() {
            addCriterion("keyworld is not null");
            return (Criteria) this;
        }

        public Criteria andKeyworldEqualTo(String value) {
            addCriterion("keyworld =", value, "keyworld");
            return (Criteria) this;
        }

        public Criteria andKeyworldNotEqualTo(String value) {
            addCriterion("keyworld <>", value, "keyworld");
            return (Criteria) this;
        }

        public Criteria andKeyworldGreaterThan(String value) {
            addCriterion("keyworld >", value, "keyworld");
            return (Criteria) this;
        }

        public Criteria andKeyworldGreaterThanOrEqualTo(String value) {
            addCriterion("keyworld >=", value, "keyworld");
            return (Criteria) this;
        }

        public Criteria andKeyworldLessThan(String value) {
            addCriterion("keyworld <", value, "keyworld");
            return (Criteria) this;
        }

        public Criteria andKeyworldLessThanOrEqualTo(String value) {
            addCriterion("keyworld <=", value, "keyworld");
            return (Criteria) this;
        }

        public Criteria andKeyworldLike(String value) {
            addCriterion("keyworld like", value, "keyworld");
            return (Criteria) this;
        }

        public Criteria andKeyworldNotLike(String value) {
            addCriterion("keyworld not like", value, "keyworld");
            return (Criteria) this;
        }

        public Criteria andKeyworldIn(List<String> values) {
            addCriterion("keyworld in", values, "keyworld");
            return (Criteria) this;
        }

        public Criteria andKeyworldNotIn(List<String> values) {
            addCriterion("keyworld not in", values, "keyworld");
            return (Criteria) this;
        }

        public Criteria andKeyworldBetween(String value1, String value2) {
            addCriterion("keyworld between", value1, value2, "keyworld");
            return (Criteria) this;
        }

        public Criteria andKeyworldNotBetween(String value1, String value2) {
            addCriterion("keyworld not between", value1, value2, "keyworld");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andStatisticDateIsNull() {
            addCriterion("statistic_date is null");
            return (Criteria) this;
        }

        public Criteria andStatisticDateIsNotNull() {
            addCriterion("statistic_date is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticDateEqualTo(Date value) {
            addCriterion("statistic_date =", value, "statisticDate");
            return (Criteria) this;
        }

        public Criteria andStatisticDateNotEqualTo(Date value) {
            addCriterion("statistic_date <>", value, "statisticDate");
            return (Criteria) this;
        }

        public Criteria andStatisticDateGreaterThan(Date value) {
            addCriterion("statistic_date >", value, "statisticDate");
            return (Criteria) this;
        }

        public Criteria andStatisticDateGreaterThanOrEqualTo(Date value) {
            addCriterion("statistic_date >=", value, "statisticDate");
            return (Criteria) this;
        }

        public Criteria andStatisticDateLessThan(Date value) {
            addCriterion("statistic_date <", value, "statisticDate");
            return (Criteria) this;
        }

        public Criteria andStatisticDateLessThanOrEqualTo(Date value) {
            addCriterion("statistic_date <=", value, "statisticDate");
            return (Criteria) this;
        }

        public Criteria andStatisticDateIn(List<Date> values) {
            addCriterion("statistic_date in", values, "statisticDate");
            return (Criteria) this;
        }

        public Criteria andStatisticDateNotIn(List<Date> values) {
            addCriterion("statistic_date not in", values, "statisticDate");
            return (Criteria) this;
        }

        public Criteria andStatisticDateBetween(Date value1, Date value2) {
            addCriterion("statistic_date between", value1, value2, "statisticDate");
            return (Criteria) this;
        }

        public Criteria andStatisticDateNotBetween(Date value1, Date value2) {
            addCriterion("statistic_date not between", value1, value2, "statisticDate");
            return (Criteria) this;
        }

        public Criteria andModIdIsNull() {
            addCriterion("mod_id is null");
            return (Criteria) this;
        }

        public Criteria andModIdIsNotNull() {
            addCriterion("mod_id is not null");
            return (Criteria) this;
        }

        public Criteria andModIdEqualTo(Integer value) {
            addCriterion("mod_id =", value, "modId");
            return (Criteria) this;
        }

        public Criteria andModIdNotEqualTo(Integer value) {
            addCriterion("mod_id <>", value, "modId");
            return (Criteria) this;
        }

        public Criteria andModIdGreaterThan(Integer value) {
            addCriterion("mod_id >", value, "modId");
            return (Criteria) this;
        }

        public Criteria andModIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mod_id >=", value, "modId");
            return (Criteria) this;
        }

        public Criteria andModIdLessThan(Integer value) {
            addCriterion("mod_id <", value, "modId");
            return (Criteria) this;
        }

        public Criteria andModIdLessThanOrEqualTo(Integer value) {
            addCriterion("mod_id <=", value, "modId");
            return (Criteria) this;
        }

        public Criteria andModIdIn(List<Integer> values) {
            addCriterion("mod_id in", values, "modId");
            return (Criteria) this;
        }

        public Criteria andModIdNotIn(List<Integer> values) {
            addCriterion("mod_id not in", values, "modId");
            return (Criteria) this;
        }

        public Criteria andModIdBetween(Integer value1, Integer value2) {
            addCriterion("mod_id between", value1, value2, "modId");
            return (Criteria) this;
        }

        public Criteria andModIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mod_id not between", value1, value2, "modId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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