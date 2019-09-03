package com.tourye.library.beans;
/**
 *
 * @ClassName:   CommonBean
 *
 * @Author:   along
 *
 * @Description:    通用实体
 *
 * @CreateDate:   2019/9/2 2:33 PM
 *
 */
public class CommonBean {

    private int status;
    private int timestamp;
    private Object data;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommonBean{" +
                "status=" + status +
                ", timestamp=" + timestamp +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
