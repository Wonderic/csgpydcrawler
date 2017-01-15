package com.kit.csg.crawler.stock.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PowereconStockmarketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PowereconStockmarketExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMarketnameIsNull() {
            addCriterion("MARKETNAME is null");
            return (Criteria) this;
        }

        public Criteria andMarketnameIsNotNull() {
            addCriterion("MARKETNAME is not null");
            return (Criteria) this;
        }

        public Criteria andMarketnameEqualTo(String value) {
            addCriterion("MARKETNAME =", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameNotEqualTo(String value) {
            addCriterion("MARKETNAME <>", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameGreaterThan(String value) {
            addCriterion("MARKETNAME >", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameGreaterThanOrEqualTo(String value) {
            addCriterion("MARKETNAME >=", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameLessThan(String value) {
            addCriterion("MARKETNAME <", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameLessThanOrEqualTo(String value) {
            addCriterion("MARKETNAME <=", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameLike(String value) {
            addCriterion("MARKETNAME like", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameNotLike(String value) {
            addCriterion("MARKETNAME not like", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameIn(List<String> values) {
            addCriterion("MARKETNAME in", values, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameNotIn(List<String> values) {
            addCriterion("MARKETNAME not in", values, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameBetween(String value1, String value2) {
            addCriterion("MARKETNAME between", value1, value2, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameNotBetween(String value1, String value2) {
            addCriterion("MARKETNAME not between", value1, value2, "marketname");
            return (Criteria) this;
        }

        public Criteria andIndexdataIsNull() {
            addCriterion("INDEXDATA is null");
            return (Criteria) this;
        }

        public Criteria andIndexdataIsNotNull() {
            addCriterion("INDEXDATA is not null");
            return (Criteria) this;
        }

        public Criteria andIndexdataEqualTo(BigDecimal value) {
            addCriterion("INDEXDATA =", value, "indexdata");
            return (Criteria) this;
        }

        public Criteria andIndexdataNotEqualTo(BigDecimal value) {
            addCriterion("INDEXDATA <>", value, "indexdata");
            return (Criteria) this;
        }

        public Criteria andIndexdataGreaterThan(BigDecimal value) {
            addCriterion("INDEXDATA >", value, "indexdata");
            return (Criteria) this;
        }

        public Criteria andIndexdataGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INDEXDATA >=", value, "indexdata");
            return (Criteria) this;
        }

        public Criteria andIndexdataLessThan(BigDecimal value) {
            addCriterion("INDEXDATA <", value, "indexdata");
            return (Criteria) this;
        }

        public Criteria andIndexdataLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INDEXDATA <=", value, "indexdata");
            return (Criteria) this;
        }

        public Criteria andIndexdataIn(List<BigDecimal> values) {
            addCriterion("INDEXDATA in", values, "indexdata");
            return (Criteria) this;
        }

        public Criteria andIndexdataNotIn(List<BigDecimal> values) {
            addCriterion("INDEXDATA not in", values, "indexdata");
            return (Criteria) this;
        }

        public Criteria andIndexdataBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INDEXDATA between", value1, value2, "indexdata");
            return (Criteria) this;
        }

        public Criteria andIndexdataNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INDEXDATA not between", value1, value2, "indexdata");
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