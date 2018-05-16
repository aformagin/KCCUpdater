package com.kcc;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class KCCDownloader extends JPanel implements ActionListener {
    JButton chooseDir;
    JButton downloaderBtn;
    JButton updateBtn;
    JFileChooser chooser;
    JProgressBar dnldBar;
    String chooserTitle;
    public static String urlADW =
            "https://downloadADW.toolslib.net/downloadADW/file/1/1511?s=fCsBLYrYx47Y5GqwM9dAuYXazYt2lkvy";
    public static String saveDir;
    public static boolean run = false;
    private URL adwCleaner;
    private URL ComboFix;
    private URL malwareBytes;
    private URL CCleaner;
    private File adw;

    public KCCDownloader() {
        chooseDir = new JButton("Select Directory");
        downloaderBtn = new JButton("Download");
        updateBtn = new JButton("Update Program");
        chooseDir.addActionListener(this);
        downloaderBtn.addActionListener(e -> download());
        add(updateBtn);
        add(chooseDir);
        add(downloaderBtn);
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("KCC Downloader");
        KCCDownloader panel = new KCCDownloader();
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        frame.getContentPane().add(panel, "Center");
        frame.setSize(panel.getPreferredSize());
        frame.setVisible(true);
    }

    //Main download method that will download all files
    public void download() {
        downloadADW();
    }

    //Download Methods
    public void downloadADW() {
        //Tries to get the URL for the following programs
        adw = new File(saveDir + "\\ADWCleaner.exe");
        {
            try {
                adwCleaner = new URL(urlADW);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        //Checks to see if the directory has been selected
        if (run) {
            try {
                FileUtils.copyURLToFile(adwCleaner, adw);
                System.out.println("Saved to " + saveDir);
                System.out.println("Finished");
            } catch (IOException e) {//If it gets to this point, print out the error stream
                System.out.print("Failed");
                e.printStackTrace();
            }

        } else {
            System.out.print(run);
            System.out.println("Do Nothing");
        }
    }

    //Default Action Listener Method
    @Override
    public void actionPerformed(ActionEvent e) {
        int result;

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(chooserTitle);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    + chooser.getSelectedFile());
            run = true;
        } else {
            System.out.println("No Selection ");
            run = false;
        }
        saveDir = String.valueOf(chooser.getSelectedFile());
        System.out.println(run);
        System.out.println("This is the saveDir " + saveDir);
    }

    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}
