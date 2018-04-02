package com.company;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class Language
{
    static ArrayList<String>lag=new ArrayList<String>();
    static boolean flag=false;
    static String [] RW;
    static String [] Spical;
    static String [] Operation;
    static boolean foundRw=false;
    static boolean foundSpical=false;
    static boolean foundOP=false;


    public Language() throws  Exception
    {
        readFileLag();
    }

    public void readFileLag() throws  Exception
    {
        String line="";
        File file=new File("Files/Lag");
        FileReader fr =new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        while((line=br.readLine()) != null)
        {
            lag.add(line);
        }
        RW=lag.get(0).split(" ");
        Spical=lag.get(1).split(" ");
        Operation=lag.get(3).split(" ");
    }

    public static String scan(char p,String code)
    {
        boolean found=false;
        int index=0;
        int count=0;
        String []Rw=lag.get(0).split(" ");
        while(true && count<Rw.length)
        {
         String data=Rw[count];
         for(int i=0;i<data.length();i++)
         {
             if(data.charAt(i)==code.charAt(i)){found=true; index=count; continue;}
             else break;
         }
         if(found)
             return Rw[index];
         count++;
        }
        return null;
    }


    private static String scanRw(String data)
    {
        String kind="";
        int index=0;
        int count=0;
        String tempRW="";
        while (true && count<RW.length) {
            tempRW = RW[count];
            for (int i = 0; i < data.length(); i++) {
                if (data.equals(tempRW)) {
                    foundRw = true;
                    index = count;
                    continue;
                } else break;
            }

            if (foundRw)
                return RW[index];
            count++;
        }
        return null;
    }

    private static  String scanSpical(String data)
    {

        String kind="";
        int index=0;
        int count=0;
        String tempSp="";
        while (true && count<Spical.length) {
            tempSp = Spical[count];
            for (int i = 0; i < data.length(); i++) {
                if (data.equals(tempSp)) {
                    foundSpical = true;
                    index = count;
                    continue;
                } else break;
            }
            if (foundSpical)
                return "Sp";

            count++;
        }
        return null;
    }


    public static String scanoperation(String data)
    {
        String kind="";
        int index=0;
        int count=0;
        String tempOp="";

        while(true && count<Operation.length)
        {
            tempOp=Operation[count];
            for(int i=0;i<data.length();i++)
            {
                if(data.equals(tempOp)){foundOP=true ;index=count; continue;}
                else break;
            }
            if(foundOP)
                return "Op";
            count++;
        }
        return null;
    }

    public static String scan(String data)
    {
        foundOP=false;
        foundSpical=false;
        foundRw =false;

        String n=scanRw(data);
        if(foundRw)return n;


        n=scanSpical(data);
        if(foundSpical)return n;

        n=scanoperation(data);
        if(foundOP) return n;



        return null;
    }


}
