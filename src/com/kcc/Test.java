package com.kcc;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;



public class Test extends JPanel
        implements ActionListener {
    JButton broswLocation;

   static JFileChooser chooser;
    String choosertitle;

    public Test() {
        broswLocation = new JButton("Choose Location to Download");
        broswLocation.addActionListener(this);
        add(broswLocation);
    }

    public void actionPerformed(ActionEvent e) {
        int result;

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    +  chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    +  chooser.getSelectedFile());
        }
        else {
            System.out.println("No Selection ");
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(500, 300);
    }

    public static void main(String s[]) {
        boolean selected = false;
        JFrame frame = new JFrame("KCC UPDATER");
        Test panel = new Test();
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);

                    }
                }
        );
        selected = true;
        frame.getContentPane().add(panel,"Center");
        frame.setSize(panel.getPreferredSize());
        frame.setVisible(true);

        String adwCleanerURL = "https://download.toolslib.net/download/file/1/1511?s=2LPvu8kniU2T794QD0FXSN21jxnJOqLP";
        //Download adwCleaner to selected directory
       try {
            HttpDownloadUtility.downloadFile(adwCleanerURL, (String.valueOf(chooser.getSelectedFile())));
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}