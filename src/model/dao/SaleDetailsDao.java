/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.to.SaleDetailsTo;
import utility.ErrorHandler;

/**
 *
 * @author sushant saini
 */
public class SaleDetailsDao extends Dao{
    public boolean insertRecord(SaleDetailsTo record){
            try
            {
                String query="insert into saledetails (saleid,seatno,typeid,price)";
                query+=" values(?,?,?,?)";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setInt(1,record.getSaleid());
                stmt.setString(2,record.getSeatno());
                stmt.setInt(3,record.getTypeid());
                stmt.setFloat(4,record.getPrice());
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
           public boolean updateRecord(SaleDetailsTo record){
            try
            {
                String query="update saledetails set ";
                query+=" saleid=?,seatno=?,typeid=?,price=? where sdid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setInt(1,record.getSaleid());
                stmt.setString(2,record.getSeatno());
                stmt.setInt(3,record.getTypeid());
                stmt.setFloat(4,record.getPrice()); 
                stmt.setInt(4,record.getSdid());
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
            public boolean deleteRecord(String sdid){
            try
            {
                String query="delete  from ticketsale ";
                query+=" where sdid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setString(1,sdid);                             
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
 public SaleDetailsTo getRecord(String sdid){
            try
            {
                String query="select sdid,saleid,seatno,typeid,price ";
                query+=" from saledetails";
                query+="where sdid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setString(1,sdid);
                SaleDetailsTo result=null;
                ResultSet rs=stmt.executeQuery();
                if(rs.next()){
                    result=new SaleDetailsTo();
                    result.setSdid(rs.getInt("sdid"));
                    result.setSaleid(rs.getInt("saleid"));
                    result.setSeatno(rs.getString("seatno"));
                    result.setTypeid(rs.getInt("typeid"));
                    result.setPrice(rs.getFloat("price"));
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
 public List<SaleDetailsTo> getAllRecord(){
            try
            {
                String query="select sdid,saleid,seatno,typeid,price ";
                query+=" from saledetails ";
                  
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                
                List<SaleDetailsTo> result=null;
                ResultSet rs=stmt.executeQuery();
                if(rs.next())
                {
                    result=new ArrayList<>();
                    do{
                    SaleDetailsTo res=new SaleDetailsTo();
                     res.setSdid(rs.getInt("sdid"));
                    res.setSaleid(rs.getInt("saleid"));
                    res.setSeatno(rs.getString("seatno"));
                    res.setTypeid(rs.getInt("typeid"));
                    res.setPrice(rs.getFloat("price"));
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
  public List<SaleDetailsTo> getAllRecord(int saleid){
            try
            {
                String query="select sdid,seatno,typeid,price ";
                query+=" from saledetails where saleid=?";
                  
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setInt(1,saleid);
                List<SaleDetailsTo> result=null;
                ResultSet rs=stmt.executeQuery();
                if(rs.next())
                {
                    result=new ArrayList<>();
                    do{
                    SaleDetailsTo res=new SaleDetailsTo();
                     res.setSdid(rs.getInt("sdid"));
                   
                    res.setSeatno(rs.getString("seatno"));
                    res.setTypeid(rs.getInt("typeid"));
                    res.setPrice(rs.getFloat("price"));
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
 
public List<SaleDetailsTo> getBooked(Date showdate,int mtid,int typeid){
            try
            {
                String query="select s.seatno from saledetails s join ticketsale "+
" t on s.saleid=t.saleid join movietiming m "+
" on t.mtid=m.mtid join tickettype tt on s.typeid=tt.typeid"+
" where t.showdate=? and m.mtid=? and tt.typeid=? ";
                  
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setDate(1,showdate);
                stmt.setInt(2,mtid);
                stmt.setInt(3,typeid);
                List<SaleDetailsTo> result=null;
                ResultSet rs=stmt.executeQuery();
                if(rs.next())
                {
                    result=new ArrayList<>();
                    do{
                    SaleDetailsTo res=new SaleDetailsTo();
                     
                    res.setSeatno(rs.getString("seatno"));
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
