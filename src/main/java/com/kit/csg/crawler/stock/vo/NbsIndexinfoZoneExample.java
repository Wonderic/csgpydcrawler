package com.kit.csg.crawler.stock.vo;

import java.util.ArrayList;
import java.util.List;

public class NbsIndexinfoZoneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NbsIndexinfoZoneExample() {
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

        public Criteria andZonecodeIsNull() {
            addCriterion("ZONECODE is null");
            return (Criteria) this;
        }

        public Criteria andZonecodeIsNotNull() {
            addCriterion("ZONECODE is not null");
            return (Criteria) this;
        }

        public Criteria andZonecodeEqualTo(String value) {
            addCriterion("ZONECODE =", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeNotEqualTo(String value) {
            addCriterion("ZONECODE <>", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeGreaterThan(String value) {
            addCriterion("ZONECODE >", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeGreaterThanOrEqualTo(String value) {
            addCriterion("ZONECODE >=", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeLessThan(String value) {
            addCriterion("ZONECODE <", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeLessThanOrEqualTo(String value) {
            addCriterion("ZONECODE <=", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeLike(String value) {
            addCriterion("ZONECODE like", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeNotLike(String value) {
            addCriterion("ZONECODE not like", value, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeIn(List<String> values) {
            addCriterion("ZONECODE in", values, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeNotIn(List<String> values) {
            addCriterion("ZONECODE not in", values, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeBetween(String value1, String value2) {
            addCriterion("ZONECODE between", value1, value2, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonecodeNotBetween(String value1, String value2) {
            addCriterion("ZONECODE not between", value1, value2, "zonecode");
            return (Criteria) this;
        }

        public Criteria andZonenameIsNull() {
            addCriterion("ZONENAME is null");
            return (Criteria) this;
        }

        public Criteria andZonenameIsNotNull() {
            addCriterion("ZONENAME is not null");
            return (Criteria) this;
        }

        public Criteria andZonenameEqualTo(String value) {
            addCriterion("ZONENAME =", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotEqualTo(String value) {
            addCriterion("ZONENAME <>", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameGreaterThan(String value) {
            addCriterion("ZONENAME >", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameGreaterThanOrEqualTo(String value) {
            addCriterion("ZONENAME >=", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameLessThan(String value) {
            addCriterion("ZONENAME <", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameLessThanOrEqualTo(String value) {
            addCriterion("ZONENAME <=", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameLike(String value) {
            addCriterion("ZONENAME like", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotLike(String value) {
            addCriterion("ZONENAME not like", value, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameIn(List<String> values) {
            addCriterion("ZONENAME in", values, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotIn(List<String> values) {
            addCriterion("ZONENAME not in", values, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameBetween(String value1, String value2) {
            addCriterion("ZONENAME between", value1, value2, "zonename");
            return (Criteria) this;
        }

        public Criteria andZonenameNotBetween(String value1, String value2) {
            addCriterion("ZONENAME not between", value1, value2, "zonename");
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

        public Criteria andDbcodeIsNull() {
            addCriterion("DBCODE is null");
            return (Criteria) this;
        }

        public Criteria andDbcodeIsNotNull() {
            addCriterion("DBCODE is not null");
            return (Criteria) this;
        }

        public Criteria andDbcodeEqualTo(String value) {
            addCriterion("DBCODE =", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeNotEqualTo(String value) {
            addCriterion("DBCODE <>", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeGreaterThan(String value) {
            addCriterion("DBCODE >", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeGreaterThanOrEqualTo(String value) {
            addCriterion("DBCODE >=", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeLessThan(String value) {
            addCriterion("DBCODE <", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeLessThanOrEqualTo(String value) {
            addCriterion("DBCODE <=", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeLike(String value) {
            addCriterion("DBCODE like", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeNotLike(String value) {
            addCriterion("DBCODE not like", value, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeIn(List<String> values) {
            addCriterion("DBCODE in", values, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeNotIn(List<String> values) {
            addCriterion("DBCODE not in", values, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeBetween(String value1, String value2) {
            addCriterion("DBCODE between", value1, value2, "dbcode");
            return (Criteria) this;
        }

        public Criteria andDbcodeNotBetween(String value1, String value2) {
            addCriterion("DBCODE not between", value1, value2, "dbcode");
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