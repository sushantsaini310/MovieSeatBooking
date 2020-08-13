/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_screen;

import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import utility.ErrorHandler;
import  static utility.Operation.openInternalFrame;
/**
 *
 * @author sushant saini
 */
public class AdminMainScreen extends javax.swing.JFrame {
private String username;
    /**
     * Creates new form AdminMainScreen
     */
    public AdminMainScreen() {
        try
        {
            ImageIcon icon;
            icon= new ImageIcon(getClass().getResource("/icons/movie-box-icon.png"));
            setIconImage(icon.getImage()); 
        }catch(Exception ex)
        { 
            ErrorHandler.showStackTrace(ex);
        }
        initComponents();
        setSize(1200,700);
        setLocationRelativeTo(null);
    }
     public AdminMainScreen(String username) throws HeadlessException {
        this();
        this.username = username;
        setTitle("Welcome "+username.toUpperCase());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskpane = new javax.swing.JDesktopPane();
        backgroundDesktopPane1 = new controls.BackgroundDesktopPane();
        admin_menu_bar = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menu_screeninfo = new javax.swing.JMenu();
        addscreen = new javax.swing.JMenuItem();
        viewscreen = new javax.swing.JMenuItem();
        menu_movieinfo = new javax.swing.JMenu();
        addmovie = new javax.swing.JMenuItem();
        viewmovie = new javax.swing.JMenuItem();
        menu_tickettype = new javax.swing.JMenu();
        addticket = new javax.swing.JMenuItem();
        viewticket = new javax.swing.JMenuItem();
        menu_screentickets = new javax.swing.JMenu();
        addscreenticket = new javax.swing.JMenuItem();
        viewscreentickets = new javax.swing.JMenuItem();
        menu_movietimings = new javax.swing.JMenu();
        addmovietimig = new javax.swing.JMenuItem();
        viewmovietimings = new javax.swing.JMenuItem();
        menu_booking = new javax.swing.JMenu();
        newbooking = new javax.swing.JMenuItem();
        viewbooking = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        backgroundDesktopPane1.setLayout(new java.awt.CardLayout());

        deskpane.setLayer(backgroundDesktopPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout deskpaneLayout = new javax.swing.GroupLayout(deskpane);
        deskpane.setLayout(deskpaneLayout);
        deskpaneLayout.setHorizontalGroup(
            deskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1223, Short.MAX_VALUE)
        );
        deskpaneLayout.setVerticalGroup(
            deskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );

        getContentPane().add(deskpane, java.awt.BorderLayout.CENTER);

        admin_menu_bar.add(jMenu2);

        menu_screeninfo.setForeground(new java.awt.Color(102, 51, 255));
        menu_screeninfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/screen.PNG"))); // NOI18N
        menu_screeninfo.setText("SCREEN");
        menu_screeninfo.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        addscreen.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        addscreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addscreen.setText("Add New Screen");
        addscreen.setFocusTraversalPolicyProvider(true);
        addscreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addscreenActionPerformed(evt);
            }
        });
        menu_screeninfo.add(addscreen);

        viewscreen.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        viewscreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-view-48.png"))); // NOI18N
        viewscreen.setText("View Screen Details");
        viewscreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewscreenActionPerformed(evt);
            }
        });
        menu_screeninfo.add(viewscreen);

        admin_menu_bar.add(menu_screeninfo);

        menu_movieinfo.setForeground(new java.awt.Color(255, 102, 102));
        menu_movieinfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Movies.PNG"))); // NOI18N
        menu_movieinfo.setText("MOVIES");
        menu_movieinfo.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        addmovie.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        addmovie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addmovie.setText("Add New movie");
        addmovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addmovieActionPerformed(evt);
            }
        });
        menu_movieinfo.add(addmovie);

        viewmovie.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        viewmovie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-view-48.png"))); // NOI18N
        viewmovie.setText("View Movie Details");
        viewmovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewmovieActionPerformed(evt);
            }
        });
        menu_movieinfo.add(viewmovie);

        admin_menu_bar.add(menu_movieinfo);

        menu_tickettype.setForeground(new java.awt.Color(255, 204, 153));
        menu_tickettype.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ticket.PNG"))); // NOI18N
        menu_tickettype.setText("TICKET");
        menu_tickettype.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        addticket.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        addticket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addticket.setText("Add New Ticket");
        addticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addticketActionPerformed(evt);
            }
        });
        menu_tickettype.add(addticket);

        viewticket.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        viewticket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-view-48.png"))); // NOI18N
        viewticket.setText("View Ticket Details");
        viewticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewticketActionPerformed(evt);
            }
        });
        menu_tickettype.add(viewticket);

        admin_menu_bar.add(menu_tickettype);

        menu_screentickets.setBackground(new java.awt.Color(255, 255, 255));
        menu_screentickets.setForeground(new java.awt.Color(204, 0, 204));
        menu_screentickets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Screen ticktes.PNG"))); // NOI18N
        menu_screentickets.setText("SCREEN TICKETS");
        menu_screentickets.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        addscreenticket.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        addscreenticket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addscreenticket.setText("Add New Screen Tickets");
        addscreenticket.setActionCommand("Add New Screen tickets");
        addscreenticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addscreenticketActionPerformed(evt);
            }
        });
        menu_screentickets.add(addscreenticket);

        viewscreentickets.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        viewscreentickets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-view-48.png"))); // NOI18N
        viewscreentickets.setText("View Screen Tickets Details");
        viewscreentickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewscreenticketsActionPerformed(evt);
            }
        });
        menu_screentickets.add(viewscreentickets);

        admin_menu_bar.add(menu_screentickets);

        menu_movietimings.setBackground(new java.awt.Color(255, 255, 255));
        menu_movietimings.setForeground(new java.awt.Color(51, 255, 51));
        menu_movietimings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/movie timings.PNG"))); // NOI18N
        menu_movietimings.setText("MOVIE TIMINGS");
        menu_movietimings.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        addmovietimig.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        addmovietimig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addmovietimig.setText("Add New Movie Timings");
        addmovietimig.setActionCommand("Add New Screen tickets");
        addmovietimig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addmovietimigActionPerformed(evt);
            }
        });
        menu_movietimings.add(addmovietimig);

        viewmovietimings.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        viewmovietimings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-view-48.png"))); // NOI18N
        viewmovietimings.setText("View Movie Timings");
        viewmovietimings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewmovietimingsActionPerformed(evt);
            }
        });
        menu_movietimings.add(viewmovietimings);

        admin_menu_bar.add(menu_movietimings);

        menu_booking.setForeground(new java.awt.Color(51, 51, 255));
        menu_booking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/booking.PNG"))); // NOI18N
        menu_booking.setText("BOOKING");
        menu_booking.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N

        newbooking.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        newbooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        newbooking.setText("New Booking");
        newbooking.setActionCommand("Add New Screen tickets");
        newbooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newbookingActionPerformed(evt);
            }
        });
        menu_booking.add(newbooking);

        viewbooking.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        viewbooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-view-48.png"))); // NOI18N
        viewbooking.setText("View Booking");
        viewbooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbookingActionPerformed(evt);
            }
        });
        menu_booking.add(viewbooking);

        admin_menu_bar.add(menu_booking);

        setJMenuBar(admin_menu_bar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addscreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addscreenActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane,new AddNewScreen());
    }//GEN-LAST:event_addscreenActionPerformed

    private void addticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addticketActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane, new AddNewTicket());
    }//GEN-LAST:event_addticketActionPerformed

    private void addscreenticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addscreenticketActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane,new AddNewScreenTickets());
    }//GEN-LAST:event_addscreenticketActionPerformed

    private void viewscreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewscreenActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane, new ViewScreenDetails());
    }//GEN-LAST:event_viewscreenActionPerformed

    private void viewticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewticketActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane, new ViewTicketDetails());
    }//GEN-LAST:event_viewticketActionPerformed

    private void viewscreenticketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewscreenticketsActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane, new ViewScreenTicketsDetails());
    }//GEN-LAST:event_viewscreenticketsActionPerformed

    private void addmovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addmovieActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane, new AddNewMovie());
    }//GEN-LAST:event_addmovieActionPerformed

    private void addmovietimigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addmovietimigActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane, new AddNewMovieTimings());
    }//GEN-LAST:event_addmovietimigActionPerformed

    private void viewmovietimingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewmovietimingsActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane, new ViewMovieTimings());
    }//GEN-LAST:event_viewmovietimingsActionPerformed

    private void viewmovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewmovieActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane,new ViewMovieDetails());
    }//GEN-LAST:event_viewmovieActionPerformed

    private void newbookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbookingActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane, new MovieForBooking());
        
    }//GEN-LAST:event_newbookingActionPerformed

    private void viewbookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbookingActionPerformed
        // TODO add your handling code here:
        openInternalFrame(deskpane, new ViewBookingDetails());
    }//GEN-LAST:event_viewbookingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addmovie;
    private javax.swing.JMenuItem addmovietimig;
    private javax.swing.JMenuItem addscreen;
    private javax.swing.JMenuItem addscreenticket;
    private javax.swing.JMenuItem addticket;
    private javax.swing.JMenuBar admin_menu_bar;
    private controls.BackgroundDesktopPane backgroundDesktopPane1;
    private javax.swing.JDesktopPane deskpane;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu menu_booking;
    private javax.swing.JMenu menu_movieinfo;
    private javax.swing.JMenu menu_movietimings;
    private javax.swing.JMenu menu_screeninfo;
    private javax.swing.JMenu menu_screentickets;
    private javax.swing.JMenu menu_tickettype;
    private javax.swing.JMenuItem newbooking;
    private javax.swing.JMenuItem viewbooking;
    private javax.swing.JMenuItem viewmovie;
    private javax.swing.JMenuItem viewmovietimings;
    private javax.swing.JMenuItem viewscreen;
    private javax.swing.JMenuItem viewscreentickets;
    private javax.swing.JMenuItem viewticket;
    // End of variables declaration//GEN-END:variables
}
