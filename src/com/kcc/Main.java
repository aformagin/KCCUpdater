package com.kcc;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Main extends JPanel implements ActionListener{
    //Initializing the URLs. If they need to be updated, change them in this location
    private static String adwCleanerURL;
    private static String mbamURL;
    private static String combofixURL;
    private static String saveDir;
    private static JFileChooser chooser;
    private static JFrame frame = new JFrame("KCC UPDATER");
    private String choosertitle;


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

    public static void main(String[] args) throws IOException{
        adwCleanerURL = "https://download.toolslib.net/download/file/1/1511?s=RcpWHbEHGW5GoGGr0zpUmnIlsDY5WDiR";

        //Creating the window with title KCC Updater

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setPreferredSize(new Dimension(500, 300));
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        Main panel = new Main();
        frame.getContentPane().add(panel,BorderLayout.CENTER);

        Label emptyLabel = new Label("Test");
        //frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        //Download adwCleaner to selected directory
//        try {
//            HttpDownloadUtility.downloadFile(adwCleanerURL, saveDir);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public String getDir(String x){
        String dir = x;

        return dir;
    }



}
