package zhang.lao.mybatis.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogStatureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogStatureExample() {
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthIsNull() {
            addCriterion("shoulder_breadth is null");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthIsNotNull() {
            addCriterion("shoulder_breadth is not null");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthEqualTo(String value) {
            addCriterion("shoulder_breadth =", value, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthNotEqualTo(String value) {
            addCriterion("shoulder_breadth <>", value, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthGreaterThan(String value) {
            addCriterion("shoulder_breadth >", value, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthGreaterThanOrEqualTo(String value) {
            addCriterion("shoulder_breadth >=", value, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthLessThan(String value) {
            addCriterion("shoulder_breadth <", value, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthLessThanOrEqualTo(String value) {
            addCriterion("shoulder_breadth <=", value, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthLike(String value) {
            addCriterion("shoulder_breadth like", value, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthNotLike(String value) {
            addCriterion("shoulder_breadth not like", value, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthIn(List<String> values) {
            addCriterion("shoulder_breadth in", values, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthNotIn(List<String> values) {
            addCriterion("shoulder_breadth not in", values, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthBetween(String value1, String value2) {
            addCriterion("shoulder_breadth between", value1, value2, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andShoulderBreadthNotBetween(String value1, String value2) {
            addCriterion("shoulder_breadth not between", value1, value2, "shoulderBreadth");
            return (Criteria) this;
        }

        public Criteria andHiplineIsNull() {
            addCriterion("hipline is null");
            return (Criteria) this;
        }

        public Criteria andHiplineIsNotNull() {
            addCriterion("hipline is not null");
            return (Criteria) this;
        }

        public Criteria andHiplineEqualTo(String value) {
            addCriterion("hipline =", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineNotEqualTo(String value) {
            addCriterion("hipline <>", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineGreaterThan(String value) {
            addCriterion("hipline >", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineGreaterThanOrEqualTo(String value) {
            addCriterion("hipline >=", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineLessThan(String value) {
            addCriterion("hipline <", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineLessThanOrEqualTo(String value) {
            addCriterion("hipline <=", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineLike(String value) {
            addCriterion("hipline like", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineNotLike(String value) {
            addCriterion("hipline not like", value, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineIn(List<String> values) {
            addCriterion("hipline in", values, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineNotIn(List<String> values) {
            addCriterion("hipline not in", values, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineBetween(String value1, String value2) {
            addCriterion("hipline between", value1, value2, "hipline");
            return (Criteria) this;
        }

        public Criteria andHiplineNotBetween(String value1, String value2) {
            addCriterion("hipline not between", value1, value2, "hipline");
            return (Criteria) this;
        }

        public Criteria andWaistlineIsNull() {
            addCriterion("waistline is null");
            return (Criteria) this;
        }

        public Criteria andWaistlineIsNotNull() {
            addCriterion("waistline is not null");
            return (Criteria) this;
        }

        public Criteria andWaistlineEqualTo(String value) {
            addCriterion("waistline =", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineNotEqualTo(String value) {
            addCriterion("waistline <>", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineGreaterThan(String value) {
            addCriterion("waistline >", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineGreaterThanOrEqualTo(String value) {
            addCriterion("waistline >=", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineLessThan(String value) {
            addCriterion("waistline <", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineLessThanOrEqualTo(String value) {
            addCriterion("waistline <=", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineLike(String value) {
            addCriterion("waistline like", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineNotLike(String value) {
            addCriterion("waistline not like", value, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineIn(List<String> values) {
            addCriterion("waistline in", values, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineNotIn(List<String> values) {
            addCriterion("waistline not in", values, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineBetween(String value1, String value2) {
            addCriterion("waistline between", value1, value2, "waistline");
            return (Criteria) this;
        }

        public Criteria andWaistlineNotBetween(String value1, String value2) {
            addCriterion("waistline not between", value1, value2, "waistline");
            return (Criteria) this;
        }

        public Criteria andBustIsNull() {
            addCriterion("bust is null");
            return (Criteria) this;
        }

        public Criteria andBustIsNotNull() {
            addCriterion("bust is not null");
            return (Criteria) this;
        }

        public Criteria andBustEqualTo(String value) {
            addCriterion("bust =", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustNotEqualTo(String value) {
            addCriterion("bust <>", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustGreaterThan(String value) {
            addCriterion("bust >", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustGreaterThanOrEqualTo(String value) {
            addCriterion("bust >=", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustLessThan(String value) {
            addCriterion("bust <", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustLessThanOrEqualTo(String value) {
            addCriterion("bust <=", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustLike(String value) {
            addCriterion("bust like", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustNotLike(String value) {
            addCriterion("bust not like", value, "bust");
            return (Criteria) this;
        }

        public Criteria andBustIn(List<String> values) {
            addCriterion("bust in", values, "bust");
            return (Criteria) this;
        }

        public Criteria andBustNotIn(List<String> values) {
            addCriterion("bust not in", values, "bust");
            return (Criteria) this;
        }

        public Criteria andBustBetween(String value1, String value2) {
            addCriterion("bust between", value1, value2, "bust");
            return (Criteria) this;
        }

        public Criteria andBustNotBetween(String value1, String value2) {
            addCriterion("bust not between", value1, value2, "bust");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(String value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(String value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(String value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(String value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(String value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(String value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLike(String value) {
            addCriterion("weight like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotLike(String value) {
            addCriterion("weight not like", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<String> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<String> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(String value1, String value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(String value1, String value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<String> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<String> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNull() {
            addCriterion("device_type is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIsNotNull() {
            addCriterion("device_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeEqualTo(String value) {
            addCriterion("device_type =", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotEqualTo(String value) {
            addCriterion("device_type <>", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThan(String value) {
            addCriterion("device_type >", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("device_type >=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThan(String value) {
            addCriterion("device_type <", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLessThanOrEqualTo(String value) {
            addCriterion("device_type <=", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeLike(String value) {
            addCriterion("device_type like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotLike(String value) {
            addCriterion("device_type not like", value, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIn(List<String> values) {
            addCriterion("device_type in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotIn(List<String> values) {
            addCriterion("device_type not in", values, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeBetween(String value1, String value2) {
            addCriterion("device_type between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNotBetween(String value1, String value2) {
            addCriterion("device_type not between", value1, value2, "deviceType");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyIsNull() {
            addCriterion("device_key is null");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyIsNotNull() {
            addCriterion("device_key is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyEqualTo(String value) {
            addCriterion("device_key =", value, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyNotEqualTo(String value) {
            addCriterion("device_key <>", value, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyGreaterThan(String value) {
            addCriterion("device_key >", value, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyGreaterThanOrEqualTo(String value) {
            addCriterion("device_key >=", value, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyLessThan(String value) {
            addCriterion("device_key <", value, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyLessThanOrEqualTo(String value) {
            addCriterion("device_key <=", value, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyLike(String value) {
            addCriterion("device_key like", value, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyNotLike(String value) {
            addCriterion("device_key not like", value, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyIn(List<String> values) {
            addCriterion("device_key in", values, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyNotIn(List<String> values) {
            addCriterion("device_key not in", values, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyBetween(String value1, String value2) {
            addCriterion("device_key between", value1, value2, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andDeviceKeyNotBetween(String value1, String value2) {
            addCriterion("device_key not between", value1, value2, "deviceKey");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andAppUuidIsNull() {
            addCriterion("app_uuid is null");
            return (Criteria) this;
        }

        public Criteria andAppUuidIsNotNull() {
            addCriterion("app_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andAppUuidEqualTo(String value) {
            addCriterion("app_uuid =", value, "appUuid");
            return (Criteria) this;
        }

        public Criteria andAppUuidNotEqualTo(String value) {
            addCriterion("app_uuid <>", value, "appUuid");
            return (Criteria) this;
        }

        public Criteria andAppUuidGreaterThan(String value) {
            addCriterion("app_uuid >", value, "appUuid");
            return (Criteria) this;
        }

        public Criteria andAppUuidGreaterThanOrEqualTo(String value) {
            addCriterion("app_uuid >=", value, "appUuid");
            return (Criteria) this;
        }

        public Criteria andAppUuidLessThan(String value) {
            addCriterion("app_uuid <", value, "appUuid");
            return (Criteria) this;
        }

        public Criteria andAppUuidLessThanOrEqualTo(String value) {
            addCriterion("app_uuid <=", value, "appUuid");
            return (Criteria) this;
        }

        public Criteria andAppUuidLike(String value) {
            addCriterion("app_uuid like", value, "appUuid");
            return (Criteria) this;
        }

        public Criteria andAppUuidNotLike(String value) {
            addCriterion("app_uuid not like", value, "appUuid");
            return (Criteria) this;
        }

        public Criteria andAppUuidIn(List<String> values) {
            addCriterion("app_uuid in", values, "appUuid");
            return (Criteria) this;
        }

        public Criteria andAppUuidNotIn(List<String> values) {
            addCriterion("app_uuid not in", values, "appUuid");
            return (Criteria) this;
        }

        public Criteria andAppUuidBetween(String value1, String value2) {
            addCriterion("app_uuid between", value1, value2, "appUuid");
            return (Criteria) this;
        }

        public Criteria andAppUuidNotBetween(String value1, String value2) {
            addCriterion("app_uuid not between", value1, value2, "appUuid");
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