/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.services;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ollaberganov-PC
 */
@Service("databaseService")
public class DatabaseServiceImpl implements DatabaseService {
    
    
    @Autowired
    public DataSource dataSource;
   
    @Override
    public String SetTestData() { 
        String res="";
        Connection conn = null;
        PreparedStatement st = null;          
        String name="";
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            st = conn.prepareStatement("select login as name from users");
            ResultSet results = st.executeQuery();
            ResultSetMetaData rmd = results.getMetaData();
            while (results.next()) {
                name = results.getString("name");
            }
            results.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }
    
     @Override
    public String SetProduct(String name, int count) { 
        String res="OK";
        Connection conn = null;
        PreparedStatement st = null;                  
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(true);
            st = conn.prepareStatement("insert into products (name, count) values (?,?)");
            st.setString( 1, name); 
            st.setInt( 2, count);             
            st.executeUpdate(); 
            st.close();            
            conn.close();            
        } catch (Exception e) {
            res=e.getMessage();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
}
