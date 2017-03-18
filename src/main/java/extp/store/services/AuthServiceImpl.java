/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import extp.store.dto.UserDto;

/**
 *
 * @author Ollaberganov-PC
 */


@Service("authService")
public class AuthServiceImpl implements AuthService{
    
    @Autowired
    public DataSource dataSource;
   
    @Override
    public UserDto CheckLoginPassword(String login,String password) { 
        UserDto obj=new UserDto();
        Connection conn = null;
        PreparedStatement st = null;                  
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement("select * from users where login=? and password=?");
            st.setString( 1, login); 
            st.setString( 2, password); 
            ResultSet results = st.executeQuery();
            ResultSetMetaData rmd = results.getMetaData();
            while (results.next()) {
                obj.setFio(results.getString("fio"));
                obj.setLogin(results.getString("login"));                
            }
            results.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return obj;
                
    }
    
    @Override
    public boolean CheckLogin(String login) { 
        int res=1;
        Connection conn = null;
        PreparedStatement st = null;          
        String name="";
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement("select count(login) as cnt from users where login=?");
            st.setString( 1, login); 
            ResultSet results = st.executeQuery();
            ResultSetMetaData rmd = results.getMetaData();
            while (results.next()) {
                res = results.getInt("cnt");
            }
            results.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(res==0){
            return true;
        }else{
            return false;
        }        
    }
    
    
    @Override
    public boolean SetUser(String fio, String login, String password) { 
        boolean res=false;
        Connection conn = null;
        PreparedStatement st = null;          
        String name="";
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(true);
            st = conn.prepareStatement("insert into users (fio, login, password) values (?,?,?)");
            st.setString( 1, fio); 
            st.setString( 2, login); 
            st.setString( 3, password); 
            st.executeUpdate(); 
            st.close();            
            conn.close();
            res=true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
}
