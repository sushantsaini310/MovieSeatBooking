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
import model.to.MovieInfoTo;
import utility.ErrorHandler;

/**
 *
 * @author sushant saini
 */
public class MovieInfoDao extends Dao {
    public boolean insertRecord(MovieInfoTo record){
            try
            {
                String query="insert into movieinfo (moviename,genre,description,duration,startdate,enddate,moviephoto)";
                query+=" values(?,?,?,?,?,?,?)";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setString(1,record.getMoviename());
                stmt.setString(2,record.getGenre());
                stmt.setString(3,record.getDescription());
                stmt.setTime(4,record.getDuration());
                stmt.setDate(5,record.getStartdate());
                stmt.setDate(6,record.getEnddate());
                stmt.setBlob(7,record.getMoviephoto());
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
     public boolean updateRecord(MovieInfoTo record){
            try
            {
                String query="update movieinfo ";
                query+=" set moviename=?,genre=?,description=?,duration=?,startdate=?,enddate=?";
                query+=" where movieid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setString(1,record.getMoviename());
                stmt.setString(2,record.getGenre());
                stmt.setString(3,record.getDescription());
                stmt.setTime(4,record.getDuration());
                stmt.setDate(5,record.getStartdate());
                stmt.setDate(6,record.getEnddate());
                stmt.setInt(7,record.getMoiveid());
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
        public    boolean deleteRecord(int movieid){
            try
            {
                String query="delete from movieinfo ";
                
                query+="where movieid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
              
                stmt.setInt(1,movieid);
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
           public MovieInfoTo getRecord(int movieid){
            try
            {
                String query="select movieid,moviename,genre,description,duration,startdate,enddate,moviephoto ";
                query+=" from movieinfo ";
                query+="where movieid=?";
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                stmt.setInt(1,movieid);
                MovieInfoTo result=null;
                ResultSet rs=stmt.executeQuery();
                if(rs.next())
                {
                    result=new MovieInfoTo();
                    result.setMoiveid(rs.getInt("movieid"));
                    result.setMoviename(rs.getString("moviename"));
                    result.setGenre(rs.getString("genre"));
                    result.setDescription(rs.getString("description"));
                    result.setDuration(rs.getTime("duration"));
                    result.setStartdate(rs.getDate("startdate"));
                    result.setEnddate(rs.getDate("enddate"));
                    result.setMoviephoto(rs.getBinaryStream("moviephoto"));
                    
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
      public List<MovieInfoTo> getAllRecord(){
            try
            {
                String query="select movieid,moviename,genre,description,duration,startdate,enddate,moviephoto ";
                query+=" from movieinfo ";
                  
                PreparedStatement stmt=DataConnection.prepareStatement(query);
                
                List<MovieInfoTo> result=null;
                ResultSet rs=stmt.executeQuery();
                if(rs.next())
                {
                    result=new ArrayList<>();
                    do{
                    MovieInfoTo res=new MovieInfoTo();
                    
                    res.setMoiveid(rs.getInt("movieid"));
                    res.setMoviename(rs.getString("moviename"));
                    res.setGenre(rs.getString("genre"));
                    res.setDescription(rs.getString("description"));
                    res.setDuration(rs.getTime("duration"));
                    res.setStartdate(rs.getDate("startdate"));
                    res.setEnddate(rs.getDate("enddate"));
                    res.setMoviephoto(rs.getBinaryStream("moviephoto"));
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


