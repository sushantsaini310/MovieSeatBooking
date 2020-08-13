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
import model.to.MovieTimingTo;
import utility.ErrorHandler;

/**
 *
 * @author sushant saini
 */
public class MovieTimingDao extends Dao {

    public boolean insertRecord(MovieTimingTo record) {
        try {
            String query = "insert into movietiming (movieid,screenid,starttime,endtime,isactive) ";
            query += " values(?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setInt(1, record.getMovieid());
            stmt.setString(2, record.getScreenid());
            stmt.setTime(3, record.getStarttime());
            stmt.setTime(4, record.getEndtime());
            stmt.setString(5, record.getIsactive());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }

    }

    public boolean updateRecord(MovieTimingTo record) {
        try {
            String query = "update movietiming ";
            query += " set movieid=?,screenid=?,starttime=?,endtime=?,isactive=? ";
            query += "where mtid=?";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setInt(1, record.getMovieid());
            stmt.setString(2, record.getScreenid());
            stmt.setTime(3, record.getStarttime());
            stmt.setTime(4, record.getEndtime());
            stmt.setString(5, record.getIsactive());
            stmt.setInt(6, record.getMtid());

            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int mtid) {
        try {
            String query = "delete from movietiming ";

            query += "where mtid=?";
            PreparedStatement stmt = DataConnection.prepareStatement(query);

            stmt.setInt(1, mtid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }

    }

    public MovieTimingTo getRecord(int mtid) {
        try {
            String query = "select mtid,movieid,screenid,starttime,endtime,isactive ";
            query += " from movietiming ";
            query += "where mtid=?";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setInt(1, mtid);
            MovieTimingTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new MovieTimingTo();
                result.setMtid(rs.getInt("mtid"));
                result.setMovieid(rs.getInt("movieid"));
                result.setScreenid(rs.getString("screenid"));
                result.setStarttime(rs.getTime("starttime"));
                result.setEndtime(rs.getTime("endtime"));
                result.setIsactive(rs.getString("isactive"));

            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }

    }
       public MovieTimingTo getmtid(String screenname,String moviename) {
        try {
            String query = "select mtid,movieid,screenid from movietiming "+
" where screenid in(select screenid from screeninfo" +
" where screenname=? and movieid in "+
" (select movieid from movieinfo where "+
" moviename=?))";
            
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setString(1, screenname);
            stmt.setString(2, moviename);
            MovieTimingTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new MovieTimingTo();
                result.setMtid(rs.getInt("mtid"));
                result.setMovieid(rs.getInt("movieid"));
                result.setScreenid(rs.getString("screenid"));
              

            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }

    }

    public List<MovieTimingTo> getAllRecord() {
        try {
            String query = "select s.mtid,s.movieid,s.screenid,s.starttime,s.endtime,s.isactive ,i.screenname,j.moviename from movietiming s\n"
                    + "inner join screeninfo i on (s.screenid=i.screenid)\n"
                    + "      inner join movieinfo j on (s.movieid=j.movieid)";

            PreparedStatement stmt = DataConnection.prepareStatement(query);

            List<MovieTimingTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    MovieTimingTo res = new MovieTimingTo();

                    res.setMtid(rs.getInt("mtid"));
                    res.setMovieid(rs.getInt("movieid"));
                    res.setScreenid(rs.getString("screenid"));
                    res.setStarttime(rs.getTime("starttime"));
                    res.setEndtime(rs.getTime("endtime"));
                    res.setIsactive(rs.getString("isactive"));
                    res.setScreenname(rs.getString("screenname"));
                    res.setMoviename(rs.getString("moviename"));
                    result.add(res);
                } while (rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }

    }
public List<MovieTimingTo> getActiveMovies() {
        try {
            String query = "select moviename ,t.screenid,screenname,starttime,endtime,moviephoto from movieinfo m join "
+" movietiming t on (m.movieid=t.movieid and t.isactive=\"yes\") inner join "
+" screeninfo st on(t.screenid=st.screenid)";

            PreparedStatement stmt = DataConnection.prepareStatement(query);

            List<MovieTimingTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    MovieTimingTo res = new MovieTimingTo();

                    
                    res.setMoviename(rs.getString("moviename"));
                    res.setScreenid(rs.getString("screenid"));
                    res.setScreenname(rs.getString("screenname"));
                    res.setStarttime(rs.getTime("starttime"));
                    res.setEndtime(rs.getTime("endtime"));
                    res.setMoviephoto(rs.getBinaryStream("moviephoto"));
                    
                    result.add(res);
                } while (rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }

    }
    public List<MovieTimingTo> getAllRecord(String moviename) {
        try {
            String query = "select s.mtid,s.movieid,s.screenid,s.starttime,s.endtime,s.isactive ,i.screenname,j.moviename from movietiming s\n"
                    + "inner join screeninfo i on (s.screenid=i.screenid)\n"
                    + "      inner join movieinfo j on (s.movieid=j.movieid) where moviename=?";

            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setString(1, moviename);
            List<MovieTimingTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    MovieTimingTo res = new MovieTimingTo();

                    res.setMtid(rs.getInt("mtid"));
                    res.setMovieid(rs.getInt("movieid"));
                    res.setScreenid(rs.getString("screenid"));
                    res.setStarttime(rs.getTime("starttime"));
                    res.setEndtime(rs.getTime("endtime"));
                    res.setIsactive(rs.getString("isactive"));
                    res.setScreenname(rs.getString("screenname"));
                    res.setMoviename(rs.getString("moviename"));
                    result.add(res);
                } while (rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }

    }

    public List<MovieTimingTo> getAllScreenRecord(String screenname) {
        try {
            String query = "select s.mtid,s.movieid,s.screenid,s.starttime,s.endtime,s.isactive ,i.screenname,j.moviename from movietiming s\n"
                    + "inner join screeninfo i on (s.screenid=i.screenid)\n"
                    + "      inner join movieinfo j on (s.movieid=j.movieid) where i.screenname=?";

            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setString(1, screenname);
            List<MovieTimingTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    MovieTimingTo res = new MovieTimingTo();

                    res.setMtid(rs.getInt("mtid"));
                    res.setMovieid(rs.getInt("movieid"));
                    res.setScreenid(rs.getString("screenid"));
                    res.setStarttime(rs.getTime("starttime"));
                    res.setEndtime(rs.getTime("endtime"));
                    res.setIsactive(rs.getString("isactive"));
                    res.setScreenname(rs.getString("screenname"));
                    res.setMoviename(rs.getString("moviename"));
                    result.add(res);
                } while (rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }

    }

    public List<MovieTimingTo> getMovieName() {
        try {
            String query = "select distinct j.moviename from movietiming s\n"
                    + "      inner join movieinfo j on (s.movieid=j.movieid)";

            PreparedStatement stmt = DataConnection.prepareStatement(query);

            List<MovieTimingTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    MovieTimingTo res = new MovieTimingTo();

                    res.setMoviename(rs.getString("moviename"));
                    result.add(res);
                } while (rs.next());
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }

    }
}
