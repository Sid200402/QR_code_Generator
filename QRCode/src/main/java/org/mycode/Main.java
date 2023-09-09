package org.mycode;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        try {
            File file = new File("C:\\Users\\siddh\\OneDrive\\Desktop\\Out_put\\img.jpg");
            String content = sc.next();

            ByteArrayOutputStream output =QRCode.from(content).to(ImageType.JPG).stream();

            FileOutputStream file_write=new FileOutputStream(file);
            file_write.write(output.toByteArray());
            file_write.close();
            System.out.println("Your QR code is genarated successfully ");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}