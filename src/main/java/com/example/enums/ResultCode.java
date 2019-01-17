package com.example.enums;

public enum ResultCode {
    OK(0),

    NOT_FOUND(404);

    private int value;

    public int getValue(){
        return value;
    }

    ResultCode(int value) {
        this.value = value;
    }
}
