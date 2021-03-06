/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.sql.*;
import utility.ErrorHandler;

/**
 *
 * @author sushant saini
 */
public class TimePanel extends javax.swing.JPanel {

    /**
     * Creates new form TimePanel
     */
    public TimePanel() {
        initComponents();
        jcbhour.removeAllItems();
        jcbminute.removeAllItems();
        jcbsecond.removeAllItems();
        jcbhour.addItem("Hour");
        for(int i=0;i<=12;i++){
            jcbhour.addItem(i);
        }
        jcbminute.addItem("Minute");
        for(int i=0;i<=60;i++){
            jcbminute.addItem(i);
        }
        jcbsecond.addItem("Second");
         for(int i=0;i<=60;i++){
            jcbsecond.addItem(i);
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

        jcbhour = new javax.swing.JComboBox<>();
        jcbminute = new javax.swing.JComboBox<>();
        jcbsecond = new javax.swing.JComboBox<>();

        jcbhour.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jcbhour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbhour.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbhourItemStateChanged(evt);
            }
        });

        jcbminute.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jcbminute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbsecond.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jcbsecond.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jcbhour, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbminute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbsecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jcbhour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jcbminute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jcbsecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
public Time getSelectedTime(){
        Time selected_time = null;
        try{
            if(jcbhour.getSelectedIndex() > 0 && jcbminute.getSelectedIndex() > 0 && jcbsecond.getSelectedIndex()>0){
                int hour = jcbhour.getSelectedIndex()-1;
                int minute = jcbminute.getSelectedIndex()-1;
                int second = jcbsecond.getSelectedIndex()-1;
                String time_string = hour + ":" + minute + ":" + second;
                selected_time = Time.valueOf(time_string);
            }
        }catch(Exception ex){
            ErrorHandler.showStackTrace(ex);
        }
        return selected_time;
    }
public void setTime(Time time_value){
        try{
            String[] values = time_value.toString().split(":");
            int hour = Integer.parseInt(values[0]);
            int minute = Integer.parseInt(values[1]);
            int second = Integer.parseInt(values[2]);
            jcbhour.setSelectedIndex(hour+1);
            jcbminute.setSelectedIndex(minute+1);
            jcbsecond.setSelectedIndex(second+1);
        }catch(Exception ex){
            ErrorHandler.showStackTrace(ex);
        }
    }

    private void jcbhourItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbhourItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbhourItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> jcbhour;
    private javax.swing.JComboBox<Object> jcbminute;
    private javax.swing.JComboBox<Object> jcbsecond;
    // End of variables declaration//GEN-END:variables
}
