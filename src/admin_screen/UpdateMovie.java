/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_screen;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import model.dao.MovieInfoDao;
import model.to.MovieInfoTo;
import utility.ErrorHandler;
import utility.Validations;

/**
 *
 * @author sushant saini
 */
public class UpdateMovie extends javax.swing.JInternalFrame {
    private String file_path;
    private int movieid;
    InputStream moviephoto;

    /**
     * Creates new form AddNewMovie
     */
    public UpdateMovie() {
        initComponents();
    }
     public UpdateMovie(int movieid) {
        this();
        MovieInfoTo record = new MovieInfoDao().getRecord(movieid);
        if (record != null) {
            this.movieid = movieid;
            moviephoto=record.getMoviephoto();
            setTitle("Edit Movie Details");
            btnoperation.setText("Update Movie Details");
            jtfgenre.setText(record.getGenre());
            jtfmoviename.setText(record.getMoviename());
            jtadescription.setText(record.getDescription());
            cdpstartdate.setDate(record.getStartdate());
            tpduration.setTime(record.getDuration());
            if(record.getEnddate()!=null){
            cdpenddate.setDate(record.getEnddate());}
            ImageIcon icon = new ImageIcon();
            try {
                        BufferedImage img;
                        img = ImageIO.read(record.getMoviephoto());
                        Image dimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        icon = new ImageIcon(dimg);
                        
                    } catch (Exception ex) {
                        ErrorHandler.showStackTrace(ex);
                    }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfgenre = new javax.swing.JTextField();
        jtfmoviename = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtadescription = new javax.swing.JTextArea();
        btnoperation = new javax.swing.JButton();
        cdpstartdate = new controls.CurrentDatePanel();
        cdpenddate = new controls.CurrentDatePanel();
        tpduration = new controls.TimePanel();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Enter Genre:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Enter Movie Name:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Enter Duration:");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Enter Description:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Enter End date:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Enter Start Date:");

        jtfgenre.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jtfmoviename.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jtadescription.setColumns(20);
        jtadescription.setRows(5);
        jScrollPane1.setViewportView(jtadescription);

        btnoperation.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        btnoperation.setText("Update Movie");
        btnoperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoperationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfmoviename)
                            .addComponent(jtfgenre)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cdpstartdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cdpenddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(270, 270, 270))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tpduration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(456, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btnoperation, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfmoviename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfgenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpduration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cdpstartdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cdpenddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnoperation, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnoperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoperationActionPerformed
        // TODO add your handling code here:
        String moviename=jtfmoviename.getText().trim();
        String genre=jtfgenre.getText().trim();
       String description=jtadescription.getText().trim();
        String message="";
        boolean allvalid=true;
        if(Validations.isEmpty(moviename)||Validations.isEmpty(genre)||Validations.isEmpty(description)){
            message="Please Give All Details";
            allvalid=false;
        }
        else if(!Validations.isLetterAndSpace(genre)){
            message="Please Enter Letters in MOVIE NAME and GENRE";
            allvalid=false;
        }
        Time duration=tpduration.getSelectedTime();
        Date startdate=cdpstartdate.getSelectedDate();
        Date enddate=cdpenddate.getSelectedDate();
        if(startdate==null){
            message="Please choose any stockdate";
            allvalid=false;
        }
        if(duration==null){
            message="please choose duration";
            allvalid=false;
        }
        
        if(allvalid){
            try{
            MovieInfoTo record=new MovieInfoTo();
            record.setMoviename(moviename);
            record.setGenre(genre);
            record.setDescription(description);
            record.setDuration(duration);
            record.setStartdate(startdate);
            record.setEnddate(enddate);
            
              MovieInfoDao action= new MovieInfoDao();
                    record.setMoiveid(movieid);
                   
                    if(action.updateRecord(record)){
                    message=" movie updated";
                }else{
                    message="Failure in updating  movie due to "+action.getError_message();
                }
                
            }catch(Exception ex){
                ErrorHandler.showStackTrace(ex);
                message="Failure in saving file";
            } 
        }
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_btnoperationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnoperation;
    private controls.CurrentDatePanel cdpenddate;
    private controls.CurrentDatePanel cdpstartdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtadescription;
    private javax.swing.JTextField jtfgenre;
    private javax.swing.JTextField jtfmoviename;
    private controls.TimePanel tpduration;
    // End of variables declaration//GEN-END:variables
}
