package com.kit.csg.crawler.stock.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PowereconIntypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PowereconIntypeExample() {
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

        public Criteria andIndextypeIdIsNull() {
            addCriterion("INDEXTYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andIndextypeIdIsNotNull() {
            addCriterion("INDEXTYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andIndextypeIdEqualTo(BigDecimal value) {
            addCriterion("INDEXTYPE_ID =", value, "indextypeId");
            return (Criteria) this;
        }

        public Criteria andIndextypeIdNotEqualTo(BigDecimal value) {
            addCriterion("INDEXTYPE_ID <>", value, "indextypeId");
            return (Criteria) this;
        }

        public Criteria andIndextypeIdGreaterThan(BigDecimal value) {
            addCriterion("INDEXTYPE_ID >", value, "indextypeId");
            return (Criteria) this;
        }

        public Criteria andIndextypeIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INDEXTYPE_ID >=", value, "indextypeId");
            return (Criteria) this;
        }

        public Criteria andIndextypeIdLessThan(BigDecimal value) {
            addCriterion("INDEXTYPE_ID <", value, "indextypeId");
            return (Criteria) this;
        }

        public Criteria andIndextypeIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INDEXTYPE_ID <=", value, "indextypeId");
            return (Criteria) this;
        }

        public Criteria andIndextypeIdIn(List<BigDecimal> values) {
            addCriterion("INDEXTYPE_ID in", values, "indextypeId");
            return (Criteria) this;
        }

        public Criteria andIndextypeIdNotIn(List<BigDecimal> values) {
            addCriterion("INDEXTYPE_ID not in", values, "indextypeId");
            return (Criteria) this;
        }

        public Criteria andIndextypeIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INDEXTYPE_ID between", value1, value2, "indextypeId");
            return (Criteria) this;
        }

        public Criteria andIndextypeIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INDEXTYPE_ID not between", value1, value2, "indextypeId");
            return (Criteria) this;
        }

        public Criteria andIndetypenameIsNull() {
            addCriterion("INDETYPENAME is null");
            return (Criteria) this;
        }

        public Criteria andIndetypenameIsNotNull() {
            addCriterion("INDETYPENAME is not null");
            return (Criteria) this;
        }

        public Criteria andIndetypenameEqualTo(String value) {
            addCriterion("INDETYPENAME =", value, "indetypename");
            return (Criteria) this;
        }

        public Criteria andIndetypenameNotEqualTo(String value) {
            addCriterion("INDETYPENAME <>", value, "indetypename");
            return (Criteria) this;
        }

        public Criteria andIndetypenameGreaterThan(String value) {
            addCriterion("INDETYPENAME >", value, "indetypename");
            return (Criteria) this;
        }

        public Criteria andIndetypenameGreaterThanOrEqualTo(String value) {
            addCriterion("INDETYPENAME >=", value, "indetypename");
            return (Criteria) this;
        }

        public Criteria andIndetypenameLessThan(String value) {
            addCriterion("INDETYPENAME <", value, "indetypename");
            return (Criteria) this;
        }

        public Criteria andIndetypenameLessThanOrEqualTo(String value) {
            addCriterion("INDETYPENAME <=", value, "indetypename");
            return (Criteria) this;
        }

        public Criteria andIndetypenameLike(String value) {
            addCriterion("INDETYPENAME like", value, "indetypename");
            return (Criteria) this;
        }

        public Criteria andIndetypenameNotLike(String value) {
            addCriterion("INDETYPENAME not like", value, "indetypename");
            return (Criteria) this;
        }

        public Criteria andIndetypenameIn(List<String> values) {
            addCriterion("INDETYPENAME in", values, "indetypename");
            return (Criteria) this;
        }

        public Criteria andIndetypenameNotIn(List<String> values) {
            addCriterion("INDETYPENAME not in", values, "indetypename");
            return (Criteria) this;
        }

        public Criteria andIndetypenameBetween(String value1, String value2) {
            addCriterion("INDETYPENAME between", value1, value2, "indetypename");
            return (Criteria) this;
        }

        public Criteria andIndetypenameNotBetween(String value1, String value2) {
            addCriterion("INDETYPENAME not between", value1, value2, "indetypename");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("UNIT is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("UNIT =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("UNIT <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("UNIT >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("UNIT <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("UNIT <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("UNIT like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("UNIT not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("UNIT in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("UNIT not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("UNIT between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("UNIT not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andStatastreeidIsNull() {
            addCriterion("STATASTREEID is null");
            return (Criteria) this;
        }

        public Criteria andStatastreeidIsNotNull() {
            addCriterion("STATASTREEID is not null");
            return (Criteria) this;
        }

        public Criteria andStatastreeidEqualTo(BigDecimal value) {
            addCriterion("STATASTREEID =", value, "statastreeid");
            return (Criteria) this;
        }

        public Criteria andStatastreeidNotEqualTo(BigDecimal value) {
            addCriterion("STATASTREEID <>", value, "statastreeid");
            return (Criteria) this;
        }

        public Criteria andStatastreeidGreaterThan(BigDecimal value) {
            addCriterion("STATASTREEID >", value, "statastreeid");
            return (Criteria) this;
        }

        public Criteria andStatastreeidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STATASTREEID >=", value, "statastreeid");
            return (Criteria) this;
        }

        public Criteria andStatastreeidLessThan(BigDecimal value) {
            addCriterion("STATASTREEID <", value, "statastreeid");
            return (Criteria) this;
        }

        public Criteria andStatastreeidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STATASTREEID <=", value, "statastreeid");
            return (Criteria) this;
        }

        public Criteria andStatastreeidIn(List<BigDecimal> values) {
            addCriterion("STATASTREEID in", values, "statastreeid");
            return (Criteria) this;
        }

        public Criteria andStatastreeidNotIn(List<BigDecimal> values) {
            addCriterion("STATASTREEID not in", values, "statastreeid");
            return (Criteria) this;
        }

        public Criteria andStatastreeidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STATASTREEID between", value1, value2, "statastreeid");
            return (Criteria) this;
        }

        public Criteria andStatastreeidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STATASTREEID not between", value1, value2, "statastreeid");
            return (Criteria) this;
        }

        public Criteria andSelftreeidIsNull() {
            addCriterion("SELFTREEID is null");
            return (Criteria) this;
        }

        public Criteria andSelftreeidIsNotNull() {
            addCriterion("SELFTREEID is not null");
            return (Criteria) this;
        }

        public Criteria andSelftreeidEqualTo(BigDecimal value) {
            addCriterion("SELFTREEID =", value, "selftreeid");
            return (Criteria) this;
        }

        public Criteria andSelftreeidNotEqualTo(BigDecimal value) {
            addCriterion("SELFTREEID <>", value, "selftreeid");
            return (Criteria) this;
        }

        public Criteria andSelftreeidGreaterThan(BigDecimal value) {
            addCriterion("SELFTREEID >", value, "selftreeid");
            return (Criteria) this;
        }

        public Criteria andSelftreeidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SELFTREEID >=", value, "selftreeid");
            return (Criteria) this;
        }

        public Criteria andSelftreeidLessThan(BigDecimal value) {
            addCriterion("SELFTREEID <", value, "selftreeid");
            return (Criteria) this;
        }

        public Criteria andSelftreeidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SELFTREEID <=", value, "selftreeid");
            return (Criteria) this;
        }

        public Criteria andSelftreeidIn(List<BigDecimal> values) {
            addCriterion("SELFTREEID in", values, "selftreeid");
            return (Criteria) this;
        }

        public Criteria andSelftreeidNotIn(List<BigDecimal> values) {
            addCriterion("SELFTREEID not in", values, "selftreeid");
            return (Criteria) this;
        }

        public Criteria andSelftreeidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELFTREEID between", value1, value2, "selftreeid");
            return (Criteria) this;
        }

        public Criteria andSelftreeidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SELFTREEID not between", value1, value2, "selftreeid");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("COMMENT =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("COMMENT <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("COMMENT >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENT >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("COMMENT <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("COMMENT <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("COMMENT like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("COMMENT not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("COMMENT in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("COMMENT not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("COMMENT between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("COMMENT not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andExpIsNull() {
            addCriterion("EXP is null");
            return (Criteria) this;
        }

        public Criteria andExpIsNotNull() {
            addCriterion("EXP is not null");
            return (Criteria) this;
        }

        public Criteria andExpEqualTo(String value) {
            addCriterion("EXP =", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpNotEqualTo(String value) {
            addCriterion("EXP <>", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpGreaterThan(String value) {
            addCriterion("EXP >", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpGreaterThanOrEqualTo(String value) {
            addCriterion("EXP >=", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpLessThan(String value) {
            addCriterion("EXP <", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpLessThanOrEqualTo(String value) {
            addCriterion("EXP <=", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpLike(String value) {
            addCriterion("EXP like", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpNotLike(String value) {
            addCriterion("EXP not like", value, "exp");
            return (Criteria) this;
        }

        public Criteria andExpIn(List<String> values) {
            addCriterion("EXP in", values, "exp");
            return (Criteria) this;
        }

        public Criteria andExpNotIn(List<String> values) {
            addCriterion("EXP not in", values, "exp");
            return (Criteria) this;
        }

        public Criteria andExpBetween(String value1, String value2) {
            addCriterion("EXP between", value1, value2, "exp");
            return (Criteria) this;
        }

        public Criteria andExpNotBetween(String value1, String value2) {
            addCriterion("EXP not between", value1, value2, "exp");
            return (Criteria) this;
        }

        public Criteria andScopeIsNull() {
            addCriterion("SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andScopeIsNotNull() {
            addCriterion("SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andScopeEqualTo(String value) {
            addCriterion("SCOPE =", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotEqualTo(String value) {
            addCriterion("SCOPE <>", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThan(String value) {
            addCriterion("SCOPE >", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeGreaterThanOrEqualTo(String value) {
            addCriterion("SCOPE >=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThan(String value) {
            addCriterion("SCOPE <", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLessThanOrEqualTo(String value) {
            addCriterion("SCOPE <=", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeLike(String value) {
            addCriterion("SCOPE like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotLike(String value) {
            addCriterion("SCOPE not like", value, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeIn(List<String> values) {
            addCriterion("SCOPE in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotIn(List<String> values) {
            addCriterion("SCOPE not in", values, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeBetween(String value1, String value2) {
            addCriterion("SCOPE between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andScopeNotBetween(String value1, String value2) {
            addCriterion("SCOPE not between", value1, value2, "scope");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("SOURCE =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("SOURCE <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("SOURCE >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("SOURCE <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("SOURCE <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("SOURCE like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("SOURCE not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("SOURCE in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("SOURCE not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("SOURCE between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("SOURCE not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourcekeyIsNull() {
            addCriterion("SOURCEKEY is null");
            return (Criteria) this;
        }

        public Criteria andSourcekeyIsNotNull() {
            addCriterion("SOURCEKEY is not null");
            return (Criteria) this;
        }

        public Criteria andSourcekeyEqualTo(String value) {
            addCriterion("SOURCEKEY =", value, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andSourcekeyNotEqualTo(String value) {
            addCriterion("SOURCEKEY <>", value, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andSourcekeyGreaterThan(String value) {
            addCriterion("SOURCEKEY >", value, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andSourcekeyGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCEKEY >=", value, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andSourcekeyLessThan(String value) {
            addCriterion("SOURCEKEY <", value, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andSourcekeyLessThanOrEqualTo(String value) {
            addCriterion("SOURCEKEY <=", value, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andSourcekeyLike(String value) {
            addCriterion("SOURCEKEY like", value, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andSourcekeyNotLike(String value) {
            addCriterion("SOURCEKEY not like", value, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andSourcekeyIn(List<String> values) {
            addCriterion("SOURCEKEY in", values, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andSourcekeyNotIn(List<String> values) {
            addCriterion("SOURCEKEY not in", values, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andSourcekeyBetween(String value1, String value2) {
            addCriterion("SOURCEKEY between", value1, value2, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andSourcekeyNotBetween(String value1, String value2) {
            addCriterion("SOURCEKEY not between", value1, value2, "sourcekey");
            return (Criteria) this;
        }

        public Criteria andTimetypeIsNull() {
            addCriterion("TIMETYPE is null");
            return (Criteria) this;
        }

        public Criteria andTimetypeIsNotNull() {
            addCriterion("TIMETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTimetypeEqualTo(String value) {
            addCriterion("TIMETYPE =", value, "timetype");
            return (Criteria) this;
        }

        public Criteria andTimetypeNotEqualTo(String value) {
            addCriterion("TIMETYPE <>", value, "timetype");
            return (Criteria) this;
        }

        public Criteria andTimetypeGreaterThan(String value) {
            addCriterion("TIMETYPE >", value, "timetype");
            return (Criteria) this;
        }

        public Criteria andTimetypeGreaterThanOrEqualTo(String value) {
            addCriterion("TIMETYPE >=", value, "timetype");
            return (Criteria) this;
        }

        public Criteria andTimetypeLessThan(String value) {
            addCriterion("TIMETYPE <", value, "timetype");
            return (Criteria) this;
        }

        public Criteria andTimetypeLessThanOrEqualTo(String value) {
            addCriterion("TIMETYPE <=", value, "timetype");
            return (Criteria) this;
        }

        public Criteria andTimetypeLike(String value) {
            addCriterion("TIMETYPE like", value, "timetype");
            return (Criteria) this;
        }

        public Criteria andTimetypeNotLike(String value) {
            addCriterion("TIMETYPE not like", value, "timetype");
            return (Criteria) this;
        }

        public Criteria andTimetypeIn(List<String> values) {
            addCriterion("TIMETYPE in", values, "timetype");
            return (Criteria) this;
        }

        public Criteria andTimetypeNotIn(List<String> values) {
            addCriterion("TIMETYPE not in", values, "timetype");
            return (Criteria) this;
        }

        public Criteria andTimetypeBetween(String value1, String value2) {
            addCriterion("TIMETYPE between", value1, value2, "timetype");
            return (Criteria) this;
        }

        public Criteria andTimetypeNotBetween(String value1, String value2) {
            addCriterion("TIMETYPE not between", value1, value2, "timetype");
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