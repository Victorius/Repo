/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinProject_07_08;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Anastasiia
 */
public class MainPanel extends javax.swing.JPanel {

    private ResultSet mod = null;
    private SqlQueryClass  sqlClass = null;
    
    public MainPanel() {
        initComponents();
        sqlClass = new SqlQueryClass("historical_data", "root", "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        mainTabPanel = new javax.swing.JTabbedPane();
        grTabPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        optionTabPanel = new javax.swing.JPanel();
        mainBtn = new javax.swing.JButton();
        infoTextArea = new javax.swing.JScrollPane();
        optionInfoText = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        resultOptionText = new javax.swing.JTextField();
        resetBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField3 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        dateLbl = new javax.swing.JLabel();
        initPriceText = new javax.swing.JTextField();
        initPLbl = new javax.swing.JLabel();
        date2Chooser = new com.toedter.calendar.JDateChooser();
        toLbl = new javax.swing.JLabel();
        date1Chooser = new com.toedter.calendar.JDateChooser();
        fromLbl = new javax.swing.JLabel();
        volatLbl = new javax.swing.JLabel();
        volatilText = new javax.swing.JTextField();
        volatBtn = new javax.swing.JButton();
        riskLbl1 = new javax.swing.JLabel();
        riskLbl = new javax.swing.JLabel();
        intRateText1 = new javax.swing.JTextField();
        intRateText = new javax.swing.JTextField();
        strikeLbl = new javax.swing.JLabel();
        strPriceText = new javax.swing.JTextField();
        curPairPanel = new javax.swing.JPanel();

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        mainTabPanel.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        mainTabPanel.setAutoscrolls(true);
        mainTabPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        grTabPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        grTabPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Building Graphs");
        grTabPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 60));

        jButton1.setText("Load the data");
        grTabPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 140, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        grTabPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 340, 30));

        jButton2.setText("Show graph ");
        grTabPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 140, 50));

        mainTabPanel.addTab("Building Graphs", grTabPanel);

        optionTabPanel.setBackground(new java.awt.Color(255, 255, 255));
        optionTabPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        optionTabPanel.setForeground(new java.awt.Color(255, 255, 255));
        optionTabPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        optionTabPanel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        optionTabPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainBtn.setText("Option Calculating");
        mainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainBtnActionPerformed(evt);
            }
        });
        optionTabPanel.add(mainBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 170, 50));

        infoTextArea.setBackground(new java.awt.Color(0, 51, 51));

        optionInfoText.setEditable(false);
        optionInfoText.setColumns(20);
        optionInfoText.setRows(5);
        optionInfoText.setText("European Call\n\nEuropean Call option \nis");
        optionInfoText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoTextArea.setViewportView(optionInfoText);

        optionTabPanel.add(infoTextArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 150, 280));

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setText("RESULTED OPTION PRICE:");
        optionTabPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 260, 30));

        resultOptionText.setEditable(false);
        optionTabPanel.add(resultOptionText, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 200, 30));

        resetBtn.setText("Reset data");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        optionTabPanel.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 180, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("CURRENCY PAIR:");
        optionTabPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 190, 30));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("European Call");
        optionTabPanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 130, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("OPTION TYPE:");
        optionTabPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 30));
        optionTabPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 710, 20));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("EUR/GBP");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        optionTabPanel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 130, -1));

        jToggleButton1.setText("Input Data for option pricing");
        optionTabPanel.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 150, 70));
        optionTabPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 710, 10));

        dateLbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        dateLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dateLbl.setLabelFor(date1Chooser);
        dateLbl.setText("Date:");
        optionTabPanel.add(dateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 50, 20));
        optionTabPanel.add(initPriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 120, -1));

        initPLbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        initPLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        initPLbl.setLabelFor(initPriceText);
        initPLbl.setText("Initial Price:");
        optionTabPanel.add(initPLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 80, 20));

        date2Chooser.setBackground(new java.awt.Color(204, 204, 204));
        optionTabPanel.add(date2Chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 150, -1));

        toLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        toLbl.setText("to");
        optionTabPanel.add(toLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 20, 20));

        date1Chooser.setBackground(new java.awt.Color(153, 153, 153));
        date1Chooser.setAutoscrolls(true);
        date1Chooser.setMaxSelectableDate(new java.util.Date(1420074119000L));
        date1Chooser.setMinSelectableDate(new java.util.Date(978310919000L));
        optionTabPanel.add(date1Chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 120, 20));

        fromLbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fromLbl.setText("from");
        optionTabPanel.add(fromLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 30, 20));

        volatLbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        volatLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        volatLbl.setLabelFor(volatilText);
        volatLbl.setText("Volatility:");
        optionTabPanel.add(volatLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 70, 20));

        volatilText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volatilTextActionPerformed(evt);
            }
        });
        optionTabPanel.add(volatilText, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 120, -1));

        volatBtn.setText("Calculate Volatility");
        volatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volatBtnActionPerformed(evt);
            }
        });
        optionTabPanel.add(volatBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 150, 30));

        riskLbl1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        riskLbl1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        riskLbl1.setText("Risk-free rate(foreign currency):");
        optionTabPanel.add(riskLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 240, 20));

        riskLbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        riskLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        riskLbl.setText("Risk-free rate(domestic currency):");
        optionTabPanel.add(riskLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 260, 20));
        optionTabPanel.add(intRateText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 120, -1));
        optionTabPanel.add(intRateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 120, -1));

        strikeLbl.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        strikeLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        strikeLbl.setText("Strike Price:");
        optionTabPanel.add(strikeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 180, 20));
        optionTabPanel.add(strPriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 120, -1));

        curPairPanel.setBackground(new java.awt.Color(204, 255, 204));
        curPairPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        optionTabPanel.add(curPairPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        mainTabPanel.addTab("Calculating Option Prices", optionTabPanel);

        add(mainTabPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        date1Chooser.setDate(null);
        date2Chooser.setDate(null);
        initPriceText.setText("");
        volatilText.setText("");
        intRateText.setText("");
        strPriceText.setText("");
        resultOptionText.setText("");
        //userInfoLbl.setText("");
        optionInfoText.setText("");
    }//GEN-LAST:event_resetBtnActionPerformed

  private void mainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainBtnActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_mainBtnActionPerformed

  private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField3ActionPerformed

  private void volatilTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volatilTextActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_volatilTextActionPerformed

  private void volatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volatBtnActionPerformed
    SimpleDateFormat dateFormatted = new SimpleDateFormat("yyyyMMdd");// format in db

    Date date1 = null;
    Date date2 = null;
    boolean formatted = false;
    String fromDate = "";
    String toDate = "";

    try{
      date1 = date1Chooser.getDate();
      date2 = date2Chooser.getDate();
      fromDate = dateFormatted.format(date1);
      toDate = dateFormatted.format(date2);
      formatted = true;
    }
    catch(NullPointerException e){
      formatted = false;
    }
    if(formatted){
      // if
      //mod = sqlClass.getClPrice_EurGbp(fromDate);

    }

  }//GEN-LAST:event_volatBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel curPairPanel;
    private com.toedter.calendar.JDateChooser date1Chooser;
    private com.toedter.calendar.JDateChooser date2Chooser;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel fromLbl;
    private javax.swing.JPanel grTabPanel;
    private javax.swing.JScrollPane infoTextArea;
    private javax.swing.JLabel initPLbl;
    private javax.swing.JTextField initPriceText;
    private javax.swing.JTextField intRateText;
    private javax.swing.JTextField intRateText1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton mainBtn;
    private javax.swing.JTabbedPane mainTabPanel;
    private javax.swing.JTextArea optionInfoText;
    private javax.swing.JPanel optionTabPanel;
    private javax.swing.JButton resetBtn;
    private javax.swing.JTextField resultOptionText;
    private javax.swing.JLabel riskLbl;
    private javax.swing.JLabel riskLbl1;
    private javax.swing.JTextField strPriceText;
    private javax.swing.JLabel strikeLbl;
    private javax.swing.JLabel toLbl;
    private javax.swing.JButton volatBtn;
    private javax.swing.JLabel volatLbl;
    private javax.swing.JTextField volatilText;
    // End of variables declaration//GEN-END:variables
}
