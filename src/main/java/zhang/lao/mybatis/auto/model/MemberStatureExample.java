package zhang.lao.mybatis.auto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberStatureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberStatureExample() {
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

        public Criteria andMsIdIsNull() {
            addCriterion("ms_id is null");
            return (Criteria) this;
        }

        public Criteria andMsIdIsNotNull() {
            addCriterion("ms_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsIdEqualTo(Long value) {
            addCriterion("ms_id =", value, "msId");
            return (Criteria) this;
        }

        public Criteria andMsIdNotEqualTo(Long value) {
            addCriterion("ms_id <>", value, "msId");
            return (Criteria) this;
        }

        public Criteria andMsIdGreaterThan(Long value) {
            addCriterion("ms_id >", value, "msId");
            return (Criteria) this;
        }

        public Criteria andMsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ms_id >=", value, "msId");
            return (Criteria) this;
        }

        public Criteria andMsIdLessThan(Long value) {
            addCriterion("ms_id <", value, "msId");
            return (Criteria) this;
        }

        public Criteria andMsIdLessThanOrEqualTo(Long value) {
            addCriterion("ms_id <=", value, "msId");
            return (Criteria) this;
        }

        public Criteria andMsIdIn(List<Long> values) {
            addCriterion("ms_id in", values, "msId");
            return (Criteria) this;
        }

        public Criteria andMsIdNotIn(List<Long> values) {
            addCriterion("ms_id not in", values, "msId");
            return (Criteria) this;
        }

        public Criteria andMsIdBetween(Long value1, Long value2) {
            addCriterion("ms_id between", value1, value2, "msId");
            return (Criteria) this;
        }

        public Criteria andMsIdNotBetween(Long value1, Long value2) {
            addCriterion("ms_id not between", value1, value2, "msId");
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

        public Criteria andUSexIsNull() {
            addCriterion("u_sex is null");
            return (Criteria) this;
        }

        public Criteria andUSexIsNotNull() {
            addCriterion("u_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUSexEqualTo(String value) {
            addCriterion("u_sex =", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotEqualTo(String value) {
            addCriterion("u_sex <>", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThan(String value) {
            addCriterion("u_sex >", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexGreaterThanOrEqualTo(String value) {
            addCriterion("u_sex >=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThan(String value) {
            addCriterion("u_sex <", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLessThanOrEqualTo(String value) {
            addCriterion("u_sex <=", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexLike(String value) {
            addCriterion("u_sex like", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotLike(String value) {
            addCriterion("u_sex not like", value, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexIn(List<String> values) {
            addCriterion("u_sex in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotIn(List<String> values) {
            addCriterion("u_sex not in", values, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexBetween(String value1, String value2) {
            addCriterion("u_sex between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andUSexNotBetween(String value1, String value2) {
            addCriterion("u_sex not between", value1, value2, "uSex");
            return (Criteria) this;
        }

        public Criteria andModSizeIsNull() {
            addCriterion("mod_size is null");
            return (Criteria) this;
        }

        public Criteria andModSizeIsNotNull() {
            addCriterion("mod_size is not null");
            return (Criteria) this;
        }

        public Criteria andModSizeEqualTo(String value) {
            addCriterion("mod_size =", value, "modSize");
            return (Criteria) this;
        }

        public Criteria andModSizeNotEqualTo(String value) {
            addCriterion("mod_size <>", value, "modSize");
            return (Criteria) this;
        }

        public Criteria andModSizeGreaterThan(String value) {
            addCriterion("mod_size >", value, "modSize");
            return (Criteria) this;
        }

        public Criteria andModSizeGreaterThanOrEqualTo(String value) {
            addCriterion("mod_size >=", value, "modSize");
            return (Criteria) this;
        }

        public Criteria andModSizeLessThan(String value) {
            addCriterion("mod_size <", value, "modSize");
            return (Criteria) this;
        }

        public Criteria andModSizeLessThanOrEqualTo(String value) {
            addCriterion("mod_size <=", value, "modSize");
            return (Criteria) this;
        }

        public Criteria andModSizeLike(String value) {
            addCriterion("mod_size like", value, "modSize");
            return (Criteria) this;
        }

        public Criteria andModSizeNotLike(String value) {
            addCriterion("mod_size not like", value, "modSize");
            return (Criteria) this;
        }

        public Criteria andModSizeIn(List<String> values) {
            addCriterion("mod_size in", values, "modSize");
            return (Criteria) this;
        }

        public Criteria andModSizeNotIn(List<String> values) {
            addCriterion("mod_size not in", values, "modSize");
            return (Criteria) this;
        }

        public Criteria andModSizeBetween(String value1, String value2) {
            addCriterion("mod_size between", value1, value2, "modSize");
            return (Criteria) this;
        }

        public Criteria andModSizeNotBetween(String value1, String value2) {
            addCriterion("mod_size not between", value1, value2, "modSize");
            return (Criteria) this;
        }

        public Criteria andModHeightIsNull() {
            addCriterion("mod_height is null");
            return (Criteria) this;
        }

        public Criteria andModHeightIsNotNull() {
            addCriterion("mod_height is not null");
            return (Criteria) this;
        }

        public Criteria andModHeightEqualTo(BigDecimal value) {
            addCriterion("mod_height =", value, "modHeight");
            return (Criteria) this;
        }

        public Criteria andModHeightNotEqualTo(BigDecimal value) {
            addCriterion("mod_height <>", value, "modHeight");
            return (Criteria) this;
        }

        public Criteria andModHeightGreaterThan(BigDecimal value) {
            addCriterion("mod_height >", value, "modHeight");
            return (Criteria) this;
        }

        public Criteria andModHeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_height >=", value, "modHeight");
            return (Criteria) this;
        }

        public Criteria andModHeightLessThan(BigDecimal value) {
            addCriterion("mod_height <", value, "modHeight");
            return (Criteria) this;
        }

        public Criteria andModHeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_height <=", value, "modHeight");
            return (Criteria) this;
        }

        public Criteria andModHeightIn(List<BigDecimal> values) {
            addCriterion("mod_height in", values, "modHeight");
            return (Criteria) this;
        }

        public Criteria andModHeightNotIn(List<BigDecimal> values) {
            addCriterion("mod_height not in", values, "modHeight");
            return (Criteria) this;
        }

        public Criteria andModHeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_height between", value1, value2, "modHeight");
            return (Criteria) this;
        }

        public Criteria andModHeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_height not between", value1, value2, "modHeight");
            return (Criteria) this;
        }

        public Criteria andModBustIsNull() {
            addCriterion("mod_bust is null");
            return (Criteria) this;
        }

        public Criteria andModBustIsNotNull() {
            addCriterion("mod_bust is not null");
            return (Criteria) this;
        }

        public Criteria andModBustEqualTo(BigDecimal value) {
            addCriterion("mod_bust =", value, "modBust");
            return (Criteria) this;
        }

        public Criteria andModBustNotEqualTo(BigDecimal value) {
            addCriterion("mod_bust <>", value, "modBust");
            return (Criteria) this;
        }

        public Criteria andModBustGreaterThan(BigDecimal value) {
            addCriterion("mod_bust >", value, "modBust");
            return (Criteria) this;
        }

        public Criteria andModBustGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_bust >=", value, "modBust");
            return (Criteria) this;
        }

        public Criteria andModBustLessThan(BigDecimal value) {
            addCriterion("mod_bust <", value, "modBust");
            return (Criteria) this;
        }

        public Criteria andModBustLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_bust <=", value, "modBust");
            return (Criteria) this;
        }

        public Criteria andModBustIn(List<BigDecimal> values) {
            addCriterion("mod_bust in", values, "modBust");
            return (Criteria) this;
        }

        public Criteria andModBustNotIn(List<BigDecimal> values) {
            addCriterion("mod_bust not in", values, "modBust");
            return (Criteria) this;
        }

        public Criteria andModBustBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_bust between", value1, value2, "modBust");
            return (Criteria) this;
        }

        public Criteria andModBustNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_bust not between", value1, value2, "modBust");
            return (Criteria) this;
        }

        public Criteria andModWaistIsNull() {
            addCriterion("mod_waist is null");
            return (Criteria) this;
        }

        public Criteria andModWaistIsNotNull() {
            addCriterion("mod_waist is not null");
            return (Criteria) this;
        }

        public Criteria andModWaistEqualTo(BigDecimal value) {
            addCriterion("mod_waist =", value, "modWaist");
            return (Criteria) this;
        }

        public Criteria andModWaistNotEqualTo(BigDecimal value) {
            addCriterion("mod_waist <>", value, "modWaist");
            return (Criteria) this;
        }

        public Criteria andModWaistGreaterThan(BigDecimal value) {
            addCriterion("mod_waist >", value, "modWaist");
            return (Criteria) this;
        }

        public Criteria andModWaistGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_waist >=", value, "modWaist");
            return (Criteria) this;
        }

        public Criteria andModWaistLessThan(BigDecimal value) {
            addCriterion("mod_waist <", value, "modWaist");
            return (Criteria) this;
        }

        public Criteria andModWaistLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_waist <=", value, "modWaist");
            return (Criteria) this;
        }

        public Criteria andModWaistIn(List<BigDecimal> values) {
            addCriterion("mod_waist in", values, "modWaist");
            return (Criteria) this;
        }

        public Criteria andModWaistNotIn(List<BigDecimal> values) {
            addCriterion("mod_waist not in", values, "modWaist");
            return (Criteria) this;
        }

        public Criteria andModWaistBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_waist between", value1, value2, "modWaist");
            return (Criteria) this;
        }

        public Criteria andModWaistNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_waist not between", value1, value2, "modWaist");
            return (Criteria) this;
        }

        public Criteria andModHipIsNull() {
            addCriterion("mod_hip is null");
            return (Criteria) this;
        }

        public Criteria andModHipIsNotNull() {
            addCriterion("mod_hip is not null");
            return (Criteria) this;
        }

        public Criteria andModHipEqualTo(BigDecimal value) {
            addCriterion("mod_hip =", value, "modHip");
            return (Criteria) this;
        }

        public Criteria andModHipNotEqualTo(BigDecimal value) {
            addCriterion("mod_hip <>", value, "modHip");
            return (Criteria) this;
        }

        public Criteria andModHipGreaterThan(BigDecimal value) {
            addCriterion("mod_hip >", value, "modHip");
            return (Criteria) this;
        }

        public Criteria andModHipGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_hip >=", value, "modHip");
            return (Criteria) this;
        }

        public Criteria andModHipLessThan(BigDecimal value) {
            addCriterion("mod_hip <", value, "modHip");
            return (Criteria) this;
        }

        public Criteria andModHipLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_hip <=", value, "modHip");
            return (Criteria) this;
        }

        public Criteria andModHipIn(List<BigDecimal> values) {
            addCriterion("mod_hip in", values, "modHip");
            return (Criteria) this;
        }

        public Criteria andModHipNotIn(List<BigDecimal> values) {
            addCriterion("mod_hip not in", values, "modHip");
            return (Criteria) this;
        }

        public Criteria andModHipBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_hip between", value1, value2, "modHip");
            return (Criteria) this;
        }

        public Criteria andModHipNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_hip not between", value1, value2, "modHip");
            return (Criteria) this;
        }

        public Criteria andModWeightIsNull() {
            addCriterion("mod_weight is null");
            return (Criteria) this;
        }

        public Criteria andModWeightIsNotNull() {
            addCriterion("mod_weight is not null");
            return (Criteria) this;
        }

        public Criteria andModWeightEqualTo(BigDecimal value) {
            addCriterion("mod_weight =", value, "modWeight");
            return (Criteria) this;
        }

        public Criteria andModWeightNotEqualTo(BigDecimal value) {
            addCriterion("mod_weight <>", value, "modWeight");
            return (Criteria) this;
        }

        public Criteria andModWeightGreaterThan(BigDecimal value) {
            addCriterion("mod_weight >", value, "modWeight");
            return (Criteria) this;
        }

        public Criteria andModWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_weight >=", value, "modWeight");
            return (Criteria) this;
        }

        public Criteria andModWeightLessThan(BigDecimal value) {
            addCriterion("mod_weight <", value, "modWeight");
            return (Criteria) this;
        }

        public Criteria andModWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_weight <=", value, "modWeight");
            return (Criteria) this;
        }

        public Criteria andModWeightIn(List<BigDecimal> values) {
            addCriterion("mod_weight in", values, "modWeight");
            return (Criteria) this;
        }

        public Criteria andModWeightNotIn(List<BigDecimal> values) {
            addCriterion("mod_weight not in", values, "modWeight");
            return (Criteria) this;
        }

        public Criteria andModWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_weight between", value1, value2, "modWeight");
            return (Criteria) this;
        }

        public Criteria andModWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_weight not between", value1, value2, "modWeight");
            return (Criteria) this;
        }

        public Criteria andModShoulderIsNull() {
            addCriterion("mod_shoulder is null");
            return (Criteria) this;
        }

        public Criteria andModShoulderIsNotNull() {
            addCriterion("mod_shoulder is not null");
            return (Criteria) this;
        }

        public Criteria andModShoulderEqualTo(BigDecimal value) {
            addCriterion("mod_shoulder =", value, "modShoulder");
            return (Criteria) this;
        }

        public Criteria andModShoulderNotEqualTo(BigDecimal value) {
            addCriterion("mod_shoulder <>", value, "modShoulder");
            return (Criteria) this;
        }

        public Criteria andModShoulderGreaterThan(BigDecimal value) {
            addCriterion("mod_shoulder >", value, "modShoulder");
            return (Criteria) this;
        }

        public Criteria andModShoulderGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_shoulder >=", value, "modShoulder");
            return (Criteria) this;
        }

        public Criteria andModShoulderLessThan(BigDecimal value) {
            addCriterion("mod_shoulder <", value, "modShoulder");
            return (Criteria) this;
        }

        public Criteria andModShoulderLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_shoulder <=", value, "modShoulder");
            return (Criteria) this;
        }

        public Criteria andModShoulderIn(List<BigDecimal> values) {
            addCriterion("mod_shoulder in", values, "modShoulder");
            return (Criteria) this;
        }

        public Criteria andModShoulderNotIn(List<BigDecimal> values) {
            addCriterion("mod_shoulder not in", values, "modShoulder");
            return (Criteria) this;
        }

        public Criteria andModShoulderBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_shoulder between", value1, value2, "modShoulder");
            return (Criteria) this;
        }

        public Criteria andModShoulderNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_shoulder not between", value1, value2, "modShoulder");
            return (Criteria) this;
        }

        public Criteria andArmLenIsNull() {
            addCriterion("arm_len is null");
            return (Criteria) this;
        }

        public Criteria andArmLenIsNotNull() {
            addCriterion("arm_len is not null");
            return (Criteria) this;
        }

        public Criteria andArmLenEqualTo(BigDecimal value) {
            addCriterion("arm_len =", value, "armLen");
            return (Criteria) this;
        }

        public Criteria andArmLenNotEqualTo(BigDecimal value) {
            addCriterion("arm_len <>", value, "armLen");
            return (Criteria) this;
        }

        public Criteria andArmLenGreaterThan(BigDecimal value) {
            addCriterion("arm_len >", value, "armLen");
            return (Criteria) this;
        }

        public Criteria andArmLenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("arm_len >=", value, "armLen");
            return (Criteria) this;
        }

        public Criteria andArmLenLessThan(BigDecimal value) {
            addCriterion("arm_len <", value, "armLen");
            return (Criteria) this;
        }

        public Criteria andArmLenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("arm_len <=", value, "armLen");
            return (Criteria) this;
        }

        public Criteria andArmLenIn(List<BigDecimal> values) {
            addCriterion("arm_len in", values, "armLen");
            return (Criteria) this;
        }

        public Criteria andArmLenNotIn(List<BigDecimal> values) {
            addCriterion("arm_len not in", values, "armLen");
            return (Criteria) this;
        }

        public Criteria andArmLenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("arm_len between", value1, value2, "armLen");
            return (Criteria) this;
        }

        public Criteria andArmLenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("arm_len not between", value1, value2, "armLen");
            return (Criteria) this;
        }

        public Criteria andModThighIsNull() {
            addCriterion("mod_thigh is null");
            return (Criteria) this;
        }

        public Criteria andModThighIsNotNull() {
            addCriterion("mod_thigh is not null");
            return (Criteria) this;
        }

        public Criteria andModThighEqualTo(BigDecimal value) {
            addCriterion("mod_thigh =", value, "modThigh");
            return (Criteria) this;
        }

        public Criteria andModThighNotEqualTo(BigDecimal value) {
            addCriterion("mod_thigh <>", value, "modThigh");
            return (Criteria) this;
        }

        public Criteria andModThighGreaterThan(BigDecimal value) {
            addCriterion("mod_thigh >", value, "modThigh");
            return (Criteria) this;
        }

        public Criteria andModThighGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_thigh >=", value, "modThigh");
            return (Criteria) this;
        }

        public Criteria andModThighLessThan(BigDecimal value) {
            addCriterion("mod_thigh <", value, "modThigh");
            return (Criteria) this;
        }

        public Criteria andModThighLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mod_thigh <=", value, "modThigh");
            return (Criteria) this;
        }

        public Criteria andModThighIn(List<BigDecimal> values) {
            addCriterion("mod_thigh in", values, "modThigh");
            return (Criteria) this;
        }

        public Criteria andModThighNotIn(List<BigDecimal> values) {
            addCriterion("mod_thigh not in", values, "modThigh");
            return (Criteria) this;
        }

        public Criteria andModThighBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_thigh between", value1, value2, "modThigh");
            return (Criteria) this;
        }

        public Criteria andModThighNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mod_thigh not between", value1, value2, "modThigh");
            return (Criteria) this;
        }

        public Criteria andLegLenIsNull() {
            addCriterion("leg_len is null");
            return (Criteria) this;
        }

        public Criteria andLegLenIsNotNull() {
            addCriterion("leg_len is not null");
            return (Criteria) this;
        }

        public Criteria andLegLenEqualTo(BigDecimal value) {
            addCriterion("leg_len =", value, "legLen");
            return (Criteria) this;
        }

        public Criteria andLegLenNotEqualTo(BigDecimal value) {
            addCriterion("leg_len <>", value, "legLen");
            return (Criteria) this;
        }

        public Criteria andLegLenGreaterThan(BigDecimal value) {
            addCriterion("leg_len >", value, "legLen");
            return (Criteria) this;
        }

        public Criteria andLegLenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("leg_len >=", value, "legLen");
            return (Criteria) this;
        }

        public Criteria andLegLenLessThan(BigDecimal value) {
            addCriterion("leg_len <", value, "legLen");
            return (Criteria) this;
        }

        public Criteria andLegLenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("leg_len <=", value, "legLen");
            return (Criteria) this;
        }

        public Criteria andLegLenIn(List<BigDecimal> values) {
            addCriterion("leg_len in", values, "legLen");
            return (Criteria) this;
        }

        public Criteria andLegLenNotIn(List<BigDecimal> values) {
            addCriterion("leg_len not in", values, "legLen");
            return (Criteria) this;
        }

        public Criteria andLegLenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("leg_len between", value1, value2, "legLen");
            return (Criteria) this;
        }

        public Criteria andLegLenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("leg_len not between", value1, value2, "legLen");
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