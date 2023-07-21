package com.uas027.uas_prg7_20222_027;

public class Result {
    private Integer status;
    private String result;

    public Result(Integer status, String result) {
        this.status = status;
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
