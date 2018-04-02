package com.company;

import java.util.ArrayList;

public class Token
{
    String tokenval;
    String attributeCon;
    String ValueCon;
    String []Value=new String[20];
    ArrayList<String>attribute=new ArrayList<>();
    public Token()
        {
        for(int i=0;i<20;i++)
        {
        // this.attribute[i]="";
        this.Value[i]="";
        }
        }
        }
