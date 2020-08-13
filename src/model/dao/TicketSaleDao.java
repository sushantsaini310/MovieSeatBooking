/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.TicketSaleTo;
import utility.ErrorHandler;

/**
 *
 * @author sushant saini
 */
public class TicketSaleDao extends Dao{
    public boolean insertRecord(TicketSaleTo record){
            try
            {
                String query="insert into ticketsale (mtid,totalseat,bookdate,showdate)";
                query+=" values(?,?,?,?)";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setInt(1,record.getMtid());
                stmt.setInt(2,record.getTotalseat());
                stmt.setDate(3,record.getBookdate());
                stmt.setDate(4,record.getShowdate());
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
           public boolean updateRecord(TicketSaleTo record){
            try
            {
                String query="update ticketsale set ";
                query+=" mtid=?,totalseat=?,bookdate=?,showdate=? where saleid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setInt(1,record.getMtid());
                stmt.setInt(2,record.getTotalseat());
                stmt.setDate(3,record.getBookdate());
                stmt.setDate(4,record.getShowdate()); 
                stmt.setInt(4,record.getSaleid());
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
            public boolean deleteRecord(String saleid){
            try
            {
                String query="delete  from ticketsale ";
                query+=" where saleid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setString(1,saleid);                             
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
 public TicketSaleTo getRecord(String saleid){
            try
            {
                String query="select saleid,mtid,totalseat,bookdate,showdate  ";
                query+=" from ticketsale";
                query+="where saleid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setString(1,saleid);
                TicketSaleTo result=null;
                ResultSet rs=stmt.executeQuery();
                if(rs.next()){
                    result=new TicketSaleTo();
                    result.setSaleid(rs.getInt("saleid"));
                    result.setMtid(rs.getInt("mtid"));
                    result.setTotalseat(rs.getInt("totalseat"));
                    result.setBookdate(rs.getDate("bookdate"));
                    result.setShowdate(rs.getDate("showdate"));
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
 public List<TicketSaleTo> getAllRecord(){
            try
            {
                String query="select saleid,mtid,totalseat,bookdate,showdate ";
                query+=" from ticketsale ";
                  
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                
                List<TicketSaleTo> result=null;
                ResultSet rs=stmt.executeQuery();
                if(rs.next())
                {
                    result=new ArrayList<>();
                    do{
                    TicketSaleTo res=new TicketSaleTo();
                     res.setSaleid(rs.getInt("saleid"));
                    res.setMtid(rs.getInt("mtid"));
                    res.setTotalseat(rs.getInt("totalseat"));
                    res.setBookdate(rs.getDate("bookdate"));
                    res.setShowdate(rs.getDate("showdate"));
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
