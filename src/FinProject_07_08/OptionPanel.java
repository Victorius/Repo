/*
 * Date: 7/25/2013
 * Author: Anastasiia
 */
package FinProject_07_08;

import PairHandlers.CommonHandlerForPair;
import PairHandlers.EURGBP;
import handlersOption.CommonHandler;
import handlersOption.EuropeanOption;
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

public class OptionPanel extends javax.swing.JPanel {

  /**
   * Creates new form OptionPanel
   */
  private SqlQueryClass  sqlClass = null;
  private VolatilityCalc volCalc = new VolatilityCalc(); // declare parametr of class
  private EuropeanOptionsClass eurClass = null;
  private ForwardFuturesOptionClass forFutClass = null;
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
      Thread gh = new Thread(thread);
      gh.start();
      SecondChecker sc = new SecondChecker(gh,thread);
      Thread gh2 =new Thread(sc);
      gh2.start();
      DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category 1", 43.2);
        dataset.setValue("Category 2", 76.2);
        dataset.setValue("Category 1", 10.9);
        JFreeChart jfc = ChartFactory.createPieChart("Sample",
                dataset,
                true,
                true,
                false);
        panel = new ChartPanel(jfc);
      grTabPanel.add(panel);
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
      }else if(parametres instanceof EuropeanOptionsClass){
          this.eurClass = (EuropeanOptionsClass)parametres;
      }else if(parametres instanceof ForwardFuturesOptionClass){
          this.forFutClass = (ForwardFuturesOptionClass)parametres;
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
      this.curPairText.setText(text);
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
            initPriceText.setText(t==null?"Q":t);
            if(initPriceText.getText().equals("Q")){
                initPriceText.setText("");
                jLabel19.setText("In this date We have not data.");
                jLabel20.setText("Please,choose another start date.");
            }else{
                jLabel19.setText("");
                jLabel20.setText("");
            }
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
          x = Double.parseDouble(strikePrText.getText());
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
        jLabel1 = new javax.swing.JLabel();
        curPairText = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
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
        buyOptRadBtn = new javax.swing.JRadioButton();
        SellOptRadBtn = new javax.swing.JRadioButton();
        resPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        optPriceText = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        grTabPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        date3Choice = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

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

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("   CURRENCY PAIR:");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPairPanel.add(jLabel1);

        curPairText.setEditable(false);
        curPairText.setBackground(new java.awt.Color(255, 255, 255));
        curPairText.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        curPairText.setForeground(new java.awt.Color(0, 51, 51));
        curPairText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curPairPanel.add(curPairText);
        curPairPanel.add(jLabel15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("   OPTION TYPE:");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPairPanel.add(jLabel2);

        optTypeText.setEditable(false);
        optTypeText.setBackground(new java.awt.Color(255, 255, 255));
        optTypeText.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        optTypeText.setForeground(new java.awt.Color(0, 51, 51));
        optTypeText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curPairPanel.add(optTypeText);

        resetBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                date2ChoiceInputMethodTextChanged(evt);
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

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Select dates of option:");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        opPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("-");
        opPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 10, 20));

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

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Stock Price:");
        opPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 110, 20));

        initPriceText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        opPanel.add(initPriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 110, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Volatility:");
        opPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 90, 20));

        volText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        volText.setText("0.0043");
        opPanel.add(volText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 110, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Maturity time:");
        opPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 120, 20));

        dayCountText.setEditable(false);
        dayCountText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        opPanel.add(dayCountText, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 110, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Risk-free rate");
        opPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 130, 20));

        r1Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r1Text.setText("0.03");
        opPanel.add(r1Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 80, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Risk-free rate");
        opPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 110, 20));

        r2Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        r2Text.setText("0.04");
        opPanel.add(r2Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 80, -1));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detailed Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 14), new java.awt.Color(51, 0, 0))); // NOI18N

        infoTextArea.setEditable(false);
        infoTextArea.setColumns(16);
        infoTextArea.setRows(5);
        infoTextArea.setText("\nEuropean Call Option\n is an option of:");
        jScrollPane1.setViewportView(infoTextArea);

        opPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 220, 300));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Strike price:");
        opPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        strikePrText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        strikePrText.setText("0.644");
        strikePrText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strikePrTextActionPerformed(evt);
            }
        });
        opPanel.add(strikePrText, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 80, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        opPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 10, 420));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        opPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 10, 420));

        jLabel12.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel12.setText("domestic currency:");
        opPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel13.setText("foreign currency:");
        opPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 130, 20));

        buyOptRadBtn.setBackground(new java.awt.Color(204, 204, 255));
        optBtnGr.add(buyOptRadBtn);
        buyOptRadBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buyOptRadBtn.setSelected(true);
        buyOptRadBtn.setText("Buy an option");
        opPanel.add(buyOptRadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 130, -1));

        SellOptRadBtn.setBackground(new java.awt.Color(204, 204, 255));
        optBtnGr.add(SellOptRadBtn);
        SellOptRadBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SellOptRadBtn.setText("Sell an option");
        opPanel.add(SellOptRadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 130, -1));

        resPanel.setBackground(new java.awt.Color(255, 255, 255));
        resPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        resPanel.setPreferredSize(new java.awt.Dimension(552, 70));
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
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        resPanel.add(saveBtn);

        opPanel.add(resPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 756, -1));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 0));
        opPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 160, 10));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 0, 0));
        opPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 160, 10));

        optionTabPanel.add(opPanel, java.awt.BorderLayout.CENTER);

        mainTabPane.addTab("Option Pricing", optionTabPanel);

        grTabPanel.setPreferredSize(new java.awt.Dimension(761, 706));
        grTabPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(761, 270));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Choose the currency pair:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, 20));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("EUR/GBP");
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jRadioButton2.setText("EUR/JPY");
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jRadioButton3.setText("EUR/USD");
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jRadioButton4.setText("GBP/JPY");
        jPanel1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, -1));

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jRadioButton5.setText("GBP/USD");
        jPanel1.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jRadioButton6.setBackground(new java.awt.Color(255, 255, 255));
        curBtnGrp.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jRadioButton6.setText("USD/JPY");
        jPanel1.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 80, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Input the date:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, 20));

        date3Choice.setBackground(new java.awt.Color(153, 153, 153));
        date3Choice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date3Choice.setAutoscrolls(true);
        date3Choice.setDate(Calendar.getInstance().getTime());
        date3Choice.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        date3Choice.setMaxSelectableDate(new java.util.Date(1420074119000L));
        date3Choice.setMinSelectableDate(new java.util.Date(978483719000L));
        jPanel1.add(date3Choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 110, 20));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("OPTION DETAILS:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 140, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("CALCULATE");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 150, 30));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 410, 180));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 10, 300));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Build Graph");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 140, 30));

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "OptionsGraph", "HistoricalVolatility" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 130, 30));

        grTabPanel.add(jPanel1, java.awt.BorderLayout.NORTH);

        mainTabPane.addTab("Ghaph representation", grTabPanel);

        add(mainTabPane, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void optPriceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optPriceBtnActionPerformed
        if(this.optionHandler.getOptionName().length()>0 && canICalculateOption()){
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
                Double option = 0.0;
             if(this.optionHandler.getOptionName().contains("EUROPEAN") || this.optionHandler.getOptionName().contains("AMERICAN"))
                if(this.flag)
                    option=this.optionHandler.Call(inPrice, strPr,r1, r2, days, vol);
                else
                    option=this.optionHandler.Put(inPrice, strPr,r1, r2, days, vol);
             else
                option=this.optionHandler.Put(inPrice, strPr,r1, r2, days, vol);
                optPriceText.setText(String.valueOf(option));
            }
            catch(NumberFormatException e){
                  JOptionPane.showMessageDialog(null, "Input proper double values", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else 
            JOptionPane.showMessageDialog(null, "Please, correctly fill all requirement fileds","Error", JOptionPane.ERROR_MESSAGE);
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
            volCalc.calculateVolatility(daysCount, this.pairHandler.getClosePrice(fromDate,toDate), daysCount);
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
          JOptionPane.showMessageDialog(null, "Please, correctly fill all requirement fileds","Error", JOptionPane.ERROR_MESSAGE);
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
        strikePrText.setText("");
        this.pairHandler = new CommonHandlerForPair(this.pairHandler.getDB());
        this.optionHandler = new CommonHandler();
        parent.setHandlers(optionHandler, pairHandler);
    }//GEN-LAST:event_resetBtnActionPerformed

    private void strikePrTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strikePrTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_strikePrTextActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category 1", 43.2);
        dataset.setValue("Category 2", 190.2);
        dataset.setValue("Category 3", 17.9);
        JFreeChart jfc = ChartFactory.createPieChart("Sample",
                dataset,
                true,
                true,
                false);
        panel.setChart(jfc);
        panel.repaint();
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton SellOptRadBtn;
    private javax.swing.JRadioButton buyOptRadBtn;
    private javax.swing.ButtonGroup curBtnGrp;
    private javax.swing.JPanel curPairPanel;
    private javax.swing.JTextField curPairText;
    private com.toedter.calendar.JDateChooser date1Choice;
    private com.toedter.calendar.JDateChooser date2Choice;
    private com.toedter.calendar.JDateChooser date3Choice;
    private javax.swing.JTextField dayCountText;
    private javax.swing.JPanel grTabPanel;
    private javax.swing.JTextArea infoTextArea;
    private javax.swing.JTextField initPriceText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTabbedPane mainTabPane;
    private javax.swing.JPanel opPanel;
    private javax.swing.ButtonGroup optBtnGr;
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
