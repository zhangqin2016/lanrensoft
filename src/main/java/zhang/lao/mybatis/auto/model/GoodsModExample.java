package zhang.lao.mybatis.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsModExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsModExample() {
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

        public Criteria andMgmIdIsNull() {
            addCriterion("mgm_id is null");
            return (Criteria) this;
        }

        public Criteria andMgmIdIsNotNull() {
            addCriterion("mgm_id is not null");
            return (Criteria) this;
        }

        public Criteria andMgmIdEqualTo(Integer value) {
            addCriterion("mgm_id =", value, "mgmId");
            return (Criteria) this;
        }

        public Criteria andMgmIdNotEqualTo(Integer value) {
            addCriterion("mgm_id <>", value, "mgmId");
            return (Criteria) this;
        }

        public Criteria andMgmIdGreaterThan(Integer value) {
            addCriterion("mgm_id >", value, "mgmId");
            return (Criteria) this;
        }

        public Criteria andMgmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mgm_id >=", value, "mgmId");
            return (Criteria) this;
        }

        public Criteria andMgmIdLessThan(Integer value) {
            addCriterion("mgm_id <", value, "mgmId");
            return (Criteria) this;
        }

        public Criteria andMgmIdLessThanOrEqualTo(Integer value) {
            addCriterion("mgm_id <=", value, "mgmId");
            return (Criteria) this;
        }

        public Criteria andMgmIdIn(List<Integer> values) {
            addCriterion("mgm_id in", values, "mgmId");
            return (Criteria) this;
        }

        public Criteria andMgmIdNotIn(List<Integer> values) {
            addCriterion("mgm_id not in", values, "mgmId");
            return (Criteria) this;
        }

        public Criteria andMgmIdBetween(Integer value1, Integer value2) {
            addCriterion("mgm_id between", value1, value2, "mgmId");
            return (Criteria) this;
        }

        public Criteria andMgmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mgm_id not between", value1, value2, "mgmId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Integer value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Integer value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Integer value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Integer value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Integer> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Integer> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andModUrlIsNull() {
            addCriterion("mod_url is null");
            return (Criteria) this;
        }

        public Criteria andModUrlIsNotNull() {
            addCriterion("mod_url is not null");
            return (Criteria) this;
        }

        public Criteria andModUrlEqualTo(String value) {
            addCriterion("mod_url =", value, "modUrl");
            return (Criteria) this;
        }

        public Criteria andModUrlNotEqualTo(String value) {
            addCriterion("mod_url <>", value, "modUrl");
            return (Criteria) this;
        }

        public Criteria andModUrlGreaterThan(String value) {
            addCriterion("mod_url >", value, "modUrl");
            return (Criteria) this;
        }

        public Criteria andModUrlGreaterThanOrEqualTo(String value) {
            addCriterion("mod_url >=", value, "modUrl");
            return (Criteria) this;
        }

        public Criteria andModUrlLessThan(String value) {
            addCriterion("mod_url <", value, "modUrl");
            return (Criteria) this;
        }

        public Criteria andModUrlLessThanOrEqualTo(String value) {
            addCriterion("mod_url <=", value, "modUrl");
            return (Criteria) this;
        }

        public Criteria andModUrlLike(String value) {
            addCriterion("mod_url like", value, "modUrl");
            return (Criteria) this;
        }

        public Criteria andModUrlNotLike(String value) {
            addCriterion("mod_url not like", value, "modUrl");
            return (Criteria) this;
        }

        public Criteria andModUrlIn(List<String> values) {
            addCriterion("mod_url in", values, "modUrl");
            return (Criteria) this;
        }

        public Criteria andModUrlNotIn(List<String> values) {
            addCriterion("mod_url not in", values, "modUrl");
            return (Criteria) this;
        }

        public Criteria andModUrlBetween(String value1, String value2) {
            addCriterion("mod_url between", value1, value2, "modUrl");
            return (Criteria) this;
        }

        public Criteria andModUrlNotBetween(String value1, String value2) {
            addCriterion("mod_url not between", value1, value2, "modUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlIsNull() {
            addCriterion("front_url is null");
            return (Criteria) this;
        }

        public Criteria andFrontUrlIsNotNull() {
            addCriterion("front_url is not null");
            return (Criteria) this;
        }

        public Criteria andFrontUrlEqualTo(String value) {
            addCriterion("front_url =", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlNotEqualTo(String value) {
            addCriterion("front_url <>", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlGreaterThan(String value) {
            addCriterion("front_url >", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlGreaterThanOrEqualTo(String value) {
            addCriterion("front_url >=", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlLessThan(String value) {
            addCriterion("front_url <", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlLessThanOrEqualTo(String value) {
            addCriterion("front_url <=", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlLike(String value) {
            addCriterion("front_url like", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlNotLike(String value) {
            addCriterion("front_url not like", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlIn(List<String> values) {
            addCriterion("front_url in", values, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlNotIn(List<String> values) {
            addCriterion("front_url not in", values, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlBetween(String value1, String value2) {
            addCriterion("front_url between", value1, value2, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlNotBetween(String value1, String value2) {
            addCriterion("front_url not between", value1, value2, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlIsNull() {
            addCriterion("reverse_url is null");
            return (Criteria) this;
        }

        public Criteria andReverseUrlIsNotNull() {
            addCriterion("reverse_url is not null");
            return (Criteria) this;
        }

        public Criteria andReverseUrlEqualTo(String value) {
            addCriterion("reverse_url =", value, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlNotEqualTo(String value) {
            addCriterion("reverse_url <>", value, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlGreaterThan(String value) {
            addCriterion("reverse_url >", value, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlGreaterThanOrEqualTo(String value) {
            addCriterion("reverse_url >=", value, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlLessThan(String value) {
            addCriterion("reverse_url <", value, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlLessThanOrEqualTo(String value) {
            addCriterion("reverse_url <=", value, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlLike(String value) {
            addCriterion("reverse_url like", value, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlNotLike(String value) {
            addCriterion("reverse_url not like", value, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlIn(List<String> values) {
            addCriterion("reverse_url in", values, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlNotIn(List<String> values) {
            addCriterion("reverse_url not in", values, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlBetween(String value1, String value2) {
            addCriterion("reverse_url between", value1, value2, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andReverseUrlNotBetween(String value1, String value2) {
            addCriterion("reverse_url not between", value1, value2, "reverseUrl");
            return (Criteria) this;
        }

        public Criteria andTerminalIsNull() {
            addCriterion("terminal is null");
            return (Criteria) this;
        }

        public Criteria andTerminalIsNotNull() {
            addCriterion("terminal is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalEqualTo(String value) {
            addCriterion("terminal =", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotEqualTo(String value) {
            addCriterion("terminal <>", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalGreaterThan(String value) {
            addCriterion("terminal >", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalGreaterThanOrEqualTo(String value) {
            addCriterion("terminal >=", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalLessThan(String value) {
            addCriterion("terminal <", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalLessThanOrEqualTo(String value) {
            addCriterion("terminal <=", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalLike(String value) {
            addCriterion("terminal like", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotLike(String value) {
            addCriterion("terminal not like", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalIn(List<String> values) {
            addCriterion("terminal in", values, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotIn(List<String> values) {
            addCriterion("terminal not in", values, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalBetween(String value1, String value2) {
            addCriterion("terminal between", value1, value2, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotBetween(String value1, String value2) {
            addCriterion("terminal not between", value1, value2, "terminal");
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

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Integer value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Integer value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Integer value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Integer value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Integer> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Integer> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMd5CodeIsNull() {
            addCriterion("md5_code is null");
            return (Criteria) this;
        }

        public Criteria andMd5CodeIsNotNull() {
            addCriterion("md5_code is not null");
            return (Criteria) this;
        }

        public Criteria andMd5CodeEqualTo(String value) {
            addCriterion("md5_code =", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeNotEqualTo(String value) {
            addCriterion("md5_code <>", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeGreaterThan(String value) {
            addCriterion("md5_code >", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeGreaterThanOrEqualTo(String value) {
            addCriterion("md5_code >=", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeLessThan(String value) {
            addCriterion("md5_code <", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeLessThanOrEqualTo(String value) {
            addCriterion("md5_code <=", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeLike(String value) {
            addCriterion("md5_code like", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeNotLike(String value) {
            addCriterion("md5_code not like", value, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeIn(List<String> values) {
            addCriterion("md5_code in", values, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeNotIn(List<String> values) {
            addCriterion("md5_code not in", values, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeBetween(String value1, String value2) {
            addCriterion("md5_code between", value1, value2, "md5Code");
            return (Criteria) this;
        }

        public Criteria andMd5CodeNotBetween(String value1, String value2) {
            addCriterion("md5_code not between", value1, value2, "md5Code");
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