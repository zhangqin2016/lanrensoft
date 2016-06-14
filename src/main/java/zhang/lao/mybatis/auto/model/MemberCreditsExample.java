package zhang.lao.mybatis.auto.model;

import java.util.ArrayList;
import java.util.List;

public class MemberCreditsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberCreditsExample() {
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

        public Criteria andMcIdIsNull() {
            addCriterion("mc_id is null");
            return (Criteria) this;
        }

        public Criteria andMcIdIsNotNull() {
            addCriterion("mc_id is not null");
            return (Criteria) this;
        }

        public Criteria andMcIdEqualTo(Long value) {
            addCriterion("mc_id =", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdNotEqualTo(Long value) {
            addCriterion("mc_id <>", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdGreaterThan(Long value) {
            addCriterion("mc_id >", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mc_id >=", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdLessThan(Long value) {
            addCriterion("mc_id <", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdLessThanOrEqualTo(Long value) {
            addCriterion("mc_id <=", value, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdIn(List<Long> values) {
            addCriterion("mc_id in", values, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdNotIn(List<Long> values) {
            addCriterion("mc_id not in", values, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdBetween(Long value1, Long value2) {
            addCriterion("mc_id between", value1, value2, "mcId");
            return (Criteria) this;
        }

        public Criteria andMcIdNotBetween(Long value1, Long value2) {
            addCriterion("mc_id not between", value1, value2, "mcId");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Long value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Long value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Long value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Long value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Long value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Long value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Long> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Long> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Long value1, Long value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Long value1, Long value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsIsNull() {
            addCriterion("total_credits is null");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsIsNotNull() {
            addCriterion("total_credits is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsEqualTo(Integer value) {
            addCriterion("total_credits =", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsNotEqualTo(Integer value) {
            addCriterion("total_credits <>", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsGreaterThan(Integer value) {
            addCriterion("total_credits >", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_credits >=", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsLessThan(Integer value) {
            addCriterion("total_credits <", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsLessThanOrEqualTo(Integer value) {
            addCriterion("total_credits <=", value, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsIn(List<Integer> values) {
            addCriterion("total_credits in", values, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsNotIn(List<Integer> values) {
            addCriterion("total_credits not in", values, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsBetween(Integer value1, Integer value2) {
            addCriterion("total_credits between", value1, value2, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andTotalCreditsNotBetween(Integer value1, Integer value2) {
            addCriterion("total_credits not between", value1, value2, "totalCredits");
            return (Criteria) this;
        }

        public Criteria andFreezeIsNull() {
            addCriterion("freeze is null");
            return (Criteria) this;
        }

        public Criteria andFreezeIsNotNull() {
            addCriterion("freeze is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeEqualTo(Integer value) {
            addCriterion("freeze =", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeNotEqualTo(Integer value) {
            addCriterion("freeze <>", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeGreaterThan(Integer value) {
            addCriterion("freeze >", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeGreaterThanOrEqualTo(Integer value) {
            addCriterion("freeze >=", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeLessThan(Integer value) {
            addCriterion("freeze <", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeLessThanOrEqualTo(Integer value) {
            addCriterion("freeze <=", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeIn(List<Integer> values) {
            addCriterion("freeze in", values, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeNotIn(List<Integer> values) {
            addCriterion("freeze not in", values, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeBetween(Integer value1, Integer value2) {
            addCriterion("freeze between", value1, value2, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeNotBetween(Integer value1, Integer value2) {
            addCriterion("freeze not between", value1, value2, "freeze");
            return (Criteria) this;
        }

        public Criteria andCreditsIsNull() {
            addCriterion("credits is null");
            return (Criteria) this;
        }

        public Criteria andCreditsIsNotNull() {
            addCriterion("credits is not null");
            return (Criteria) this;
        }

        public Criteria andCreditsEqualTo(Integer value) {
            addCriterion("credits =", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotEqualTo(Integer value) {
            addCriterion("credits <>", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThan(Integer value) {
            addCriterion("credits >", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsGreaterThanOrEqualTo(Integer value) {
            addCriterion("credits >=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThan(Integer value) {
            addCriterion("credits <", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsLessThanOrEqualTo(Integer value) {
            addCriterion("credits <=", value, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsIn(List<Integer> values) {
            addCriterion("credits in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotIn(List<Integer> values) {
            addCriterion("credits not in", values, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsBetween(Integer value1, Integer value2) {
            addCriterion("credits between", value1, value2, "credits");
            return (Criteria) this;
        }

        public Criteria andCreditsNotBetween(Integer value1, Integer value2) {
            addCriterion("credits not between", value1, value2, "credits");
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