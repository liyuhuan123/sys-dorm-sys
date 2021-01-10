package model;

//响应
public class Response {
    private boolean success;
    private String code;
    private String message;
    private Integer total;
    private Object data;
    //异常堆栈信息
    private String stackTrace;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getTotal() {
        return total;
    }

    public Object getData() {
        return data;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", total=" + total +
                ", data=" + data +
                ", stackTrace='" + stackTrace + '\'' +
                '}';
    }

}
