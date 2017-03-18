/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.dto;

/**
 *
 * @author Ollaberganov-PC
 */
public class SecurityDto {
    
    private String fio;
    private String role;
    private String dep_name;
    private int dep_code;
    private String position_name;
    private int position_code;
    private String ns10_name;
    private int ns10_code;
    private String ns11_name;
    private int ns11_code;
    
    private boolean isactive;
    private int user_type;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public int getDep_code() {
        return dep_code;
    }

    public void setDep_code(int dep_code) {
        this.dep_code = dep_code;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public int getPosition_code() {
        return position_code;
    }

    public void setPosition_code(int position_code) {
        this.position_code = position_code;
    }

    public String getNs10_name() {
        return ns10_name;
    }

    public void setNs10_name(String ns10_name) {
        this.ns10_name = ns10_name;
    }

    public int getNs10_code() {
        return ns10_code;
    }

    public void setNs10_code(int ns10_code) {
        this.ns10_code = ns10_code;
    }

    public String getNs11_name() {
        return ns11_name;
    }

    public void setNs11_name(String ns11_name) {
        this.ns11_name = ns11_name;
    }

    public int getNs11_code() {
        return ns11_code;
    }

    public void setNs11_code(int ns11_code) {
        this.ns11_code = ns11_code;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }
    
}
