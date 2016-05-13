package com.indusmed.response;

import com.indusmed.base.DashboardBatch;

public class FindBatchResponse extends AbstractServiceResponse {
    private DashboardBatch batch;

    public DashboardBatch getBatch() {
        return batch;
    }

    public void setBatch(DashboardBatch batch) {
        this.batch = batch;
    }
    
}
