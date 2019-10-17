package com.blankhouse.project.potgold.model;

import java.util.Date;

public class TGoldTask {
    /**
     *
     */
    private Long id;

    /**
     * 任务进行到的步骤
     */
    private Integer step;

    /**
     * 步骤描述
     */
    private String stepDesc;

    /**
     * 任务原始文件夹
     */
    private String fileOrigin;

    /**
     * 任务输出文件夹
     */
    private String fileOutput;

    /**
     * 任务执行节点记录
     */
    private String fileRecord;

    /**
     * 异常停止信息
     */
    private String exception;

    /**
     * 当前转化到的页数
     */
    private Long converted;

    /**
     * 当前识别到的页数
     */
    private Long current;

    /**
     * 总页数
     */
    private Long total;

    /**
     * 删除状态 0:未删除 1:已删除
     */
    private Byte deleted;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Long updateBy;

    /**
     * 警告信息
     */
    private String warning;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 任务进行到的步骤
     *
     * @return step 任务进行到的步骤
     */
    public Integer getStep() {
        return step;
    }

    /**
     * 任务进行到的步骤
     *
     * @param step 任务进行到的步骤
     */
    public void setStep(Integer step) {
        this.step = step;
    }

    /**
     * 步骤描述
     *
     * @return step_desc 步骤描述
     */
    public String getStepDesc() {
        return stepDesc;
    }

    /**
     * 步骤描述
     *
     * @param stepDesc 步骤描述
     */
    public void setStepDesc(String stepDesc) {
        this.stepDesc = stepDesc == null ? null : stepDesc.trim();
    }

    /**
     * 任务原始文件夹
     *
     * @return file_origin 任务原始文件夹
     */
    public String getFileOrigin() {
        return fileOrigin;
    }

    /**
     * 任务原始文件夹
     *
     * @param fileOrigin 任务原始文件夹
     */
    public void setFileOrigin(String fileOrigin) {
        this.fileOrigin = fileOrigin == null ? null : fileOrigin.trim();
    }

    /**
     * 任务输出文件夹
     *
     * @return file_output 任务输出文件夹
     */
    public String getFileOutput() {
        return fileOutput;
    }

    /**
     * 任务输出文件夹
     *
     * @param fileOutput 任务输出文件夹
     */
    public void setFileOutput(String fileOutput) {
        this.fileOutput = fileOutput == null ? null : fileOutput.trim();
    }

    /**
     * 任务执行节点记录
     *
     * @return file_record 任务执行节点记录
     */
    public String getFileRecord() {
        return fileRecord;
    }

    /**
     * 任务执行节点记录
     *
     * @param fileRecord 任务执行节点记录
     */
    public void setFileRecord(String fileRecord) {
        this.fileRecord = fileRecord == null ? null : fileRecord.trim();
    }

    /**
     * 异常停止信息
     *
     * @return exception 异常停止信息
     */
    public String getException() {
        return exception;
    }

    /**
     * 异常停止信息
     *
     * @param exception 异常停止信息
     */
    public void setException(String exception) {
        this.exception = exception == null ? null : exception.trim();
    }

    /**
     * 当前转化到的页数
     *
     * @return converted 当前转化到的页数
     */
    public Long getConverted() {
        return converted;
    }

    /**
     * 当前转化到的页数
     *
     * @param converted 当前转化到的页数
     */
    public void setConverted(Long converted) {
        this.converted = converted;
    }

    /**
     * 当前识别到的页数
     *
     * @return current 当前识别到的页数
     */
    public Long getCurrent() {
        return current;
    }

    /**
     * 当前识别到的页数
     *
     * @param current 当前识别到的页数
     */
    public void setCurrent(Long current) {
        this.current = current;
    }

    /**
     * 总页数
     *
     * @return total 总页数
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 总页数
     *
     * @param total 总页数
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 删除状态 0:未删除 1:已删除
     *
     * @return deleted 删除状态 0:未删除 1:已删除
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * 删除状态 0:未删除 1:已删除
     *
     * @param deleted 删除状态 0:未删除 1:已删除
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    /**
     * 创建时间
     *
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人
     *
     * @return create_by 创建人
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 修改时间
     *
     * @return update_time 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 修改人
     *
     * @return update_by 修改人
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 修改人
     *
     * @param updateBy 修改人
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 警告信息
     *
     * @return warning 警告信息
     */
    public String getWarning() {
        return warning;
    }

    /**
     * 警告信息
     *
     * @param warning 警告信息
     */
    public void setWarning(String warning) {
        this.warning = warning == null ? null : warning.trim();
    }


    @Override
    public String toString() {
        return "TGoldTask{" +
                "id=" + id +
                (step == null ? "" : (", step=" + step)) +
                (stepDesc == null ? "" : (", stepDesc='" + stepDesc + '\'' ))+
                (fileOrigin == null ? "" : ( ", fileOrigin='" + fileOrigin + '\'' ))+
                (fileOutput == null ? "" : ( ", fileOutput='" + fileOutput + '\'' ))+
                (fileRecord == null ? "" : ( ", fileRecord='" + fileRecord + '\'' ))+
                (exception == null ? "" : (", exception='" + exception + '\'' ))+
                (converted == null ? "" : ( ", converted=" + converted ))+
                (current == null ? "" : ( ", current=" + current ))+
                (total == null ? "" : (  ", total=" + total)) +
                        (deleted == null ? "" : (  ", deleted=" + deleted ))+
                        (createTime == null ? "" : ( ", createTime=" + createTime ))+
                        (createBy == null ? "" : ( ", createBy=" + createBy ))+
                        (updateTime == null ? "" : ( ", updateTime=" + updateTime ))+
                        (updateBy == null ? "" : ( ", updateBy=" + updateBy ))+
                        (warning == null ? "" : ( ", warning='" + warning + '\'' ))+
                '}';
    }
}