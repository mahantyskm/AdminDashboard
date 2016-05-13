package com.indusmed.response;

import com.indusmed.base.DashboardUser;

/**
 * @author sandeep.kumar08
 *
 */
public class GetUserResponse extends AbstractServiceResponse {
    
    private DashboardUser user;

    public DashboardUser getUser() {
        return user;
    }

    public void setUser(DashboardUser user) {
        this.user = user;
    }
    

}
