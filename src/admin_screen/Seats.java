/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_screen;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import model.dao.ScreenTicketsDao;
import model.to.ScreenTicketsTo;
import model.to.TicketTypeTo;

/**
 *
 * @author sushant saini
 */
public class Seats extends javax.swing.JInternalFrame {
String screenname;
List<JCheckBox> checks;
    List<ScreenTicketsTo> st;
    /**
     * Creates new form Seats
     */
    public Seats() {
        initComponents();
       
    }
   public Seats(String screen){
       this();
       screenname=screen;
       bindTicketCombo();
   }
    public void bindTicketCombo()
    {
        jcbchooseticket.removeAllItems();
        st=new ScreenTicketsDao().getAllticktes(screenname);
        jcbchooseticket.addItem("Choose Ticket");
        for(ScreenTicketsTo ticket:st){
            jcbchooseticket.addItem(ticket.getTypename());
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

        jcbchooseticket = new javax.swing.JComboBox<>();
        panelticket = new javax.swing.JPanel();
        btnoperation = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Seats");

        jcbchooseticket.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jcbchooseticket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbchooseticket.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbchooseticketItemStateChanged(evt);
            }
        });

        panelticket.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelticketLayout = new javax.swing.GroupLayout(panelticket);
        panelticket.setLayout(panelticketLayout);
        panelticketLayout.setHorizontalGroup(
            panelticketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelticketLayout.setVerticalGroup(
            panelticketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        btnoperation.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnoperation.setText("Book Ticket");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelticket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbchooseticket, 0, 569, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btnoperation, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbchooseticket, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(panelticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnoperation, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbchooseticketItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbchooseticketItemStateChanged
        // TODO add your handling code here:
        panelticket.removeAll();
        if(jcbchooseticket.getSelectedIndex()>0)
        {
            String ticket= jcbchooseticket.getSelectedItem().toString();
            ScreenTicketsTo st=new ScreenTicketsDao().getRecord(ticket, screenname);
            GridLayout layout=new GridLayout(st.getTotalrow(), st.getSeatinrow(), 5, 5);
            panelticket.setLayout(layout);
            panelticket.repaint();
            panelticket.revalidate();
            checks=new ArrayList<>();
            char symbol='A';
            for(int row=1;row<=st.getTotalrow();row++){
                for(int col=1;col<=st.getSeatinrow();col++){
                    JCheckBox jcb=new JCheckBox(symbol+""+col);
                    panelticket.add(jcb);
                    checks.add(jcb);
                }
                symbol++;
            }
        }
    }//GEN-LAST:event_jcbchooseticketItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnoperation;
    private javax.swing.JComboBox<java.lang.Object> jcbchooseticket;
    private javax.swing.JPanel panelticket;
    // End of variables declaration//GEN-END:variables
}
