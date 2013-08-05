/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finproject_23;

import java.awt.Dimension;

/**
 *
 * @author 1210081
 */
public class FinProject_23 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
        MainWinFrame frame = new MainWinFrame();
        frame.setVisible(true);
        frame.setTitle("Option Pricing Model");
        frame.setPreferredSize(new Dimension(750, 550));
        frame.setMinimumSize(new Dimension(800,540));
        frame.setMaximumSize(new Dimension (900, 600));
  }
}
