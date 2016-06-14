package zhang.lao.mybatis.auto.model;

import java.util.ArrayList;
import java.util.List;

public class SysCompanyUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysCompanyUserExample() {
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

        public Criteria andCuIdIsNull() {
            addCriterion("cu_id is null");
            return (Criteria) this;
        }

        public Criteria andCuIdIsNotNull() {
            addCriterion("cu_id is not null");
            return (Criteria) this;
        }

        public Criteria andCuIdEqualTo(Integer value) {
            addCriterion("cu_id =", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdNotEqualTo(Integer value) {
            addCriterion("cu_id <>", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdGreaterThan(Integer value) {
            addCriterion("cu_id >", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cu_id >=", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdLessThan(Integer value) {
            addCriterion("cu_id <", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdLessThanOrEqualTo(Integer value) {
            addCriterion("cu_id <=", value, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdIn(List<Integer> values) {
            addCriterion("cu_id in", values, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdNotIn(List<Integer> values) {
            addCriterion("cu_id not in", values, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdBetween(Integer value1, Integer value2) {
            addCriterion("cu_id between", value1, value2, "cuId");
            return (Criteria) this;
        }

        public Criteria andCuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cu_id not between", value1, value2, "cuId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andSuIdIsNull() {
            addCriterion("su_id is null");
            return (Criteria) this;
        }

        public Criteria andSuIdIsNotNull() {
            addCriterion("su_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuIdEqualTo(Integer value) {
            addCriterion("su_id =", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdNotEqualTo(Integer value) {
            addCriterion("su_id <>", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdGreaterThan(Integer value) {
            addCriterion("su_id >", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("su_id >=", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdLessThan(Integer value) {
            addCriterion("su_id <", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdLessThanOrEqualTo(Integer value) {
            addCriterion("su_id <=", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdIn(List<Integer> values) {
            addCriterion("su_id in", values, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdNotIn(List<Integer> values) {
            addCriterion("su_id not in", values, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdBetween(Integer value1, Integer value2) {
            addCriterion("su_id between", value1, value2, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("su_id not between", value1, value2, "suId");
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