package com.encyro.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    public static void writeLineToFile(String FileName, String Message) {

        try {
            boolean append = true;
            FileWriter fWriter = new FileWriter(FileName, append);

            fWriter.write(Message);
            fWriter.write("\n");
            fWriter.close();
            System.out.println("File is created successfully with the content.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] getFileListFromFolder(String FolderName) {

        File file = new File(FolderName);
        String[] fileList = file.list();

        if (fileList != null) {
            {
                for (String name : fileList) {
                    System.out.println(name.substring(0, name.indexOf(".")));//"-- "+
                }
            }
        }
        return fileList;
    }
}
