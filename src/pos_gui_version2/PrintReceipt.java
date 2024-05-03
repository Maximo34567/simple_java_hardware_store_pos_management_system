package pos_gui_version2;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrintReceipt extends javax.swing.JFrame {

    Connection DBCon = PosConn.DBConnection();
    PreparedStatement sql = null;
    ResultSet rs = null;

    public PrintReceipt() {
        initComponents();
        displayText();
        displayBillingData();
    }

    private void displayText() {
        String clerkName = LoginScreen.clerkName != null ? LoginScreen.clerkName : "";
        double totalChange = TransactionScreen.totalChange != 0.0 ? TransactionScreen.totalChange : 0.0;
        double totalProductPrice = TransactionScreen.totalProductPrice != 0.0 ? TransactionScreen.totalProductPrice : 0.0;

        lblClerk.setText("Clerk Name: " + clerkName);
        lblChange.setText("Change: " + totalChange);
        lblTotal.setText("Total Price: " + totalProductPrice);
    }

    private void displayBillingData() {
        try {
            sql = DBCon.prepareStatement("SELECT * FROM billing");
            rs = sql.executeQuery();

            pnlData.removeAll();
            pnlData.setLayout(new BoxLayout(pnlData, BoxLayout.Y_AXIS));

            int rowCount = 0;

            while (rs.next()) {
                String productName = rs.getString("product_name");
                double productPrice = rs.getDouble("product_price");
                int productQTY = rs.getInt("billing_qty");

                String formattedPrice = String.format("%.2f", productPrice);

                JLabel label = new JLabel("Product Name: " + productName + "     " + "Price: " + formattedPrice + "     " + "Qty: " +  productQTY);
                pnlData.add(label);

                rowCount++;
            }

            if (rowCount == 0) {
                JLabel noDataLabel = new JLabel("No billing data available");
                pnlData.add(noDataLabel);
            }

            pnlData.revalidate();
            pnlData.repaint();
            pnlData.requestFocusInWindow();  // Request focus for the panel

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while fetching billing data.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        pnlData = new javax.swing.JPanel();
        lblChange = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblClerk = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane3.setBorder(null);

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(pnlData);

        lblChange.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblChange.setText("Change:");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTotal.setText("Total Price:");

        lblClerk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblClerk.setText("Clerk Name:");

        btnBack.setText("BACK TO TRANSACTION");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblClerk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChange)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClerk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        TransactionScreen TS = new TransactionScreen();
        TS.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintReceipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblChange;
    private javax.swing.JLabel lblClerk;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlData;
    // End of variables declaration//GEN-END:variables
}
