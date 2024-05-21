package lesson8.file;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File fileTest = new File("C:\\Users\\anduser\\Desktop\\additional\\file\\text.txt");
        System.out.println("Name of file: " + fileTest.getName());
        System.out.println("Size of file: " + fileTest.length());
        System.out.println("Can I write? " + fileTest.canWrite());
        System.out.println("Can I read? " + fileTest.canRead());
        System.out.println("Is it a file? " + fileTest.isFile());
        System.out.println("Is it a folder? " + fileTest.isDirectory());
        System.out.println("=========");

        File fileFolder = new File("C:\\Users\\anduser\\Desktop\\additional\\file");
        System.out.println("Is it a file? " + fileFolder.isFile());
        System.out.println("Is it a folder? " + fileFolder.isDirectory());
        int counter = 1;
        for (File file: fileFolder.listFiles()){
            System.out.println(counter + ") " + file.getName());
            counter++;
        }
        //fileTest.createNewFile();
    }
}
