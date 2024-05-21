package lesson8.file;

import java.io.*;

public class FileInputAndOutputStream {
    public static void main(String[] args) {

        //write in file
        try(FileOutputStream outputStream =
                new FileOutputStream("C:\\Users\\anduser\\Desktop\\additional\\file\\text2.txt")
        ){
            outputStream.write("Text for example".getBytes());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        //read
        byte[] bufferByte = new byte[10];
        StringBuilder textForRead = new StringBuilder();
        try(FileInputStream fileInput =
                    new FileInputStream("C:\\Users\\anduser\\Desktop\\additional\\file\\text2.txt")
        ){
           int count;
           while((count=fileInput.read(bufferByte)) > 0){
               for (int i = 0; i < count; i++){
                   textForRead.append((char) bufferByte[i]);
               }
           }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(textForRead);
    }
}
