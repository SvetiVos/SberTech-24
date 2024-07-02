package com.reflection.annotation.io;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java. io. FileNotFoundException;
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

        try (PrintWriter writer = new PrintWriter(filename, "UTF-8")) {
            writer.println(str);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Файл не найден: " + e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedEncodingException("Не поддерживается кодировка: " + e.getMessage(), e);
        }

    }

    public String readFile(String name) {

        return null;
    }
}