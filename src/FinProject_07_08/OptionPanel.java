/*
 * DATE: 23/08/2013
 * Option Panel Class
 */

package FinProject_07_08;

import PairHandlers.*;
import handlersOption.*;
import helpful_package.Checker;
import helpful_package.SecondChecker;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Anastasiia
 */

public class OptionPanel extends javax.swing.JPanel {

  /**
   * Creates new form OptionPanel
   */
  private SqlQueryClass  sqlClass = null;
  private VolatilityCalc volCalc = new VolatilityCalc(); // declare parametr of class
  
  private CommonHandlerForPair pairHandler=null;
  private CommonHandler optionHandler =  new EuropeanOption();
  private int daysCount; // for maturity time
  private boolean flag = true;
  private boolean changedDate = false;
  private Checker thread = new Checker(this);
  private ChartPanel panel = new ChartPanel(null);
  private MainWinFrame parent = null;
  
  public OptionPanel(MainWinFrame frame) {
      initComponents();
      date1Choice.setDate(Calendar.getInstance().getTime());
      parent = frame;
//      Thread gh = new Thread(thread);
//      gh.start();
//      SecondChecker sc = new SecondChecker(gh,thread);
//      Thread gh2 =new Thread(sc);
//      gh2.start();
//      DefaultPieDataset dataset = new DefaultPieDataset();
//      dataset.setValue("Category 1", 43.2);
//      dataset.setValue("Category 2", 27.9);
//      dataset.setValue("Category 3", 79.5);
//      JFreeChart chart = ChartFactory.createPieChart(
//        "Sample Pie Chart",
//        dataset,
//        true, // legend?
//        true, // tooltips?
//        false // URLs?
//      );
//      panel = new ChartPanel(chart);
      graphPanel.add(panel);
  }
  
  /**
   * Method is about checking the correct period of chosen time
   * @return boolean
   */
  public boolean getFlag(){
      return changedDate;
  }
  /**
   * Method is about checking the correct period of chosen time
   * @param flag 
   */
  public void setFlag(boolean flag){
      changedDate = flag;
  }
  
  public com.toedter.calendar.JDateChooser getDate(boolean firstOrSecond){
      if(firstOrSecond)
          return this.date1Choice;
      else
          return this.date2Choice;
  }
  
  public void SetOptions(Object parametres){
      if(parametres instanceof SqlQueryClass){
          this.sqlClass=(SqlQueryClass)parametres;
          if(this.pairHandler==null)
              this.pairHandler=new EURGBP(sqlClass.getDB());
          this.pairHandler.setDBConn(sqlClass.getDB());
      }else if(parametres instanceof VolatilityCalc){
          this.volCalc=(VolatilityCalc)parametres;
      }else if(parametres instanceof Boolean){
          this.flag = (boolean)parametres;
      }
  }
  
  public void setPairH(CommonHandlerForPair ch){
      this.pairHandler=ch;
  }
  public void setOptionH(CommonHandler ch){
      this.optionHandler=ch;
  }
  
  public void changePairName(String text){
      if(!this.curPairText.getText().equals(text)){
          this.optPriceText.setText("");
          dayCountText.setText("");
          initPriceText.setText("");
          this.curPairText.setText(text);
      }
      
      
  }
  
  public void changeOptionName(String text){
      this.optTypeText.setText(text);
  }
  
  public void setCountOsDays(Integer count){
      if(this.pairHandler.getCurrpair().length()>0)
        dayCountText.setText(String.valueOf(count));
  }
  
  public void setInfoAboutOption(String text){
      infoTextArea.setText(text);
  }
  
  public void setStockPrice(){
    if(this.pairHandler.getCurrpair().length()>0){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String fromDate = format.format(date1Choice.getDate()); // format in Db
        
        try {            
            String t = this.pairHandler.getClosePrice(fromDate);
        } catch (SQLException ex) {
  //          Logger.getLogger(OptionPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Some problems in second thread");
        }
        
    }
  }
  
  public boolean canICalculateOption(){
      try{
          Double x = Double.parseDouble(r1Text.getText());
                 x = Double.parseDouble(r2Text.getText());
                 x = Double.parseDouble(strikePriceText.getText());
                 x = Double.parseDouble(volText.getText());
          
          return true&&canICalculateVol();
      }catch(NumberFormatException e){
          return false;
      }
  }
  
  public boolean canICalculateVol(){
      try{
          Double x = Double.parseDouble(initPriceText.getText());
                 x = Double.parseDouble(dayCountText.getText());
          return true;
      }catch(NumberFormatException e){
          return false;
      }
  }
  
  // to pass the last selected currency pair to the second pane
  public void setRadioButton(){
          if(this.pairHandler.getCurrpair().equals("EUR/GBP"))
            this.recalculateBtn.setSelected(true);
      else if(this.pairHandler.getCurrpair().equals("EUR/JPY"))
            this.EurJpyRadBtn.setSelected(true);
      else if(this.pairHandler.getCurrpair().equals("EUR/USD"))
            this.EurUsdRadBtn.setSelected(true);
      else if(this.pairHandler.getCurrpair().equals("GBP/JPY"))
            this.GbpJpyRadBtn.setSelected(true);
      else if(this.pairHandler.getCurrpair().equals("GBP/USD"))
            this.GbpUsdRadBtn.setSelected(true);
      else if(this.pairHandler.getCurrpair().equals("USD/JPY"))
            this.UsdJpyRadBtn.setSelected(true);
  }
  
  public void setClearFields(){
      this.dayCountText.setText("");
      this.initPriceText.setText("");
  }
  
  
  
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        optBtnGr = new javax.swing.ButtonGroup();
        curBtnGrp = new javax.swing.ButtonGroup();
        mainTabPane = new javax.swing.JTabbedPane();
        optionTabPanel = new javax.swing.JPanel();
        curPairPanel = new javax.swing.JPanel();
        curPairChLbl = new javax.swing.JLabel();
        curPairText = new javax.swing.JTextField();
        emptyLbl = new javax.swing.JLabel();
        optTypeChLbl = new javax.swing.JLabel();
        optTypeText = new javax.swing.JTextField();
        resetBtn = new javax.swing.JButton();
        opPanel = new javax.swing.JPanel();
        date2Choice = new com.toedter.calendar.JDateChooser();
        date1Choice = new com.toedter.calendar.JDateChooser();
        selectDateLbl = new javax.swing.JLabel();
        dashLbl = new javax.swing.JLabel();
        volatBtn = new javax.swing.JButton();
        optPriceBtn = new javax.swing.JButton();
        stPriceLbl = new javax.swing.JLabel();
        initPriceText = new javax.swing.JTextField();
        volatLbl = new javax.swing.JLabel();
        volText = new javax.swing.JTextField();
        matTimeLbl = new javax.swing.JLabel();
        dayCountText = new javax.swing.JTextField();
        r1Lbl = new javax.swing.JLabel();
        r1Text = new javax.swing.JTextField();
        r2Lbl = new javax.swing.JLabel();
        r2Text = new javax.swing.JTextField();
        infoPane = new javax.swing.JScrollPane();
        infoTextArea = new javax.swing.JTextArea();
        strikePrLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        r1Lbl1 = new javax.swing.JLabel();
        r2Lbl1 = new javax.swing.JLabel();
        buyOptRadBtn = new javax.swing.JRadioButton();
        sellOptRadBtn = new javax.swing.JRadioButton();
        resPanel = new javax.swing.JPanel();
        resOptPriceLbl = new javax.swing.JLabel();
        optPriceText = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        strikePriceText = new javax.swing.JTextField();
        tradOptTabPanel = new javax.swing.JPanel();
        tradedPanel = new javax.swing.JPanel();
        choiceCurPairLbl = new javax.swing.JLabel();
        EurGbpRadBtn = new javax.swing.JRadioButton();
        EurJpyRadBtn = new javax.swing.JRadioButton();
        EurUsdRadBtn = new javax.swing.JRadioButton();
        GbpJpyRadBtn = new javax.swing.JRadioButton();
        GbpUsdRadBtn = new javax.swing.JRadioButton();
        UsdJpyRadBtn = new javax.swing.JRadioButton();
        currDateLbl = new javax.swing.JLabel();
        date3Choice = new com.toedter.calendar.JDateChooser();
        tradOptLbl = new javax.swing.JLabel();
        recalculateBtn = new javax.swing.JButton();
        trOptScrollPane = new javax.swing.JScrollPane();
        tradedOptTable = new javax.swing.JTable();
        curRate1Lbl = new javax.swing.JLabel();
        curRate2Lbl = new javax.swing.JLabel();
        curClosePrLbl = new javax.swing.JLabel();
        curClosePrLbl1 = new javax.swing.JLabel();
        curRate1Text = new javax.swing.JTextField();
        curRate2Text = new javax.swing.JTextField();
        curClPriceText = new javax.swing.JTextField();
        curVolatLbl = new javax.swing.JLabel();
        curVolatText = new javax.swing.JTextField();
        totValueLbl = new javax.swing.JLabel();
        totalCashLbl = new javax.swing.JLabel();
        totDeltaLbl = new javax.swing.JLabel();
        totValueText = new javax.swing.JTextField();
        totalCashText = new javax.swing.JTextField();
        totDeltaText = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        graphPanel = new javax.swing.JPanel();
        contentGraphPanel = new javax.swing.JPanel();
        listOfGraphs = new javax.swing.JComboBox();
        buildGrBtn = new javax.swing.JButton();
        leftImageLbl = new javax.swing.JLabel();
        rightImageLbl = new javax.swing.JLabel();
        midImageLbl = new javax.swing.JLabel();

        jLabel14.setText("jLabel14");

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMinimumSize(new java.awt.Dimension(749, 639));
        setPreferredSize(new java.awt.Dimension(770, 720));
        setLayout(new java.awt.BorderLayout());

        mainTabPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mainTabPane.setMinimumSize(new java.awt.Dimension(763, 612));
        mainTabPane.setPreferredSize(new java.awt.Dimension(768, 612));

        optionTabPanel.setBackground(new java.awt.Color(255, 255, 255));
        optionTabPanel.setLayout(new java.awt.BorderLayout());

        curPairPanel.setBackground(new java.awt.Color(204, 204, 255));
        curPairPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        curPairPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        curPairPanel.setPreferredSize(new java.awt.Dimension(552, 100));
        curPairPanel.setLayout(new java.awt.GridLayout(2, 3, 8, 10));

        curPairChLbl.setBackground(new java.awt.Color(0, 51, 51));
        curPairChLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        curPairChLbl.setForeground(new java.awt.Color(0, 0, 51));
        curPairChLbl.setText("   CURRENCY PAIR:");
        curPairChLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPairPanel.add(curPairChLbl);

        curPairText.setEditable(false);
        curPairText.setBackground(new java.awt.Color(255, 255, 255));
        curPairText.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        curPairText.setForeground(new java.awt.Color(0, 51, 51));
        curPairText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curPairPanel.add(curPairText);
        curPairPanel.add(emptyLbl);

        optTypeChLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        optTypeChLbl.setForeground(new java.awt.Color(0, 0, 51));
        optTypeChLbl.setText("   OPTION TYPE:");
        optTypeChLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPairPanel.add(optTypeChLbl);

        optTypeText.setEditable(false);
        optTypeText.setBackground(new java.awt.Color(255, 255, 255));
        optTypeText.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        optTypeText.setForeground(new java.awt.Color(0, 51, 51));
        optTypeText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curPairPanel.add(optTypeText);

        resetBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resetBtn.setForeground(new java.awt.Color(0, 0, 51));
        resetBtn.setText("RESET DATA");
        resetBtn.setActionCommand("reset");
        resetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });
        curPairPanel.add(resetBtn);

        optionTabPanel.add(curPairPanel, java.awt.BorderLayout.NORTH);

        opPanel.setBackground(new java.awt.Color(204, 204, 255));
        opPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        opPanel.setPreferredSize(new java.awt.Dimension(552, 200));
        opPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date2Choice.setBackground(new java.awt.Color(153, 153, 153));
        date2Choice.setAutoscrolls(true);
        date2Choice.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        date2Choice.setMaxSelectableDate(new java.util.Date(1420074119000L));
        date2Choice.setMinSelectableDate(new java.util.Date(978483719000L));
        date2Choice.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                date2ChoiceInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        opPanel.add(date2Choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 110, 20));

        date1Choice.setBackground(new java.awt.Color(153, 153, 153));
        date1Choice.setAutoscrolls(true);
        date1Choice.setDate(Calendar.getInstance().getTime());
        date1Choice.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        date1Choice.setMaxSelectableDate(new java.util.Date(1420074119000L));
        date1Choice.setMinSelectableDate(new java.util.Date(978483719000L));
        opPanel.add(date1Choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, 20));

        selectDateLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        selectDateLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        selectDateLbl.setText("Select dates of option:");
        selectDateLbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        opPanel.add(selectDateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, 40));

        dashLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dashLbl.setText("-");
        opPanel.add(dashLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 10, 20));

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
        opPanel.add(volatBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 230, 50));

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
        opPanel.add(optPriceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 220, 50));

        stPriceLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        stPriceLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        stPriceLbl.setText("Stock Price:");
        opPanel.add(stPriceLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, 20));

        initPriceText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        opPanel.add(initPriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 110, 20));

        volatLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        volatLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        volatLbl.setText("Volatility:");
        opPanel.add(volatLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 90, 20));

        volText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        volText.setText("0.0043");
        opPanel.add(volText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 110, 20));

        matTimeLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        matTimeLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        matTimeLbl.setText("Maturity time:");
        opPanel.add(matTimeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 120, 20));

        dayCountText.setEditable(false);
        dayCountText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        opPanel.add(dayCountText, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 110, 20));

        r1Lbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        r1Lbl.setText("Risk-free rate");
        opPanel.add(r1Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 130, 20));

        r1Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r1Text.setText("0.03");
        opPanel.add(r1Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 80, 20));

        r2Lbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        r2Lbl.setText("Risk-free rate");
        opPanel.add(r2Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 110, 20));

        r2Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r2Text.setText("0.04");
        opPanel.add(r2Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 80, -1));

        infoPane.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detailed Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 14), new java.awt.Color(51, 0, 0))); // NOI18N

        infoTextArea.setEditable(false);
        infoTextArea.setColumns(16);
        infoTextArea.setRows(5);
        infoTextArea.setText("\nEuropean Call Option\n is an option of:");
        infoPane.setViewportView(infoTextArea);

        opPanel.add(infoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 220, 300));

        strikePrLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        strikePrLbl.setText("Strike price:");
        opPanel.add(strikePrLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        opPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 10, 420));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        opPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 10, 420));

        r1Lbl1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        r1Lbl1.setText("domestic currency:");
        opPanel.add(r1Lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, 20));

        r2Lbl1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        r2Lbl1.setText("foreign currency:");
        opPanel.add(r2Lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 130, 20));

        buyOptRadBtn.setBackground(new java.awt.Color(204, 204, 255));
        optBtnGr.add(buyOptRadBtn);
        buyOptRadBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buyOptRadBtn.setSelected(true);
        buyOptRadBtn.setText("Buy an option");
        opPanel.add(buyOptRadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 130, -1));

        sellOptRadBtn.setBackground(new java.awt.Color(204, 204, 255));
        optBtnGr.add(sellOptRadBtn);
        sellOptRadBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sellOptRadBtn.setText("Sell an option");
        opPanel.add(sellOptRadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 130, -1));

        resPanel.setBackground(new java.awt.Color(255, 255, 255));
        resPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        resPanel.setPreferredSize(new java.awt.Dimension(552, 70));
        resPanel.setLayout(new java.awt.GridLayout(1, 3, 4, 5));

        resOptPriceLbl.setBackground(new java.awt.Color(153, 255, 204));
        resOptPriceLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        resOptPriceLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resOptPriceLbl.setText("OPTION PRICE:");
        resOptPriceLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        resPanel.add(resOptPriceLbl);

        optPriceText.setEditable(false);
        optPriceText.setBackground(new java.awt.Color(204, 255, 255));
        optPriceText.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        optPriceText.setForeground(new java.awt.Color(0, 0, 102));
        optPriceText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        optPriceText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        resPanel.add(optPriceText);

        saveBtn.setBackground(new java.awt.Color(255, 255, 255));
        saveBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(0, 0, 51));
        saveBtn.setText("Save Price");
        saveBtn.setActionCommand("save");
        saveBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        resPanel.add(saveBtn);

        opPanel.add(resPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 756, -1));
        opPanel.add(strikePriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 80, -1));

        optionTabPanel.add(opPanel, java.awt.BorderLayout.CENTER);

        mainTabPane.addTab("Option Pricing", optionTabPanel);

        tradOptTabPanel.setPreferredSize(new java.awt.Dimension(761, 706));
        tradOptTabPanel.setLayout(new java.awt.BorderLayout());

        tradedPanel.setBackground(new java.awt.Color(255, 255, 255));
        tradedPanel.setPreferredSize(new java.awt.Dimension(761, 671));
        tradedPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        choiceCurPairLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        choiceCurPairLbl.setText("Choose the currency pair:");
        tradedPanel.add(choiceCurPairLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, 20));

        EurGbpRadBtn.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(EurGbpRadBtn);
        EurGbpRadBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        EurGbpRadBtn.setSelected(true);
        EurGbpRadBtn.setText("EUR/GBP");
        EurGbpRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EurGbpRadBtnActionPerformed(evt);
            }
        });
        tradedPanel.add(EurGbpRadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        EurJpyRadBtn.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(EurJpyRadBtn);
        EurJpyRadBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        EurJpyRadBtn.setText("EUR/JPY");
        EurJpyRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EurJpyRadBtnActionPerformed(evt);
            }
        });
        tradedPanel.add(EurJpyRadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        EurUsdRadBtn.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(EurUsdRadBtn);
        EurUsdRadBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        EurUsdRadBtn.setText("EUR/USD");
        EurUsdRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EurUsdRadBtnActionPerformed(evt);
            }
        });
        tradedPanel.add(EurUsdRadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        GbpJpyRadBtn.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(GbpJpyRadBtn);
        GbpJpyRadBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        GbpJpyRadBtn.setText("GBP/JPY");
        GbpJpyRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GbpJpyRadBtnActionPerformed(evt);
            }
        });
        tradedPanel.add(GbpJpyRadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, -1));

        GbpUsdRadBtn.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(GbpUsdRadBtn);
        GbpUsdRadBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        GbpUsdRadBtn.setText("GBP/USD");
        GbpUsdRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GbpUsdRadBtnActionPerformed(evt);
            }
        });
        tradedPanel.add(GbpUsdRadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        UsdJpyRadBtn.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(UsdJpyRadBtn);
        UsdJpyRadBtn.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        UsdJpyRadBtn.setText("USD/JPY");
        UsdJpyRadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsdJpyRadBtnActionPerformed(evt);
            }
        });
        tradedPanel.add(UsdJpyRadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 80, -1));

        currDateLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        currDateLbl.setForeground(new java.awt.Color(0, 51, 51));
        currDateLbl.setText("Today's date");
        tradedPanel.add(currDateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 110, 20));

        date3Choice.setBackground(new java.awt.Color(153, 153, 153));
        date3Choice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date3Choice.setAutoscrolls(true);
        date3Choice.setDate(Calendar.getInstance().getTime());
        date3Choice.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        date3Choice.setMaxSelectableDate(new java.util.Date(1420074119000L));
        date3Choice.setMinSelectableDate(new java.util.Date(978483719000L));
        tradedPanel.add(date3Choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 100, 20));

        tradOptLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        tradOptLbl.setText("Traded Options Details:");
        tradedPanel.add(tradOptLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 170, 20));

        recalculateBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        recalculateBtn.setForeground(new java.awt.Color(0, 0, 51));
        recalculateBtn.setText("CALCULATE");
        recalculateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tradedPanel.add(recalculateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 230, 40));

        tradedOptTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Buy/Sell", "CurPair", "OptionType", "StrikePrice", "MaturTime", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        trOptScrollPane.setViewportView(tradedOptTable);

        tradedPanel.add(trOptScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 420, 30));

        curRate1Lbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        curRate1Lbl.setForeground(new java.awt.Color(0, 51, 51));
        curRate1Lbl.setText("Risk-free domestic rate");
        tradedPanel.add(curRate1Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        curRate2Lbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        curRate2Lbl.setForeground(new java.awt.Color(0, 51, 51));
        curRate2Lbl.setText("Risk-free foreign rate");
        tradedPanel.add(curRate2Lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        curClosePrLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        curClosePrLbl.setForeground(new java.awt.Color(0, 51, 51));
        curClosePrLbl.setText("Current currency pair");
        tradedPanel.add(curClosePrLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        curClosePrLbl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        curClosePrLbl1.setForeground(new java.awt.Color(0, 51, 51));
        curClosePrLbl1.setText(" exchange rate");
        tradedPanel.add(curClosePrLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 110, -1));
        tradedPanel.add(curRate1Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 100, -1));
        tradedPanel.add(curRate2Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 100, -1));
        tradedPanel.add(curClPriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 100, -1));

        curVolatLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        curVolatLbl.setForeground(new java.awt.Color(0, 51, 51));
        curVolatLbl.setText("Curent volatility");
        tradedPanel.add(curVolatLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));
        tradedPanel.add(curVolatText, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 100, -1));

        totValueLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totValueLbl.setForeground(new java.awt.Color(0, 102, 0));
        totValueLbl.setText("Total value");
        tradedPanel.add(totValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        totalCashLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalCashLbl.setForeground(new java.awt.Color(0, 102, 0));
        totalCashLbl.setText("Total cash");
        tradedPanel.add(totalCashLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, -1, -1));

        totDeltaLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totDeltaLbl.setForeground(new java.awt.Color(0, 102, 0));
        totDeltaLbl.setText("Total delta");
        tradedPanel.add(totDeltaLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, 20));
        tradedPanel.add(totValueText, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 110, -1));
        tradedPanel.add(totalCashText, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 110, -1));
        tradedPanel.add(totDeltaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, 110, -1));

        jSeparator3.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        tradedPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 10, 180));

        jSeparator4.setBackground(new java.awt.Color(102, 102, 102));
        tradedPanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 760, -1));

        jSeparator5.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        tradedPanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, 400));

        tradOptTabPanel.add(tradedPanel, java.awt.BorderLayout.NORTH);

        mainTabPane.addTab("Traded Options", tradOptTabPanel);

        graphPanel.setBackground(new java.awt.Color(255, 255, 255));
        graphPanel.setMinimumSize(new java.awt.Dimension(761, 50));
        graphPanel.setPreferredSize(new java.awt.Dimension(761, 671));
        graphPanel.setLayout(new java.awt.BorderLayout());

        contentGraphPanel.setBackground(new java.awt.Color(204, 204, 255));
        contentGraphPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contentGraphPanel.setForeground(new java.awt.Color(0, 51, 51));
        contentGraphPanel.setMinimumSize(new java.awt.Dimension(761, 150));
        contentGraphPanel.setPreferredSize(new java.awt.Dimension(761, 150));
        contentGraphPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listOfGraphs.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listOfGraphs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Historical data of exchange rates", "Historical volatility" }));
        listOfGraphs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentGraphPanel.add(listOfGraphs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 250, 30));

        buildGrBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buildGrBtn.setForeground(new java.awt.Color(0, 0, 51));
        buildGrBtn.setText("Build Graph");
        buildGrBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buildGrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildGrBtnActionPerformed(evt);
            }
        });
        contentGraphPanel.add(buildGrBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 160, 30));

        leftImageLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        leftImageLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SourceImage/4.jpg"))); // NOI18N
        contentGraphPanel.add(leftImageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 270, 150));

        rightImageLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rightImageLbl.setForeground(new java.awt.Color(255, 255, 255));
        rightImageLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SourceImage/4.jpg"))); // NOI18N
        contentGraphPanel.add(rightImageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 150));

        midImageLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SourceImage/4.jpg"))); // NOI18N
        midImageLbl.setText("jLabel31");
        contentGraphPanel.add(midImageLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 230, 150));

        graphPanel.add(contentGraphPanel, java.awt.BorderLayout.NORTH);

        mainTabPane.addTab("Graph representation", graphPanel);

        add(mainTabPane, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void optPriceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optPriceBtnActionPerformed
        if(this.optionHandler.getOptionName().length()>0 && canICalculateOption()){
            double inPrice = Double.parseDouble(initPriceText.getText());
            double vol = Double.parseDouble(volText.getText());
            double r1 = Double.parseDouble(r1Text.getText());
            double r2 = Double.parseDouble(r2Text.getText());
            double strPr = Double.parseDouble(strikePriceText.getText());
            int days = Integer.parseInt(dayCountText.getText());
            System.out.println("init Price " + inPrice + " volat " + vol + " risk dom + " + r1 + " risk for + " + r2 +
                               " strike " + strPr + " days " + days);

            // if input are numbers not string format
            try{
                Double option = 0.0;
                if(this.flag)
                    option=this.optionHandler.Call(inPrice, strPr,r1, r2, days, vol);
                else
                    option=this.optionHandler.Put(inPrice, strPr,r1, r2, days, vol);
                optPriceText.setText(String.valueOf(option));
            }
            catch(NumberFormatException e){
                  JOptionPane.showMessageDialog(null, "Input proper double values", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else 
            JOptionPane.showMessageDialog(null, "Please, fill all required fileds properly","Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_optPriceBtnActionPerformed

    private void volatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volatBtnActionPerformed
      if(date2Choice.getDate()!=null && date1Choice.getDate()!=null && date2Choice.getDate().after(date1Choice.getDate())){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");  
        boolean formatted = false;
        String fromDate = format.format(date1Choice.getDate()); // format in Db
        String toDate = format.format(date2Choice.getDate());// format in Db
        int daysCount =  (int) ((date2Choice.getDate().getTime() - date1Choice.getDate().getTime()) / (1000*60*60*24));
        dayCountText.setText(String.valueOf(daysCount));
        try{
            initPriceText.setText((String)this.pairHandler.getClosePrice(fromDate));
            volCalc.calculateVolatility(30, this.pairHandler.getClosePrice(fromDate,toDate), 30);
            volText.setText(String.valueOf(volCalc.getVolatility()));
        }catch(SQLException e){
          e.printStackTrace();
        }
    }else if(date2Choice.getDate()==null){
          JOptionPane.showMessageDialog(null, "Choose the first date of option period, please","Error", JOptionPane.ERROR_MESSAGE);
      }else if(date1Choice.getDate()==null){
          JOptionPane.showMessageDialog(null, "Choose the last date of option period, please","Error", JOptionPane.ERROR_MESSAGE);
      }else if(date2Choice.getDate().before(date1Choice.getDate())){
          JOptionPane.showMessageDialog(null, "Choose correct dates \"From\" and \"To\"! The date \"From\" should be before date \"To\"","Error", JOptionPane.ERROR_MESSAGE);
      }else if(!canICalculateVol()){
          JOptionPane.showMessageDialog(null, "Please, fill all required fileds properly","Error", JOptionPane.ERROR_MESSAGE);
      }
   
    }//GEN-LAST:event_volatBtnActionPerformed

    private void date2ChoiceInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_date2ChoiceInputMethodTextChanged
        //Date d1 = date1Choice.getDate();
        //Date d2 = date2Choice.getDate();
        //daysCount =  (int) ((d2.getTime() - d1.getTime()) / (1000*60*60*24));
        //
        dayCountText.setText(String.valueOf(daysCount));
        System.out.println("changed");
    }//GEN-LAST:event_date2ChoiceInputMethodTextChanged

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        optTypeText.setText("");
        curPairText.setText("");
        date1Choice.setDate(null);
        date2Choice.setDate(null);
        dayCountText.setText("");
        initPriceText.setText("");
        volText.setText("");
        r1Text.setText("");
        r2Text.setText("");
        infoTextArea.setText("");
        strikePriceText.setText("");
        this.pairHandler = new CommonHandlerForPair(this.pairHandler.getDB());
        this.optionHandler = new CommonHandler();
        parent.setHandlers(optionHandler, pairHandler);
    }//GEN-LAST:event_resetBtnActionPerformed

// insert calculated data to the traded_option table in database
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if(this.optionHandler.getOptionName().length()>0 && canICalculateOption()){
            
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void buildGrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildGrBtnActionPerformed
        JFreeChart chart= null;
        switch(listOfGraphs.getSelectedIndex()){
            case 0:                
                chart=HistoricalGraph.getHistoricalGraph(this.pairHandler.getDB());
                break;
            case 1:
                chart=HistoricalGraph.getHistoricalVolatilityGraph(this.pairHandler.getDB());
                break;
            case 2:
                break;
        }
        panel.setChart(chart);
        panel.repaint();
        
               
    }//GEN-LAST:event_buildGrBtnActionPerformed

    private void EurGbpRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EurGbpRadBtnActionPerformed
        this.pairHandler=new EURGBP(pairHandler.getDB());
        parent.setHandlers(optionHandler, pairHandler);
        parent.refresh();
        
    }//GEN-LAST:event_EurGbpRadBtnActionPerformed

    private void EurJpyRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EurJpyRadBtnActionPerformed
        this.pairHandler=new EURJPY(pairHandler.getDB());
        parent.setHandlers(optionHandler, pairHandler);
        parent.refresh();
    }//GEN-LAST:event_EurJpyRadBtnActionPerformed

    private void EurUsdRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EurUsdRadBtnActionPerformed
        this.pairHandler=new EURUSD(pairHandler.getDB());
        parent.setHandlers(optionHandler, pairHandler);
        parent.refresh();
    }//GEN-LAST:event_EurUsdRadBtnActionPerformed

    private void GbpJpyRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GbpJpyRadBtnActionPerformed
        this.pairHandler=new GBPJPY(pairHandler.getDB());
        parent.setHandlers(optionHandler, pairHandler);
        parent.refresh();
    }//GEN-LAST:event_GbpJpyRadBtnActionPerformed

    private void GbpUsdRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GbpUsdRadBtnActionPerformed
        this.pairHandler=new GBPUSD(pairHandler.getDB());
        parent.setHandlers(optionHandler, pairHandler);
        parent.refresh();
    }//GEN-LAST:event_GbpUsdRadBtnActionPerformed

    private void UsdJpyRadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsdJpyRadBtnActionPerformed
        this.pairHandler=new USDJPY(this.pairHandler.getDB());
        parent.setHandlers(optionHandler, pairHandler);
        parent.refresh();
    }//GEN-LAST:event_UsdJpyRadBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton EurGbpRadBtn;
    private javax.swing.JRadioButton EurJpyRadBtn;
    private javax.swing.JRadioButton EurUsdRadBtn;
    private javax.swing.JRadioButton GbpJpyRadBtn;
    private javax.swing.JRadioButton GbpUsdRadBtn;
    private javax.swing.JRadioButton UsdJpyRadBtn;
    private javax.swing.JButton buildGrBtn;
    private javax.swing.JRadioButton buyOptRadBtn;
    private javax.swing.JLabel choiceCurPairLbl;
    private javax.swing.JPanel contentGraphPanel;
    private javax.swing.ButtonGroup curBtnGrp;
    private javax.swing.JTextField curClPriceText;
    private javax.swing.JLabel curClosePrLbl;
    private javax.swing.JLabel curClosePrLbl1;
    private javax.swing.JLabel curPairChLbl;
    private javax.swing.JPanel curPairPanel;
    private javax.swing.JTextField curPairText;
    private javax.swing.JLabel curRate1Lbl;
    private javax.swing.JTextField curRate1Text;
    private javax.swing.JLabel curRate2Lbl;
    private javax.swing.JTextField curRate2Text;
    private javax.swing.JLabel curVolatLbl;
    private javax.swing.JTextField curVolatText;
    private javax.swing.JLabel currDateLbl;
    private javax.swing.JLabel dashLbl;
    private com.toedter.calendar.JDateChooser date1Choice;
    private com.toedter.calendar.JDateChooser date2Choice;
    private com.toedter.calendar.JDateChooser date3Choice;
    private javax.swing.JTextField dayCountText;
    private javax.swing.JLabel emptyLbl;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JScrollPane infoPane;
    private javax.swing.JTextArea infoTextArea;
    private javax.swing.JTextField initPriceText;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel leftImageLbl;
    private javax.swing.JComboBox listOfGraphs;
    private javax.swing.JTabbedPane mainTabPane;
    private javax.swing.JLabel matTimeLbl;
    private javax.swing.JLabel midImageLbl;
    private javax.swing.JPanel opPanel;
    private javax.swing.ButtonGroup optBtnGr;
    private javax.swing.JButton optPriceBtn;
    private javax.swing.JTextField optPriceText;
    private javax.swing.JLabel optTypeChLbl;
    private javax.swing.JTextField optTypeText;
    private javax.swing.JPanel optionTabPanel;
    private javax.swing.JLabel r1Lbl;
    private javax.swing.JLabel r1Lbl1;
    private javax.swing.JTextField r1Text;
    private javax.swing.JLabel r2Lbl;
    private javax.swing.JLabel r2Lbl1;
    private javax.swing.JTextField r2Text;
    private javax.swing.JButton recalculateBtn;
    private javax.swing.JLabel resOptPriceLbl;
    private javax.swing.JPanel resPanel;
    private javax.swing.JButton resetBtn;
    private javax.swing.JLabel rightImageLbl;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel selectDateLbl;
    private javax.swing.JRadioButton sellOptRadBtn;
    private javax.swing.JLabel stPriceLbl;
    private javax.swing.JLabel strikePrLbl;
    private javax.swing.JTextField strikePriceText;
    private javax.swing.JLabel totDeltaLbl;
    private javax.swing.JTextField totDeltaText;
    private javax.swing.JLabel totValueLbl;
    private javax.swing.JTextField totValueText;
    private javax.swing.JLabel totalCashLbl;
    private javax.swing.JTextField totalCashText;
    private javax.swing.JScrollPane trOptScrollPane;
    private javax.swing.JLabel tradOptLbl;
    private javax.swing.JPanel tradOptTabPanel;
    private javax.swing.JTable tradedOptTable;
    private javax.swing.JPanel tradedPanel;
    private javax.swing.JTextField volText;
    private javax.swing.JButton volatBtn;
    private javax.swing.JLabel volatLbl;
    // End of variables declaration//GEN-END:variables
}
