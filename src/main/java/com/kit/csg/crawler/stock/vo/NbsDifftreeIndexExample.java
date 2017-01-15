package com.kit.csg.crawler.stock.vo;

import java.util.ArrayList;
import java.util.List;

public class NbsDifftreeIndexExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NbsDifftreeIndexExample() {
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

        public Criteria andFscodeIsNull() {
            addCriterion("FSCODE is null");
            return (Criteria) this;
        }

        public Criteria andFscodeIsNotNull() {
            addCriterion("FSCODE is not null");
            return (Criteria) this;
        }

        public Criteria andFscodeEqualTo(String value) {
            addCriterion("FSCODE =", value, "fscode");
            return (Criteria) this;
        }

        public Criteria andFscodeNotEqualTo(String value) {
            addCriterion("FSCODE <>", value, "fscode");
            return (Criteria) this;
        }

        public Criteria andFscodeGreaterThan(String value) {
            addCriterion("FSCODE >", value, "fscode");
            return (Criteria) this;
        }

        public Criteria andFscodeGreaterThanOrEqualTo(String value) {
            addCriterion("FSCODE >=", value, "fscode");
            return (Criteria) this;
        }

        public Criteria andFscodeLessThan(String value) {
            addCriterion("FSCODE <", value, "fscode");
            return (Criteria) this;
        }

        public Criteria andFscodeLessThanOrEqualTo(String value) {
            addCriterion("FSCODE <=", value, "fscode");
            return (Criteria) this;
        }

        public Criteria andFscodeLike(String value) {
            addCriterion("FSCODE like", value, "fscode");
            return (Criteria) this;
        }

        public Criteria andFscodeNotLike(String value) {
            addCriterion("FSCODE not like", value, "fscode");
            return (Criteria) this;
        }

        public Criteria andFscodeIn(List<String> values) {
            addCriterion("FSCODE in", values, "fscode");
            return (Criteria) this;
        }

        public Criteria andFscodeNotIn(List<String> values) {
            addCriterion("FSCODE not in", values, "fscode");
            return (Criteria) this;
        }

        public Criteria andFscodeBetween(String value1, String value2) {
            addCriterion("FSCODE between", value1, value2, "fscode");
            return (Criteria) this;
        }

        public Criteria andFscodeNotBetween(String value1, String value2) {
            addCriterion("FSCODE not between", value1, value2, "fscode");
            return (Criteria) this;
        }

        public Criteria andIndexnameIsNull() {
            addCriterion("INDEXNAME is null");
            return (Criteria) this;
        }

        public Criteria andIndexnameIsNotNull() {
            addCriterion("INDEXNAME is not null");
            return (Criteria) this;
        }

        public Criteria andIndexnameEqualTo(String value) {
            addCriterion("INDEXNAME =", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotEqualTo(String value) {
            addCriterion("INDEXNAME <>", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameGreaterThan(String value) {
            addCriterion("INDEXNAME >", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameGreaterThanOrEqualTo(String value) {
            addCriterion("INDEXNAME >=", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLessThan(String value) {
            addCriterion("INDEXNAME <", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLessThanOrEqualTo(String value) {
            addCriterion("INDEXNAME <=", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameLike(String value) {
            addCriterion("INDEXNAME like", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotLike(String value) {
            addCriterion("INDEXNAME not like", value, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameIn(List<String> values) {
            addCriterion("INDEXNAME in", values, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotIn(List<String> values) {
            addCriterion("INDEXNAME not in", values, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameBetween(String value1, String value2) {
            addCriterion("INDEXNAME between", value1, value2, "indexname");
            return (Criteria) this;
        }

        public Criteria andIndexnameNotBetween(String value1, String value2) {
            addCriterion("INDEXNAME not between", value1, value2, "indexname");
            return (Criteria) this;
        }

        public Criteria andTreenodenameIsNull() {
            addCriterion("TREENODENAME is null");
            return (Criteria) this;
        }

        public Criteria andTreenodenameIsNotNull() {
            addCriterion("TREENODENAME is not null");
            return (Criteria) this;
        }

        public Criteria andTreenodenameEqualTo(String value) {
            addCriterion("TREENODENAME =", value, "treenodename");
            return (Criteria) this;
        }

        public Criteria andTreenodenameNotEqualTo(String value) {
            addCriterion("TREENODENAME <>", value, "treenodename");
            return (Criteria) this;
        }

        public Criteria andTreenodenameGreaterThan(String value) {
            addCriterion("TREENODENAME >", value, "treenodename");
            return (Criteria) this;
        }

        public Criteria andTreenodenameGreaterThanOrEqualTo(String value) {
            addCriterion("TREENODENAME >=", value, "treenodename");
            return (Criteria) this;
        }

        public Criteria andTreenodenameLessThan(String value) {
            addCriterion("TREENODENAME <", value, "treenodename");
            return (Criteria) this;
        }

        public Criteria andTreenodenameLessThanOrEqualTo(String value) {
            addCriterion("TREENODENAME <=", value, "treenodename");
            return (Criteria) this;
        }

        public Criteria andTreenodenameLike(String value) {
            addCriterion("TREENODENAME like", value, "treenodename");
            return (Criteria) this;
        }

        public Criteria andTreenodenameNotLike(String value) {
            addCriterion("TREENODENAME not like", value, "treenodename");
            return (Criteria) this;
        }

        public Criteria andTreenodenameIn(List<String> values) {
            addCriterion("TREENODENAME in", values, "treenodename");
            return (Criteria) this;
        }

        public Criteria andTreenodenameNotIn(List<String> values) {
            addCriterion("TREENODENAME not in", values, "treenodename");
            return (Criteria) this;
        }

        public Criteria andTreenodenameBetween(String value1, String value2) {
            addCriterion("TREENODENAME between", value1, value2, "treenodename");
            return (Criteria) this;
        }

        public Criteria andTreenodenameNotBetween(String value1, String value2) {
            addCriterion("TREENODENAME not between", value1, value2, "treenodename");
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