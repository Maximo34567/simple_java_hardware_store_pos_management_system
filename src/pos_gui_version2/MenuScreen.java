package pos_gui_version2;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MenuScreen extends javax.swing.JFrame {

    public MenuScreen() {
        initComponents();
        
        lblClerkName.setText("Clerk Name: " + LoginScreen.clerkName);

        Icon imgLogo = lblLoadingLogo.getIcon();
        ImageIcon logoLoading = (ImageIcon) imgLogo;
        Image imgLogoLoading = logoLoading.getImage().getScaledInstance(lblLoadingLogo.getWidth(), lblLoadingLogo.getHeight(), Image.SCALE_SMOOTH);

        lblLoadingLogo.setIcon(new ImageIcon(imgLogoLoading));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLoadingLogo = new javax.swing.JLabel();
        lblLogoText = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnTransaction = new javax.swing.JButton();
        btnClerks = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        btnProducts = new javax.swing.JButton();
        lblClerkName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(150, 500));
        jPanel2.setPreferredSize(new java.awt.Dimension(150, 500));

        lblLoadingLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_gui_version2/img/imgLogoheader.png"))); // NOI18N
        lblLoadingLogo.setText("jLabel1");

        lblLogoText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLogoText.setText("<html><center>Hardware <br>Point of Sale System</center></html>");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblLogoText, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblLoadingLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(lblLoadingLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLogoText, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 392));

        btnLogout.setBackground(new java.awt.Color(102, 204, 255));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 170, 30));

        btnTransaction.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTransaction.setText("Transaction");
        btnTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransactionActionPerformed(evt);
            }
        });
        jPanel1.add(btnTransaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 88, 485, 66));

        btnClerks.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClerks.setText("Clerks");
        btnClerks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClerksActionPerformed(evt);
            }
        });
        jPanel1.add(btnClerks, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 172, 485, 66));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Welcome to Hardware Point of Sales System");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 44, -1, 31));

        btnProducts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProducts.setText("Products");
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsActionPerformed(evt);
            }
        });
        jPanel1.add(btnProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 256, 485, 66));

        lblClerkName.setBackground(new java.awt.Color(255, 255, 255));
        lblClerkName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblClerkName.setText("Welcome");
        jPanel1.add(lblClerkName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 300, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LoginScreen LS = new LoginScreen();
        LS.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionActionPerformed
        TransactionScreen TS = new TransactionScreen();
        TS.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTransactionActionPerformed

    private void btnClerksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClerksActionPerformed
        ClerkScreen CS = new ClerkScreen();
        CS.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnClerksActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsActionPerformed
        ProductScreen PS = new ProductScreen();
        PS.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProductsActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnClerks;
    public javax.swing.JButton btnLogout;
    public javax.swing.JButton btnProducts;
    public javax.swing.JButton btnTransaction;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblClerkName;
    public javax.swing.JLabel lblLoadingLogo;
    public javax.swing.JLabel lblLogoText;
    // End of variables declaration//GEN-END:variables
}
