/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author sushant saini
 */
public class MovieInfoTo {
    private int moiveid;
    private String moviename;
    private String genre;
    private String description;
    private Time duration;
    private Date startdate;
    private Date enddate;
    private  InputStream moviephoto;

    public int getMoiveid() {
        return moiveid;
    }

    public void setMoiveid(int moiveid) {
        this.moiveid = moiveid;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public InputStream getMoviephoto() {
        return moviephoto;
    }

    public void setMoviephoto(InputStream moviephoto) {
        this.moviephoto = moviephoto;
    }

    @Override
    public String toString() {
        return moviename; //To change body of generated methods, choose Tools | Templates.
    }
    
}
