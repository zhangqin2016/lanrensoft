package zhang.lao.mybatis.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopInfoExample() {
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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andOrganizationNoIsNull() {
            addCriterion("organization_no is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoIsNotNull() {
            addCriterion("organization_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoEqualTo(String value) {
            addCriterion("organization_no =", value, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoNotEqualTo(String value) {
            addCriterion("organization_no <>", value, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoGreaterThan(String value) {
            addCriterion("organization_no >", value, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoGreaterThanOrEqualTo(String value) {
            addCriterion("organization_no >=", value, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoLessThan(String value) {
            addCriterion("organization_no <", value, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoLessThanOrEqualTo(String value) {
            addCriterion("organization_no <=", value, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoLike(String value) {
            addCriterion("organization_no like", value, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoNotLike(String value) {
            addCriterion("organization_no not like", value, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoIn(List<String> values) {
            addCriterion("organization_no in", values, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoNotIn(List<String> values) {
            addCriterion("organization_no not in", values, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoBetween(String value1, String value2) {
            addCriterion("organization_no between", value1, value2, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andOrganizationNoNotBetween(String value1, String value2) {
            addCriterion("organization_no not between", value1, value2, "organizationNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoIsNull() {
            addCriterion("tax_no is null");
            return (Criteria) this;
        }

        public Criteria andTaxNoIsNotNull() {
            addCriterion("tax_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaxNoEqualTo(String value) {
            addCriterion("tax_no =", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotEqualTo(String value) {
            addCriterion("tax_no <>", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoGreaterThan(String value) {
            addCriterion("tax_no >", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoGreaterThanOrEqualTo(String value) {
            addCriterion("tax_no >=", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoLessThan(String value) {
            addCriterion("tax_no <", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoLessThanOrEqualTo(String value) {
            addCriterion("tax_no <=", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoLike(String value) {
            addCriterion("tax_no like", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotLike(String value) {
            addCriterion("tax_no not like", value, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoIn(List<String> values) {
            addCriterion("tax_no in", values, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotIn(List<String> values) {
            addCriterion("tax_no not in", values, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoBetween(String value1, String value2) {
            addCriterion("tax_no between", value1, value2, "taxNo");
            return (Criteria) this;
        }

        public Criteria andTaxNoNotBetween(String value1, String value2) {
            addCriterion("tax_no not between", value1, value2, "taxNo");
            return (Criteria) this;
        }

        public Criteria andBusinessPicIsNull() {
            addCriterion("business_pic is null");
            return (Criteria) this;
        }

        public Criteria andBusinessPicIsNotNull() {
            addCriterion("business_pic is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessPicEqualTo(String value) {
            addCriterion("business_pic =", value, "businessPic");
            return (Criteria) this;
        }

        public Criteria andBusinessPicNotEqualTo(String value) {
            addCriterion("business_pic <>", value, "businessPic");
            return (Criteria) this;
        }

        public Criteria andBusinessPicGreaterThan(String value) {
            addCriterion("business_pic >", value, "businessPic");
            return (Criteria) this;
        }

        public Criteria andBusinessPicGreaterThanOrEqualTo(String value) {
            addCriterion("business_pic >=", value, "businessPic");
            return (Criteria) this;
        }

        public Criteria andBusinessPicLessThan(String value) {
            addCriterion("business_pic <", value, "businessPic");
            return (Criteria) this;
        }

        public Criteria andBusinessPicLessThanOrEqualTo(String value) {
            addCriterion("business_pic <=", value, "businessPic");
            return (Criteria) this;
        }

        public Criteria andBusinessPicLike(String value) {
            addCriterion("business_pic like", value, "businessPic");
            return (Criteria) this;
        }

        public Criteria andBusinessPicNotLike(String value) {
            addCriterion("business_pic not like", value, "businessPic");
            return (Criteria) this;
        }

        public Criteria andBusinessPicIn(List<String> values) {
            addCriterion("business_pic in", values, "businessPic");
            return (Criteria) this;
        }

        public Criteria andBusinessPicNotIn(List<String> values) {
            addCriterion("business_pic not in", values, "businessPic");
            return (Criteria) this;
        }

        public Criteria andBusinessPicBetween(String value1, String value2) {
            addCriterion("business_pic between", value1, value2, "businessPic");
            return (Criteria) this;
        }

        public Criteria andBusinessPicNotBetween(String value1, String value2) {
            addCriterion("business_pic not between", value1, value2, "businessPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicIsNull() {
            addCriterion("organization_pic is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicIsNotNull() {
            addCriterion("organization_pic is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicEqualTo(String value) {
            addCriterion("organization_pic =", value, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicNotEqualTo(String value) {
            addCriterion("organization_pic <>", value, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicGreaterThan(String value) {
            addCriterion("organization_pic >", value, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicGreaterThanOrEqualTo(String value) {
            addCriterion("organization_pic >=", value, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicLessThan(String value) {
            addCriterion("organization_pic <", value, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicLessThanOrEqualTo(String value) {
            addCriterion("organization_pic <=", value, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicLike(String value) {
            addCriterion("organization_pic like", value, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicNotLike(String value) {
            addCriterion("organization_pic not like", value, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicIn(List<String> values) {
            addCriterion("organization_pic in", values, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicNotIn(List<String> values) {
            addCriterion("organization_pic not in", values, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicBetween(String value1, String value2) {
            addCriterion("organization_pic between", value1, value2, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andOrganizationPicNotBetween(String value1, String value2) {
            addCriterion("organization_pic not between", value1, value2, "organizationPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicIsNull() {
            addCriterion("tax_pic is null");
            return (Criteria) this;
        }

        public Criteria andTaxPicIsNotNull() {
            addCriterion("tax_pic is not null");
            return (Criteria) this;
        }

        public Criteria andTaxPicEqualTo(String value) {
            addCriterion("tax_pic =", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicNotEqualTo(String value) {
            addCriterion("tax_pic <>", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicGreaterThan(String value) {
            addCriterion("tax_pic >", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicGreaterThanOrEqualTo(String value) {
            addCriterion("tax_pic >=", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicLessThan(String value) {
            addCriterion("tax_pic <", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicLessThanOrEqualTo(String value) {
            addCriterion("tax_pic <=", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicLike(String value) {
            addCriterion("tax_pic like", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicNotLike(String value) {
            addCriterion("tax_pic not like", value, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicIn(List<String> values) {
            addCriterion("tax_pic in", values, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicNotIn(List<String> values) {
            addCriterion("tax_pic not in", values, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicBetween(String value1, String value2) {
            addCriterion("tax_pic between", value1, value2, "taxPic");
            return (Criteria) this;
        }

        public Criteria andTaxPicNotBetween(String value1, String value2) {
            addCriterion("tax_pic not between", value1, value2, "taxPic");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("type not between", value1, value2, "type");
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