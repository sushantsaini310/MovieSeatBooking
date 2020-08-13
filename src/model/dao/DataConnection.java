/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utility.Configuration;

/**
 *
 * @author sushant saini
 */
public class DataConnection {
    private static Connection con;
    public static Connection getConnection() throws Exception
    {
        if(con==null)
        {
            Class.forName(Configuration.DRIVER_NAME);
            con=DriverManager.getConnection(Configuration.CONNECTION_URL,Configuration.USER_NAME,Configuration.PASSWORD);
            
             }
        return con;
    }
    public static void closeConnection() throws Exception
    {
        if(con!=null)
        {
            con.close();
        }
        con=null;
    }
    private DataConnection()
    {}
    public static PreparedStatement prepareStatement(String query) throws Exception
    {
          return getConnection().prepareStatement(query);
    }
}
