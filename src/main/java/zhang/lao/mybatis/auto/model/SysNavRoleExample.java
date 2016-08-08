package zhang.lao.mybatis.auto.model;

import java.util.ArrayList;
import java.util.List;

public class SysNavRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysNavRoleExample() {
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

        public Criteria andSnrIdIsNull() {
            addCriterion("SNR_ID is null");
            return (Criteria) this;
        }

        public Criteria andSnrIdIsNotNull() {
            addCriterion("SNR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSnrIdEqualTo(Long value) {
            addCriterion("SNR_ID =", value, "snrId");
            return (Criteria) this;
        }

        public Criteria andSnrIdNotEqualTo(Long value) {
            addCriterion("SNR_ID <>", value, "snrId");
            return (Criteria) this;
        }

        public Criteria andSnrIdGreaterThan(Long value) {
            addCriterion("SNR_ID >", value, "snrId");
            return (Criteria) this;
        }

        public Criteria andSnrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SNR_ID >=", value, "snrId");
            return (Criteria) this;
        }

        public Criteria andSnrIdLessThan(Long value) {
            addCriterion("SNR_ID <", value, "snrId");
            return (Criteria) this;
        }

        public Criteria andSnrIdLessThanOrEqualTo(Long value) {
            addCriterion("SNR_ID <=", value, "snrId");
            return (Criteria) this;
        }

        public Criteria andSnrIdIn(List<Long> values) {
            addCriterion("SNR_ID in", values, "snrId");
            return (Criteria) this;
        }

        public Criteria andSnrIdNotIn(List<Long> values) {
            addCriterion("SNR_ID not in", values, "snrId");
            return (Criteria) this;
        }

        public Criteria andSnrIdBetween(Long value1, Long value2) {
            addCriterion("SNR_ID between", value1, value2, "snrId");
            return (Criteria) this;
        }

        public Criteria andSnrIdNotBetween(Long value1, Long value2) {
            addCriterion("SNR_ID not between", value1, value2, "snrId");
            return (Criteria) this;
        }

        public Criteria andNavIdIsNull() {
            addCriterion("NAV_ID is null");
            return (Criteria) this;
        }

        public Criteria andNavIdIsNotNull() {
            addCriterion("NAV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNavIdEqualTo(Long value) {
            addCriterion("NAV_ID =", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdNotEqualTo(Long value) {
            addCriterion("NAV_ID <>", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdGreaterThan(Long value) {
            addCriterion("NAV_ID >", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdGreaterThanOrEqualTo(Long value) {
            addCriterion("NAV_ID >=", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdLessThan(Long value) {
            addCriterion("NAV_ID <", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdLessThanOrEqualTo(Long value) {
            addCriterion("NAV_ID <=", value, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdIn(List<Long> values) {
            addCriterion("NAV_ID in", values, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdNotIn(List<Long> values) {
            addCriterion("NAV_ID not in", values, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdBetween(Long value1, Long value2) {
            addCriterion("NAV_ID between", value1, value2, "navId");
            return (Criteria) this;
        }

        public Criteria andNavIdNotBetween(Long value1, Long value2) {
            addCriterion("NAV_ID not between", value1, value2, "navId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Long value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Long value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Long value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Long value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Long value1, Long value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
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