/*
 * Date: 7/25/2013
 * Author: Anastasiia
 */
package finproject_23;

import PairHandlers.CommonHandlerForPair;
import handlersOption.CommonHandler;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author 1210081
 */
public class OptionPanel extends javax.swing.JPanel {

  /**
   * Creates new form OptionPanel
   */
  private SqlQueryClass  sqlClass = null;
  private VolatilityCalc volCalc = new VolatilityCalc(); // declare parametr of class
  private EuropeanOptionsClass eurClass = null;
  private ForwardFuturesOptionClass forFutClass = null;
  private CommonHandlerForPair pairHandler=new CommonHandlerForPair();
  private CommonHandler optionHandler = new CommonHandler();
  private int daysCount; // for maturity time
  
  public OptionPanel() {
    initComponents();
    
    
    date1Choice.setDate(Calendar.getInstance().getTime());
  }
  
  public void SetOptions(Object parametres){
      if(parametres instanceof SqlQueryClass){
          this.sqlClass=(SqlQueryClass)parametres;
          this.pairHandler.setDBConn(sqlClass.getDB());
      }else if(parametres instanceof VolatilityCalc){
          this.volCalc=(VolatilityCalc)parametres;
      }else if(parametres instanceof EuropeanOptionsClass){
          this.eurClass = (EuropeanOptionsClass)parametres;
      }else if(parametres instanceof ForwardFuturesOptionClass){
          this.forFutClass = (ForwardFuturesOptionClass)parametres;
      }
  }
  
  public void setPairH(CommonHandlerForPair ch){
      this.pairHandler=ch;
  }
  public void setOptionH(CommonHandler ch){
      this.optionHandler=ch;
  }
  
  public void changePairName(String text){
      this.curPairText.setText(text);
  }
  
  public void changeOptionName(String text){
      this.optTypeText.setText(text);
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabPane = new javax.swing.JTabbedPane();
        optionTabPanel = new javax.swing.JPanel();
        resPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        optPriceText = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        curPairPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        curPairText = new javax.swing.JTextField();
        inputBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        optTypeText = new javax.swing.JTextField();
        resetBtn = new javax.swing.JButton();
        opPanel = new javax.swing.JPanel();
        date2Choice = new com.toedter.calendar.JDateChooser();
        date1Choice = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        volatBtn = new javax.swing.JButton();
        optPriceBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        initPriceText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        volText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dayCountText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        r1Text = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        r2Text = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoTextArea = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        strikePrText = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        grTabPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.BorderLayout());

        mainTabPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        optionTabPanel.setBackground(new java.awt.Color(255, 255, 255));
        optionTabPanel.setLayout(new java.awt.BorderLayout());

        resPanel.setBackground(new java.awt.Color(255, 255, 255));
        resPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        resPanel.setPreferredSize(new java.awt.Dimension(552, 50));
        resPanel.setLayout(new java.awt.GridLayout(1, 3, 4, 5));

        jLabel3.setBackground(new java.awt.Color(153, 255, 204));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("OPTION PRICE:");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        resPanel.add(jLabel3);

        optPriceText.setEditable(false);
        optPriceText.setBackground(new java.awt.Color(204, 255, 255));
        optPriceText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        optPriceText.setForeground(new java.awt.Color(0, 0, 102));
        optPriceText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        optPriceText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        resPanel.add(optPriceText);

        saveBtn.setBackground(new java.awt.Color(255, 255, 255));
        saveBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        saveBtn.setText("SAVE PRICE");
        saveBtn.setActionCommand("save");
        saveBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resPanel.add(saveBtn);

        optionTabPanel.add(resPanel, java.awt.BorderLayout.SOUTH);

        curPairPanel.setBackground(new java.awt.Color(204, 204, 255));
        curPairPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        curPairPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        curPairPanel.setPreferredSize(new java.awt.Dimension(552, 70));
        curPairPanel.setLayout(new java.awt.GridLayout(2, 3, 8, 10));

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("CURRENCY PAIR:");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPairPanel.add(jLabel1);

        curPairText.setEditable(false);
        curPairText.setBackground(new java.awt.Color(255, 255, 255));
        curPairText.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        curPairText.setForeground(new java.awt.Color(0, 51, 51));
        curPairText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curPairText.setText("EUR/GBP");
        curPairPanel.add(curPairText);

        inputBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        inputBtn.setText("INPUT DATA");
        inputBtn.setActionCommand("input");
        inputBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        curPairPanel.add(inputBtn);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("OPTION TYPE:");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPairPanel.add(jLabel2);

        optTypeText.setEditable(false);
        optTypeText.setBackground(new java.awt.Color(255, 255, 255));
        optTypeText.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        optTypeText.setForeground(new java.awt.Color(0, 51, 51));
        optTypeText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        optTypeText.setText("EUROPEAN CALL");
        curPairPanel.add(optTypeText);

        resetBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resetBtn.setText("RESET DATA");
        resetBtn.setActionCommand("reset");
        resetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        curPairPanel.add(resetBtn);

        optionTabPanel.add(curPairPanel, java.awt.BorderLayout.NORTH);

        opPanel.setBackground(new java.awt.Color(204, 204, 255));
        opPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        opPanel.setPreferredSize(new java.awt.Dimension(552, 100));
        opPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date2Choice.setBackground(new java.awt.Color(153, 153, 153));
        date2Choice.setAutoscrolls(true);
        date2Choice.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        date2Choice.setMaxSelectableDate(new java.util.Date(1420074119000L));
        date2Choice.setMinSelectableDate(new java.util.Date(978483719000L));
        date2Choice.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                date2ChoiceInputMethodTextChanged(evt);
            }
        });
        opPanel.add(date2Choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 110, 20));

        date1Choice.setBackground(new java.awt.Color(153, 153, 153));
        date1Choice.setAutoscrolls(true);
        date1Choice.setDate(Calendar.getInstance().getTime());
        date1Choice.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        date1Choice.setMaxSelectableDate(new java.util.Date(1420074119000L));
        date1Choice.setMinSelectableDate(new java.util.Date(978483719000L));
        opPanel.add(date1Choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Select dates of option:");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        opPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("-");
        opPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 60, 10, 20));

        volatBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        volatBtn.setForeground(new java.awt.Color(0, 0, 51));
        volatBtn.setText("Calculate Volatility");
        volatBtn.setActionCommand("calcVol");
        volatBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volatBtnActionPerformed(evt);
            }
        });
        opPanel.add(volatBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 240, 50));

        optPriceBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        optPriceBtn.setForeground(new java.awt.Color(0, 0, 51));
        optPriceBtn.setText("Evaluate Option Price");
        optPriceBtn.setActionCommand("calcPrice");
        optPriceBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        optPriceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optPriceBtnActionPerformed(evt);
            }
        });
        opPanel.add(optPriceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 200, 50));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Stock Price:");
        opPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, 20));

        initPriceText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        opPanel.add(initPriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 110, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Volatility:");
        opPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 90, 20));

        volText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        volText.setText("0.0043");
        opPanel.add(volText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 110, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Maturity time:");
        opPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, 20));

        dayCountText.setEditable(false);
        dayCountText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        opPanel.add(dayCountText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 110, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Risk-free rate");
        opPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 130, 20));

        r1Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r1Text.setText("0.03");
        opPanel.add(r1Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 80, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Risk-free rate");
        opPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 110, 20));

        r2Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r2Text.setText("0.04");
        opPanel.add(r2Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 80, -1));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detailed Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 14), new java.awt.Color(51, 0, 0))); // NOI18N

        infoTextArea.setEditable(false);
        infoTextArea.setColumns(16);
        infoTextArea.setRows(5);
        infoTextArea.setText("\nEuropean Call Option\n is an option of:");
        jScrollPane1.setViewportView(infoTextArea);

        opPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 200, 250));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Strike price:");
        opPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        strikePrText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        strikePrText.setText("0.644");
        opPanel.add(strikePrText, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 80, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        opPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 0, 10, 320));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        opPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 10, 320));

        jLabel12.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel12.setText("domestic currency:");
        opPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel13.setText("foreign currency:");
        opPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 130, 20));

        optionTabPanel.add(opPanel, java.awt.BorderLayout.CENTER);

        mainTabPane.addTab("Option Pricing", optionTabPanel);

        javax.swing.GroupLayout grTabPanelLayout = new javax.swing.GroupLayout(grTabPanel);
        grTabPanel.setLayout(grTabPanelLayout);
        grTabPanelLayout.setHorizontalGroup(
            grTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        grTabPanelLayout.setVerticalGroup(
            grTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        mainTabPane.addTab("Ghaph representation", grTabPanel);

        add(mainTabPane, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void optPriceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optPriceBtnActionPerformed
        double inPrice = Double.parseDouble(initPriceText.getText());
        double vol = Double.parseDouble(volText.getText());
        double r1 = Double.parseDouble(r1Text.getText());
        double r2 = Double.parseDouble(r2Text.getText());
        double strPr = Double.parseDouble(strikePrText.getText());
        int days = Integer.parseInt(dayCountText.getText());
        System.out.println("init Price " + inPrice + " volat " + vol + " risk dom + " + r1 + " risk for + " + r2 +
                           " strike " + strPr + " days " + days);
        
        // if input are numbers not string
        try{
        // if europ call
        //if (optTypeText.getText().equalsIgnoreCase("European Call")){
        // call European Call and display in optionprice result text field
        optPriceText.setText(String.valueOf(eurClass.europCall(days,inPrice, vol, r1, r2, strPr)));
        }
        catch(NumberFormatException e){
              JOptionPane.showMessageDialog(null, "Input proper double values", "Error", JOptionPane.ERROR);
        }

        //}
        //else if (optTypeText.getText().equalsIgnoreCase("European Put")){
            // european put
        //optPriceText.setText(String.valueOf(eurClass.europPut(days,inPrice, vol, r1, r2, strPr)));    
        //}
        //else if(optTypeText.getText().equalsIgnoreCase("Futures options")){
         //optPriceText.setText(String.valueOf(forFutClass.getFuturesOpPrice(days, r1, r2, inPrice)));  
        //}else if(optTypeText.getText().equalsIgnoreCase("Forwards options")){
         //optPriceText.setText(String.valueOf(forFutClass.getForwardPrice(days, r1, r2, strPr)));  
        //}
        
        
    }//GEN-LAST:event_optPriceBtnActionPerformed

    private void volatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volatBtnActionPerformed
      if(date2Choice.getDate()!=null){
      SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");  
      boolean formatted = false;
      String fromDate = format.format(date1Choice.getDate()); // format in Db
      String toDate = format.format(date2Choice.getDate());// format in Db
      int daysCount =  (int) ((date2Choice.getDate().getTime() - date1Choice.getDate().getTime()) / (1000*60*60*24));
      dayCountText.setText(String.valueOf(daysCount));
      try{
          initPriceText.setText((String)this.pairHandler.getClosePrice(fromDate));
          volCalc.calculateVolatility(daysCount, this.pairHandler.getClosePrice(fromDate,toDate), daysCount);
      }catch(SQLException e){
        e.printStackTrace();
      }
      
//    if (formatted){
//        int daysCount =  (int) ((date2.getTime() - date1.getTime()) / (1000*60*60*24));
//        dayCountText.setText(String.valueOf(daysCount));
//        if(sqlClass!=null){
//            System.out.println(sqlClass.getClPrice_EurGbp(fromDate));
//            initPriceText.setText(sqlClass.getClPrice_EurGbp(fromDate));
//        }else{
////            sqlClass = new SqlQueryClass("","","");
//        }
//            
//        
//        ArrayList<Float> stockPrices = new ArrayList<Float>();
//        if(sqlClass!=null){
//            stockPrices = sqlClass.getDataforVol_EurGbp(fromDate); // for array
//            System.out.println(stockPrices.toArray());
//            volCalc.calculateVolatility(daysCount, stockPrices, daysCount);
//        }
//      }
    }else{
          JOptionPane.showMessageDialog(null, "Choice end of date period","Error", JOptionPane.ERROR_MESSAGE);
      }
   
    }//GEN-LAST:event_volatBtnActionPerformed

    private void date2ChoiceInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_date2ChoiceInputMethodTextChanged
        //Date d1 = date1Choice.getDate();
        //Date d2 = date2Choice.getDate();
        //daysCount =  (int) ((d2.getTime() - d1.getTime()) / (1000*60*60*24));
        //
        dayCountText.setText(String.valueOf(daysCount));
    }//GEN-LAST:event_date2ChoiceInputMethodTextChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel curPairPanel;
    private javax.swing.JTextField curPairText;
    private com.toedter.calendar.JDateChooser date1Choice;
    private com.toedter.calendar.JDateChooser date2Choice;
    private javax.swing.JTextField dayCountText;
    private javax.swing.JPanel grTabPanel;
    private javax.swing.JTextArea infoTextArea;
    private javax.swing.JTextField initPriceText;
    private javax.swing.JButton inputBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane mainTabPane;
    private javax.swing.JPanel opPanel;
    private javax.swing.JButton optPriceBtn;
    private javax.swing.JTextField optPriceText;
    private javax.swing.JTextField optTypeText;
    private javax.swing.JPanel optionTabPanel;
    private javax.swing.JTextField r1Text;
    private javax.swing.JTextField r2Text;
    private javax.swing.JPanel resPanel;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField strikePrText;
    private javax.swing.JTextField volText;
    private javax.swing.JButton volatBtn;
    // End of variables declaration//GEN-END:variables
}
