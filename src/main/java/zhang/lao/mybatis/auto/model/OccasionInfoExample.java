package zhang.lao.mybatis.auto.model;

import java.util.ArrayList;
import java.util.List;

public class OccasionInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OccasionInfoExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCsIdIsNull() {
            addCriterion("cs_id is null");
            return (Criteria) this;
        }

        public Criteria andCsIdIsNotNull() {
            addCriterion("cs_id is not null");
            return (Criteria) this;
        }

        public Criteria andCsIdEqualTo(Integer value) {
            addCriterion("cs_id =", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotEqualTo(Integer value) {
            addCriterion("cs_id <>", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdGreaterThan(Integer value) {
            addCriterion("cs_id >", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cs_id >=", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdLessThan(Integer value) {
            addCriterion("cs_id <", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdLessThanOrEqualTo(Integer value) {
            addCriterion("cs_id <=", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdIn(List<Integer> values) {
            addCriterion("cs_id in", values, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotIn(List<Integer> values) {
            addCriterion("cs_id not in", values, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdBetween(Integer value1, Integer value2) {
            addCriterion("cs_id between", value1, value2, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cs_id not between", value1, value2, "csId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsIsNull() {
            addCriterion("goods_ids is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsIsNotNull() {
            addCriterion("goods_ids is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsEqualTo(String value) {
            addCriterion("goods_ids =", value, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsNotEqualTo(String value) {
            addCriterion("goods_ids <>", value, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsGreaterThan(String value) {
            addCriterion("goods_ids >", value, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsGreaterThanOrEqualTo(String value) {
            addCriterion("goods_ids >=", value, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsLessThan(String value) {
            addCriterion("goods_ids <", value, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsLessThanOrEqualTo(String value) {
            addCriterion("goods_ids <=", value, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsLike(String value) {
            addCriterion("goods_ids like", value, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsNotLike(String value) {
            addCriterion("goods_ids not like", value, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsIn(List<String> values) {
            addCriterion("goods_ids in", values, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsNotIn(List<String> values) {
            addCriterion("goods_ids not in", values, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsBetween(String value1, String value2) {
            addCriterion("goods_ids between", value1, value2, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andGoodsIdsNotBetween(String value1, String value2) {
            addCriterion("goods_ids not between", value1, value2, "goodsIds");
            return (Criteria) this;
        }

        public Criteria andStyleNameIsNull() {
            addCriterion("style_name is null");
            return (Criteria) this;
        }

        public Criteria andStyleNameIsNotNull() {
            addCriterion("style_name is not null");
            return (Criteria) this;
        }

        public Criteria andStyleNameEqualTo(String value) {
            addCriterion("style_name =", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotEqualTo(String value) {
            addCriterion("style_name <>", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameGreaterThan(String value) {
            addCriterion("style_name >", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameGreaterThanOrEqualTo(String value) {
            addCriterion("style_name >=", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameLessThan(String value) {
            addCriterion("style_name <", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameLessThanOrEqualTo(String value) {
            addCriterion("style_name <=", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameLike(String value) {
            addCriterion("style_name like", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotLike(String value) {
            addCriterion("style_name not like", value, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameIn(List<String> values) {
            addCriterion("style_name in", values, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotIn(List<String> values) {
            addCriterion("style_name not in", values, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameBetween(String value1, String value2) {
            addCriterion("style_name between", value1, value2, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleNameNotBetween(String value1, String value2) {
            addCriterion("style_name not between", value1, value2, "styleName");
            return (Criteria) this;
        }

        public Criteria andStyleImageIsNull() {
            addCriterion("style_image is null");
            return (Criteria) this;
        }

        public Criteria andStyleImageIsNotNull() {
            addCriterion("style_image is not null");
            return (Criteria) this;
        }

        public Criteria andStyleImageEqualTo(String value) {
            addCriterion("style_image =", value, "styleImage");
            return (Criteria) this;
        }

        public Criteria andStyleImageNotEqualTo(String value) {
            addCriterion("style_image <>", value, "styleImage");
            return (Criteria) this;
        }

        public Criteria andStyleImageGreaterThan(String value) {
            addCriterion("style_image >", value, "styleImage");
            return (Criteria) this;
        }

        public Criteria andStyleImageGreaterThanOrEqualTo(String value) {
            addCriterion("style_image >=", value, "styleImage");
            return (Criteria) this;
        }

        public Criteria andStyleImageLessThan(String value) {
            addCriterion("style_image <", value, "styleImage");
            return (Criteria) this;
        }

        public Criteria andStyleImageLessThanOrEqualTo(String value) {
            addCriterion("style_image <=", value, "styleImage");
            return (Criteria) this;
        }

        public Criteria andStyleImageLike(String value) {
            addCriterion("style_image like", value, "styleImage");
            return (Criteria) this;
        }

        public Criteria andStyleImageNotLike(String value) {
            addCriterion("style_image not like", value, "styleImage");
            return (Criteria) this;
        }

        public Criteria andStyleImageIn(List<String> values) {
            addCriterion("style_image in", values, "styleImage");
            return (Criteria) this;
        }

        public Criteria andStyleImageNotIn(List<String> values) {
            addCriterion("style_image not in", values, "styleImage");
            return (Criteria) this;
        }

        public Criteria andStyleImageBetween(String value1, String value2) {
            addCriterion("style_image between", value1, value2, "styleImage");
            return (Criteria) this;
        }

        public Criteria andStyleImageNotBetween(String value1, String value2) {
            addCriterion("style_image not between", value1, value2, "styleImage");
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