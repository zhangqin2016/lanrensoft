package zhang.lao.mybatis.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogSysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogSysExample() {
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

        public Criteria andActionenddateIsNull() {
            addCriterion("actionenddate is null");
            return (Criteria) this;
        }

        public Criteria andActionenddateIsNotNull() {
            addCriterion("actionenddate is not null");
            return (Criteria) this;
        }

        public Criteria andActionenddateEqualTo(Date value) {
            addCriterion("actionenddate =", value, "actionenddate");
            return (Criteria) this;
        }

        public Criteria andActionenddateNotEqualTo(Date value) {
            addCriterion("actionenddate <>", value, "actionenddate");
            return (Criteria) this;
        }

        public Criteria andActionenddateGreaterThan(Date value) {
            addCriterion("actionenddate >", value, "actionenddate");
            return (Criteria) this;
        }

        public Criteria andActionenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("actionenddate >=", value, "actionenddate");
            return (Criteria) this;
        }

        public Criteria andActionenddateLessThan(Date value) {
            addCriterion("actionenddate <", value, "actionenddate");
            return (Criteria) this;
        }

        public Criteria andActionenddateLessThanOrEqualTo(Date value) {
            addCriterion("actionenddate <=", value, "actionenddate");
            return (Criteria) this;
        }

        public Criteria andActionenddateIn(List<Date> values) {
            addCriterion("actionenddate in", values, "actionenddate");
            return (Criteria) this;
        }

        public Criteria andActionenddateNotIn(List<Date> values) {
            addCriterion("actionenddate not in", values, "actionenddate");
            return (Criteria) this;
        }

        public Criteria andActionenddateBetween(Date value1, Date value2) {
            addCriterion("actionenddate between", value1, value2, "actionenddate");
            return (Criteria) this;
        }

        public Criteria andActionenddateNotBetween(Date value1, Date value2) {
            addCriterion("actionenddate not between", value1, value2, "actionenddate");
            return (Criteria) this;
        }

        public Criteria andActionendtimeIsNull() {
            addCriterion("actionendtime is null");
            return (Criteria) this;
        }

        public Criteria andActionendtimeIsNotNull() {
            addCriterion("actionendtime is not null");
            return (Criteria) this;
        }

        public Criteria andActionendtimeEqualTo(Long value) {
            addCriterion("actionendtime =", value, "actionendtime");
            return (Criteria) this;
        }

        public Criteria andActionendtimeNotEqualTo(Long value) {
            addCriterion("actionendtime <>", value, "actionendtime");
            return (Criteria) this;
        }

        public Criteria andActionendtimeGreaterThan(Long value) {
            addCriterion("actionendtime >", value, "actionendtime");
            return (Criteria) this;
        }

        public Criteria andActionendtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("actionendtime >=", value, "actionendtime");
            return (Criteria) this;
        }

        public Criteria andActionendtimeLessThan(Long value) {
            addCriterion("actionendtime <", value, "actionendtime");
            return (Criteria) this;
        }

        public Criteria andActionendtimeLessThanOrEqualTo(Long value) {
            addCriterion("actionendtime <=", value, "actionendtime");
            return (Criteria) this;
        }

        public Criteria andActionendtimeIn(List<Long> values) {
            addCriterion("actionendtime in", values, "actionendtime");
            return (Criteria) this;
        }

        public Criteria andActionendtimeNotIn(List<Long> values) {
            addCriterion("actionendtime not in", values, "actionendtime");
            return (Criteria) this;
        }

        public Criteria andActionendtimeBetween(Long value1, Long value2) {
            addCriterion("actionendtime between", value1, value2, "actionendtime");
            return (Criteria) this;
        }

        public Criteria andActionendtimeNotBetween(Long value1, Long value2) {
            addCriterion("actionendtime not between", value1, value2, "actionendtime");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiIsNull() {
            addCriterion("actionhaoshi is null");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiIsNotNull() {
            addCriterion("actionhaoshi is not null");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiEqualTo(Integer value) {
            addCriterion("actionhaoshi =", value, "actionhaoshi");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiNotEqualTo(Integer value) {
            addCriterion("actionhaoshi <>", value, "actionhaoshi");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiGreaterThan(Integer value) {
            addCriterion("actionhaoshi >", value, "actionhaoshi");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiGreaterThanOrEqualTo(Integer value) {
            addCriterion("actionhaoshi >=", value, "actionhaoshi");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiLessThan(Integer value) {
            addCriterion("actionhaoshi <", value, "actionhaoshi");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiLessThanOrEqualTo(Integer value) {
            addCriterion("actionhaoshi <=", value, "actionhaoshi");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiIn(List<Integer> values) {
            addCriterion("actionhaoshi in", values, "actionhaoshi");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiNotIn(List<Integer> values) {
            addCriterion("actionhaoshi not in", values, "actionhaoshi");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiBetween(Integer value1, Integer value2) {
            addCriterion("actionhaoshi between", value1, value2, "actionhaoshi");
            return (Criteria) this;
        }

        public Criteria andActionhaoshiNotBetween(Integer value1, Integer value2) {
            addCriterion("actionhaoshi not between", value1, value2, "actionhaoshi");
            return (Criteria) this;
        }

        public Criteria andActionstartdateIsNull() {
            addCriterion("actionstartdate is null");
            return (Criteria) this;
        }

        public Criteria andActionstartdateIsNotNull() {
            addCriterion("actionstartdate is not null");
            return (Criteria) this;
        }

        public Criteria andActionstartdateEqualTo(Date value) {
            addCriterion("actionstartdate =", value, "actionstartdate");
            return (Criteria) this;
        }

        public Criteria andActionstartdateNotEqualTo(Date value) {
            addCriterion("actionstartdate <>", value, "actionstartdate");
            return (Criteria) this;
        }

        public Criteria andActionstartdateGreaterThan(Date value) {
            addCriterion("actionstartdate >", value, "actionstartdate");
            return (Criteria) this;
        }

        public Criteria andActionstartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("actionstartdate >=", value, "actionstartdate");
            return (Criteria) this;
        }

        public Criteria andActionstartdateLessThan(Date value) {
            addCriterion("actionstartdate <", value, "actionstartdate");
            return (Criteria) this;
        }

        public Criteria andActionstartdateLessThanOrEqualTo(Date value) {
            addCriterion("actionstartdate <=", value, "actionstartdate");
            return (Criteria) this;
        }

        public Criteria andActionstartdateIn(List<Date> values) {
            addCriterion("actionstartdate in", values, "actionstartdate");
            return (Criteria) this;
        }

        public Criteria andActionstartdateNotIn(List<Date> values) {
            addCriterion("actionstartdate not in", values, "actionstartdate");
            return (Criteria) this;
        }

        public Criteria andActionstartdateBetween(Date value1, Date value2) {
            addCriterion("actionstartdate between", value1, value2, "actionstartdate");
            return (Criteria) this;
        }

        public Criteria andActionstartdateNotBetween(Date value1, Date value2) {
            addCriterion("actionstartdate not between", value1, value2, "actionstartdate");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeIsNull() {
            addCriterion("actionstarttime is null");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeIsNotNull() {
            addCriterion("actionstarttime is not null");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeEqualTo(Long value) {
            addCriterion("actionstarttime =", value, "actionstarttime");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeNotEqualTo(Long value) {
            addCriterion("actionstarttime <>", value, "actionstarttime");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeGreaterThan(Long value) {
            addCriterion("actionstarttime >", value, "actionstarttime");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeGreaterThanOrEqualTo(Long value) {
            addCriterion("actionstarttime >=", value, "actionstarttime");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeLessThan(Long value) {
            addCriterion("actionstarttime <", value, "actionstarttime");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeLessThanOrEqualTo(Long value) {
            addCriterion("actionstarttime <=", value, "actionstarttime");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeIn(List<Long> values) {
            addCriterion("actionstarttime in", values, "actionstarttime");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeNotIn(List<Long> values) {
            addCriterion("actionstarttime not in", values, "actionstarttime");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeBetween(Long value1, Long value2) {
            addCriterion("actionstarttime between", value1, value2, "actionstarttime");
            return (Criteria) this;
        }

        public Criteria andActionstarttimeNotBetween(Long value1, Long value2) {
            addCriterion("actionstarttime not between", value1, value2, "actionstarttime");
            return (Criteria) this;
        }

        public Criteria andCauseIsNull() {
            addCriterion("cause is null");
            return (Criteria) this;
        }

        public Criteria andCauseIsNotNull() {
            addCriterion("cause is not null");
            return (Criteria) this;
        }

        public Criteria andCauseEqualTo(String value) {
            addCriterion("cause =", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotEqualTo(String value) {
            addCriterion("cause <>", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseGreaterThan(String value) {
            addCriterion("cause >", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseGreaterThanOrEqualTo(String value) {
            addCriterion("cause >=", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseLessThan(String value) {
            addCriterion("cause <", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseLessThanOrEqualTo(String value) {
            addCriterion("cause <=", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseLike(String value) {
            addCriterion("cause like", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotLike(String value) {
            addCriterion("cause not like", value, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseIn(List<String> values) {
            addCriterion("cause in", values, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotIn(List<String> values) {
            addCriterion("cause not in", values, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseBetween(String value1, String value2) {
            addCriterion("cause between", value1, value2, "cause");
            return (Criteria) this;
        }

        public Criteria andCauseNotBetween(String value1, String value2) {
            addCriterion("cause not between", value1, value2, "cause");
            return (Criteria) this;
        }

        public Criteria andCookieIsNull() {
            addCriterion("cookie is null");
            return (Criteria) this;
        }

        public Criteria andCookieIsNotNull() {
            addCriterion("cookie is not null");
            return (Criteria) this;
        }

        public Criteria andCookieEqualTo(String value) {
            addCriterion("cookie =", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotEqualTo(String value) {
            addCriterion("cookie <>", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThan(String value) {
            addCriterion("cookie >", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieGreaterThanOrEqualTo(String value) {
            addCriterion("cookie >=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThan(String value) {
            addCriterion("cookie <", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLessThanOrEqualTo(String value) {
            addCriterion("cookie <=", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieLike(String value) {
            addCriterion("cookie like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotLike(String value) {
            addCriterion("cookie not like", value, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieIn(List<String> values) {
            addCriterion("cookie in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotIn(List<String> values) {
            addCriterion("cookie not in", values, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieBetween(String value1, String value2) {
            addCriterion("cookie between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andCookieNotBetween(String value1, String value2) {
            addCriterion("cookie not between", value1, value2, "cookie");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterion("enddate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterion("enddate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterion("enddate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterion("enddate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterion("enddate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterion("enddate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterion("enddate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterion("enddate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterion("enddate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterion("enddate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Long value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Long value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Long value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Long value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Long value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Long> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Long> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Long value1, Long value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Long value1, Long value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andHaoshiIsNull() {
            addCriterion("haoshi is null");
            return (Criteria) this;
        }

        public Criteria andHaoshiIsNotNull() {
            addCriterion("haoshi is not null");
            return (Criteria) this;
        }

        public Criteria andHaoshiEqualTo(Integer value) {
            addCriterion("haoshi =", value, "haoshi");
            return (Criteria) this;
        }

        public Criteria andHaoshiNotEqualTo(Integer value) {
            addCriterion("haoshi <>", value, "haoshi");
            return (Criteria) this;
        }

        public Criteria andHaoshiGreaterThan(Integer value) {
            addCriterion("haoshi >", value, "haoshi");
            return (Criteria) this;
        }

        public Criteria andHaoshiGreaterThanOrEqualTo(Integer value) {
            addCriterion("haoshi >=", value, "haoshi");
            return (Criteria) this;
        }

        public Criteria andHaoshiLessThan(Integer value) {
            addCriterion("haoshi <", value, "haoshi");
            return (Criteria) this;
        }

        public Criteria andHaoshiLessThanOrEqualTo(Integer value) {
            addCriterion("haoshi <=", value, "haoshi");
            return (Criteria) this;
        }

        public Criteria andHaoshiIn(List<Integer> values) {
            addCriterion("haoshi in", values, "haoshi");
            return (Criteria) this;
        }

        public Criteria andHaoshiNotIn(List<Integer> values) {
            addCriterion("haoshi not in", values, "haoshi");
            return (Criteria) this;
        }

        public Criteria andHaoshiBetween(Integer value1, Integer value2) {
            addCriterion("haoshi between", value1, value2, "haoshi");
            return (Criteria) this;
        }

        public Criteria andHaoshiNotBetween(Integer value1, Integer value2) {
            addCriterion("haoshi not between", value1, value2, "haoshi");
            return (Criteria) this;
        }

        public Criteria andIpsIsNull() {
            addCriterion("ips is null");
            return (Criteria) this;
        }

        public Criteria andIpsIsNotNull() {
            addCriterion("ips is not null");
            return (Criteria) this;
        }

        public Criteria andIpsEqualTo(String value) {
            addCriterion("ips =", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotEqualTo(String value) {
            addCriterion("ips <>", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsGreaterThan(String value) {
            addCriterion("ips >", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsGreaterThanOrEqualTo(String value) {
            addCriterion("ips >=", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLessThan(String value) {
            addCriterion("ips <", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLessThanOrEqualTo(String value) {
            addCriterion("ips <=", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsLike(String value) {
            addCriterion("ips like", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotLike(String value) {
            addCriterion("ips not like", value, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsIn(List<String> values) {
            addCriterion("ips in", values, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotIn(List<String> values) {
            addCriterion("ips not in", values, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsBetween(String value1, String value2) {
            addCriterion("ips between", value1, value2, "ips");
            return (Criteria) this;
        }

        public Criteria andIpsNotBetween(String value1, String value2) {
            addCriterion("ips not between", value1, value2, "ips");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andRefererIsNull() {
            addCriterion("referer is null");
            return (Criteria) this;
        }

        public Criteria andRefererIsNotNull() {
            addCriterion("referer is not null");
            return (Criteria) this;
        }

        public Criteria andRefererEqualTo(String value) {
            addCriterion("referer =", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotEqualTo(String value) {
            addCriterion("referer <>", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererGreaterThan(String value) {
            addCriterion("referer >", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererGreaterThanOrEqualTo(String value) {
            addCriterion("referer >=", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererLessThan(String value) {
            addCriterion("referer <", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererLessThanOrEqualTo(String value) {
            addCriterion("referer <=", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererLike(String value) {
            addCriterion("referer like", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotLike(String value) {
            addCriterion("referer not like", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererIn(List<String> values) {
            addCriterion("referer in", values, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotIn(List<String> values) {
            addCriterion("referer not in", values, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererBetween(String value1, String value2) {
            addCriterion("referer between", value1, value2, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotBetween(String value1, String value2) {
            addCriterion("referer not between", value1, value2, "referer");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNull() {
            addCriterion("startdate is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("startdate is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(Date value) {
            addCriterion("startdate =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(Date value) {
            addCriterion("startdate <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(Date value) {
            addCriterion("startdate >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(Date value) {
            addCriterion("startdate >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(Date value) {
            addCriterion("startdate <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(Date value) {
            addCriterion("startdate <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<Date> values) {
            addCriterion("startdate in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<Date> values) {
            addCriterion("startdate not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(Date value1, Date value2) {
            addCriterion("startdate between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(Date value1, Date value2) {
            addCriterion("startdate not between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Long value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Long value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Long value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Long value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Long value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Long value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Long> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Long> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Long value1, Long value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Long value1, Long value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUseragentIsNull() {
            addCriterion("useragent is null");
            return (Criteria) this;
        }

        public Criteria andUseragentIsNotNull() {
            addCriterion("useragent is not null");
            return (Criteria) this;
        }

        public Criteria andUseragentEqualTo(String value) {
            addCriterion("useragent =", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotEqualTo(String value) {
            addCriterion("useragent <>", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentGreaterThan(String value) {
            addCriterion("useragent >", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentGreaterThanOrEqualTo(String value) {
            addCriterion("useragent >=", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentLessThan(String value) {
            addCriterion("useragent <", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentLessThanOrEqualTo(String value) {
            addCriterion("useragent <=", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentLike(String value) {
            addCriterion("useragent like", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotLike(String value) {
            addCriterion("useragent not like", value, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentIn(List<String> values) {
            addCriterion("useragent in", values, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotIn(List<String> values) {
            addCriterion("useragent not in", values, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentBetween(String value1, String value2) {
            addCriterion("useragent between", value1, value2, "useragent");
            return (Criteria) this;
        }

        public Criteria andUseragentNotBetween(String value1, String value2) {
            addCriterion("useragent not between", value1, value2, "useragent");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiIsNull() {
            addCriterion("viewhaoshi is null");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiIsNotNull() {
            addCriterion("viewhaoshi is not null");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiEqualTo(Integer value) {
            addCriterion("viewhaoshi =", value, "viewhaoshi");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiNotEqualTo(Integer value) {
            addCriterion("viewhaoshi <>", value, "viewhaoshi");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiGreaterThan(Integer value) {
            addCriterion("viewhaoshi >", value, "viewhaoshi");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiGreaterThanOrEqualTo(Integer value) {
            addCriterion("viewhaoshi >=", value, "viewhaoshi");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiLessThan(Integer value) {
            addCriterion("viewhaoshi <", value, "viewhaoshi");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiLessThanOrEqualTo(Integer value) {
            addCriterion("viewhaoshi <=", value, "viewhaoshi");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiIn(List<Integer> values) {
            addCriterion("viewhaoshi in", values, "viewhaoshi");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiNotIn(List<Integer> values) {
            addCriterion("viewhaoshi not in", values, "viewhaoshi");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiBetween(Integer value1, Integer value2) {
            addCriterion("viewhaoshi between", value1, value2, "viewhaoshi");
            return (Criteria) this;
        }

        public Criteria andViewhaoshiNotBetween(Integer value1, Integer value2) {
            addCriterion("viewhaoshi not between", value1, value2, "viewhaoshi");
            return (Criteria) this;
        }

        public Criteria andOperatoridsIsNull() {
            addCriterion("operatorids is null");
            return (Criteria) this;
        }

        public Criteria andOperatoridsIsNotNull() {
            addCriterion("operatorids is not null");
            return (Criteria) this;
        }

        public Criteria andOperatoridsEqualTo(String value) {
            addCriterion("operatorids =", value, "operatorids");
            return (Criteria) this;
        }

        public Criteria andOperatoridsNotEqualTo(String value) {
            addCriterion("operatorids <>", value, "operatorids");
            return (Criteria) this;
        }

        public Criteria andOperatoridsGreaterThan(String value) {
            addCriterion("operatorids >", value, "operatorids");
            return (Criteria) this;
        }

        public Criteria andOperatoridsGreaterThanOrEqualTo(String value) {
            addCriterion("operatorids >=", value, "operatorids");
            return (Criteria) this;
        }

        public Criteria andOperatoridsLessThan(String value) {
            addCriterion("operatorids <", value, "operatorids");
            return (Criteria) this;
        }

        public Criteria andOperatoridsLessThanOrEqualTo(String value) {
            addCriterion("operatorids <=", value, "operatorids");
            return (Criteria) this;
        }

        public Criteria andOperatoridsLike(String value) {
            addCriterion("operatorids like", value, "operatorids");
            return (Criteria) this;
        }

        public Criteria andOperatoridsNotLike(String value) {
            addCriterion("operatorids not like", value, "operatorids");
            return (Criteria) this;
        }

        public Criteria andOperatoridsIn(List<String> values) {
            addCriterion("operatorids in", values, "operatorids");
            return (Criteria) this;
        }

        public Criteria andOperatoridsNotIn(List<String> values) {
            addCriterion("operatorids not in", values, "operatorids");
            return (Criteria) this;
        }

        public Criteria andOperatoridsBetween(String value1, String value2) {
            addCriterion("operatorids between", value1, value2, "operatorids");
            return (Criteria) this;
        }

        public Criteria andOperatoridsNotBetween(String value1, String value2) {
            addCriterion("operatorids not between", value1, value2, "operatorids");
            return (Criteria) this;
        }

        public Criteria andAcceptIsNull() {
            addCriterion("accept is null");
            return (Criteria) this;
        }

        public Criteria andAcceptIsNotNull() {
            addCriterion("accept is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptEqualTo(String value) {
            addCriterion("accept =", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotEqualTo(String value) {
            addCriterion("accept <>", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptGreaterThan(String value) {
            addCriterion("accept >", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptGreaterThanOrEqualTo(String value) {
            addCriterion("accept >=", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLessThan(String value) {
            addCriterion("accept <", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLessThanOrEqualTo(String value) {
            addCriterion("accept <=", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLike(String value) {
            addCriterion("accept like", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotLike(String value) {
            addCriterion("accept not like", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptIn(List<String> values) {
            addCriterion("accept in", values, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotIn(List<String> values) {
            addCriterion("accept not in", values, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptBetween(String value1, String value2) {
            addCriterion("accept between", value1, value2, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotBetween(String value1, String value2) {
            addCriterion("accept not between", value1, value2, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingIsNull() {
            addCriterion("acceptencoding is null");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingIsNotNull() {
            addCriterion("acceptencoding is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingEqualTo(String value) {
            addCriterion("acceptencoding =", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingNotEqualTo(String value) {
            addCriterion("acceptencoding <>", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingGreaterThan(String value) {
            addCriterion("acceptencoding >", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingGreaterThanOrEqualTo(String value) {
            addCriterion("acceptencoding >=", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingLessThan(String value) {
            addCriterion("acceptencoding <", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingLessThanOrEqualTo(String value) {
            addCriterion("acceptencoding <=", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingLike(String value) {
            addCriterion("acceptencoding like", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingNotLike(String value) {
            addCriterion("acceptencoding not like", value, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingIn(List<String> values) {
            addCriterion("acceptencoding in", values, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingNotIn(List<String> values) {
            addCriterion("acceptencoding not in", values, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingBetween(String value1, String value2) {
            addCriterion("acceptencoding between", value1, value2, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptencodingNotBetween(String value1, String value2) {
            addCriterion("acceptencoding not between", value1, value2, "acceptencoding");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageIsNull() {
            addCriterion("acceptlanguage is null");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageIsNotNull() {
            addCriterion("acceptlanguage is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageEqualTo(String value) {
            addCriterion("acceptlanguage =", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageNotEqualTo(String value) {
            addCriterion("acceptlanguage <>", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageGreaterThan(String value) {
            addCriterion("acceptlanguage >", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageGreaterThanOrEqualTo(String value) {
            addCriterion("acceptlanguage >=", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageLessThan(String value) {
            addCriterion("acceptlanguage <", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageLessThanOrEqualTo(String value) {
            addCriterion("acceptlanguage <=", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageLike(String value) {
            addCriterion("acceptlanguage like", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageNotLike(String value) {
            addCriterion("acceptlanguage not like", value, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageIn(List<String> values) {
            addCriterion("acceptlanguage in", values, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageNotIn(List<String> values) {
            addCriterion("acceptlanguage not in", values, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageBetween(String value1, String value2) {
            addCriterion("acceptlanguage between", value1, value2, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andAcceptlanguageNotBetween(String value1, String value2) {
            addCriterion("acceptlanguage not between", value1, value2, "acceptlanguage");
            return (Criteria) this;
        }

        public Criteria andConnectionIsNull() {
            addCriterion("connection is null");
            return (Criteria) this;
        }

        public Criteria andConnectionIsNotNull() {
            addCriterion("connection is not null");
            return (Criteria) this;
        }

        public Criteria andConnectionEqualTo(String value) {
            addCriterion("connection =", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionNotEqualTo(String value) {
            addCriterion("connection <>", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionGreaterThan(String value) {
            addCriterion("connection >", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionGreaterThanOrEqualTo(String value) {
            addCriterion("connection >=", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionLessThan(String value) {
            addCriterion("connection <", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionLessThanOrEqualTo(String value) {
            addCriterion("connection <=", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionLike(String value) {
            addCriterion("connection like", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionNotLike(String value) {
            addCriterion("connection not like", value, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionIn(List<String> values) {
            addCriterion("connection in", values, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionNotIn(List<String> values) {
            addCriterion("connection not in", values, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionBetween(String value1, String value2) {
            addCriterion("connection between", value1, value2, "connection");
            return (Criteria) this;
        }

        public Criteria andConnectionNotBetween(String value1, String value2) {
            addCriterion("connection not between", value1, value2, "connection");
            return (Criteria) this;
        }

        public Criteria andHostIsNull() {
            addCriterion("host is null");
            return (Criteria) this;
        }

        public Criteria andHostIsNotNull() {
            addCriterion("host is not null");
            return (Criteria) this;
        }

        public Criteria andHostEqualTo(String value) {
            addCriterion("host =", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotEqualTo(String value) {
            addCriterion("host <>", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThan(String value) {
            addCriterion("host >", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThanOrEqualTo(String value) {
            addCriterion("host >=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThan(String value) {
            addCriterion("host <", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThanOrEqualTo(String value) {
            addCriterion("host <=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLike(String value) {
            addCriterion("host like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotLike(String value) {
            addCriterion("host not like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostIn(List<String> values) {
            addCriterion("host in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotIn(List<String> values) {
            addCriterion("host not in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostBetween(String value1, String value2) {
            addCriterion("host between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotBetween(String value1, String value2) {
            addCriterion("host not between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithIsNull() {
            addCriterion("xrequestedwith is null");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithIsNotNull() {
            addCriterion("xrequestedwith is not null");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithEqualTo(String value) {
            addCriterion("xrequestedwith =", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithNotEqualTo(String value) {
            addCriterion("xrequestedwith <>", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithGreaterThan(String value) {
            addCriterion("xrequestedwith >", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithGreaterThanOrEqualTo(String value) {
            addCriterion("xrequestedwith >=", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithLessThan(String value) {
            addCriterion("xrequestedwith <", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithLessThanOrEqualTo(String value) {
            addCriterion("xrequestedwith <=", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithLike(String value) {
            addCriterion("xrequestedwith like", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithNotLike(String value) {
            addCriterion("xrequestedwith not like", value, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithIn(List<String> values) {
            addCriterion("xrequestedwith in", values, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithNotIn(List<String> values) {
            addCriterion("xrequestedwith not in", values, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithBetween(String value1, String value2) {
            addCriterion("xrequestedwith between", value1, value2, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andXrequestedwithNotBetween(String value1, String value2) {
            addCriterion("xrequestedwith not between", value1, value2, "xrequestedwith");
            return (Criteria) this;
        }

        public Criteria andPvidsIsNull() {
            addCriterion("pvids is null");
            return (Criteria) this;
        }

        public Criteria andPvidsIsNotNull() {
            addCriterion("pvids is not null");
            return (Criteria) this;
        }

        public Criteria andPvidsEqualTo(String value) {
            addCriterion("pvids =", value, "pvids");
            return (Criteria) this;
        }

        public Criteria andPvidsNotEqualTo(String value) {
            addCriterion("pvids <>", value, "pvids");
            return (Criteria) this;
        }

        public Criteria andPvidsGreaterThan(String value) {
            addCriterion("pvids >", value, "pvids");
            return (Criteria) this;
        }

        public Criteria andPvidsGreaterThanOrEqualTo(String value) {
            addCriterion("pvids >=", value, "pvids");
            return (Criteria) this;
        }

        public Criteria andPvidsLessThan(String value) {
            addCriterion("pvids <", value, "pvids");
            return (Criteria) this;
        }

        public Criteria andPvidsLessThanOrEqualTo(String value) {
            addCriterion("pvids <=", value, "pvids");
            return (Criteria) this;
        }

        public Criteria andPvidsLike(String value) {
            addCriterion("pvids like", value, "pvids");
            return (Criteria) this;
        }

        public Criteria andPvidsNotLike(String value) {
            addCriterion("pvids not like", value, "pvids");
            return (Criteria) this;
        }

        public Criteria andPvidsIn(List<String> values) {
            addCriterion("pvids in", values, "pvids");
            return (Criteria) this;
        }

        public Criteria andPvidsNotIn(List<String> values) {
            addCriterion("pvids not in", values, "pvids");
            return (Criteria) this;
        }

        public Criteria andPvidsBetween(String value1, String value2) {
            addCriterion("pvids between", value1, value2, "pvids");
            return (Criteria) this;
        }

        public Criteria andPvidsNotBetween(String value1, String value2) {
            addCriterion("pvids not between", value1, value2, "pvids");
            return (Criteria) this;
        }

        public Criteria andUseridsIsNull() {
            addCriterion("userids is null");
            return (Criteria) this;
        }

        public Criteria andUseridsIsNotNull() {
            addCriterion("userids is not null");
            return (Criteria) this;
        }

        public Criteria andUseridsEqualTo(String value) {
            addCriterion("userids =", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsNotEqualTo(String value) {
            addCriterion("userids <>", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsGreaterThan(String value) {
            addCriterion("userids >", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsGreaterThanOrEqualTo(String value) {
            addCriterion("userids >=", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsLessThan(String value) {
            addCriterion("userids <", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsLessThanOrEqualTo(String value) {
            addCriterion("userids <=", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsLike(String value) {
            addCriterion("userids like", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsNotLike(String value) {
            addCriterion("userids not like", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsIn(List<String> values) {
            addCriterion("userids in", values, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsNotIn(List<String> values) {
            addCriterion("userids not in", values, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsBetween(String value1, String value2) {
            addCriterion("userids between", value1, value2, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsNotBetween(String value1, String value2) {
            addCriterion("userids not between", value1, value2, "userids");
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