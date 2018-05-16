package com.kcc;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Testing3 {
    public static void main(String[] args) throws IOException {
        //URL and Directory to save to
        String urlADW = "https://downloadADW.toolslib.net/downloadADW/file/1/1511?s=fCsBLYrYx47Y5GqwM9dAuYXazYt2lkvy";
        String saveDir = "C:\\Users\\Austin\\Desktop\\kccutil";
        //int num = 1;
        //URL and Directory creation
        URL Testing = new URL(urlADW);
        File adw = new File(saveDir + "\\ADWCleaner.exe");
        //Trying to downloadADW the file to the directory
        try {
//            if(adw.exists())
//            {
//                File adwNum = new File(saveDir + "\\ADWCleaner" + num + ".exe");
//            }else{
//
//            }
            FileUtils.copyURLToFile(Testing, adw);
            System.out.println("Finished");
        } catch (IOException e) {//If it gets to this point, print out the error stream
            System.out.print("Failed");
            e.printStackTrace();
        }

    }
}
