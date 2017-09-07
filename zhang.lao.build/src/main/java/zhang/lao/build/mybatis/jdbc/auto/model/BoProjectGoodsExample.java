package zhang.lao.build.mybatis.jdbc.auto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BoProjectGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoProjectGoodsExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNull() {
            addCriterion("build_area is null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNotNull() {
            addCriterion("build_area is not null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaEqualTo(BigDecimal value) {
            addCriterion("build_area =", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotEqualTo(BigDecimal value) {
            addCriterion("build_area <>", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThan(BigDecimal value) {
            addCriterion("build_area >", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("build_area >=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThan(BigDecimal value) {
            addCriterion("build_area <", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("build_area <=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIn(List<BigDecimal> values) {
            addCriterion("build_area in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotIn(List<BigDecimal> values) {
            addCriterion("build_area not in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("build_area between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("build_area not between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andEquityPriceIsNull() {
            addCriterion("equity_price is null");
            return (Criteria) this;
        }

        public Criteria andEquityPriceIsNotNull() {
            addCriterion("equity_price is not null");
            return (Criteria) this;
        }

        public Criteria andEquityPriceEqualTo(BigDecimal value) {
            addCriterion("equity_price =", value, "equityPrice");
            return (Criteria) this;
        }

        public Criteria andEquityPriceNotEqualTo(BigDecimal value) {
            addCriterion("equity_price <>", value, "equityPrice");
            return (Criteria) this;
        }

        public Criteria andEquityPriceGreaterThan(BigDecimal value) {
            addCriterion("equity_price >", value, "equityPrice");
            return (Criteria) this;
        }

        public Criteria andEquityPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("equity_price >=", value, "equityPrice");
            return (Criteria) this;
        }

        public Criteria andEquityPriceLessThan(BigDecimal value) {
            addCriterion("equity_price <", value, "equityPrice");
            return (Criteria) this;
        }

        public Criteria andEquityPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("equity_price <=", value, "equityPrice");
            return (Criteria) this;
        }

        public Criteria andEquityPriceIn(List<BigDecimal> values) {
            addCriterion("equity_price in", values, "equityPrice");
            return (Criteria) this;
        }

        public Criteria andEquityPriceNotIn(List<BigDecimal> values) {
            addCriterion("equity_price not in", values, "equityPrice");
            return (Criteria) this;
        }

        public Criteria andEquityPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("equity_price between", value1, value2, "equityPrice");
            return (Criteria) this;
        }

        public Criteria andEquityPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("equity_price not between", value1, value2, "equityPrice");
            return (Criteria) this;
        }

        public Criteria andAdminPriceIsNull() {
            addCriterion("admin_price is null");
            return (Criteria) this;
        }

        public Criteria andAdminPriceIsNotNull() {
            addCriterion("admin_price is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPriceEqualTo(BigDecimal value) {
            addCriterion("admin_price =", value, "adminPrice");
            return (Criteria) this;
        }

        public Criteria andAdminPriceNotEqualTo(BigDecimal value) {
            addCriterion("admin_price <>", value, "adminPrice");
            return (Criteria) this;
        }

        public Criteria andAdminPriceGreaterThan(BigDecimal value) {
            addCriterion("admin_price >", value, "adminPrice");
            return (Criteria) this;
        }

        public Criteria andAdminPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("admin_price >=", value, "adminPrice");
            return (Criteria) this;
        }

        public Criteria andAdminPriceLessThan(BigDecimal value) {
            addCriterion("admin_price <", value, "adminPrice");
            return (Criteria) this;
        }

        public Criteria andAdminPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("admin_price <=", value, "adminPrice");
            return (Criteria) this;
        }

        public Criteria andAdminPriceIn(List<BigDecimal> values) {
            addCriterion("admin_price in", values, "adminPrice");
            return (Criteria) this;
        }

        public Criteria andAdminPriceNotIn(List<BigDecimal> values) {
            addCriterion("admin_price not in", values, "adminPrice");
            return (Criteria) this;
        }

        public Criteria andAdminPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("admin_price between", value1, value2, "adminPrice");
            return (Criteria) this;
        }

        public Criteria andAdminPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("admin_price not between", value1, value2, "adminPrice");
            return (Criteria) this;
        }

        public Criteria andImageCoverIsNull() {
            addCriterion("image_cover is null");
            return (Criteria) this;
        }

        public Criteria andImageCoverIsNotNull() {
            addCriterion("image_cover is not null");
            return (Criteria) this;
        }

        public Criteria andImageCoverEqualTo(String value) {
            addCriterion("image_cover =", value, "imageCover");
            return (Criteria) this;
        }

        public Criteria andImageCoverNotEqualTo(String value) {
            addCriterion("image_cover <>", value, "imageCover");
            return (Criteria) this;
        }

        public Criteria andImageCoverGreaterThan(String value) {
            addCriterion("image_cover >", value, "imageCover");
            return (Criteria) this;
        }

        public Criteria andImageCoverGreaterThanOrEqualTo(String value) {
            addCriterion("image_cover >=", value, "imageCover");
            return (Criteria) this;
        }

        public Criteria andImageCoverLessThan(String value) {
            addCriterion("image_cover <", value, "imageCover");
            return (Criteria) this;
        }

        public Criteria andImageCoverLessThanOrEqualTo(String value) {
            addCriterion("image_cover <=", value, "imageCover");
            return (Criteria) this;
        }

        public Criteria andImageCoverLike(String value) {
            addCriterion("image_cover like", value, "imageCover");
            return (Criteria) this;
        }

        public Criteria andImageCoverNotLike(String value) {
            addCriterion("image_cover not like", value, "imageCover");
            return (Criteria) this;
        }

        public Criteria andImageCoverIn(List<String> values) {
            addCriterion("image_cover in", values, "imageCover");
            return (Criteria) this;
        }

        public Criteria andImageCoverNotIn(List<String> values) {
            addCriterion("image_cover not in", values, "imageCover");
            return (Criteria) this;
        }

        public Criteria andImageCoverBetween(String value1, String value2) {
            addCriterion("image_cover between", value1, value2, "imageCover");
            return (Criteria) this;
        }

        public Criteria andImageCoverNotBetween(String value1, String value2) {
            addCriterion("image_cover not between", value1, value2, "imageCover");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
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