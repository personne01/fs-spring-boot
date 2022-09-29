/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serverside.model.dto.request;

import java.util.List;

/**
 *
 * @author MSI-JO
 */
public class AddRoleUserRequest {

    private Long userId;
    private List<String> roles;

    public AddRoleUserRequest(Long userId, List<String> roles) {
        this.userId = userId;
        this.roles = roles;
    }

    public AddRoleUserRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
