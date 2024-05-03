package pos_gui_version2;

import java.awt.Image;
import java.security.MessageDigest;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginScreen extends javax.swing.JFrame {

    static String clerkName;

    Connection DBCon = PosConn.DBConnection();
    PreparedStatement sql = null;
    ResultSet rs = null;

    public LoginScreen() {
        initComponents();

        Icon imgLogo = lblLoadingLogo.getIcon();
        ImageIcon logoLoading = (ImageIcon) imgLogo;
        Image imgLogoLoading = logoLoading.getImage().getScaledInstance(lblLoadingLogo.getWidth(), lblLoadingLogo.getHeight(), Image.SCALE_SMOOTH);

        lblLoadingLogo.setIcon(new ImageIcon(imgLogoLoading));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());

            // Convert byte array to hexadecimal representation
            StringBuilder hexString = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                hexString.append(Integer.toHexString(0xFF & hashedByte));
            }

            return hexString.toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occured| Please try again");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblLoadingLogo = new javax.swing.JLabel();
        lblLogoText = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblUserLogo = new javax.swing.JLabel();
        lblPasswordLogo = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

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
                .addGap(33, 33, 33)
                .addComponent(lblLoadingLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblLogoText, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(lblLoadingLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogoText, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblUserLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_gui_version2/img/icons8-user-40.png"))); // NOI18N

        lblPasswordLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_gui_version2/img/icons8-password-40.png"))); // NOI18N
        lblPasswordLogo.setText("jLabel2");

        lblUsername.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblUsername.setText("Username");

        lblPassword.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblPassword.setText("Password");

        btnLogin.setBackground(new java.awt.Color(19, 33, 60));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(lblPasswordLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUserLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(lblPassword)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUser)
                                .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogin)))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblUsername)
                        .addGap(0, 0, 0)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblUserLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblPasswordLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPassword)
                        .addGap(0, 0, 0)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addGap(0, 182, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            String username = txtUser.getText();
            String password = txtPass.getText();

            // Hash the entered password
            String hashedPassword = hashPassword(password);

            sql = DBCon.prepareStatement("SELECT * FROM clerk WHERE clerk_username = ? AND clerk_password = ?");
            sql.setString(1, username);
            sql.setString(2, hashedPassword);
            rs = sql.executeQuery();

            if (rs.next()) {
                clerkName = rs.getString("clerk_name");

                JOptionPane.showMessageDialog(null, "Hello " + clerkName + "!");

                MenuScreen MS = new MenuScreen();
                MS.setVisible(true);
                dispose();
            } else {
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username should not be empty.");
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password must not be empty.");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please check your credentials.");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "There's an error occured while logging in");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnLogin;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblLoadingLogo;
    public javax.swing.JLabel lblLogoText;
    public javax.swing.JLabel lblPassword;
    public javax.swing.JLabel lblPasswordLogo;
    public javax.swing.JLabel lblUserLogo;
    public javax.swing.JLabel lblUsername;
    public javax.swing.JPasswordField txtPass;
    public javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
