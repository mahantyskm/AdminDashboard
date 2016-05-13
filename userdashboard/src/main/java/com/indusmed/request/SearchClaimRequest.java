package com.indusmed.request;

public class SearchClaimRequest extends AbstractServiceRequest {
    private String searchItem;

    public String getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

}
