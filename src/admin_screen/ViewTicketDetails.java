/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_screen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import model.dao.ScreenInfoDao;
import model.dao.TicketTypeDao;
import model.to.ScreenInfoTo;
import model.to.TicketTypeTo;
import utility.Operation;

/**
 *
 * @author sushant saini
 */
public class ViewTicketDetails extends javax.swing.JInternalFrame {
private List<TicketTypeTo> tickets;
 private JPopupMenu popup;
    private int selected_row;
    /**
     * Creates new form ViewTicketDetails
     */
    public ViewTicketDetails() {
        initComponents();
        bindTableTicket();
         preparePopupMenu();
        selected_row=-1;
    }
    public void  preparePopupMenu(){
        popup=new JPopupMenu();
        Font font=new Font("Consolas",Font.BOLD,18);
        JMenuItem delete_item=new JMenuItem("DELETE");
        JMenuItem edit_itme=new JMenuItem("EDIT");
        ImageIcon delete_icon=new ImageIcon(getClass().getResource("/icons/delete.png"));
        ImageIcon edit_icon=new ImageIcon(getClass().getResource("/icons/edit_1.png"));
        delete_item.setFont(font);
        edit_itme.setFont(font);
        delete_item.setIcon(delete_icon);
        edit_itme.setIcon(edit_icon);
        popup.add(delete_item);
        popup.add(edit_itme);
         delete_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         delete_ticket();
            }
        });
          edit_itme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         edit_ticket();
            }
        });
    }
    public void delete_ticket(){
        if(selected_row!=-1&&tickets!=null&&tickets.size()>0&&selected_row<tickets.size()){
         int result =  JOptionPane.showConfirmDialog(this,"Do You Want To Delete ?","Suggestions", JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
                TicketTypeTo record=tickets.get(selected_row);
                TicketTypeDao action=new TicketTypeDao();
                String message="";
                if(action.deleteRecord(record.getTypeid())){
                    message="Record is Deleted";
                    bindTableTicket();
                }else{
                    message="Failure due to "+action.getError_message();
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        selected_row=-1;
    }
    public void edit_ticket(){
    if(selected_row!=-1&&tickets!=null&&tickets.size()>0&&selected_row<tickets.size()){
     TicketTypeTo record=tickets.get(selected_row);
     AddNewTicket anc=new AddNewTicket(record);
        Operation.openInternalFrame(getDesktopPane(), anc);
        dispose();
    }    
    }
public void bindTableTicket(){
        String[] col_names={"Type Id","Type Name","Price"};
        Object[][]  records=null;
        tickets=new TicketTypeDao().getAllRecord();
        if(tickets!=null&tickets.size()>0){
            records=new Object[tickets.size()][col_names.length];
            int index=0;
            for(TicketTypeTo sc:tickets){
            records[index]=new  Object[]{sc.getTypeid(),sc.getTypename(),sc.getPrice()};
            index++;}
        }else{
            records=new Object[1][col_names.length];
            records[0]=new  Object[]{"No Information","No Information","No Information"};
        }
        DefaultTableModel model=new DefaultTableModel(records, col_names);
         tableticket.setModel(model);
         
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableticket = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Ticket Details");

        tableticket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableticket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableticketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableticket);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableticketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableticketMouseClicked
        // TODO add your handling code here:
        if(evt.getButton()==MouseEvent.BUTTON3){
            int row_point=tableticket.rowAtPoint(evt.getPoint());
            tableticket.getSelectionModel().setSelectionInterval(row_point, row_point);
            popup.show(tableticket, evt.getX(), evt.getY());
            selected_row=tableticket.getSelectedRow();
        }
    }//GEN-LAST:event_tableticketMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableticket;
    // End of variables declaration//GEN-END:variables
}
