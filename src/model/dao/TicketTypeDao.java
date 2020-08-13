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
import model.to.TicketTypeTo;

import utility.ErrorHandler;

/**
 *
 * @author sushant saini
 */
public class TicketTypeDao extends Dao {

    public boolean insertRecord(TicketTypeTo record) {
        try {
            String query = "insert into tickettype (typename,price)";
            query += " values(?,?)";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setString(1, record.getTypename());
            stmt.setFloat(2, record.getPrice());

            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (SQLIntegrityConstraintViolationException ex) {
            error_message = "Duplicate Entry For Ticket ";
            return false;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }

    }

    public boolean updateRecord(TicketTypeTo record) {
        try {
            String query = "update tickettype set ";
            query += " typename=?,price=? where typeid=?";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setString(1, record.getTypename());
            stmt.setFloat(2, record.getPrice());
            stmt.setInt(3, record.getTypeid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }

    }

    public boolean deleteRecord(int typeid) {
        try {
            String query = "delete  from tickettype ";
            query += " where typeid=?";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setInt(1, typeid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return false;
        }

    }

    public TicketTypeTo getRecord(int typeid) {
        try {
            String query = "select typeid,typename,price  ";
            query += " from tickettype ";
            query += "where typeid=?";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setInt(1, typeid);
            TicketTypeTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TicketTypeTo();
                result.setTypeid(rs.getInt("typeid"));
                result.setTypename(rs.getString("typename"));
                result.setPrice(rs.getFloat("price"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }

    }
    public TicketTypeTo getprice(String typename) {
        try {
            String query = "select typeid,typename,price  ";
            query += " from tickettype";
            query += " where typename=?";
            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setString(1, typename);
            TicketTypeTo result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TicketTypeTo();
                result.setTypeid(rs.getInt("typeid"));
                result.setTypename(rs.getString("typename"));
                result.setPrice(rs.getFloat("price"));
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            error_message = ex.toString();
            ErrorHandler.showStackTrace(ex);
            return null;
        }

    }

    public List<TicketTypeTo> getAllRecord() {
        try {
            String query = "select typeid,typename,price  ";
            query += " from tickettype ";

            PreparedStatement stmt = DataConnection.prepareStatement(query);

            List<TicketTypeTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TicketTypeTo res = new TicketTypeTo();

                    res.setTypeid(rs.getInt("typeid"));
                    res.setTypename(rs.getString("typename"));
                    res.setPrice(rs.getFloat("price"));
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

    public List<TicketTypeTo> getAllRecord(String screenid) {
        try {
            String query = "select  typeid,typename,price from tickettype where typeid ";
            query += " not in (select typeid from screentickets where screenid=?)";

            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setString(1, screenid);
            List<TicketTypeTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TicketTypeTo res = new TicketTypeTo();

                    res.setTypeid(rs.getInt("typeid"));
                    res.setTypename(rs.getString("typename"));
                    res.setPrice(rs.getFloat("price"));
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

    } public List<TicketTypeTo> getAllRecord1(String screenid) {
        try {
             String query = "select  typeid,typename,price from tickettype where typeid ";
            query += " IN (select typeid from screentickets where screenid=?)";

            PreparedStatement stmt = DataConnection.prepareStatement(query);
            stmt.setString(1, screenid);
            List<TicketTypeTo> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TicketTypeTo res = new TicketTypeTo();

                    res.setTypeid(rs.getInt("typeid"));
                    res.setTypename(rs.getString("typename"));
                    res.setPrice(rs.getFloat("price"));
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
