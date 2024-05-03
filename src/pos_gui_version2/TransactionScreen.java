package pos_gui_version2;

import java.awt.Image;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionScreen extends javax.swing.JFrame {

    Connection DBCon = PosConn.DBConnection();
    PreparedStatement sql = null;
    ResultSet rs = null;

    static String productNameList;
    static double productPriceList;
    static double totalProductPrice;
    static double totalChange;

    public TransactionScreen() {
        initComponents();

        lblClerkName.setText(LoginScreen.clerkName);
        lblClerk.setText("Clerk Name: " + LoginScreen.clerkName);

        Icon imgSearch = lblSearch.getIcon();
        ImageIcon logoSearch = (ImageIcon) imgSearch;
        Image imgSearchIcon = logoSearch.getImage().getScaledInstance(lblSearch.getWidth(), lblSearch.getHeight(), Image.SCALE_SMOOTH);

        lblSearch.setIcon(new ImageIcon(imgSearchIcon));

        Icon imgLogo = lblLogo.getIcon();
        ImageIcon logoLoading = (ImageIcon) imgLogo;
        Image imgLogoLoading = logoLoading.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);

        lblLogo.setIcon(new ImageIcon(imgLogoLoading));
        displayProductTable();
        displayBillingTable();
    }

    private void displayProductTable() {
        try {
            sql = DBCon.prepareStatement("SELECT product_name, product_price FROM product");
            rs = sql.executeQuery();

            ResultSetMetaData data = rs.getMetaData();
            int columnCount = data.getColumnCount();

            DefaultTableModel tbRecord = (DefaultTableModel) tblProductList.getModel();
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
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void displayBillingTable() {
        try {
            sql = DBCon.prepareStatement("SELECT product_name, product_price, billing_qty FROM billing");
            rs = sql.executeQuery();

            ResultSetMetaData data = rs.getMetaData();
            int columnCount = data.getColumnCount();

            DefaultTableModel tbRecord = (DefaultTableModel) tblBilling.getModel();
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
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void clearData() {
        txtQty.setText("");
        txtCash.setText("");
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
        txtCash = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBilling = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductList = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblChange = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblClerk = new javax.swing.JLabel();
        lblTransaction = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnCompute = new javax.swing.JButton();
        btnCancelTransaction = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnReceipt = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();

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
                .addComponent(lblClerkName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        txtCash.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtQty.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Cash");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Quantity");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQty)
                    .addComponent(txtCash))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblBilling.setBackground(new java.awt.Color(204, 255, 255));
        tblBilling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product Name", "Total Price", "Qty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
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
        tblBilling.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblBillingFocusGained(evt);
            }
        });
        tblBilling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBillingMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBilling);
        if (tblBilling.getColumnModel().getColumnCount() > 0) {
            tblBilling.getColumnModel().getColumn(1).setMinWidth(150);
            tblBilling.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblBilling.getColumnModel().getColumn(1).setMaxWidth(150);
            tblBilling.getColumnModel().getColumn(2).setMinWidth(150);
            tblBilling.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblBilling.getColumnModel().getColumn(2).setMaxWidth(150);
        }

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Customer Billing");

        tblProductList.setBackground(new java.awt.Color(204, 255, 255));
        tblProductList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Product Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
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
        tblProductList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblProductList.getTableHeader().setReorderingAllowed(false);
        tblProductList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProductList);
        if (tblProductList.getColumnModel().getColumnCount() > 0) {
            tblProductList.getColumnModel().getColumn(1).setMinWidth(100);
            tblProductList.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblProductList.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblChange.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblChange.setText("Change:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblClerk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblClerk.setText("Clerk Name:");

        lblTransaction.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTransaction.setText("Transaction Information:");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setText("Total Price:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblClerk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel25)
                        .addGap(400, 400, 400)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChange, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClerk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCompute.setBackground(new java.awt.Color(255, 255, 0));
        btnCompute.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnCompute.setText("COMPUTE");
        btnCompute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComputeActionPerformed(evt);
            }
        });

        btnCancelTransaction.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelTransaction.setText("CANCEL TRANSACTION");
        btnCancelTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelTransactionActionPerformed(evt);
            }
        });

        btnPay.setBackground(new java.awt.Color(102, 204, 255));
        btnPay.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnPay.setText("PAY");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setText("BACK TO MENU");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos_gui_version2/img/icons8-search-208.png"))); // NOI18N

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

        btnReceipt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReceipt.setText("PRINT RECIEPT");
        btnReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceiptActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Product List");

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
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
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCompute, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCancelTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReceipt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)))
                .addContainerGap())
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCompute, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        String product_name = productNameList;
        double product_price = productPriceList;

        if (product_name == null || product_name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You must select product on product list first");
        } else {
            try {

                if (txtQty.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Total Quantity is required");
                } else {
                    int qty = Integer.parseInt(txtQty.getText());

                    double total_price = product_price * qty;

                    sql = DBCon.prepareStatement("INSERT INTO billing (product_name, product_price, billing_qty) VALUES (?, ?, ?)");
                    sql.setString(1, product_name);
                    sql.setDouble(2, total_price);
                    sql.setInt(3, qty);

                    int rowsAffected = sql.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Record inserted successfully");
                        clearData();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to insert record");
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
            }
            displayBillingTable();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblProductListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductListMouseClicked
        try {
            int row = tblProductList.getSelectedRow();

            String productname = tblProductList.getModel().getValueAt(row, 0).toString();
            sql = DBCon.prepareStatement("SELECT * FROM product WHERE product_name = ?");
            sql.setString(1, productname);
            rs = sql.executeQuery();

            if (rs.next()) {
                productNameList = rs.getString("product_name");

                if (rs.getObject("product_price") != null) {
                    productPriceList = rs.getDouble("product_price");
                } else {
                    JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
    }//GEN-LAST:event_tblProductListMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblBilling.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "You must select data first from costumer billing");
        } else {
            int answer = JOptionPane.showConfirmDialog(null, "Delete Product?");

            if (answer == JOptionPane.YES_OPTION) {
                try {

                    String productname = tblBilling.getModel().getValueAt(row, 0).toString();
                    sql = DBCon.prepareStatement("SELECT * FROM billing WHERE product_name = ?");
                    sql.setString(1, productname);
                    rs = sql.executeQuery();

                    if (rs.next()) {
                        int billingID = rs.getInt("billing_id");

                        sql = DBCon.prepareStatement("DELETE FROM billing WHERE billing_id = ?");
                        sql.setInt(1, billingID);
                        int rowsAffected = sql.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Record deleted successfully");

                            sql = DBCon.prepareStatement("ALTER TABLE billing AUTO_INCREMENT = 1");
                            sql.executeUpdate();

                            displayBillingTable();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to delete record");
                        }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(TransactionScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnComputeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComputeActionPerformed
        try {
            sql = DBCon.prepareStatement("SELECT SUM(product_price) AS total_product_price FROM billing");
            rs = sql.executeQuery();

            if (rs.next()) {
                totalProductPrice = rs.getDouble("total_product_price");

                if (!rs.wasNull()) {
                    DecimalFormat df = new DecimalFormat("#.##");
                    String formattedTotalPrice = df.format(totalProductPrice);

                    lblTotal.setText("Total Price: " + formattedTotalPrice);
                } else {
                    JOptionPane.showMessageDialog(null, "No data to be computed");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No data to be computed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
    }//GEN-LAST:event_btnComputeActionPerformed

    private void btnCancelTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelTransactionActionPerformed
        try {
            int answer = JOptionPane.showConfirmDialog(null, "Are you sure to cancel the current transaction?");

            if (answer == JOptionPane.YES_OPTION) {
                btnCancel.doClick();

                lblChange.setText("Change:");
                lblTotal.setText("Total Price:");

                sql = DBCon.prepareStatement("DELETE FROM billing");
                int rowsAffected = sql.executeUpdate();

                if (rowsAffected > 0) {
                    if (!DBCon.getAutoCommit()) {
                        DBCon.commit();
                    }

                    JOptionPane.showMessageDialog(null, "Transaction canceled successfully");
                } else {
                    if (!DBCon.getAutoCommit()) {
                        DBCon.rollback();
                    }

                    JOptionPane.showMessageDialog(null, "No records to delete");
                }
            }
        } catch (Exception e) {
            try {
                if (!DBCon.getAutoCommit()) {
                    try {
                        DBCon.rollback();
                    } catch (SQLException ex) {
                        ex.printStackTrace(); // Handle rollback exception
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(TransactionScreen.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
        displayBillingTable();
    }//GEN-LAST:event_btnCancelTransactionActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        try {
            String billCash = txtCash.getText();

            if (billCash.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Cash amount is required");
                return;
            }

            double cash;
            try {
                cash = Double.parseDouble(billCash);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid cash amount. Please enter a valid number.");
                return;
            }

            if (cash < 0) {
                JOptionPane.showMessageDialog(null, "Cash amount cannot be negative");
                return;
            }

            if (totalProductPrice == 0) {
                JOptionPane.showMessageDialog(null, "Required to compute all products first");
                return;
            }

            if (cash < totalProductPrice) {
                JOptionPane.showMessageDialog(null, "Cash amount is less than the total product price");
                return;
            }

            totalChange = cash - totalProductPrice;

            DecimalFormat df = new DecimalFormat("#.##");
            String formattedChange = df.format(totalChange);

            lblChange.setText("Change: " + formattedChange);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }

    }//GEN-LAST:event_btnPayActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuScreen MS = new MenuScreen();
        MS.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        txtSearch.setText("");
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        txtSearch.setText("Search for product name...");
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            String searchInfo = "%" + txtSearch.getText() + "%";
            sql = DBCon.prepareStatement("SELECT * FROM product WHERE product_name LIKE  '" + searchInfo + "' ");
            rs = sql.executeQuery();

            ResultSetMetaData data = rs.getMetaData();
            int columnCount = data.getColumnCount();

            DefaultTableModel tbRecord = (DefaultTableModel) tblProductList.getModel();
            tbRecord.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();

                for (int i = 1; i <= columnCount; i++) {
                    if ("product_name".equals(data.getColumnName(i))) {
                        columnData.add(rs.getString("product_name"));
                    } else if ("product_price".equals(data.getColumnName(i))) {
                        columnData.add(rs.getDouble("product_price"));
                    }
                }

                tbRecord.addRow(columnData);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceiptActionPerformed
        PrintReceipt PR = new PrintReceipt();
        PR.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnReceiptActionPerformed

    private void tblBillingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBillingMouseClicked
        try {
            int row = tblBilling.getSelectedRow();

            String productname = tblBilling.getModel().getValueAt(row, 0).toString();
            sql = DBCon.prepareStatement("SELECT * FROM billing WHERE product_name = ?");
            sql.setString(1, productname);
            rs = sql.executeQuery();

            if (rs.next()) {
                productNameList = rs.getString("product_name");

                if (rs.getObject("product_price") != null) {
                    productPriceList = rs.getDouble("product_price");
                } else {
                    JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
        }
    }//GEN-LAST:event_tblBillingMouseClicked

    private void tblBillingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblBillingFocusGained
    }//GEN-LAST:event_tblBillingFocusGained

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        tblProductList.clearSelection();
        tblBilling.clearSelection();
        txtQty.setText("");
        txtCash.setText("");
    }//GEN-LAST:event_btnCancelActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelTransaction;
    private javax.swing.JButton btnCompute;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnReceipt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblClerk;
    private javax.swing.JLabel lblClerkName;
    public javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoText;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTransaction;
    private javax.swing.JLabel lblUserLogo;
    public javax.swing.JTable tblBilling;
    private javax.swing.JTable tblProductList;
    private javax.swing.JTextField txtCash;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
