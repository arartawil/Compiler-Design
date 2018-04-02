package com.company;

import java.util.ArrayList;

public class Grammar
{
    ArrayList<Token> tokenList=new ArrayList<>();
    public Grammar()
    {
        this.tokenList=TokenAll.tokenList;
        Scan();
    }
    public void Scan()
    {
        for(int i=0;i<this.tokenList.size();i++)
        {
          switch (tokenList.get(i).tokenval)
          {
              case "print_T":
              {
                 boolean fixed=scanPrint(i);
                 if(fixed)
                  System.out.println("the print code if true");
                 else
                     System.out.println("Error");
              }break;
              case "int_T":
              {
                  boolean fixed=scanInt(i);
                  if(fixed) System.out.println("correct int");
                  else
                      System.out.println("incorrect");
              }break;

              case "float_T":
              {
                  boolean fixed=scanFloat(i);
                  if(fixed) System.out.println("correct float");
                  else
                      System.out.println("incorrect");
              }break;

              case "double_T":
              {
                  boolean fixed=scanDouble(i);
                  if(fixed) System.out.println("correct double");
                  else
                      System.out.println("incorrect");
              }
          }
        }
    }

    private boolean scanDouble(int i)
    {
        i++;
        if(Character.isDigit(tokenList.get(i).attribute.get(0).charAt(0))) return false;

        for(int j=0;j<tokenList.get(i).attribute.get(0).length();j++)
        {

            if(Character.isDigit(tokenList.get(i).attribute.get(0).charAt(j))==false && Character.isLetter(tokenList.get(i).attribute.get(0).charAt(j))==false)
                return false;
        }
        try {


            if (tokenList.get(++i).attribute.get(0).equals(";")) return true;
            else return false;
        }
        catch (Exception ex){return  false;}

    }

    private boolean scanFloat(int i)
    {
        i++;
        if(Character.isDigit(tokenList.get(i).attribute.get(0).charAt(0))) return false;

        for(int j=0;j<tokenList.get(i).attribute.get(0).length();j++)
        {

            if(Character.isDigit(tokenList.get(i).attribute.get(0).charAt(j))==false && Character.isLetter(tokenList.get(i).attribute.get(0).charAt(j))==false)
                return false;
        }
        try {
            if (tokenList.get(++i).attribute.get(0).equals(";")) return true;
            else return false;
        }
        catch (Exception ex){return false;}
    }

    private boolean scanInt(int i)
    {
        i++;
        if(Character.isDigit(tokenList.get(i).attribute.get(0).charAt(0))) return false;

        for(int j=0;j<tokenList.get(i).attribute.get(0).length();j++)
        {

             if(Character.isDigit(tokenList.get(i).attribute.get(0).charAt(j))==false && Character.isLetter(tokenList.get(i).attribute.get(0).charAt(j))==false)
                return false;
        }

        try {

            if (tokenList.get(++i).attribute.get(0).equals(";")) return true;
            else return false;
        }
        catch (Exception ex){return false;}
    }


    private boolean scanPrint(int i)
    {
        switch (tokenList.get(++i).attribute.get(0))
        {
            case "(":
            {
                switch (tokenList.get(++i).attribute.get(0))
                {
                    case"\"":
                    {
                        try {

                            if (tokenList.get(++i).attribute.get(0).equals("\"") && tokenList.get(++i).attribute.get(0).equals(")") && tokenList.get(++i).attribute.get(0).equals(";")) {
                                return true;
                            }
                            return false;
                        }
                        catch (Exception ex)
                        {
                            return false;
                        }

                    }
                }
            }break;
            case "\"":
            {
                try {

                    if (tokenList.get(++i).attribute.get(0).equals("\"") && tokenList.get(++i).attribute.get(0).equals(";")) {
                        return true;
                    } else return false;
                }
                catch (Exception ex)
                {
                    return false;
                }

            }
        }
        return false;
    }


}
