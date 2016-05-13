package com.indusmed.request;

public class FindBatchRequest extends AbstractServiceRequest {
    private String batchNumber;

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }
    
}
