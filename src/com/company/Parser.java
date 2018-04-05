package com.company;

import java.util.ArrayList;

/**
 *
 * A1->printA2
 * A2->SP A3
 * A3->SP A4
 * A4->SEM
 * SP->'|"|(|)
 * SEM->;
 * S->" "

 */

public class Parser
{
	String firstResult="";



    public String parseS(ArrayList<String> toParse)
    {

	switch (toParse.get(0))
	    {
	    case "$":
		match(toParse, "$");
		return "(S $ " + parseTail1(toParse) + ")";
		
	    case "print":
	    	firstResult+="(S " + parseW(toParse) + ")";
	    	if (toParse.size()>0 && toParse.get(0)!=".")parseS(toParse);
	    	return firstResult;

	    default:
		System.err.println("parse error");
		return "error";
	    }
    }

    private  String parseTail1(ArrayList<String> toParse)
    {
	switch (toParse.get(0))
	    {
	    case ".":
		return "(tail1)";
		
	    case "a":
	    case "$":
		return "(tail1 " + parseS(toParse) + ")";

	    default:
		System.err.println("parse error");
		return "error";
	    }
    }

    public  String parseW(ArrayList<String> toParse)
    {
	match(toParse, "print");
		String test=parseTail2(toParse);
		System.out.println(test);
	return "(A1 print " + test + ")";
    }

    public   String parseTail2(ArrayList<String> toParse)
    {
	switch (toParse.get(0))
	    {
	    case "\"":
		match(toParse, "\"");
		match(toParse, "\"");
		match(toParse,";");
		return "(A2(A3(A4 (\" \" ; )";



	    default:
		System.err.println("parse error");
		return "error";
	    }
    }

    public   void match(ArrayList<String> s, String c)
    {
	if (s.size() > 0 && s.get(0).equals(c))
	    {
		s.remove(0);
	    }
	else
	    {
		System.err.println("parse error " + s + " " + c);
	    }
    }


}

	
