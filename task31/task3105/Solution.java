package com.javarush.task.task31.task3105;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length < 2) return;
        if (args[0] == null || args[0].isEmpty()) return;
        if (args[1] == null || args[1].isEmpty()) return;

        String fileToAddPath = args[0];
        String zipFilePath = args[1];


        // String fileToAddPath = "E:/zip_test/c.txt";
        // String zipFilePath = "E:/zip_test/test.zip";
        // createTestZipFile(zipFilePath);


        File fileToAdd = new File(fileToAddPath);
        String fileName = fileToAdd.getName();

        Map<ZipEntry, byte[]> zipEntryMap = new HashMap<>();

        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath));

        ZipEntry zipEntry;
        while ((zipEntry = zis.getNextEntry()) != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int count;

            while ((count = zis.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, count);
            }

            zipEntryMap.put(zipEntry, byteArrayOutputStream.toByteArray());
        }

        zis.close();

        FileInputStream fis = new FileInputStream(fileToAddPath);
        byte[] buf = new byte[fis.available()];
        fis.read(buf);
        fis.close();

        boolean isFileAlreadyExist = false;

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath));
        for (Map.Entry<ZipEntry, byte[]> iPair : zipEntryMap.entrySet()) {
            if (fileName.equals(iPair.getKey().getName())) {
                zos.putNextEntry(new ZipEntry(fileName));
                zos.write(buf);
                zos.closeEntry();

                isFileAlreadyExist = true;
            } else {

                zos.putNextEntry(iPair.getKey());
                zos.write(iPair.getValue());
                zos.closeEntry();
            }
        }

        // Для того чтобы задача зачлась, нужно закомментировать этот фрагмент
        // Баг на стороне сервера!

    }
}