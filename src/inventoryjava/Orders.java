/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventoryjava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Orders extends javax.swing.JFrame {

    
     public Orders() {
        initComponents();
        SelectProd();
        GetToday();
        SelectCust();
    }
    Connection Con=null;
    Statement St = null;
    ResultSet Rs = null;
public void SelectProd() {
    try {
        Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb","Nidhi","1234");
        St = Con.createStatement();
        Rs = St.executeQuery("select * from PRODUCTTBL");
        ProductTable.setModel(DbUtils.resultSetToTableModel(Rs));
    } catch (SQLException e){
        
    }
}
public void SelectCust() {
    try {
        Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb","Nidhi","1234");
        St = Con.createStatement();
        Rs = St.executeQuery("select * from CUSTOMERTBL");
        Customertable.setModel(DbUtils.resultSetToTableModel(Rs));
    } catch (SQLException e){
        
    }
}
private void GetToday() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    Datelbl.setText(dtf.format(now));
}
private void Update() {
    int newqty=olqty-Integer.valueOf(Qtytb.getText());
            try { 
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb","Nidhi","1234");
                String UpdateQuery = "update Nidhi.PRODUCTTBL set PRODQTY="+newqty+""+"where PRODID ="+productId;
                Statement Add = Con.createStatement();
                Add.executeUpdate(UpdateQuery);
                SelectProd();
                //JOptionPane.showMessageDialog(this, "Category Updated Successfully");
            }catch(SQLException e) 
            {
                e.printStackTrace();
            }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Customertable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        BillTbl = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BillId = new javax.swing.JTextField();
        Datelbl = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AddOrder = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        CustNamelbl = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Qtytb = new javax.swing.JTextField();
        AddToButton = new javax.swing.JButton();
        TotAmtlbl = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Price = new javax.swing.JTextField();
        Print = new javax.swing.JButton();
        TotAmtlbl1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ClearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Customertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CustomerId", "Name", "Phone Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Customertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomertableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Customertable);

        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductId", "Name", "Quantity", "Description", "Category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(ProductTable);

        BillTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Product", "Quantity", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(BillTbl);

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inventory Management System");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MANAGE ORDERS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(261, 261, 261))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(347, 347, 347))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(19, 19, 19))
        );

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("CUSTOMER LIST");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 0));
        jLabel4.setText("PRODUCT LIST");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("Customer Name");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setText("OrderId");

        BillId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillIdActionPerformed(evt);
            }
        });

        Datelbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatelblActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("Date");

        AddOrder.setBackground(new java.awt.Color(0, 153, 51));
        AddOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddOrder.setForeground(new java.awt.Color(255, 255, 255));
        AddOrder.setText("ADD ORDER");
        AddOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddOrderMouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("VIEW ORDERS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 153, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("HOME");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        CustNamelbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustNamelblActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setText("Quantity");

        Qtytb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QtytbActionPerformed(evt);
            }
        });

        AddToButton.setBackground(new java.awt.Color(0, 153, 51));
        AddToButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddToButton.setForeground(new java.awt.Color(255, 255, 255));
        AddToButton.setText("Add To Order");
        AddToButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddToButtonMouseClicked(evt);
            }
        });

        TotAmtlbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TotAmtlbl.setForeground(new java.awt.Color(0, 153, 51));
        TotAmtlbl.setText("      AMOUNT");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 0));
        jLabel10.setText("Price");

        Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceActionPerformed(evt);
            }
        });

        Print.setBackground(new java.awt.Color(0, 153, 51));
        Print.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Print.setForeground(new java.awt.Color(255, 255, 255));
        Print.setText("PRINT");
        Print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintMouseClicked(evt);
            }
        });

        TotAmtlbl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TotAmtlbl1.setForeground(new java.awt.Color(0, 153, 51));
        TotAmtlbl1.setText("RS");

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        ClearBtn.setBackground(new java.awt.Color(0, 153, 51));
        ClearBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(255, 255, 255));
        ClearBtn.setText("CLEAR");
        ClearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(188, 188, 188))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(Datelbl))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CustNamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BillId, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(AddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                            .addComponent(jScrollPane5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Qtytb, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(Price))
                                .addGap(18, 18, 18)
                                .addComponent(AddToButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TotAmtlbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotAmtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(BillId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(Qtytb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddToButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(CustNamelbl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Datelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddOrder)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(ClearBtn))
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TotAmtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TotAmtlbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(107, 107, 107))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void DatelblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatelblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DatelblActionPerformed

    private void BillIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillIdActionPerformed

    private void CustNamelblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustNamelblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustNamelblActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void QtytbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QtytbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QtytbActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void CustomertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomertableMouseClicked
        DefaultTableModel model = (DefaultTableModel)Customertable.getModel();
        int Myindex = Customertable.getSelectedRow();
        //CustId.setText(model.getValueAt(Myindex, 0).toString());
        CustNamelbl.setText(model.getValueAt(Myindex, 1).toString());
        //CustPhone.setText(model.getValueAt(Myindex, 2).toString());
    }//GEN-LAST:event_CustomertableMouseClicked
int flag=0,productId,olqty;
    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
         DefaultTableModel model = (DefaultTableModel)ProductTable.getModel();
        int Myindex = ProductTable.getSelectedRow();
        productId= Integer.valueOf(model.getValueAt(Myindex, 0).toString());
        ProdName=model.getValueAt(Myindex, 1).toString();
        olqty= Integer.valueOf(model.getValueAt(Myindex, 2).toString());
        //ProdDesc.setText(model.getValueAt(Myindex, 3).toString());
        flag=1;
    }//GEN-LAST:event_ProductTableMouseClicked
int i=1,UPrice,total,tot=0;
String ProdName;

    private void AddToButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddToButtonMouseClicked
        if(flag==0||Qtytb.getText().isEmpty()||Price.getText().isEmpty()){
        JOptionPane.showMessageDialog(this, "Select Product And Enter Quantity");
    }
        else {
        UPrice = Integer.valueOf(Price.getText());
        tot=UPrice*Integer.valueOf(Qtytb.getText());
        Vector v = new Vector();
        v.add(i);
        v.add(ProdName);
        v.add(Qtytb.getText());
        v.add(UPrice);
        v.add(tot);
        DefaultTableModel dt = (DefaultTableModel)BillTbl.getModel();
        dt.addRow(v);
        total = tot+total;
        TotAmtlbl.setText(""+total);
        Update();
        i++;
        
                }
    }//GEN-LAST:event_AddToButtonMouseClicked

    private void PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceActionPerformed

    private void PrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintMouseClicked
        try{
            BillTbl.print();
        } catch(Exception exp) {
            exp.printStackTrace();
        }
    }//GEN-LAST:event_PrintMouseClicked

    private void AddOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddOrderMouseClicked
        if(BillId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Enter Bill ID");
        }
        else {
            try {
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Inventorydb","Nidhi","1234");
            PreparedStatement add = Con.prepareStatement("insert into ORDERTBL values(?,?,?,?)");
            add.setInt(1, Integer.valueOf(BillId.getText()));
            add.setString(2, CustNamelbl.getText());
            add.setString(3, Datelbl.getText());
            add.setInt(4, Integer.valueOf(TotAmtlbl.getText()));
            int row = add.executeUpdate(); 
            JOptionPane.showMessageDialog(this,"Order Successfully Added");
            Con.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        }
        
    }//GEN-LAST:event_AddOrderMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        new HomeForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        BillId.setText("");
        CustNamelbl.setText("");
        Qtytb.setText("");
        Price.setText("");
    }//GEN-LAST:event_ClearBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Orders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddOrder;
    private javax.swing.JButton AddToButton;
    private javax.swing.JTextField BillId;
    private javax.swing.JTable BillTbl;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JTextField CustNamelbl;
    private javax.swing.JTable Customertable;
    private javax.swing.JTextField Datelbl;
    private javax.swing.JTextField Price;
    private javax.swing.JButton Print;
    private javax.swing.JTable ProductTable;
    private javax.swing.JTextField Qtytb;
    private javax.swing.JTextField TotAmtlbl;
    private javax.swing.JTextField TotAmtlbl1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
