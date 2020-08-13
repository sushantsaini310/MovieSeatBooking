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
public class ScreenInfoTo {
    private String screenid;
    private String Screenname;

    public String getScreenid() {
        return screenid;
    }

    public void setScreenid(String screenid) {
        this.screenid = screenid;
    }

    public String getScreenname() {
        return Screenname;
    }

    public void setScreenname(String Screenname) {
        this.Screenname = Screenname;
    }

    @Override
    public String toString() {
       return Screenname; //To change body of generated methods, choose Tools | Templates.
    }
    
}
