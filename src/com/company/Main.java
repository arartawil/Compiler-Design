package com.company;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main
{
    static ArrayList<String> data=new ArrayList<String>();
    public static void main(String[] args) throws Exception
    {
        new Language();
        ReadCode2 readCode=new ReadCode2("Files/test.txt");

        for(int i=0;i<TokenAll.tokenList.size();i++)
            data.add(TokenAll.tokenList.get(i).attribute.get(0));


        Parser parser=new Parser();

        data.add(".");
        String parseTree = parser.parseS(data);
        parser.match(data, ".");

        System.out.println(parseTree);

    }


}
