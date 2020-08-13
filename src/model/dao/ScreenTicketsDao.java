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
import model.to.ScreenTicketsTo;
import utility.ErrorHandler;

/**
 *
 * @author sushant saini
 */
public class ScreenTicketsDao extends Dao {

    public boolean insertRecord(ScreenTicketsTo record) {
        try {
            String query = "insert into screentickets (screenid,typeid,totalrow,seatinrow) ";
            query += " values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setString(1, record.getScreenid());
            stmt.setInt(2, record.getTypeid());
            stmt.setInt(3, record.getTotalrow());
            stmt.setInt(4, record.getSeatinrow());

            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }

    }

    public boolean updateRecord(ScreenTicketsTo record) {
        try {
            String query = "update screentickets ";
            query += " set screenid=?,typeid=?,totalrow=?,seatinrow=? ";
            query += "where stid=?";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setString(1, record.getScreenid());
            stmt.setInt(2, record.getTypeid());
            stmt.setInt(3, record.getTotalrow());
            stmt.setInt(4, record.getSeatinrow());
            stmt.setInt(5, record.getStid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int stid) {
        try {
            String query = "delete from screentickets ";

            query += "where stid=?";
            PreparedStatement stmt = DataConnection.prepareStatement(query);

            stmt.setInt(1, stid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }

    }

    public ScreenTicketsTo getRecord(int stid) {
        try {
            String query = "select s.stid,s.screenid,s.typeid,s.totalrow,s.seatinrow\n"
                    + ",i.screenname,j.typename from screentickets s\n"
                    + "inner join screeninfo i\n"
                    + "on (s.screenid=i.screenid)\n"
                    + "inner join tickettype j\n"
                    + "on(s.typeid=j.typeid) ";
            query += "where stid=?";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setInt(1, stid);
            ScreenTicketsTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ScreenTicketsTo();
                result.setStid(rs.getInt("stid"));
                result.setScreenid(rs.getString("screenid"));
                result.setTypeid(rs.getInt("typeid"));
                result.setTotalrow(rs.getInt("totalrow"));
                result.setSeatinrow(rs.getInt("seatinrow"));

            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }

    }
    public ScreenTicketsTo getRecord(String typename,String screenname) {
        try {
            String query = "select s.stid,s.screenid,s.typeid,s.totalrow,s.seatinrow\n"
                    + ",i.screenname,j.typename from screentickets s\n"
                    + "inner join screeninfo i\n"
                    + "on (s.screenid=i.screenid)\n"
                    + "inner join tickettype j\n"
                    + "on(s.typeid=j.typeid) ";
            query += "where typename=? and screenname=?";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setString(1, typename);
            stmt.setString(2, screenname);
            ScreenTicketsTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ScreenTicketsTo();
                result.setStid(rs.getInt("stid"));
                result.setScreenid(rs.getString("screenid"));
                result.setTypeid(rs.getInt("typeid"));
                result.setTotalrow(rs.getInt("totalrow"));
                result.setSeatinrow(rs.getInt("seatinrow"));

            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }

    }

    public List<ScreenTicketsTo> getAllRecord() {
        try {
            String query = "select s.stid,s.screenid,s.typeid,s.totalrow,s.seatinrow\n"
                    + ",i.screenname,j.typename from screentickets s\n"
                    + "inner join screeninfo i\n"
                    + "on (s.screenid=i.screenid)\n"
                    + "inner join tickettype j\n"
                    + "on(s.typeid=j.typeid)";

            PreparedStatement stmt = DataConnection.prepareStatement(query);

            List<ScreenTicketsTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ScreenTicketsTo res = new ScreenTicketsTo();

                    res.setStid(rs.getInt("stid"));
                    res.setScreenid(rs.getString("screenid"));
                    res.setTypeid(rs.getInt("typeid"));
                    res.setTotalrow(rs.getInt("totalrow"));
                    res.setSeatinrow(rs.getInt("seatinrow"));
                    res.setScreenname(rs.getString("screenname"));
                    res.setTypename(rs.getString("typename"));
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
public List<ScreenTicketsTo> getAllticktes(String screenname) {
        try {
            String query = "select s.stid,s.screenid,s.typeid,s.totalrow,s.seatinrow\n"
                    + ",i.screenname,j.typename from screentickets s\n"
                    + "inner join screeninfo i\n"
                    + "on (s.screenid=i.screenid)\n"
                    + "inner join tickettype j\n"
                    + "on(s.typeid=j.typeid) where i.screenname=?";

            PreparedStatement stmt = DataConnection.prepareStatement(query);
             stmt.setString(1, screenname);
            List<ScreenTicketsTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ScreenTicketsTo res = new ScreenTicketsTo();

                    res.setStid(rs.getInt("stid"));
                    res.setScreenid(rs.getString("screenid"));
                    res.setTypeid(rs.getInt("typeid"));
                    res.setTotalrow(rs.getInt("totalrow"));
                    res.setSeatinrow(rs.getInt("seatinrow"));
                    res.setScreenname(rs.getString("screenname"));
                    res.setTypename(rs.getString("typename"));
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
