package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadCode2
{
    private ArrayList<String> lines=new ArrayList<>();
    private String [] splite;
    String line="";
    TokenAll tokenAll=new TokenAll();
    public ReadCode2(String nameFile) throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader(nameFile));
        while((line=br.readLine())!=null) {
            lines.add(line);
        }
        for(int i=0;i<lines.size();i++)
        {
            tokenAll.Tokenization(lines.get(i));
        }
        TokenAll.showToken();
        //Grammar gammer=new Grammar();
    }



}
