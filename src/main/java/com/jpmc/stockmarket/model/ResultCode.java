package com.jpmc.stockmarket.model;


public enum ResultCode implements Code {

    SUCCESS                                         (2000000, "SUCCESS"),
    STOCK_INVALID_PARAM                              (4000102, "STOCK_INVALID_PARAM"),
    STOCK_NOT_FOUND                                  (4040100, "STOCK_NOT_FOUND"),
    BAD_REQUEST                                     (4000000, "BAD_REQUEST");

    private int code;
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

}
