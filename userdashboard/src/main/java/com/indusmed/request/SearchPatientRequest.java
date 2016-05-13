package com.indusmed.request;

public class SearchPatientRequest extends AbstractServiceRequest {
    private String searchItem;

    public String getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

}
