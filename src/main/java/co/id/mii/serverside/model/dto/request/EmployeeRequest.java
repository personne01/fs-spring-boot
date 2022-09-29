/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serverside.model.dto.request;

/**
 *
 * @author MSI-JO
 */
public class EmployeeRequest {

    private String name;
    private String email;
    private int number;
    private String username;
    private String password;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String name, String email, int number, String username, String password) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
