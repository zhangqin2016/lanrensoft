package zhang.lao.build.mybatis.jdbc.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BoProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BoProjectExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSelfBuildIsNull() {
            addCriterion("self_build is null");
            return (Criteria) this;
        }

        public Criteria andSelfBuildIsNotNull() {
            addCriterion("self_build is not null");
            return (Criteria) this;
        }

        public Criteria andSelfBuildEqualTo(String value) {
            addCriterion("self_build =", value, "selfBuild");
            return (Criteria) this;
        }

        public Criteria andSelfBuildNotEqualTo(String value) {
            addCriterion("self_build <>", value, "selfBuild");
            return (Criteria) this;
        }

        public Criteria andSelfBuildGreaterThan(String value) {
            addCriterion("self_build >", value, "selfBuild");
            return (Criteria) this;
        }

        public Criteria andSelfBuildGreaterThanOrEqualTo(String value) {
            addCriterion("self_build >=", value, "selfBuild");
            return (Criteria) this;
        }

        public Criteria andSelfBuildLessThan(String value) {
            addCriterion("self_build <", value, "selfBuild");
            return (Criteria) this;
        }

        public Criteria andSelfBuildLessThanOrEqualTo(String value) {
            addCriterion("self_build <=", value, "selfBuild");
            return (Criteria) this;
        }

        public Criteria andSelfBuildLike(String value) {
            addCriterion("self_build like", value, "selfBuild");
            return (Criteria) this;
        }

        public Criteria andSelfBuildNotLike(String value) {
            addCriterion("self_build not like", value, "selfBuild");
            return (Criteria) this;
        }

        public Criteria andSelfBuildIn(List<String> values) {
            addCriterion("self_build in", values, "selfBuild");
            return (Criteria) this;
        }

        public Criteria andSelfBuildNotIn(List<String> values) {
            addCriterion("self_build not in", values, "selfBuild");
            return (Criteria) this;
        }

        public Criteria andSelfBuildBetween(String value1, String value2) {
            addCriterion("self_build between", value1, value2, "selfBuild");
            return (Criteria) this;
        }

        public Criteria andSelfBuildNotBetween(String value1, String value2) {
            addCriterion("self_build not between", value1, value2, "selfBuild");
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

        public Criteria andProjectDevelopersIsNull() {
            addCriterion("project_developers is null");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersIsNotNull() {
            addCriterion("project_developers is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersEqualTo(String value) {
            addCriterion("project_developers =", value, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersNotEqualTo(String value) {
            addCriterion("project_developers <>", value, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersGreaterThan(String value) {
            addCriterion("project_developers >", value, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersGreaterThanOrEqualTo(String value) {
            addCriterion("project_developers >=", value, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersLessThan(String value) {
            addCriterion("project_developers <", value, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersLessThanOrEqualTo(String value) {
            addCriterion("project_developers <=", value, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersLike(String value) {
            addCriterion("project_developers like", value, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersNotLike(String value) {
            addCriterion("project_developers not like", value, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersIn(List<String> values) {
            addCriterion("project_developers in", values, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersNotIn(List<String> values) {
            addCriterion("project_developers not in", values, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersBetween(String value1, String value2) {
            addCriterion("project_developers between", value1, value2, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectDevelopersNotBetween(String value1, String value2) {
            addCriterion("project_developers not between", value1, value2, "projectDevelopers");
            return (Criteria) this;
        }

        public Criteria andProjectIntoIsNull() {
            addCriterion("project_into is null");
            return (Criteria) this;
        }

        public Criteria andProjectIntoIsNotNull() {
            addCriterion("project_into is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIntoEqualTo(Date value) {
            addCriterionForJDBCDate("project_into =", value, "projectInto");
            return (Criteria) this;
        }

        public Criteria andProjectIntoNotEqualTo(Date value) {
            addCriterionForJDBCDate("project_into <>", value, "projectInto");
            return (Criteria) this;
        }

        public Criteria andProjectIntoGreaterThan(Date value) {
            addCriterionForJDBCDate("project_into >", value, "projectInto");
            return (Criteria) this;
        }

        public Criteria andProjectIntoGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("project_into >=", value, "projectInto");
            return (Criteria) this;
        }

        public Criteria andProjectIntoLessThan(Date value) {
            addCriterionForJDBCDate("project_into <", value, "projectInto");
            return (Criteria) this;
        }

        public Criteria andProjectIntoLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("project_into <=", value, "projectInto");
            return (Criteria) this;
        }

        public Criteria andProjectIntoIn(List<Date> values) {
            addCriterionForJDBCDate("project_into in", values, "projectInto");
            return (Criteria) this;
        }

        public Criteria andProjectIntoNotIn(List<Date> values) {
            addCriterionForJDBCDate("project_into not in", values, "projectInto");
            return (Criteria) this;
        }

        public Criteria andProjectIntoBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("project_into between", value1, value2, "projectInto");
            return (Criteria) this;
        }

        public Criteria andProjectIntoNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("project_into not between", value1, value2, "projectInto");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerIsNull() {
            addCriterion("projrct_manager is null");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerIsNotNull() {
            addCriterion("projrct_manager is not null");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerEqualTo(String value) {
            addCriterion("projrct_manager =", value, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerNotEqualTo(String value) {
            addCriterion("projrct_manager <>", value, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerGreaterThan(String value) {
            addCriterion("projrct_manager >", value, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerGreaterThanOrEqualTo(String value) {
            addCriterion("projrct_manager >=", value, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerLessThan(String value) {
            addCriterion("projrct_manager <", value, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerLessThanOrEqualTo(String value) {
            addCriterion("projrct_manager <=", value, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerLike(String value) {
            addCriterion("projrct_manager like", value, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerNotLike(String value) {
            addCriterion("projrct_manager not like", value, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerIn(List<String> values) {
            addCriterion("projrct_manager in", values, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerNotIn(List<String> values) {
            addCriterion("projrct_manager not in", values, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerBetween(String value1, String value2) {
            addCriterion("projrct_manager between", value1, value2, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjrctManagerNotBetween(String value1, String value2) {
            addCriterion("projrct_manager not between", value1, value2, "projrctManager");
            return (Criteria) this;
        }

        public Criteria andProjectEstateIsNull() {
            addCriterion("project_estate is null");
            return (Criteria) this;
        }

        public Criteria andProjectEstateIsNotNull() {
            addCriterion("project_estate is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEstateEqualTo(Integer value) {
            addCriterion("project_estate =", value, "projectEstate");
            return (Criteria) this;
        }

        public Criteria andProjectEstateNotEqualTo(Integer value) {
            addCriterion("project_estate <>", value, "projectEstate");
            return (Criteria) this;
        }

        public Criteria andProjectEstateGreaterThan(Integer value) {
            addCriterion("project_estate >", value, "projectEstate");
            return (Criteria) this;
        }

        public Criteria andProjectEstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_estate >=", value, "projectEstate");
            return (Criteria) this;
        }

        public Criteria andProjectEstateLessThan(Integer value) {
            addCriterion("project_estate <", value, "projectEstate");
            return (Criteria) this;
        }

        public Criteria andProjectEstateLessThanOrEqualTo(Integer value) {
            addCriterion("project_estate <=", value, "projectEstate");
            return (Criteria) this;
        }

        public Criteria andProjectEstateIn(List<Integer> values) {
            addCriterion("project_estate in", values, "projectEstate");
            return (Criteria) this;
        }

        public Criteria andProjectEstateNotIn(List<Integer> values) {
            addCriterion("project_estate not in", values, "projectEstate");
            return (Criteria) this;
        }

        public Criteria andProjectEstateBetween(Integer value1, Integer value2) {
            addCriterion("project_estate between", value1, value2, "projectEstate");
            return (Criteria) this;
        }

        public Criteria andProjectEstateNotBetween(Integer value1, Integer value2) {
            addCriterion("project_estate not between", value1, value2, "projectEstate");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
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

        public Criteria andDecorationLeaveIsNull() {
            addCriterion("decoration_leave is null");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveIsNotNull() {
            addCriterion("decoration_leave is not null");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveEqualTo(String value) {
            addCriterion("decoration_leave =", value, "decorationLeave");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveNotEqualTo(String value) {
            addCriterion("decoration_leave <>", value, "decorationLeave");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveGreaterThan(String value) {
            addCriterion("decoration_leave >", value, "decorationLeave");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveGreaterThanOrEqualTo(String value) {
            addCriterion("decoration_leave >=", value, "decorationLeave");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveLessThan(String value) {
            addCriterion("decoration_leave <", value, "decorationLeave");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveLessThanOrEqualTo(String value) {
            addCriterion("decoration_leave <=", value, "decorationLeave");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveLike(String value) {
            addCriterion("decoration_leave like", value, "decorationLeave");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveNotLike(String value) {
            addCriterion("decoration_leave not like", value, "decorationLeave");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveIn(List<String> values) {
            addCriterion("decoration_leave in", values, "decorationLeave");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveNotIn(List<String> values) {
            addCriterion("decoration_leave not in", values, "decorationLeave");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveBetween(String value1, String value2) {
            addCriterion("decoration_leave between", value1, value2, "decorationLeave");
            return (Criteria) this;
        }

        public Criteria andDecorationLeaveNotBetween(String value1, String value2) {
            addCriterion("decoration_leave not between", value1, value2, "decorationLeave");
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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