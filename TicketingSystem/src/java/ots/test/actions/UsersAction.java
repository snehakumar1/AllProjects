/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ots.test.actions;

import java.sql.SQLException;
import ots.test.beans.Users;
import ots.test.dao.UsersDao;

/**
 *
 * @author prasun
 */
public class UsersAction {

    private int userId;
    private String userFullName;
    private String email;
    private String password;
    private int roleId;
    private int statusId;
    private boolean validUser;
    private UsersDao usersdao = null;

    public String login() throws SQLException {
        String login = null;
        setUsersdao(new UsersDao());
        Users users = getUsersdao().validateLoginCredentials(getEmail(), getPassword());
        if (users != null) {
            userId=users.getUserId();
            userFullName=users.getUserFullName();
            email=users.getEmail();
            password=users.getPassword();
            roleId = users.getRoleId();
            statusId = users.getStatusId();
            System.out.println("role id" +roleId);
            if (roleId == 1) {
                login = "adminLogin";
            } else if (roleId == 2) {
                login = "csrLogin";
            } else if (roleId == 3) {
                login = "techLogin";
            }
        } else {
            login = "Failure";
        }
        return login;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the userFullName
     */
    public String getUserFullName() {
        return userFullName;
    }

    /**
     * @param userFullName the userFullName to set
     */
    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**


    /**
     * @return the validUser
     */
    public boolean isValidUser() {
        return validUser;
    }

    /**
     * @param validUser the validUser to set
     */
    public void setValidUser(boolean validUser) {
        this.validUser = validUser;
    }

    /**
     * @return the usersdao
     */
    public UsersDao getUsersdao() {
        return usersdao;
    }

    /**
     * @param usersdao the usersdao to set
     */
    public void setUsersdao(UsersDao usersdao) {
        this.usersdao = usersdao;
    }

    /**
     * @return the roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the statusId
     */
    public int getStatusId() {
        return statusId;
    }

    /**
     * @param statusId the statusId to set
     */
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

}
