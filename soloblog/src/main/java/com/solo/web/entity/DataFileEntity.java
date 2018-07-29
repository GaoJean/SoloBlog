package com.solo.web.entity;

import java.util.Date;

/**
 * 异步生成文件对象
 *                       
 * @Filename: DataFileEntity.java
 * @Version: 1.0
 * @Author: WL
 * @Email: weizhenglu@danlu.com
 * @date:2016年1月29日 下午4:22:35
 *
 */
public class DataFileEntity {
    /**文件已清除*/
    public static final Integer FILE_STATE_ISDELETE   = 2;
    /**正在生成文件*/
    public static final Integer FILE_STATE_UNCOMPLETE = 1;
    /**生成文件异常*/
    public static final Integer FILE_STATE_EXCEPTION  = -1;
    /**生成文件成功*/
    public static final Integer FILE_STATE_COMPLETE   = 0;
    /**取消下载标志*/
    public static final Integer CANCEL_DOWN           = 1;

    private String              id;
    private String              userId;
    private String              userName;

    private String              fileName;

    private String              url;

    private Integer             status;

    private Integer             downCount;

    private String              exception;

    private Date                completeDate;

    private Date                createTimestamp;

    private Date                updateTimestamp;
    private Integer             isCancel              = 0;

    /**
     * @return Returns the isCancel
     */
    public Integer getIsCancel() {
        return isCancel;
    }

    /**
     * @param isCancel
     * The isCancel to set.
     */
    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    /**
     * @param userId
     * The userId to set.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return Returns the userId
     */
    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception == null ? null : exception.trim();
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    /**
     * @return
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "DataFileEntity [id=" + id + ", userId=" + userId + ", userName=" + userName
               + ", fileName=" + fileName + ", url=" + url + ", status=" + status + ", downCount="
               + downCount + ", exception=" + exception + ", completeDate=" + completeDate
               + ", createTimestamp=" + createTimestamp + ", updateTimestamp=" + updateTimestamp
               + "]";
    }

}