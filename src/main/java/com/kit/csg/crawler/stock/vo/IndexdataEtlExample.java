package com.kit.csg.crawler.stock.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndexdataEtlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IndexdataEtlExample() {
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

        public Criteria andItemdateIsNull() {
            addCriterion("ITEMDATE is null");
            return (Criteria) this;
        }

        public Criteria andItemdateIsNotNull() {
            addCriterion("ITEMDATE is not null");
            return (Criteria) this;
        }

        public Criteria andItemdateEqualTo(Date value) {
            addCriterion("ITEMDATE =", value, "itemdate");
            return (Criteria) this;
        }

        public Criteria andItemdateNotEqualTo(Date value) {
            addCriterion("ITEMDATE <>", value, "itemdate");
            return (Criteria) this;
        }

        public Criteria andItemdateGreaterThan(Date value) {
            addCriterion("ITEMDATE >", value, "itemdate");
            return (Criteria) this;
        }

        public Criteria andItemdateGreaterThanOrEqualTo(Date value) {
            addCriterion("ITEMDATE >=", value, "itemdate");
            return (Criteria) this;
        }

        public Criteria andItemdateLessThan(Date value) {
            addCriterion("ITEMDATE <", value, "itemdate");
            return (Criteria) this;
        }

        public Criteria andItemdateLessThanOrEqualTo(Date value) {
            addCriterion("ITEMDATE <=", value, "itemdate");
            return (Criteria) this;
        }

        public Criteria andItemdateIn(List<Date> values) {
            addCriterion("ITEMDATE in", values, "itemdate");
            return (Criteria) this;
        }

        public Criteria andItemdateNotIn(List<Date> values) {
            addCriterion("ITEMDATE not in", values, "itemdate");
            return (Criteria) this;
        }

        public Criteria andItemdateBetween(Date value1, Date value2) {
            addCriterion("ITEMDATE between", value1, value2, "itemdate");
            return (Criteria) this;
        }

        public Criteria andItemdateNotBetween(Date value1, Date value2) {
            addCriterion("ITEMDATE not between", value1, value2, "itemdate");
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

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE not between", value1, value2, "price");
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