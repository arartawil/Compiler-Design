package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg
{

public static boolean numberornot(String data)
{
    String pattern="^\\b[^\\d\\W]+\\b";
    Pattern pattern1=Pattern.compile(pattern);
    Matcher m=pattern1.matcher(data);

    if(m.find())return true;
    else return false;
}

public static boolean stringWithvaels(String data)
{

    String pattern="[^aeiou]+$";
    Pattern pattern1=Pattern.compile(pattern);
    Matcher m=pattern1.matcher(data.toLowerCase());

    if(m.find())return true;
    else return false;

}

}
