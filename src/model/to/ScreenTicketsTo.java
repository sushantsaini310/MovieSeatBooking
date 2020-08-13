/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

/**
 *
 * @author sushant saini
 */
public class ScreenTicketsTo {
    private int stid;
    private String Screenid;
    private int typeid;
    private int totalrow;
    private int seatinrow;
    private String screenname;
    private String typename;

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public String getScreenid() {
        return Screenid;
    }

    public void setScreenid(String Screenid) {
        this.Screenid = Screenid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getTotalrow() {
        return totalrow;
    }

    public void setTotalrow(int totalrow) {
        this.totalrow = totalrow;
    }

    public int getSeatinrow() {
        return seatinrow;
    }

    public void setSeatinrow(int seatinrow) {
        this.seatinrow = seatinrow;
    }
}
