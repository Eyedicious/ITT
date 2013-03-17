/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dataconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bart
 */
public class ConnectionManager {
    private Connection dbConnection = null;
    private String url = "jdbc:mysql://localhost:3306/mydb";
    private String user = "root";
    private String password = "admin";
    private PreparedStatement queryStatement = null;
    
    /*
     * Constructor
     * 
     */
    public ConnectionManager(){
        
    }
    
    /*
     * Opens up a database connection and returns a boolean if it was executed succesfully or not.
     * 
     * @return boolean if the connection was created succesfully or not
     */
    public boolean createConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            dbConnection = DriverManager.getConnection(url, user, password);
        } catch(Exception e){
            System.out.println("Failed to open Db connection: "+e);
            return false;
        }
        return true;
    }
    
    public ResultSet getFromTable(String SQLString){
        ResultSet getResults = null;
        try
        {
            queryStatement = dbConnection.prepareStatement(SQLString);
            getResults = queryStatement.executeQuery();
        } catch(Exception e){
            System.out.println("Failed to GET: "+e);
        }
        return getResults;
    }
    
    public ResultSet insertRawSQL(String SQLString){
        ResultSet getResults = null;
        try{
            queryStatement = dbConnection.prepareStatement(SQLString);
            getResults = queryStatement.executeQuery();
        } catch(Exception e){
            System.out.println("Exception in raw SQL");
        }
        return getResults;
    }
    
    public boolean insertIntoTable(String SQLString){
        try
        {
            queryStatement = dbConnection.prepareStatement(SQLString);
            int success = queryStatement.executeUpdate();
            if(success == 0){
                System.out.println("Failed to Insert into Table");
                return false;
            }
        } catch(Exception e){
            System.out.println("Failed to INSERT INTO: "+e);
            return false;
        }
        return true;
    }
    
    public void updateTable(String SQLString){
        try
        {
            queryStatement = dbConnection.prepareStatement(SQLString);
            int success = queryStatement.executeUpdate();
            if(success == 0){
                System.out.println("Failed to Update Table");
            }
        } catch(Exception e){
            System.out.println("Failed to Update Table: "+e);
        }
    }
    
    public void deleteFromTable(String SQLString){
        try
        {
            queryStatement = dbConnection.prepareStatement(SQLString);
            int success = queryStatement.executeUpdate();
            if(success == 0){
                System.out.println("Failed to Delete from Table");
            }
        } catch(Exception e){
            System.out.println("Failed to Delete From: "+e);
        }
    }
    
    public boolean closeConnection(){
        try {
            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (Exception ex) {
            System.out.println("Failed to close the Db connection: "+ex);
            return false;
        }
        return true;
    }
}
