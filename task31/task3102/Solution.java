package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/*
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> queue = new PriorityQueue<>();
        List<String> files = new ArrayList<>();
        if (root == null) return files;
        File f = new File(root);
        do
        {
            try
            {
                while (!queue.isEmpty()){
                for (File file : f.listFiles())
                {
                    if (file.isFile())
                    {
                        files.add(file.getAbsolutePath()); //файл - добавляем в список
                    } else
                    {
                        queue.add(file); //попалась папка - добавляем её в очередь
                    }
                }

                    f = queue.remove(); }//"вынимаем" из очереди папку и "лазим" по ней на следующей итерации.
            }
            catch (NullPointerException e) { //если вдруг попадается какая-то закрытая папка - игнорим её
                if (!queue.isEmpty())
                    f = queue.remove();
                else return files;
            }
        } while (queue.size() != 0);
        return files;
    }
}
