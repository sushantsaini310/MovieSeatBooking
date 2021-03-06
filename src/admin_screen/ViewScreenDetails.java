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
import model.to.ScreenInfoTo;
import utility.Operation;

/**
 *
 * @author sushant saini
 */
public class ViewScreenDetails extends javax.swing.JInternalFrame {

    private List<ScreenInfoTo> screens;
    private JPopupMenu popup;
    private int selected_row;
    /**
     * Creates new form ViewScreenDetails
     */
    public ViewScreenDetails() {
        initComponents();
        bindTableScreen();
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
         delete_screen();
            }
        });
          edit_itme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         edit_screen();
            }
        });
    }
    public void delete_screen(){
        if(selected_row!=-1&&screens!=null&&screens.size()>0&&selected_row<screens.size()){
         int result =  JOptionPane.showConfirmDialog(this,"Do You Want To Delete ?","Suggestions", JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION){
                ScreenInfoTo record=screens.get(selected_row);
                ScreenInfoDao action=new ScreenInfoDao();
                String message="";
                if(action.deleteRecord(record.getScreenid())){
                    message="Record is Deleted";
                    bindTableScreen();
                }else{
                    message="Failure due to "+action.getError_message();
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        selected_row=-1;
    }
    public void edit_screen(){
    if(selected_row!=-1&&screens!=null&&screens.size()>0&&selected_row<screens.size()){
     ScreenInfoTo record=screens.get(selected_row);
     AddNewScreen anc=new AddNewScreen(record);
        Operation.openInternalFrame(getDesktopPane(), anc);
        dispose();
    }    
    }
    public void bindTableScreen(){
        String[] col_names={"Screen Id","Screen Name"};
        Object[][]  records=null;
        screens=new ScreenInfoDao().getAllRecord();
        if(screens!=null&screens.size()>0){
            records=new Object[screens.size()][col_names.length];
            int index=0;
            for(ScreenInfoTo sc:screens){
            records[index]=new  Object[]{sc.getScreenid(),sc.getScreenname()};
            index++;}
        }else{
            records=new Object[1][col_names.length];
            records[0]=new  Object[]{"No Information","No Information"};
        }
        DefaultTableModel model=new DefaultTableModel(records, col_names);
         tablescreen.setModel(model);
         
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
        tablescreen = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Screen Details");

        tablescreen.setModel(new javax.swing.table.DefaultTableModel(
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
        tablescreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablescreenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablescreen);

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
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablescreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablescreenMouseClicked
        if(evt.getButton()==MouseEvent.BUTTON3){
            int row_point=tablescreen.rowAtPoint(evt.getPoint());
            tablescreen.getSelectionModel().setSelectionInterval(row_point, row_point);
            popup.show(tablescreen, evt.getX(), evt.getY());
            selected_row=tablescreen.getSelectedRow();
        }
    }//GEN-LAST:event_tablescreenMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablescreen;
    // End of variables declaration//GEN-END:variables
}
