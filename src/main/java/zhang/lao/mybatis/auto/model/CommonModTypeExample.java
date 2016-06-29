package zhang.lao.mybatis.auto.model;

import java.util.ArrayList;
import java.util.List;

public class CommonModTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommonModTypeExample() {
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

        public Criteria andMtIdIsNull() {
            addCriterion("mt_id is null");
            return (Criteria) this;
        }

        public Criteria andMtIdIsNotNull() {
            addCriterion("mt_id is not null");
            return (Criteria) this;
        }

        public Criteria andMtIdEqualTo(Integer value) {
            addCriterion("mt_id =", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotEqualTo(Integer value) {
            addCriterion("mt_id <>", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdGreaterThan(Integer value) {
            addCriterion("mt_id >", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mt_id >=", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdLessThan(Integer value) {
            addCriterion("mt_id <", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdLessThanOrEqualTo(Integer value) {
            addCriterion("mt_id <=", value, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdIn(List<Integer> values) {
            addCriterion("mt_id in", values, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotIn(List<Integer> values) {
            addCriterion("mt_id not in", values, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdBetween(Integer value1, Integer value2) {
            addCriterion("mt_id between", value1, value2, "mtId");
            return (Criteria) this;
        }

        public Criteria andMtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mt_id not between", value1, value2, "mtId");
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

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Short value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Short value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Short value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Short value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Short value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Short> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Short> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Short value1, Short value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Short value1, Short value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNull() {
            addCriterion("app_type is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNotNull() {
            addCriterion("app_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeEqualTo(Short value) {
            addCriterion("app_type =", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotEqualTo(Short value) {
            addCriterion("app_type <>", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThan(Short value) {
            addCriterion("app_type >", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("app_type >=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThan(Short value) {
            addCriterion("app_type <", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThanOrEqualTo(Short value) {
            addCriterion("app_type <=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeIn(List<Short> values) {
            addCriterion("app_type in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotIn(List<Short> values) {
            addCriterion("app_type not in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeBetween(Short value1, Short value2) {
            addCriterion("app_type between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotBetween(Short value1, Short value2) {
            addCriterion("app_type not between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andUpDownIsNull() {
            addCriterion("up_down is null");
            return (Criteria) this;
        }

        public Criteria andUpDownIsNotNull() {
            addCriterion("up_down is not null");
            return (Criteria) this;
        }

        public Criteria andUpDownEqualTo(String value) {
            addCriterion("up_down =", value, "upDown");
            return (Criteria) this;
        }

        public Criteria andUpDownNotEqualTo(String value) {
            addCriterion("up_down <>", value, "upDown");
            return (Criteria) this;
        }

        public Criteria andUpDownGreaterThan(String value) {
            addCriterion("up_down >", value, "upDown");
            return (Criteria) this;
        }

        public Criteria andUpDownGreaterThanOrEqualTo(String value) {
            addCriterion("up_down >=", value, "upDown");
            return (Criteria) this;
        }

        public Criteria andUpDownLessThan(String value) {
            addCriterion("up_down <", value, "upDown");
            return (Criteria) this;
        }

        public Criteria andUpDownLessThanOrEqualTo(String value) {
            addCriterion("up_down <=", value, "upDown");
            return (Criteria) this;
        }

        public Criteria andUpDownLike(String value) {
            addCriterion("up_down like", value, "upDown");
            return (Criteria) this;
        }

        public Criteria andUpDownNotLike(String value) {
            addCriterion("up_down not like", value, "upDown");
            return (Criteria) this;
        }

        public Criteria andUpDownIn(List<String> values) {
            addCriterion("up_down in", values, "upDown");
            return (Criteria) this;
        }

        public Criteria andUpDownNotIn(List<String> values) {
            addCriterion("up_down not in", values, "upDown");
            return (Criteria) this;
        }

        public Criteria andUpDownBetween(String value1, String value2) {
            addCriterion("up_down between", value1, value2, "upDown");
            return (Criteria) this;
        }

        public Criteria andUpDownNotBetween(String value1, String value2) {
            addCriterion("up_down not between", value1, value2, "upDown");
            return (Criteria) this;
        }

        public Criteria andIdListIsNull() {
            addCriterion("id_list is null");
            return (Criteria) this;
        }

        public Criteria andIdListIsNotNull() {
            addCriterion("id_list is not null");
            return (Criteria) this;
        }

        public Criteria andIdListEqualTo(String value) {
            addCriterion("id_list =", value, "idList");
            return (Criteria) this;
        }

        public Criteria andIdListNotEqualTo(String value) {
            addCriterion("id_list <>", value, "idList");
            return (Criteria) this;
        }

        public Criteria andIdListGreaterThan(String value) {
            addCriterion("id_list >", value, "idList");
            return (Criteria) this;
        }

        public Criteria andIdListGreaterThanOrEqualTo(String value) {
            addCriterion("id_list >=", value, "idList");
            return (Criteria) this;
        }

        public Criteria andIdListLessThan(String value) {
            addCriterion("id_list <", value, "idList");
            return (Criteria) this;
        }

        public Criteria andIdListLessThanOrEqualTo(String value) {
            addCriterion("id_list <=", value, "idList");
            return (Criteria) this;
        }

        public Criteria andIdListLike(String value) {
            addCriterion("id_list like", value, "idList");
            return (Criteria) this;
        }

        public Criteria andIdListNotLike(String value) {
            addCriterion("id_list not like", value, "idList");
            return (Criteria) this;
        }

        public Criteria andIdListIn(List<String> values) {
            addCriterion("id_list in", values, "idList");
            return (Criteria) this;
        }

        public Criteria andIdListNotIn(List<String> values) {
            addCriterion("id_list not in", values, "idList");
            return (Criteria) this;
        }

        public Criteria andIdListBetween(String value1, String value2) {
            addCriterion("id_list between", value1, value2, "idList");
            return (Criteria) this;
        }

        public Criteria andIdListNotBetween(String value1, String value2) {
            addCriterion("id_list not between", value1, value2, "idList");
            return (Criteria) this;
        }

        public Criteria andShowImgIsNull() {
            addCriterion("show_img is null");
            return (Criteria) this;
        }

        public Criteria andShowImgIsNotNull() {
            addCriterion("show_img is not null");
            return (Criteria) this;
        }

        public Criteria andShowImgEqualTo(String value) {
            addCriterion("show_img =", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotEqualTo(String value) {
            addCriterion("show_img <>", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgGreaterThan(String value) {
            addCriterion("show_img >", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgGreaterThanOrEqualTo(String value) {
            addCriterion("show_img >=", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgLessThan(String value) {
            addCriterion("show_img <", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgLessThanOrEqualTo(String value) {
            addCriterion("show_img <=", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgLike(String value) {
            addCriterion("show_img like", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotLike(String value) {
            addCriterion("show_img not like", value, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgIn(List<String> values) {
            addCriterion("show_img in", values, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotIn(List<String> values) {
            addCriterion("show_img not in", values, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgBetween(String value1, String value2) {
            addCriterion("show_img between", value1, value2, "showImg");
            return (Criteria) this;
        }

        public Criteria andShowImgNotBetween(String value1, String value2) {
            addCriterion("show_img not between", value1, value2, "showImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgIsNull() {
            addCriterion("selected_img is null");
            return (Criteria) this;
        }

        public Criteria andSelectedImgIsNotNull() {
            addCriterion("selected_img is not null");
            return (Criteria) this;
        }

        public Criteria andSelectedImgEqualTo(String value) {
            addCriterion("selected_img =", value, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgNotEqualTo(String value) {
            addCriterion("selected_img <>", value, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgGreaterThan(String value) {
            addCriterion("selected_img >", value, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgGreaterThanOrEqualTo(String value) {
            addCriterion("selected_img >=", value, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgLessThan(String value) {
            addCriterion("selected_img <", value, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgLessThanOrEqualTo(String value) {
            addCriterion("selected_img <=", value, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgLike(String value) {
            addCriterion("selected_img like", value, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgNotLike(String value) {
            addCriterion("selected_img not like", value, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgIn(List<String> values) {
            addCriterion("selected_img in", values, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgNotIn(List<String> values) {
            addCriterion("selected_img not in", values, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgBetween(String value1, String value2) {
            addCriterion("selected_img between", value1, value2, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSelectedImgNotBetween(String value1, String value2) {
            addCriterion("selected_img not between", value1, value2, "selectedImg");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Short value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Short value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Short value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Short value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Short value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Short value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Short> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Short> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Short value1, Short value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Short value1, Short value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
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