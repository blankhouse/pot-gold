package com.blankhouse.project.potgold.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TGoldTaskExample {
    /**
     * t_gold_task
     */
    protected String orderByClause;

    /**
     * t_gold_task
     */
    protected boolean distinct;

    /**
     * t_gold_task
     */
    protected List<Criteria> oredCriteria;

    public TGoldTaskExample() {
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

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Integer value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Integer value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Integer value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Integer value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Integer value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Integer> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Integer> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Integer value1, Integer value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Integer value1, Integer value2) {
            addCriterion("step not between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepDescIsNull() {
            addCriterion("step_desc is null");
            return (Criteria) this;
        }

        public Criteria andStepDescIsNotNull() {
            addCriterion("step_desc is not null");
            return (Criteria) this;
        }

        public Criteria andStepDescEqualTo(String value) {
            addCriterion("step_desc =", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotEqualTo(String value) {
            addCriterion("step_desc <>", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescGreaterThan(String value) {
            addCriterion("step_desc >", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescGreaterThanOrEqualTo(String value) {
            addCriterion("step_desc >=", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescLessThan(String value) {
            addCriterion("step_desc <", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescLessThanOrEqualTo(String value) {
            addCriterion("step_desc <=", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescLike(String value) {
            addCriterion("step_desc like", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotLike(String value) {
            addCriterion("step_desc not like", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescIn(List<String> values) {
            addCriterion("step_desc in", values, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotIn(List<String> values) {
            addCriterion("step_desc not in", values, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescBetween(String value1, String value2) {
            addCriterion("step_desc between", value1, value2, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotBetween(String value1, String value2) {
            addCriterion("step_desc not between", value1, value2, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andFileOriginIsNull() {
            addCriterion("file_origin is null");
            return (Criteria) this;
        }

        public Criteria andFileOriginIsNotNull() {
            addCriterion("file_origin is not null");
            return (Criteria) this;
        }

        public Criteria andFileOriginEqualTo(String value) {
            addCriterion("file_origin =", value, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOriginNotEqualTo(String value) {
            addCriterion("file_origin <>", value, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOriginGreaterThan(String value) {
            addCriterion("file_origin >", value, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOriginGreaterThanOrEqualTo(String value) {
            addCriterion("file_origin >=", value, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOriginLessThan(String value) {
            addCriterion("file_origin <", value, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOriginLessThanOrEqualTo(String value) {
            addCriterion("file_origin <=", value, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOriginLike(String value) {
            addCriterion("file_origin like", value, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOriginNotLike(String value) {
            addCriterion("file_origin not like", value, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOriginIn(List<String> values) {
            addCriterion("file_origin in", values, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOriginNotIn(List<String> values) {
            addCriterion("file_origin not in", values, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOriginBetween(String value1, String value2) {
            addCriterion("file_origin between", value1, value2, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOriginNotBetween(String value1, String value2) {
            addCriterion("file_origin not between", value1, value2, "fileOrigin");
            return (Criteria) this;
        }

        public Criteria andFileOutputIsNull() {
            addCriterion("file_output is null");
            return (Criteria) this;
        }

        public Criteria andFileOutputIsNotNull() {
            addCriterion("file_output is not null");
            return (Criteria) this;
        }

        public Criteria andFileOutputEqualTo(String value) {
            addCriterion("file_output =", value, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileOutputNotEqualTo(String value) {
            addCriterion("file_output <>", value, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileOutputGreaterThan(String value) {
            addCriterion("file_output >", value, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileOutputGreaterThanOrEqualTo(String value) {
            addCriterion("file_output >=", value, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileOutputLessThan(String value) {
            addCriterion("file_output <", value, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileOutputLessThanOrEqualTo(String value) {
            addCriterion("file_output <=", value, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileOutputLike(String value) {
            addCriterion("file_output like", value, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileOutputNotLike(String value) {
            addCriterion("file_output not like", value, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileOutputIn(List<String> values) {
            addCriterion("file_output in", values, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileOutputNotIn(List<String> values) {
            addCriterion("file_output not in", values, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileOutputBetween(String value1, String value2) {
            addCriterion("file_output between", value1, value2, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileOutputNotBetween(String value1, String value2) {
            addCriterion("file_output not between", value1, value2, "fileOutput");
            return (Criteria) this;
        }

        public Criteria andFileRecordIsNull() {
            addCriterion("file_record is null");
            return (Criteria) this;
        }

        public Criteria andFileRecordIsNotNull() {
            addCriterion("file_record is not null");
            return (Criteria) this;
        }

        public Criteria andFileRecordEqualTo(String value) {
            addCriterion("file_record =", value, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andFileRecordNotEqualTo(String value) {
            addCriterion("file_record <>", value, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andFileRecordGreaterThan(String value) {
            addCriterion("file_record >", value, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andFileRecordGreaterThanOrEqualTo(String value) {
            addCriterion("file_record >=", value, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andFileRecordLessThan(String value) {
            addCriterion("file_record <", value, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andFileRecordLessThanOrEqualTo(String value) {
            addCriterion("file_record <=", value, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andFileRecordLike(String value) {
            addCriterion("file_record like", value, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andFileRecordNotLike(String value) {
            addCriterion("file_record not like", value, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andFileRecordIn(List<String> values) {
            addCriterion("file_record in", values, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andFileRecordNotIn(List<String> values) {
            addCriterion("file_record not in", values, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andFileRecordBetween(String value1, String value2) {
            addCriterion("file_record between", value1, value2, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andFileRecordNotBetween(String value1, String value2) {
            addCriterion("file_record not between", value1, value2, "fileRecord");
            return (Criteria) this;
        }

        public Criteria andExceptionIsNull() {
            addCriterion("exception is null");
            return (Criteria) this;
        }

        public Criteria andExceptionIsNotNull() {
            addCriterion("exception is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionEqualTo(String value) {
            addCriterion("exception =", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionNotEqualTo(String value) {
            addCriterion("exception <>", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionGreaterThan(String value) {
            addCriterion("exception >", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionGreaterThanOrEqualTo(String value) {
            addCriterion("exception >=", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionLessThan(String value) {
            addCriterion("exception <", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionLessThanOrEqualTo(String value) {
            addCriterion("exception <=", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionLike(String value) {
            addCriterion("exception like", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionNotLike(String value) {
            addCriterion("exception not like", value, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionIn(List<String> values) {
            addCriterion("exception in", values, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionNotIn(List<String> values) {
            addCriterion("exception not in", values, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionBetween(String value1, String value2) {
            addCriterion("exception between", value1, value2, "exception");
            return (Criteria) this;
        }

        public Criteria andExceptionNotBetween(String value1, String value2) {
            addCriterion("exception not between", value1, value2, "exception");
            return (Criteria) this;
        }

        public Criteria andConvertedIsNull() {
            addCriterion("converted is null");
            return (Criteria) this;
        }

        public Criteria andConvertedIsNotNull() {
            addCriterion("converted is not null");
            return (Criteria) this;
        }

        public Criteria andConvertedEqualTo(Long value) {
            addCriterion("converted =", value, "converted");
            return (Criteria) this;
        }

        public Criteria andConvertedNotEqualTo(Long value) {
            addCriterion("converted <>", value, "converted");
            return (Criteria) this;
        }

        public Criteria andConvertedGreaterThan(Long value) {
            addCriterion("converted >", value, "converted");
            return (Criteria) this;
        }

        public Criteria andConvertedGreaterThanOrEqualTo(Long value) {
            addCriterion("converted >=", value, "converted");
            return (Criteria) this;
        }

        public Criteria andConvertedLessThan(Long value) {
            addCriterion("converted <", value, "converted");
            return (Criteria) this;
        }

        public Criteria andConvertedLessThanOrEqualTo(Long value) {
            addCriterion("converted <=", value, "converted");
            return (Criteria) this;
        }

        public Criteria andConvertedIn(List<Long> values) {
            addCriterion("converted in", values, "converted");
            return (Criteria) this;
        }

        public Criteria andConvertedNotIn(List<Long> values) {
            addCriterion("converted not in", values, "converted");
            return (Criteria) this;
        }

        public Criteria andConvertedBetween(Long value1, Long value2) {
            addCriterion("converted between", value1, value2, "converted");
            return (Criteria) this;
        }

        public Criteria andConvertedNotBetween(Long value1, Long value2) {
            addCriterion("converted not between", value1, value2, "converted");
            return (Criteria) this;
        }

        public Criteria andCurrentIsNull() {
            addCriterion("current is null");
            return (Criteria) this;
        }

        public Criteria andCurrentIsNotNull() {
            addCriterion("current is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentEqualTo(Long value) {
            addCriterion("current =", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotEqualTo(Long value) {
            addCriterion("current <>", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentGreaterThan(Long value) {
            addCriterion("current >", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentGreaterThanOrEqualTo(Long value) {
            addCriterion("current >=", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentLessThan(Long value) {
            addCriterion("current <", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentLessThanOrEqualTo(Long value) {
            addCriterion("current <=", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentIn(List<Long> values) {
            addCriterion("current in", values, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotIn(List<Long> values) {
            addCriterion("current not in", values, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentBetween(Long value1, Long value2) {
            addCriterion("current between", value1, value2, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotBetween(Long value1, Long value2) {
            addCriterion("current not between", value1, value2, "current");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(Long value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(Long value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(Long value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(Long value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(Long value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<Long> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<Long> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(Long value1, Long value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(Long value1, Long value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Byte value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Byte value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Byte value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Byte value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Byte> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Byte> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Byte value1, Byte value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
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

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
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

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Long value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Long> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Long> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Long value1, Long value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Long value1, Long value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }
    }

    /**
     * t_gold_task
     */
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