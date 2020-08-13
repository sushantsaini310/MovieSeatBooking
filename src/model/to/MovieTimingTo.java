/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

import java.io.InputStream;
import java.sql.Time;

/**
 *
 * @author sushant saini
 */
public class MovieTimingTo {
     private int mtid;
     private int movieid;
     private String screenid;
     private Time starttime;
     private Time endtime;
     private String isactive;
     private String moviename;
     private String screenname;
     private  InputStream moviephoto;

    public void setMoviephoto(InputStream moviephoto) {
        this.moviephoto = moviephoto;
    }

 
    public InputStream getMoviephoto() {
        return moviephoto;
    }

    public MovieTimingTo(InputStream moviephoto) {
        this.moviephoto = moviephoto;
    }

    public MovieTimingTo() {
    }
             public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    public String getScreenname() {
        return screenname;
    }

    public int getMtid() {
        return mtid;
    }

    public void setMtid(int mtid) {
        this.mtid = mtid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getScreenid() {
        return screenid;
    }

    public void setScreenid(String screenid) {
        this.screenid = screenid;
    }

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    @Override
    public String toString() {
        return moviename; //To change body of generated methods, choose Tools | Templates.
    }
    
}
