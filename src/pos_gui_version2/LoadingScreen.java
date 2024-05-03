package pos_gui_version2;

import java.awt.Image;
import java.lang.System.Logger;
import java.util.logging.Level;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LoadingScreen extends javax.swing.JFrame {

    
    public LoadingScreen() {
        initComponents();
        
        Icon imgLogo = lblLoadingLogo.getIcon();
        ImageIcon logoLoading = (ImageIcon)imgLogo;
        Image imgLogoLoading = logoLoading.getImage().getScaledInstance(lblLoadingLogo.getWidth(), lblLoadingLogo.getHeight(), Image.SCALE_SMOOTH);
        
        lblLoadingLogo.setIcon(new ImageIcon(imgLogoLoading));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLoading = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLoadingLogo = new javax.swing.JLabel();
        lbLogoText = new javax.swing.JLabel();
        prgLoading = new javax.swing.JProgressBar();
        lblTextLoading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLoading.setBackground(new java.awt.Color(255, 255, 255));
        lblLoading.setMaximumSize(new java.awt.Dimension(500, 500));
        lblLoading.setMinimumSize(new java.awt.Dimension(500, 500));
        lblLoading.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(150, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(150, 500));

        lblLoadingLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_gui_version2/img/imgLogoheader.png"))); // NOI18N
        lblLoadingLogo.setText("jLabel1");

        lbLogoText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbLogoText.setText("Hardware Point of Sale System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoadingLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLogoText, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoadingLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLogoText))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        prgLoading.setBackground(new java.awt.Color(229, 229, 229));
        prgLoading.setForeground(new java.awt.Color(153, 153, 153));
        prgLoading.setStringPainted(true);
        prgLoading.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                prgLoadingAncestorRemoved(evt);
            }
        });

        lblTextLoading.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTextLoading.setText("Loading.");

        javax.swing.GroupLayout lblLoadingLayout = new javax.swing.GroupLayout(lblLoading);
        lblLoading.setLayout(lblLoadingLayout);
        lblLoadingLayout.setHorizontalGroup(
            lblLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblLoadingLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(lblLoadingLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(lblLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prgLoading, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                    .addComponent(lblTextLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        lblLoadingLayout.setVerticalGroup(
            lblLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblLoadingLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(lblTextLoading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prgLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void prgLoadingAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_prgLoadingAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_prgLoadingAncestorRemoved

    public static void main(String args[]) {
      
        LoadingScreen L = new LoadingScreen();
        LoginScreen LS = new LoginScreen();
        L.setVisible(true);
        
         for (int i = 0; i<=100; i++) {
            try {
                prgLoading.setValue(i);
                Thread.sleep(10);
                
                 
                 if (i <= 25) {
                     lblTextLoading.setText("Loading..");
                 } else if ( i<= 50) {
                     lblTextLoading.setText("Loading...");
                 } else if ( i<= 75 ) {
                     lblTextLoading.setText("Loading...");
                 } else {
                     lblTextLoading.setText("Loading....");
                 }
                 
                  if (i == 100) {
                    LS.setVisible(true);
                    L.dispose();
                 }
                 
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(LoadingScreen.class.getName()).log(Level.SEVERE, null, ex);
            } 
         }           
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lbLogoText;
    public javax.swing.JPanel lblLoading;
    public javax.swing.JLabel lblLoadingLogo;
    public static javax.swing.JLabel lblTextLoading;
    public static javax.swing.JProgressBar prgLoading;
    // End of variables declaration//GEN-END:variables
}
