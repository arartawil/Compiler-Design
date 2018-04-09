package com.company;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * A1->printA2
 * A2->" A3 |( A3
 * A3->" A4 |) A4
 * A4->;
 */
public class ParserTable {


    String firstResult="";
    boolean [] accept=new boolean[4];
    int count=0;
    Map<Integer, String> Grammer = new HashMap<Integer, String>();
    Map<Integer,Boolean> valid=new HashMap<Integer, Boolean>();
    int[][] table = new int[][]{
            {0, -1, -1, -1, -1, -1},
            {-1, 1, -1, 2, -1, -1},
            {-1, -1, 3, -1, 4, -1},
            {-1, -1, -1, -1, -1, 5}
    };

    public ParserTable() throws Exception {

        fillMap();

    }


    public void fillMap() {
        Grammer.put(0, "A1->printA2");
        Grammer.put(1, "A2->\"A4");
        Grammer.put(2, "A2->( A4");
        Grammer.put(3, "A3->\"A4");
        Grammer.put(4, "A3->)A4");
        Grammer.put(5, "A4->;");

        valid.put(1,false);
        valid.put(2,false);
        valid.put(3,false);
        valid.put(4,false);

    }

    public String parseS(ArrayList<String> toParse) {

        switch (toParse.get(0)) {


            case "print":
                 parseW(toParse);
                if (toParse.size() > 0 && toParse.get(0) != ".") parseTail2(toParse);
                return " ";

            default:
                System.err.println("parse error");
                return "error";
        }
    }

    public  String parseW(ArrayList<String> toParse)
    {
        accept[count++]=match(toParse, "print",0);
         parseTail2(toParse);
        return " ";
    }

    public void parseTail2(ArrayList<String>toParse)
    {
        switch (toParse.get(0))
        {
            case"\"":
                int x=doubleQ();
                accept[count++]=match(toParse,"\"",x);
                parseTail2(toParse);break;
            case "(":
                accept[count++]=match(toParse,"(",3);
                parseTail2(toParse);break;

            case ")":
                accept[count++]=match(toParse,")",4);
                parseTail2(toParse);break;

            case  ";":
                accept[count++]=match(toParse,";",5);
                parseTail2(toParse);break;

            default: validation();break;

        }
    }


    public int doubleQ()
    {
        if(valid.get(1)==false)return 1;
        else return 2;
    }

    public   boolean match(ArrayList<String> s, String c,int x)
    {
        for(int i=0;i<4;i++)
        {
            if(x==4){if(!(valid.get(3)==true))return false;}

            if(table[i][x]!=-1)
            {
                s.remove(0);
                if(!c.equals("print"))
                valid.put(x,true);
                return true;
            }

        }

        System.err.println("Error in print ");
        return false;

    }

    public void validation()
    {
        int result=0;
        for(int i=0;i<accept.length;i++)
        {
            if(accept[i]==true)result++;
        }
        if(result%2==0) {System.out.println("Your code it done");}
        else
            System.out.println("Not done");
    }

}
