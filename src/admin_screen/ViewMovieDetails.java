/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_screen;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.dao.MovieInfoDao;
import model.dao.ScreenTicketsDao;
import model.to.MovieInfoTo;
import model.to.ScreenTicketsTo;
import utility.ErrorHandler;
import utility.Operation;

/**
 *
 * @author sushant saini
 */
public class ViewMovieDetails extends javax.swing.JInternalFrame {
private List<MovieInfoTo> movies;

private JPopupMenu popup;
    private int movieid;
    /**
     * Creates new form ViewMovieDetails
     */
    public ViewMovieDetails() {
        initComponents();
        bindTableMovie();
        preparePopupMenu();
    }
    public void preparePopupMenu() {
        popup = new JPopupMenu();
        Font font = new Font("Consolas", Font.BOLD, 18);
        JMenuItem delete_item = new JMenuItem("Delete");
        JMenuItem edit_item = new JMenuItem("Edit");
        ImageIcon delete_icon = new ImageIcon(getClass().getResource("/icons/delete.png"));
        ImageIcon edit_icon = new ImageIcon(getClass().getResource("/icons/edit_1.png"));
        delete_item.setFont(font);
        edit_item.setFont(font);
        delete_item.setIcon(delete_icon);
        edit_item.setIcon(edit_icon);
        popup.add(delete_item);
        popup.add(edit_item);
        delete_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_movie();
            }
        });
        edit_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit_movie();
            }
        });
    }
     public void delete_movie() {
        if(movieid!=0){
            int result = JOptionPane.showConfirmDialog(this, "Do You Want To Delete?", "Suggestions", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                MovieInfoDao action = new MovieInfoDao();
                String message = "";
                if(action.deleteRecord(movieid)){
                    message = "Record is Removed From System";
                    bindTableMovie();
                }else{
                    message = "Failure Due to " + action.getError_message();
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        movieid = 0;
    }

    public void edit_movie() {
        if(movieid!=0){
            UpdateMovie ansc = new UpdateMovie(movieid);
            Operation.openInternalFrame(getDesktopPane(), ansc);
            dispose();
        }
    }
    public void bindTableMovie(){
          String[] col_names={"Movie ID","Movie Name","Genre","Description","Duration","Start date","End Date","Movie Photo"};
        Object[][]  records=null;
        movies=new MovieInfoDao().getAllRecord();
        if(movies!=null&&movies.size()>0){
            records=new Object[movies.size()][col_names.length];
            int index=0;    
            for(MovieInfoTo sc:movies){
                
                ImageIcon icon = new ImageIcon(getClass().getResource("/icons/nopics.png"));
                   try {
                        BufferedImage img;
                        img = ImageIO.read(sc.getMoviephoto());
                        Image dimg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                        icon = new ImageIcon(dimg);
                    } catch (Exception ex) {
                        ErrorHandler.showStackTrace(ex);
                    }
                               
            records[index]=new  Object[]{sc.getMoiveid(),sc.getMoviename(),sc.getGenre(),sc.getDescription(),sc.getDuration(),sc.getStartdate(),sc.getEnddate(),icon};
            index++;}
        }else{
            records=new Object[1][col_names.length];
            records[0]=new  Object[]{"No Information","No Information","No Information","No Information","No Information","No Information","No Information","No Information","No Information"};
        }
        DefaultTableModel model = new DefaultTableModel(records, col_names) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if(columnIndex == 7){
                    return ImageIcon.class;
                }
                return super.getColumnClass(columnIndex); 
            }
            
        };
        tablemovie.getTableHeader().setReorderingAllowed(false);
        tablemovie.setAutoCreateRowSorter(true);
        tablemovie.setRowHeight(120);
        tablemovie.setModel(model);
    
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
        tablemovie = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Active Movies");

        tablemovie.setModel(new javax.swing.table.DefaultTableModel(
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
        tablemovie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablemovieMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablemovie);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablemovieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablemovieMouseClicked
        // TODO add your handling code here:
        if (SwingUtilities.isRightMouseButton(evt)) {
            int row_point = tablemovie.rowAtPoint(evt.getPoint());
            tablemovie.getSelectionModel().setSelectionInterval(row_point, row_point);
            popup.show(tablemovie, evt.getX(), evt.getY());
            int selected_row = tablemovie.getSelectedRow();
           movieid = Integer.parseInt(tablemovie.getValueAt(selected_row, 0).toString());

    }//GEN-LAST:event_tablemovieMouseClicked
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablemovie;
    // End of variables declaration//GEN-END:variables
}
