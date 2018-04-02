package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class TokenAll {
    int x = 0;
    int end = 1;

    public static ArrayList<Token> tokenList = new ArrayList<>();
    static ArrayList<Token> tokenlistConst = new ArrayList<>();

    public void Tokenization(String data) {
        x = 0;
        end = 1;
        int number = 0;
        String temp="";
        boolean doubleQutain = false;
        int sizeRw = 0;
        while (x < data.length()) {
            if(end>data.length()){break;}
             temp = data.substring(x, end);
            int num=data.length()-number-sizeRw;
            int num2=temp.length();
            if ( num2==num  && !data.contains("\"") && !data.contains("(")) {
                Token token = new Token();
                token.tokenval = "ID_T";
                if(data.contains(";"))
                token.attribute.add(temp.substring(0, temp.length()-1));
                else
                    token.attribute.add(temp.substring(0, temp.length()));
                tokenList.add(token);
                x++;
                end = x;
            }
            if (temp.equals(" ")) {
                x++;
                end++;
                number++;
                continue;
            }
            if ((temp.equals("\"")) && doubleQutain==false) {
                String n="";
                int i=0;
                Token token = new Token();
                token.tokenval = "Constant_T";

                for( i=x+1;i<data.length();i++)
                {
                    if(data.charAt(i)==';' ){x=i;break;}
                   else if(data.charAt(i)=='"'){x=i;break;}
                    else if(data.charAt(i)=='\n') {x=i;break;}
                    doubleQutain=true;
                    n+=data.charAt(i);
                    x=i;
                }
                token.attributeCon=n;
                //token.attributeCon = temp.substring(0, temp.length() - 1);
                tokenlistConst.add(token);

                //x = (6 + number) + temp.length();
                end = x;
            }
            String found = Language.scan(temp);
            if (Language.foundRw) {
                Token token = new Token();
                sizeRw = found.length();
                token.tokenval = found + "_T";
                tokenList.add(token);
                x = end;
                end = x + 1;

            } else if (Language.foundSpical) {
                Token token = new Token();
                token.tokenval = found + "_T";
                token.attribute.add(temp.substring(0,temp.length()));
                tokenList.add(token);
                x = end;
                end = x + 1;

            } else if (Language.foundOP) {
                Token token = new Token();
                token.tokenval = found + "_T";
                tokenList.add(token);
                x = end;
                end = x + 1;
            } else {
                end++;
            }
        }
    }

    public static void showToken() throws Exception {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("Files/Token"));
        for (int i = 0; i < tokenList.size(); i++) {
            // Maybe:
            if (!tokenList.isEmpty()) {
                outputWriter.write(tokenList.get(i).tokenval + "\n" + tokenList.get(i).attribute);
                outputWriter.newLine();
            }
        }
        outputWriter.flush();
        outputWriter.close();
    }
}
