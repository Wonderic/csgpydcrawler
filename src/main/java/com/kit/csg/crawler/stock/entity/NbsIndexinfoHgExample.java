package com.kit.csg.crawler.stock.entity;

import java.util.ArrayList;
import java.util.List;

public class NbsIndexinfoHgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NbsIndexinfoHgExample() {
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

        public Criteria andIndexcodeIsNull() {
            addCriterion("INDEXCODE is null");
            return (Criteria) this;
        }

        public Criteria andIndexcodeIsNotNull() {
            addCriterion("INDEXCODE is not null");
            return (Criteria) this;
        }

        public Criteria andIndexcodeEqualTo(String value) {
            addCriterion("INDEXCODE =", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeNotEqualTo(String value) {
            addCriterion("INDEXCODE <>", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeGreaterThan(String value) {
            addCriterion("INDEXCODE >", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeGreaterThanOrEqualTo(String value) {
            addCriterion("INDEXCODE >=", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeLessThan(String value) {
            addCriterion("INDEXCODE <", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeLessThanOrEqualTo(String value) {
            addCriterion("INDEXCODE <=", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeLike(String value) {
            addCriterion("INDEXCODE like", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeNotLike(String value) {
            addCriterion("INDEXCODE not like", value, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeIn(List<String> values) {
            addCriterion("INDEXCODE in", values, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeNotIn(List<String> values) {
            addCriterion("INDEXCODE not in", values, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeBetween(String value1, String value2) {
            addCriterion("INDEXCODE between", value1, value2, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexcodeNotBetween(String value1, String value2) {
            addCriterion("INDEXCODE not between", value1, value2, "indexcode");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeIsNull() {
            addCriterion("INDEXDATETYPE is null");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeIsNotNull() {
            addCriterion("INDEXDATETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeEqualTo(String value) {
            addCriterion("INDEXDATETYPE =", value, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeNotEqualTo(String value) {
            addCriterion("INDEXDATETYPE <>", value, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeGreaterThan(String value) {
            addCriterion("INDEXDATETYPE >", value, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeGreaterThanOrEqualTo(String value) {
            addCriterion("INDEXDATETYPE >=", value, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeLessThan(String value) {
            addCriterion("INDEXDATETYPE <", value, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeLessThanOrEqualTo(String value) {
            addCriterion("INDEXDATETYPE <=", value, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeLike(String value) {
            addCriterion("INDEXDATETYPE like", value, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeNotLike(String value) {
            addCriterion("INDEXDATETYPE not like", value, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeIn(List<String> values) {
            addCriterion("INDEXDATETYPE in", values, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeNotIn(List<String> values) {
            addCriterion("INDEXDATETYPE not in", values, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeBetween(String value1, String value2) {
            addCriterion("INDEXDATETYPE between", value1, value2, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatetypeNotBetween(String value1, String value2) {
            addCriterion("INDEXDATETYPE not between", value1, value2, "indexdatetype");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameIsNull() {
            addCriterion("INDEXDATANAME is null");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameIsNotNull() {
            addCriterion("INDEXDATANAME is not null");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameEqualTo(String value) {
            addCriterion("INDEXDATANAME =", value, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameNotEqualTo(String value) {
            addCriterion("INDEXDATANAME <>", value, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameGreaterThan(String value) {
            addCriterion("INDEXDATANAME >", value, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameGreaterThanOrEqualTo(String value) {
            addCriterion("INDEXDATANAME >=", value, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameLessThan(String value) {
            addCriterion("INDEXDATANAME <", value, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameLessThanOrEqualTo(String value) {
            addCriterion("INDEXDATANAME <=", value, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameLike(String value) {
            addCriterion("INDEXDATANAME like", value, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameNotLike(String value) {
            addCriterion("INDEXDATANAME not like", value, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameIn(List<String> values) {
            addCriterion("INDEXDATANAME in", values, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameNotIn(List<String> values) {
            addCriterion("INDEXDATANAME not in", values, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameBetween(String value1, String value2) {
            addCriterion("INDEXDATANAME between", value1, value2, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andIndexdatanameNotBetween(String value1, String value2) {
            addCriterion("INDEXDATANAME not between", value1, value2, "indexdataname");
            return (Criteria) this;
        }

        public Criteria andParentcodeIsNull() {
            addCriterion("PARENTCODE is null");
            return (Criteria) this;
        }

        public Criteria andParentcodeIsNotNull() {
            addCriterion("PARENTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andParentcodeEqualTo(String value) {
            addCriterion("PARENTCODE =", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotEqualTo(String value) {
            addCriterion("PARENTCODE <>", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeGreaterThan(String value) {
            addCriterion("PARENTCODE >", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("PARENTCODE >=", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLessThan(String value) {
            addCriterion("PARENTCODE <", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLessThanOrEqualTo(String value) {
            addCriterion("PARENTCODE <=", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLike(String value) {
            addCriterion("PARENTCODE like", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotLike(String value) {
            addCriterion("PARENTCODE not like", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeIn(List<String> values) {
            addCriterion("PARENTCODE in", values, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotIn(List<String> values) {
            addCriterion("PARENTCODE not in", values, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeBetween(String value1, String value2) {
            addCriterion("PARENTCODE between", value1, value2, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotBetween(String value1, String value2) {
            addCriterion("PARENTCODE not between", value1, value2, "parentcode");
            return (Criteria) this;
        }

        public Criteria andIsparentIsNull() {
            addCriterion("ISPARENT is null");
            return (Criteria) this;
        }

        public Criteria andIsparentIsNotNull() {
            addCriterion("ISPARENT is not null");
            return (Criteria) this;
        }

        public Criteria andIsparentEqualTo(String value) {
            addCriterion("ISPARENT =", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotEqualTo(String value) {
            addCriterion("ISPARENT <>", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentGreaterThan(String value) {
            addCriterion("ISPARENT >", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentGreaterThanOrEqualTo(String value) {
            addCriterion("ISPARENT >=", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentLessThan(String value) {
            addCriterion("ISPARENT <", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentLessThanOrEqualTo(String value) {
            addCriterion("ISPARENT <=", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentLike(String value) {
            addCriterion("ISPARENT like", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotLike(String value) {
            addCriterion("ISPARENT not like", value, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentIn(List<String> values) {
            addCriterion("ISPARENT in", values, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotIn(List<String> values) {
            addCriterion("ISPARENT not in", values, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentBetween(String value1, String value2) {
            addCriterion("ISPARENT between", value1, value2, "isparent");
            return (Criteria) this;
        }

        public Criteria andIsparentNotBetween(String value1, String value2) {
            addCriterion("ISPARENT not between", value1, value2, "isparent");
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

        public Criteria andRealcodeIsNull() {
            addCriterion("REALCODE is null");
            return (Criteria) this;
        }

        public Criteria andRealcodeIsNotNull() {
            addCriterion("REALCODE is not null");
            return (Criteria) this;
        }

        public Criteria andRealcodeEqualTo(String value) {
            addCriterion("REALCODE =", value, "realcode");
            return (Criteria) this;
        }

        public Criteria andRealcodeNotEqualTo(String value) {
            addCriterion("REALCODE <>", value, "realcode");
            return (Criteria) this;
        }

        public Criteria andRealcodeGreaterThan(String value) {
            addCriterion("REALCODE >", value, "realcode");
            return (Criteria) this;
        }

        public Criteria andRealcodeGreaterThanOrEqualTo(String value) {
            addCriterion("REALCODE >=", value, "realcode");
            return (Criteria) this;
        }

        public Criteria andRealcodeLessThan(String value) {
            addCriterion("REALCODE <", value, "realcode");
            return (Criteria) this;
        }

        public Criteria andRealcodeLessThanOrEqualTo(String value) {
            addCriterion("REALCODE <=", value, "realcode");
            return (Criteria) this;
        }

        public Criteria andRealcodeLike(String value) {
            addCriterion("REALCODE like", value, "realcode");
            return (Criteria) this;
        }

        public Criteria andRealcodeNotLike(String value) {
            addCriterion("REALCODE not like", value, "realcode");
            return (Criteria) this;
        }

        public Criteria andRealcodeIn(List<String> values) {
            addCriterion("REALCODE in", values, "realcode");
            return (Criteria) this;
        }

        public Criteria andRealcodeNotIn(List<String> values) {
            addCriterion("REALCODE not in", values, "realcode");
            return (Criteria) this;
        }

        public Criteria andRealcodeBetween(String value1, String value2) {
            addCriterion("REALCODE between", value1, value2, "realcode");
            return (Criteria) this;
        }

        public Criteria andRealcodeNotBetween(String value1, String value2) {
            addCriterion("REALCODE not between", value1, value2, "realcode");
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