/*
 * Date 16/07/2013
 * 
 */
package FinProject_07_08;

import PairHandlers.*;
import handlersOption.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;

/**
 *
 * @author Anastasiia
 */


public class MainWinFrame extends javax.swing.JFrame implements ActionListener, KeyListener{
    
    //private JPanel mainPanel; 
    private SqlQueryClass  sqlClass = null;
    private VolatilityCalc volCalc = null; // declare parametr of class
    private ResultSet mod = null;
    private CommonHandlerForPair pairHandler=new CommonHandlerForPair();
    private CommonHandler optionHandler = new CommonHandler();
    private boolean flag = true;
    // main Panel 
    

    private OptionPanel optionPanel;
    
    public MainWinFrame() {
    initComponents();
    //sqlClass = new SqlQueryClass("db1210081_historical_data", "1210081", "1210081");
    sqlClass = new SqlQueryClass("historical_data", "root", "");    
    pairHandler=new CommonHandlerForPair(sqlClass.getDB());
    // declares objects of frame

    // adds mainPanel to frame

     this.optionPanel = new OptionPanel();
     optionPanel.SetOptions(sqlClass);
     optionPanel.setOptionH(optionHandler);
     optionPanel.setPairH(pairHandler);
     this.getContentPane().add(optionPanel, BorderLayout.CENTER);
    
    saveDataItem.setBackground(Color.white);
    exitItem.setBackground(Color.white);
     // default option EUR/GBP is selected  
    gbp_usdItem.setBackground(Color.white);
    eur_gbpItem.setBorderPainted(true);
    eur_usdItem.setBackground(Color.white);
    eur_jpyItem.setBackground(Color.white);
    eur_gbpItem.setBackground(Color.CYAN);
    gbp_jpyItem.setBackground(Color.white);
    usd_jpyItem.setBackground(Color.white);
    
    // default is European Call
    europCallItem.setBackground(Color.CYAN);
    europCallItem.setBorderPainted(true);
    europPutItem.setBackground(Color.white);
    amerCallItem.setBackground(Color.white);
    amerPutItem.setBackground(Color.white);
    forwOpItem.setBackground(Color.white);
    futurOpItem.setBackground(Color.white);
    
    }
    
    public void refresh(){
        this.optionPanel.setPairH(pairHandler);
        this.optionPanel.changePairName(this.pairHandler.getCurrpair());
        this.optionPanel.setOptionH(optionHandler);
        if(this.optionHandler.getOptionName().length()>0)
            if(this.optionHandler.getOptionName().contains("EUROPEAN") || this.optionHandler.getOptionName().contains("AMERICAN") ||
                    this.optionHandler.getOptionName().contains("ASIAN"))
                if(this.flag)
                    this.optionPanel.changeOptionName(this.optionHandler.getOptionName()+" CALL");
                else
                    this.optionPanel.changeOptionName(this.optionHandler.getOptionName()+" PUT");
             else
                this.optionPanel.changeOptionName(this.optionHandler.getOptionName());
        this.optionPanel.SetOptions(flag);
    }
 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveDataItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        curPairMenu = new javax.swing.JMenu();
        eur_gbpItem = new javax.swing.JMenuItem();
        eur_jpyItem = new javax.swing.JMenuItem();
        eur_usdItem = new javax.swing.JMenuItem();
        gbp_usdItem = new javax.swing.JMenuItem();
        gbp_jpyItem = new javax.swing.JMenuItem();
        usd_jpyItem = new javax.swing.JMenuItem();
        opTypeMenu = new javax.swing.JMenu();
        europCallItem = new javax.swing.JMenuItem();
        europPutItem = new javax.swing.JMenuItem();
        amerCallItem = new javax.swing.JMenuItem();
        amerPutItem = new javax.swing.JMenuItem();
        forwOpItem = new javax.swing.JMenuItem();
        futurOpItem = new javax.swing.JMenuItem();
        advTypeMenu = new javax.swing.JMenu();
        asianCallTypeItem = new javax.swing.JMenuItem();
        asianPutTypeItem = new javax.swing.JMenuItem();
        graphMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/SourceImage/icon.png")));
        getContentPane().setLayout(new java.awt.BorderLayout());

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        fileMenu.setText("File");

        saveDataItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveDataItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SourceImage/save.jpg")));
        saveDataItem.setText("Save Data");
        fileMenu.add(saveDataItem);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exitItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SourceImage/exit.jpg")));
        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        jMenuBar1.add(fileMenu);

        curPairMenu.setBackground(new java.awt.Color(204, 204, 204));
        curPairMenu.setText("Currency Pair");

        eur_gbpItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, 0));
        eur_gbpItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SourceImage/eur_gbp1.jpg")));
        eur_gbpItem.setText("EUR/GBP");
        eur_gbpItem.setSelected(true);
        eur_gbpItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                eur_gbpItemMouseReleased(evt);
            }
        });
        eur_gbpItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eur_gbpItemActionPerformed(evt);
            }
        });
        curPairMenu.add(eur_gbpItem);

        eur_jpyItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, 0));
        eur_jpyItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SourceImage/eur_jpy1.jpg")));
        eur_jpyItem.setText("EUR/JPY");
        eur_jpyItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                eur_jpyItemMouseReleased(evt);
            }
        });
        eur_jpyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eur_jpyItemActionPerformed(evt);
            }
        });
        curPairMenu.add(eur_jpyItem);

        eur_usdItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, 0));
        eur_usdItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SourceImage/eur_usd1.jpg")));
        eur_usdItem.setText("EUR/USD");
        eur_usdItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                eur_usdItemMouseReleased(evt);
            }
        });
        eur_usdItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eur_usdItemActionPerformed(evt);
            }
        });
        curPairMenu.add(eur_usdItem);

        gbp_usdItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, 0));
        gbp_usdItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SourceImage/gbp_usd1.jpg")));
        gbp_usdItem.setText("GBP/USD");
        gbp_usdItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gbp_usdItemMouseReleased(evt);
            }
        });
        gbp_usdItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gbp_usdItemActionPerformed(evt);
            }
        });
        curPairMenu.add(gbp_usdItem);

        gbp_jpyItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, 0));
        gbp_jpyItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SourceImage/gbp_jpy1.jpg")));
        gbp_jpyItem.setText("GBP/JPY");
        gbp_jpyItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                gbp_jpyItemMouseReleased(evt);
            }
        });
        gbp_jpyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gbp_jpyItemActionPerformed(evt);
            }
        });
        curPairMenu.add(gbp_jpyItem);

        usd_jpyItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, 0));
        usd_jpyItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SourceImage/usd_jpy1.jpg")));
        usd_jpyItem.setText("USD/JPY");
        usd_jpyItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                usd_jpyItemMouseReleased(evt);
            }
        });
        usd_jpyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usd_jpyItemActionPerformed(evt);
            }
        });
        curPairMenu.add(usd_jpyItem);

        jMenuBar1.add(curPairMenu);

        opTypeMenu.setText("Option Types");

        europCallItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        europCallItem.setText("European Call");
        europCallItem.setSelected(true);
        europCallItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                europCallItemMouseReleased(evt);
            }
        });
        europCallItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                europCallItemActionPerformed(evt);
            }
        });
        opTypeMenu.add(europCallItem);

        europPutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        europPutItem.setText("European Put");
        europPutItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                europPutItemMouseReleased(evt);
            }
        });
        europPutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                europPutItemActionPerformed(evt);
            }
        });
        opTypeMenu.add(europPutItem);

        amerCallItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        amerCallItem.setText("American Call");
        amerCallItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                amerCallItemMouseReleased(evt);
            }
        });
        amerCallItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amerCallItemActionPerformed(evt);
            }
        });
        opTypeMenu.add(amerCallItem);

        amerPutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        amerPutItem.setText("American Put");
        amerPutItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                amerPutItemMouseReleased(evt);
            }
        });
        amerPutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amerPutItemActionPerformed(evt);
            }
        });
        opTypeMenu.add(amerPutItem);

        forwOpItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        forwOpItem.setText("Forwards option");
        forwOpItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                forwOpItemMouseReleased(evt);
            }
        });
        forwOpItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwOpItemActionPerformed(evt);
            }
        });
        opTypeMenu.add(forwOpItem);

        futurOpItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        futurOpItem.setText("Futures option");
        futurOpItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                futurOpItemMouseReleased(evt);
            }
        });
        futurOpItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                futurOpItemActionPerformed(evt);
            }
        });
        opTypeMenu.add(futurOpItem);

        jMenuBar1.add(opTypeMenu);

        advTypeMenu.setText("Advanced Options");

        asianCallTypeItem.setText("Asian Call");
        asianCallTypeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asianCallTypeItemActionPerformed(evt);
            }
        });
        advTypeMenu.add(asianCallTypeItem);

        asianPutTypeItem.setText("Asian Put");
        asianPutTypeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asianPutTypeItemActionPerformed(evt);
            }
        });
        advTypeMenu.add(asianPutTypeItem);

        jMenuBar1.add(advTypeMenu);

        graphMenu.setText("Graphs");
        jMenuBar1.add(graphMenu);

        helpMenu.setText("Help");
        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        setVisible(false);
        dispose();
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    
   
    // currency pair USD/JPY is chosen
  private void usd_jpyItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usd_jpyItemActionPerformed
        this.pairHandler=new USDJPY();
        refresh();
  }//GEN-LAST:event_usd_jpyItemActionPerformed

  private void usd_jpyItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usd_jpyItemMouseReleased
    usd_jpyItem.setBackground(Color.CYAN);
    usd_jpyItem.setBorderPainted(true);
    eur_usdItem.setBackground(Color.white);
    gbp_usdItem.setBackground(Color.white);
    eur_jpyItem.setBackground(Color.white);
    eur_gbpItem.setBackground(Color.white);
    gbp_jpyItem.setBackground(Color.white);
    //curPairText.setEnabled(true);
    //curPairText.setText("USD/JPY");
  }//GEN-LAST:event_usd_jpyItemMouseReleased

  private void gbp_jpyItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gbp_jpyItemMouseReleased
    gbp_jpyItem.setBackground(Color.CYAN);
    gbp_jpyItem.setBorderPainted(true);
    eur_usdItem.setBackground(Color.white);
    gbp_usdItem.setBackground(Color.white);
    eur_jpyItem.setBackground(Color.white);
    eur_gbpItem.setBackground(Color.white);
    usd_jpyItem.setBackground(Color.white);
    //curPairText.setEnabled(true);
    //curPairText.setText("GBP/JPY");
  }//GEN-LAST:event_gbp_jpyItemMouseReleased

  private void gbp_usdItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gbp_usdItemMouseReleased
    gbp_usdItem.setBackground(Color.CYAN);
    gbp_usdItem.setBorderPainted(true);
    eur_usdItem.setBackground(Color.white);
    eur_jpyItem.setBackground(Color.white);
    eur_gbpItem.setBackground(Color.white);
    gbp_jpyItem.setBackground(Color.white);
    usd_jpyItem.setBackground(Color.white);
    //curPairText.setEnabled(true);
    //curPairText.setText("GBP/USD");
  }//GEN-LAST:event_gbp_usdItemMouseReleased

  private void eur_usdItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eur_usdItemMouseReleased
    eur_usdItem.setBackground(Color.CYAN);
    eur_usdItem.setBorderPainted(true);
    eur_gbpItem.setBackground(Color.white);
    eur_jpyItem.setBackground(Color.white);
    gbp_usdItem.setBackground(Color.white);
    gbp_jpyItem.setBackground(Color.white);
    usd_jpyItem.setBackground(Color.white);
    //curPairText.setText("EUR/USD");
    //curPairText.setEnabled(true);
  }//GEN-LAST:event_eur_usdItemMouseReleased

  private void eur_jpyItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eur_jpyItemMouseReleased
    gbp_usdItem.setBackground(Color.white);
    eur_jpyItem.setBorderPainted(true);
    eur_usdItem.setBackground(Color.white);
    eur_jpyItem.setBackground(Color.CYAN);
    eur_gbpItem.setBackground(Color.white);
    gbp_jpyItem.setBackground(Color.white);
    usd_jpyItem.setBackground(Color.white);
    //curPairText.setEnabled(true);
    //curPairText.setText("EUR/JPY");
  }//GEN-LAST:event_eur_jpyItemMouseReleased

  private void eur_gbpItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eur_gbpItemMouseReleased
    gbp_usdItem.setBackground(Color.white);
    eur_gbpItem.setBorderPainted(true);
    eur_usdItem.setBackground(Color.white);
    eur_jpyItem.setBackground(Color.white);
    eur_gbpItem.setBackground(Color.CYAN);
    gbp_jpyItem.setBackground(Color.white);
    usd_jpyItem.setBackground(Color.white);
    //curPairText.setEnabled(true);
    //curPairText.setText("EUR/GBP");
  }//GEN-LAST:event_eur_gbpItemMouseReleased

  private void europCallItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_europCallItemMouseReleased
    europCallItem.setBackground(Color.CYAN);
    europCallItem.setBorderPainted(true);
    europPutItem.setBackground(Color.white);
    amerCallItem.setBackground(Color.white);
    amerPutItem.setBackground(Color.white);
    forwOpItem.setBackground(Color.white);
    futurOpItem.setBackground(Color.white);
    //opTypeText.setEnabled(true);
    //opTypeText.setText("EUROPEAN CALL");
    //optionInfoText.setEnabled(true);
    //optionInfoText.setText("European Call is the option ...");
  }//GEN-LAST:event_europCallItemMouseReleased

  private void europPutItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_europPutItemMouseReleased
    europPutItem.setBackground(Color.CYAN);
    europPutItem.setBorderPainted(true);
    europCallItem.setBackground(Color.white);
    amerCallItem.setBackground(Color.white);
    amerPutItem.setBackground(Color.white);
    forwOpItem.setBackground(Color.white);
    futurOpItem.setBackground(Color.white);
    //opTypeText.setEnabled(true);
    //optionPanel.optTypeText.setText("EUROPEAN PUT");
    //optionInfoText.setEnabled(true);
    //optionInfoText.setText("European Put is the option ...");
  }//GEN-LAST:event_europPutItemMouseReleased

    private void amerCallItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amerCallItemMouseReleased
    europCallItem.setBackground(Color.white);
    europCallItem.setBorderPainted(true);
    europPutItem.setBackground(Color.white);
    amerCallItem.setBackground(Color.CYAN);
    amerPutItem.setBackground(Color.white);
    forwOpItem.setBackground(Color.white);
    futurOpItem.setBackground(Color.white);
    }//GEN-LAST:event_amerCallItemMouseReleased

    private void amerPutItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amerPutItemMouseReleased
     europCallItem.setBackground(Color.white);
    europCallItem.setBorderPainted(true);
    europPutItem.setBackground(Color.CYAN);
    amerCallItem.setBackground(Color.white);
    amerPutItem.setBackground(Color.white);
    forwOpItem.setBackground(Color.white);
    futurOpItem.setBackground(Color.white);
    }//GEN-LAST:event_amerPutItemMouseReleased

    private void forwOpItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwOpItemMouseReleased
    europCallItem.setBackground(Color.white);
    europCallItem.setBorderPainted(true);
    europPutItem.setBackground(Color.white);
    amerCallItem.setBackground(Color.white);
    amerPutItem.setBackground(Color.white);
    forwOpItem.setBackground(Color.CYAN);
    futurOpItem.setBackground(Color.white);
    }//GEN-LAST:event_forwOpItemMouseReleased

    private void futurOpItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_futurOpItemMouseReleased
    europCallItem.setBackground(Color.white);
    europCallItem.setBorderPainted(true);
    europPutItem.setBackground(Color.white);
    amerCallItem.setBackground(Color.white);
    amerPutItem.setBackground(Color.white);
    forwOpItem.setBackground(Color.white);
    futurOpItem.setBackground(Color.CYAN);
    }//GEN-LAST:event_futurOpItemMouseReleased

    private void eur_gbpItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eur_gbpItemActionPerformed
      System.out.println("123");
        this.pairHandler=new EURGBP(pairHandler.getDB());
        refresh();
    }//GEN-LAST:event_eur_gbpItemActionPerformed

    private void eur_jpyItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eur_jpyItemActionPerformed
        this.pairHandler=new EURJPY();
        refresh();
    }//GEN-LAST:event_eur_jpyItemActionPerformed

    private void eur_usdItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eur_usdItemActionPerformed
        this.pairHandler=new EURUSD();
        refresh();
    }//GEN-LAST:event_eur_usdItemActionPerformed

    private void gbp_usdItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gbp_usdItemActionPerformed
        this.pairHandler=new GBPUSD();
        refresh();
    }//GEN-LAST:event_gbp_usdItemActionPerformed

    private void gbp_jpyItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gbp_jpyItemActionPerformed
        this.pairHandler=new GBPJPY();
        refresh();
    }//GEN-LAST:event_gbp_jpyItemActionPerformed

    private void europCallItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_europCallItemActionPerformed
        this.optionHandler = new EuropeanOption();
        this.flag=true;
        refresh();
    }//GEN-LAST:event_europCallItemActionPerformed

    private void europPutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_europPutItemActionPerformed
        this.optionHandler = new EuropeanOption();
        this.flag=false;
        refresh();
    }//GEN-LAST:event_europPutItemActionPerformed

    private void amerCallItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amerCallItemActionPerformed
        this.optionHandler = new AmericanOption(5);
        this.flag=true;
        refresh();
    }//GEN-LAST:event_amerCallItemActionPerformed

    private void amerPutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amerPutItemActionPerformed
        this.optionHandler = new AmericanOption(5);
        this.flag=false;
        refresh();
    }//GEN-LAST:event_amerPutItemActionPerformed

    private void forwOpItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwOpItemActionPerformed
        this.optionHandler = new ForwardOption();        
        refresh();
    }//GEN-LAST:event_forwOpItemActionPerformed

    private void futurOpItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_futurOpItemActionPerformed
        this.optionHandler = new FuturesOption();
        this.flag=false;
        refresh();
    }//GEN-LAST:event_futurOpItemActionPerformed

    private void asianCallTypeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asianCallTypeItemActionPerformed
        this.optionHandler = new AsianOption();
        this.flag=true;
        refresh();
    }//GEN-LAST:event_asianCallTypeItemActionPerformed

    private void asianPutTypeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asianPutTypeItemActionPerformed
        this.optionHandler = new AsianOption();
        this.flag=false;
        refresh();
    }//GEN-LAST:event_asianPutTypeItemActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu advTypeMenu;
    private javax.swing.JMenuItem amerCallItem;
    private javax.swing.JMenuItem amerPutItem;
    private javax.swing.JMenuItem asianCallTypeItem;
    private javax.swing.JMenuItem asianPutTypeItem;
    private javax.swing.JMenu curPairMenu;
    private javax.swing.JMenuItem eur_gbpItem;
    private javax.swing.JMenuItem eur_jpyItem;
    private javax.swing.JMenuItem eur_usdItem;
    private javax.swing.JMenuItem europCallItem;
    private javax.swing.JMenuItem europPutItem;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem forwOpItem;
    private javax.swing.JMenuItem futurOpItem;
    private javax.swing.JMenuItem gbp_jpyItem;
    private javax.swing.JMenuItem gbp_usdItem;
    private javax.swing.JMenu graphMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu opTypeMenu;
    private javax.swing.JMenuItem saveDataItem;
    private javax.swing.JMenuItem usd_jpyItem;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        //if (ae.getActionCommand().compareTo("begin") == 0){
          
          /* if (curPairText.getText().compareTo("") != 0 || opTypeText.getText().compareTo("") != 0){
               date1Chooser.setEnabled(true);
               date2Chooser.setEnabled(true);
               initPriceText.setEnabled(true);
               volatilText.setEnabled(true); 
               intRateText.setEnabled(true);
               strPriceText.setEnabled(true);
               resultOptionText.setEnabled(true);
               intRate1Text.setEnabled(true);
               optionInfoText.setEnabled(true);
           } */
          // else
            // JOptionPane.showMessageDialog(null, "Select currency pair and option type from menu");
        //}
        // for main tab pane
               //if (ae.getActionCommand().compareTo("calcVol") == 0){
                 
                 //if (initPriceText.getText().compareTo("") != 0){

        // CHECK exception if fields are have proper data and not empty
                   
      /*SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");  
      Date date1 = null;
      Date date2 = null;
      boolean formatted = false;
      String fromDate = "";
      String toDate = "";
    
    try{
      //date1 = date1Chooser.getDate();
      //date2 = date2Chooser.getDate();
      fromDate = format.format(date1); // format in Db
      toDate = format.format(date2); // format in Db
      System.out.println("From Date  is " + fromDate);
      System.out.println("To Date is " + toDate);
      formatted = true;
    }
    catch(NullPointerException e){
      formatted = false;
    }
    if (formatted){
         //if (ae.getActionCommand().compareTo("EUR/GBP") == 0){
             //if (eur_gbpItem.isSelected()) {
             System.out.println(sqlClass.getClPrice_EurGbp(fromDate));
            // initPriceText.setText(sqlClass.getClPrice_EurGbp(fromDate));
             //}
         //}
        // if the currencyPair item EUR/GBP is selected

        }
        // if the currencyPair item EUR/JPY is selected
        //initPriceText.setText(sqlClass.getClPrice_EurJpy(fromDate));
       
        // if the currencyPair item EUR/USD is selected
        //initPriceText.setText(sqlClass.getClPrice_EurUsd(fromDate));
        
        // if the currencyPair item GBP/JPY is selected
       // initPriceText.setText(sqlClass.getClPrice_GbpJpy(fromDate));
        
        // if the currencyPair item GBP/USD is selected
        //initPriceText.setText(sqlClass.getClPrice_GbpUsd(fromDate));
        
        // if the currencyPair item USD/JPY is selected
        //initPriceText.setText(sqlClass.getClPrice_UsdJpy(fromDate));
        
        // input data for volatility method   
        
        int daysCount =  (int) ((date2.getTime() - date1.getTime()) / (1000*60*60*24)); 
       // optionInfoText.setText("Days between dates " + daysCount); 
        // passing result set into array of stock prices

        
        // }else
        // JOptionPane.showMessageDialog(null, "Fill the input data for volatility parameter");          
            
        } else if (ae.getActionCommand().compareTo("reset") == 0){
              /* date1Chooser.setDate(null);
               date1Chooser.setEnabled(false);
               date2Chooser.setDate(null);
               date2Chooser.setEnabled(false);
               initPriceText.setText("");
               initPriceText.setEnabled(false);
               volatilText.setText("");
               volatilText.setEnabled(false);
               intRateText.setText("");
               intRateText.setEnabled(false);
               strPriceText.setText("");
               strPriceText.setEnabled(false);
               resultOptionText.setText("");
               resultOptionText.setEnabled(false);
               intRate1Text.setText("");
               intRate1Text.setEnabled(false);
               curPairText.setText("");
               curPairText.setEnabled(false);
               opTypeText.setText("");
               opTypeText.setEnabled(false);
               optionInfoText.setText("");
               optionInfoText.setEnabled(false); */

      //  } else if (ae.getActionCommand().compareTo("calcOptionPrice") == 0){
            
            
        // for secondary tab pane    
      //  } else if (ae.getActionCommand().compareTo("loadMatlab") == 0){
            
       // } else if (ae.getActionCommand().compareTo("showGraph") == 0){
            
      //  }
        
        
  //  }
}

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
