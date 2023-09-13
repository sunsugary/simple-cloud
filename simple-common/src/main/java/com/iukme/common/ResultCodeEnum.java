package com.iukme.common;

public enum ResultCodeEnum {
    /**
     * 成功状态码
     */
    SUCCESS(1, "请求成功"),

    /**
     * 失败状态码
     */
    FAIL(0, "失败"),
    PARAMS_IS_INVALID(999001030, "参数无效");


    private int code;
    private String msg;

    ResultCodeEnum() {
    }

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    @Override
    public String toString() {
        return "ResultCodeEnum [code=" + code + ", msg=" + msg + "]";
    }

}
