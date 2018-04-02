package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageReg
{
    public static void Image(File file) throws Exception
    {
        BufferedImage originalImage = ImageIO.read(file);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(originalImage, "jpg", baos);
        byte[] imageInByte = baos.toByteArray();

        StringBuilder check = new StringBuilder();
        for(int i = 0; i < imageInByte.length; i++)
        {
            check.append(Integer.toBinaryString(imageInByte[i]));
        }

        String array[] = check.toString().split("");


            System.out.println(check);


        //for(int i = 0; i < array.length; i++){
          //  System.out.print(array[i]);
        //}
    }

    public static void image(File file) throws Exception {

        Image image = ImageIO.read(file);
        //Get width
        int width = image.getWidth(null);
        //Get height
        int height = image.getHeight(null);

        String s = "[508][510]";
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(String.valueOf(height));
        while (matcher.find()) {
            System.out.println("Done");
            }




            System.out.println("Width:" + width + "  Height:" + height);
        }
    }
