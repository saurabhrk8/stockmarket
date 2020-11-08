package com.jpmc.stockmarket.utility;

import com.jpmc.stockmarket.model.Code;

public class StockException extends RuntimeException {

    protected Code errorCode;

    public StockException() {
        super();
    }

    public StockException(String message) {
        super(message);
    }

    public StockException(Code errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public StockException(Code errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public Code getErrorCode() {
        return errorCode;
    }
}
