package com.indusmed.response;

import java.util.List;

import com.indusmed.base.DashboardClaim;

public class SearchClaimResponse extends AbstractServiceResponse {
    private List<DashboardClaim> claims;

    public List<DashboardClaim> getClaims() {
        return claims;
    }

    public void setClaims(List<DashboardClaim> claims) {
        this.claims = claims;
    }
}
