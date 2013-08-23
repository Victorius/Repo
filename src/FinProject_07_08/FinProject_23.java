/*
 * DATE: 23/07/2013
 * Main Application Class
 */

package FinProject_07_08;

import java.awt.Dimension;

/**
 *
 * @author Anastasiia
 */

public class FinProject_23 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
        MainWinFrame frame = new MainWinFrame();
        frame.setVisible(true);
        frame.setTitle("Option Pricing Model");
        frame.setPreferredSize(new Dimension(765,671));
        frame.setMinimumSize(new Dimension(765,671));
        frame.setMaximumSize(new Dimension (765,671));
  }
}
