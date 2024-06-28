package com.Reflection.Annotation.IO;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class LogCreator{

    public void createLog() {
        File dir = new File("log");
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    public void writeFile(String str) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename = "log/log_" + timeStamp + ".txt";

        File dir = new File("log");
        File[] files = dir.listFiles();
        if (files != null && files.length > 1) {
            for (File file : files) {
                file.delete();
            }
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            writer.println(str);
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }

    public String readFile(String name) {
        return null;
    }
}