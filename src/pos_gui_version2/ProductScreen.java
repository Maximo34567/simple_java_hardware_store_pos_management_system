package pos_gui_version2;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ProductScreen extends javax.swing.JFrame {

    Connection DBCon = PosConn.DBConnection();
    PreparedStatement sql = null;
    ResultSet rs = null;

    public ProductScreen() {
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

        countProducts();
        displayTable();
    }

    private void displayTable() {
        try {
            sql = DBCon.prepareStatement("SELECT * FROM product");
            rs = sql.executeQuery();

            ResultSetMetaData data = rs.getMetaData();
            int columnCount = data.getColumnCount();

            DefaultTableModel tbRecord = (DefaultTableModel) tblProduct.getModel();
            tbRecord.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();

                for (int i = 1; i <= columnCount; i++) {
                    if ("product_price".equals(data.getColumnName(i))) {
                        columnData.add(rs.getDouble(i));
                    } else {
                        columnData.add(rs.getObject(i));
                    }
                }

                tbRecord.addRow(columnData);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
    }

    public void countProducts() {
        try {
            sql = DBCon.prepareStatement("SELECT COUNT(*) AS productCount FROM product");
            rs = sql.executeQuery();

            if (rs.next()) {
                int productCount = rs.getInt("productCount");

                lblProductCount.setText("Total Products: " + productCount);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
    }

    public void clearData() {
        txtProductName.setText("");
        txtProductPrice.setText("");
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
        txtProductPrice = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        lblProductCount = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();

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
                .addComponent(lblClerkName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUserLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClerkName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(42, Short.MAX_VALUE))
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

        txtProductPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtProductName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Price");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setText("Product Name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Product List");

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

        tblProduct.setBackground(new java.awt.Color(204, 255, 255));
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblProduct);

        lblProductCount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProductCount.setText("Total Products:");

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

        txtSearch.setForeground(new java.awt.Color(102, 102, 102));
        txtSearch.setText("Search for product name...");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
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

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_gui_version2/img/icons8-search-208.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProductCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(lblProductCount, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String product_name = txtProductName.getText().trim();
            String product_price_text = txtProductPrice.getText().trim();

            if (product_name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Product name is required");
            } else if (product_price_text.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Product price is required");
            } else {
                try {
                    double product_price = Double.parseDouble(product_price_text);

                    sql = DBCon.prepareStatement("SELECT * FROM product WHERE product_name = ?");
                    sql.setString(1, product_name);
                    rs = sql.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "A product with this name already exists");
                    } else {
                        sql = DBCon.prepareStatement("INSERT INTO product(product_name, product_price) VALUES (?,?)");
                        sql.setString(1, product_name);
                        sql.setDouble(2, product_price);
                        sql.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Record Saved");
                        clearData();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid numeric input for price");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while adding data");
        }
        displayTable();
        countProducts();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblProduct.getSelectedRow();
        String productId = tblProduct.getModel().getValueAt(row, 0).toString();

        int id = Integer.parseInt(productId);
        int answer;

        answer = JOptionPane.showConfirmDialog(null, "Delete Product?");

        if (answer == JOptionPane.YES_OPTION) {
            try {
                int ID = id;

                sql = DBCon.prepareStatement("DELETE FROM product WHERE product_id = ?");
                sql.setInt(1, ID);
                sql.executeUpdate();

                // Adjust the auto-increment value after deletion
                sql = DBCon.prepareStatement("SELECT MAX(product_id) + 1 AS nextID FROM product");
                rs = sql.executeQuery();

                int nextID = 1; // Default value if no records
                if (rs.next()) {
                    nextID = rs.getInt("nextID");
                }

                sql = DBCon.prepareStatement("ALTER TABLE product AUTO_INCREMENT = ?");
                sql.setInt(1, nextID);
                sql.executeUpdate();

                JOptionPane.showMessageDialog(null, "Product Deleted");
                btnCancel.doClick(); // Assuming btnCancelProduct is your cancel button for products
                clearData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occurred while deleting data.");
            }
            displayTable();
            countProducts();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            int row = tblProduct.getSelectedRow();
            String productId = tblProduct.getModel().getValueAt(row, 0).toString();

            String productName = txtProductName.getText();
            String productPriceStr = txtProductPrice.getText();

            if (productName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Product name must not be empty.");
            } else if (productPriceStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Product price must not be empty.");
            } else {
                double productPrice = Double.parseDouble(productPriceStr);

                sql = DBCon.prepareStatement("UPDATE product SET product_name = ?, product_price = ? WHERE product_id = ?");
                sql.setString(1, productName);
                sql.setDouble(2, productPrice);
                sql.setString(3, productId);

                int rowsUpdated = sql.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Product Updated");
                    btnCancel.doClick();
                    displayTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update product. Product not found or no changes made.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occured while updating data");
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuScreen MS = new MenuScreen();
        MS.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        txtProductName.setText("");
        txtProductPrice.setText("");
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
    }//GEN-LAST:event_txtSearchActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        try {
            int row = tblProduct.getSelectedRow();

            String id = tblProduct.getModel().getValueAt(row, 0).toString();
            sql = DBCon.prepareStatement("SELECT * FROM product WHERE product_id = ?");
            sql.setString(1, id);
            rs = sql.executeQuery();

            btnAdd.setEnabled(false);
            btnEdit.setEnabled(true);
            btnDelete.setEnabled(true);

            if (rs.next()) {
                txtProductName.setText(rs.getString("product_name"));
                txtProductPrice.setText(String.valueOf(rs.getDouble("product_price")));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
    }//GEN-LAST:event_tblProductMouseClicked

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        txtSearch.setText("Search for product name...");
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            String searchInfo = "%" + txtSearch.getText() + "%";
            sql = DBCon.prepareStatement("SELECT * FROM product WHERE product_name LIKE  '" + searchInfo + "' ");
            rs = sql.executeQuery();

            ResultSetMetaData data = rs.getMetaData();
            int columnCount = data.getColumnCount();

            DefaultTableModel tbRecord = (DefaultTableModel) tblProduct.getModel();
            tbRecord.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();

                for (int i = 1; i <= columnCount; i++) {
                    if ("product_price".equals(data.getColumnName(i))) {
                        columnData.add(rs.getDouble(i));
                    } else {
                        columnData.add(rs.getObject(i));
                    }
                }

                tbRecord.addRow(columnData);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblClerkName;
    public javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoText;
    private javax.swing.JLabel lblProductCount;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblUserLogo;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
