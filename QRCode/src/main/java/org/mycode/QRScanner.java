package org.mycode;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

public class QRScanner {
    public static void main(String[] args) {
        try {
            JFileChooser ch=new JFileChooser();
            ch.showOpenDialog(null);
           File file=ch.getSelectedFile();
           if (file==null){
               throw new Exception("invalid file");
           }

            Result result=
                    new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(file)))));
            JOptionPane.showMessageDialog(null,result.getText(),"Content",JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(file.getAbsolutePath()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
