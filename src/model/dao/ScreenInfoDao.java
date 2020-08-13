/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import model.to.ScreenInfoTo;
import utility.ErrorHandler;

/**
 *
 * @author sushant saini
 */
public class ScreenInfoDao extends Dao {
    
         public boolean insertRecord(ScreenInfoTo record){
            try
            {
                String query="insert into screeninfo (screenid,screenname)";
                query+=" values(?,?)";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setString(1,record.getScreenid());
                stmt.setString(2,record.getScreenname());
               
                boolean result=stmt.executeUpdate()>0;
                stmt.close();
                return result;
            }catch(SQLIntegrityConstraintViolationException ex){
              List<ScreenInfoTo> screens=getAllRecord();
              for(ScreenInfoTo s:screens){
                  if(s.getScreenid().equals(record.getScreenid())){
                      error_message="duplicate entry for screen id\n\n";break;}
              }
               for(ScreenInfoTo s:screens){
                   if(s.getScreenname().equals(record.getScreenname())){
                       error_message+="duplicate entry for screen name";break;
                   }
               }    
                
                return false;
            }
            catch(Exception ex)
            {
                error_message=ex.toString();
                ErrorHandler.showStackTrace(ex);
                return false;
            }
            
    }
           public boolean updateRecord(ScreenInfoTo record){
            try
            {
                String query="update screeninfo set ";
                query+=" screenname=? where screenid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setString(1,record.getScreenname());
                stmt.setString(2,record.getScreenid());
                              
                boolean result=stmt.executeUpdate()>0;
                stmt.close();
                return result;
            }catch(Exception ex)
            {
                error_message=ex.toString();
                ErrorHandler.showStackTrace(ex);
                return false;
            }
            
    }
            public boolean deleteRecord(String screenid){
            try
            {
                String query="delete  from screeninfo ";
                query+=" where screenid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setString(1,screenid);                             
                boolean result=stmt.executeUpdate()>0;
                stmt.close();
                return result;
            }catch(Exception ex)
            {
                error_message=ex.toString();
                ErrorHandler.showStackTrace(ex);
                return false;
            }
            
    }   
 public ScreenInfoTo getRecord(String screenid){
            try
            {
                String query="select screenname ,screenid ";
                query+=" from screeninfo";
                query+=" where screenid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setString(1,screenid);
                ScreenInfoTo result=null;
                ResultSet rs=stmt.executeQuery();
                if(rs.next()){
                    result=new ScreenInfoTo();
                    result.setScreenid(rs.getString("screenid"));
                    result.setScreenname(rs.getString("screenname"));
                }
                stmt.close();
                return result;
            }catch(Exception ex)
            {
                error_message=ex.toString();
                ErrorHandler.showStackTrace(ex);
                return null;
            }
            
    }public ScreenInfoTo getScreenId(String screenname){
            try
            {
                String query="select screenid,screenname  ";
                query+=" from screeninfo";
                query+="where screenname=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setString(1,screenname);
                ScreenInfoTo result=null;
                ResultSet rs=stmt.executeQuery();
                if(rs.next()){
                    result=new ScreenInfoTo();
                    result.setScreenid(rs.getString("screenid"));
                    result.setScreenname(rs.getString("screenname"));
                }
                stmt.close();
                return result;
            }catch(Exception ex)
            {
                error_message=ex.toString();
                ErrorHandler.showStackTrace(ex);
                return null;
            }
            
    }
 public List<ScreenInfoTo> getAllRecord(){
            try
            {
                String query="select screenid,screenname   ";
                query+=" from screeninfo";
                  
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                
                List<ScreenInfoTo> result=null;
                ResultSet rs=stmt.executeQuery();
                if(rs.next())
                {
                    result=new ArrayList<>();
                    do{
                    ScreenInfoTo res=new ScreenInfoTo();
                    
                     res.setScreenid(rs.getString("screenid"));
                    res.setScreenname(rs.getString("screenname"));
                    result.add(res);
                }while(rs.next());
                }
                stmt.close();
                return result;
            }catch(Exception ex)
            {
                error_message=ex.toString();
                ErrorHandler.showStackTrace(ex);
                return null;
            }
            
    }      

}
