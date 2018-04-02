package com.company;


import java.io.File;
import java.util.ArrayList;


public class Main
{
    ArrayList<Token>token=new ArrayList<>();
    public static void main(String[] args) throws Exception
    {
        //new Language();
        //ReadCode2 readCode=new ReadCode2("Files/test.txt");

        //System.out.println(Reg.stringWithvaels("Plate"));
        File file=new File("Files/E.png");
        //ImageReg.Image(file);
        ImageReg.image(file);

    }


}
