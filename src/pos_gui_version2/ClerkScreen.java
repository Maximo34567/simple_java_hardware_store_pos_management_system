package pos_gui_version2;

import java.awt.Color;
import java.awt.Image;
import java.security.MessageDigest;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClerkScreen extends javax.swing.JFrame {

    Connection DBCon = PosConn.DBConnection();
    PreparedStatement sql = null;
    ResultSet rs = null;

    public ClerkScreen() {
        initComponents();

        lblClerkName.setText(LoginScreen.clerkName);

        Icon imgLogo = lblLogo.getIcon();
        ImageIcon logoLoading = (ImageIcon) imgLogo;
        Image imgLogoLoading = logoLoading.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);

        lblLogo.setIcon(new ImageIcon(imgLogoLoading));

        Icon imgSearch = lblSearch.getIcon();
        ImageIcon logoSearch = (ImageIcon) imgSearch;
        Image imgSearchIcon = logoSearch.getImage().getScaledInstance(lblSearch.getWidth(), lblSearch.getHeight(), Image.SCALE_SMOOTH);

        lblSearch.setIcon(new ImageIcon(imgSearchIcon));

        countClerks();
        displayTable();
    }

    private void displayTable() {
        try {
            sql = DBCon.prepareStatement("SELECT *  FROM clerk");
            rs = sql.executeQuery();

            ResultSetMetaData data = rs.getMetaData();
            int columnCount = data.getColumnCount();

            DefaultTableModel tbRecord = (DefaultTableModel) tblClerk.getModel();
            tbRecord.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();

                for (int i = 0; i <= columnCount; i++) {
                    columnData.add(rs.getInt("clerk_id"));
                    columnData.add(rs.getString("clerk_name"));
                }
                tbRecord.addRow(columnData);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
    }

    public void countClerks() {
        try {
            sql = DBCon.prepareStatement("SELECT COUNT(*) AS clerkCount FROM clerk");
            rs = sql.executeQuery();

            if (rs.next()) {
                int clerkCount = rs.getInt("clerkCount");

                lblClerkCount.setText("Total Clerks: " + clerkCount);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occured. Please try again");
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                hexString.append(Integer.toHexString(0xFF & hashedByte));
            }

            return hexString.toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occured. Please try again");
            System.out.println(e);
            return null;
        }
    }

    public void clearData() {
        txtClerkName.setText("");
        txtClerkUsername.setText("");
        txtClerkPassword.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblLogoText = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUserLogo = new javax.swing.JLabel();
        lblClerkName = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtClerkName = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtClerkUsername = new javax.swing.JTextField();
        txtClerkPassword = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblClerk = new javax.swing.JTable();
        lblClerkCount = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(150, 500));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_gui_version2/img/imgLogoheader.png"))); // NOI18N
        lblLogo.setText("jLabel1");

        lblLogoText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLogoText.setText("<html><center>Hardware <br>Point of Sale System</center></html>");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        lblUserLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_gui_version2/img/icons8-user-40.png"))); // NOI18N

        lblClerkName.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblClerkName.setForeground(new java.awt.Color(255, 255, 255));
        lblClerkName.setText("Welcome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblUserLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClerkName, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUserLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClerkName)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblLogoText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogoText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAdd.setBackground(new java.awt.Color(153, 255, 153));
        btnAdd.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtClerkName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setText("Clerk Name");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setText("Username");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setText("Password");

        txtClerkUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtClerkName, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                    .addComponent(txtClerkPassword)
                    .addComponent(txtClerkUsername, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClerkName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClerkUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtClerkPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Clerk List");

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 255, 0));
        btnEdit.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblClerk.setBackground(new java.awt.Color(204, 255, 255));
        tblClerk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Clerk Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClerk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClerkMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblClerk);

        lblClerkCount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setText("BACK TO MENU");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(102, 204, 255));
        btnCancel.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_gui_version2/img/icons8-search-208.png"))); // NOI18N

        txtSearch.setForeground(new java.awt.Color(102, 102, 102));
        txtSearch.setText("Search for clerk name...");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(7, 7, 7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblClerkCount, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(240, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblClerkCount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String clerk_name = txtClerkName.getText();
            String clerk_username = txtClerkUsername.getText();
            String clerk_password = txtClerkPassword.getText();

            String hashedPassword = hashPassword(clerk_password);

            sql = DBCon.prepareStatement("SELECT * FROM clerk WHERE clerk_name = ? OR clerk_username = ?");
            sql.setString(1, clerk_name);
            sql.setString(2, clerk_username);
            rs = sql.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "A clerk with this record already exists");
            } else {
                if (clerk_name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Clerk name is required");
                } else if (clerk_username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Clerk username is required");
                } else if (clerk_password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Clerk password is required");
                } else if (clerk_password.length() > 10) {
                    JOptionPane.showMessageDialog(null, "Password must not exceed 10 characters.");
                } else {
                    sql = DBCon.prepareStatement("INSERT INTO clerk (clerk_name, clerk_username, clerk_password) VALUES (?,?,?)");
                    sql.setString(1, clerk_name);
                    sql.setString(2, clerk_username);
                    sql.setString(3, hashedPassword);

                    sql.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Saved");
                    clearData();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occured while adding data");
        }
        displayTable();
        countClerks();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblClerk.getSelectedRow();
        String clerkId = tblClerk.getModel().getValueAt(row, 0).toString();

        int id = Integer.parseInt(clerkId);
        int answer;

        answer = JOptionPane.showConfirmDialog(null, "Delete Record?");

        if (answer == JOptionPane.YES_OPTION) {
            try {
                int ID = id;

                sql = DBCon.prepareStatement("DELETE FROM clerk WHERE clerk_id = ?");
                sql.setInt(1, ID);
                sql.executeUpdate();

                sql = DBCon.prepareStatement("SELECT MAX(clerk_id) + 1 AS nextID FROM clerk");
                rs = sql.executeQuery();

                int nextID = 1;
                if (rs.next()) {
                    nextID = rs.getInt("nextID");
                }

                sql = DBCon.prepareStatement("ALTER TABLE clerk AUTO_INCREMENT = ?");
                sql.setInt(1, nextID);
                sql.executeUpdate();

                JOptionPane.showMessageDialog(null, "Record Deleted");
                btnCancel.doClick();
                clearData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occurred while deleting data");
            }
            displayTable();
            countClerks();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            int row = tblClerk.getSelectedRow();
            String clerkId = tblClerk.getModel().getValueAt(row, 0).toString();

            String clerkName = txtClerkName.getText();
            String clerkUsername = txtClerkUsername.getText();
            String clerkPassword = txtClerkPassword.getText();

            if (clerkName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name must not be empty.");
            } else if (clerkUsername.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username must not be empty.");
            } else if (clerkPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Password must not be empty.");
            } else if (clerkPassword.length() > 10) {
                JOptionPane.showMessageDialog(null, "Password must not exceed 10 characters.");
            } else {

                String hashedPassword = hashPassword(clerkPassword);

                sql = DBCon.prepareStatement("UPDATE clerk SET clerk_name = ?, clerk_username = ?, clerk_password = ? WHERE clerk_id = ?");
                sql.setString(1, clerkName);
                sql.setString(2, clerkUsername);
                sql.setString(3, hashedPassword);
                sql.setString(4, clerkId);

                int rowsUpdated = sql.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Record Updated");
                    btnCancel.doClick();
                    displayTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update record. Clerk not found or no changes made.");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while updating data.");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuScreen MS = new MenuScreen();
        MS.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        txtClerkName.setText("");
        txtClerkUsername.setText("");
        txtClerkPassword.setText("");
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tblClerkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClerkMouseClicked
        try {
            int row = tblClerk.getSelectedRow();

            String id = tblClerk.getModel().getValueAt(row, 0).toString();
            sql = DBCon.prepareStatement("SELECT * FROM clerk WHERE clerk_id = '" + id + "'");
            rs = sql.executeQuery();

            btnAdd.setEnabled(false);
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);

            if (rs.next()) {
                txtClerkName.setText(rs.getString(2));
                txtClerkUsername.setText("");
                txtClerkPassword.setText("");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
    }//GEN-LAST:event_tblClerkMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            String searchInfo = "%" + txtSearch.getText() + "%";
            sql = DBCon.prepareStatement("SELECT * FROM clerk WHERE clerk_name LIKE  '" + searchInfo + "' ");
            rs = sql.executeQuery();

            ResultSetMetaData data = rs.getMetaData();
            int columnCount = data.getColumnCount();

            DefaultTableModel tbRecord = (DefaultTableModel) tblClerk.getModel();
            tbRecord.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();

                for (int i = 0; i <= columnCount; i++) {
                    columnData.add(rs.getInt("clerk_id"));
                    columnData.add(rs.getString("clerk_name"));
                }
                tbRecord.addRow(columnData);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
         txtSearch.setText("");
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        txtSearch.setText("Search for clerk name...");
    }//GEN-LAST:event_txtSearchFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClerkScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblClerkCount;
    private javax.swing.JLabel lblClerkName;
    public javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoText;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblUserLogo;
    private javax.swing.JTable tblClerk;
    private javax.swing.JTextField txtClerkName;
    private javax.swing.JPasswordField txtClerkPassword;
    private javax.swing.JTextField txtClerkUsername;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
