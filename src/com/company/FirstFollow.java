package com.company;

import java.util.*;

/**
 * A1->printA2
 * A2->" A3 |( A3
 * A3->" A4 |) A4
 * A4->;
 */

public class FirstFollow
{
    HashSet<String>NonTerminal=new HashSet<String>();
    Map<Integer, String> Grammer = new HashMap<Integer, String>();
    Map<HashSet<String>,LinkedList<String>>divdgram=new HashMap<>();
    String [] First=new String[4];
   public FirstFollow()
   {
       fillGram();
       getNonTer();
      divdGram();
      findFirst();
   }
   public void fillGram()
   {
       Grammer.put(0, "A1-A5 A2");
       Grammer.put(1, "A2-\" A4");
       Grammer.put(2, "A2-( A4");
       Grammer.put(3, "A3-\" A4");
       Grammer.put(4, "A3-) A4");
       Grammer.put(5, "A4-;");
   }

   private void divdGram()
   {
       for(int i=0;i<Grammer.size();i++)
       {
           String []a=Grammer.get(i).split("-");
           HashSet<String>set=new HashSet<>();
           set.add(a[0]);
           divdgram.put(set,getLeftSide(a[0]));
       }

   }

   private LinkedList getLeftSide(String data)
   {
       LinkedList<String>list=new LinkedList<>();
       for(int i=0;i<Grammer.size();i++)
       {
           String []a=Grammer.get(i).split("-");
           if(a[0].equals(data))
           {
               list.add(a[1]);
           }
       }
       return list;
   }

   private void getNonTer()
   {
       for(int i=0;i<Grammer.size();i++)
       {
           String []a=Grammer.get(i).split("-");
           NonTerminal.add(a[0]);
       }

   }

   private  void findFirst()
   {
       // using iterators
       Iterator<Map.Entry<HashSet<String>, LinkedList<String>>> itr = divdgram.entrySet().iterator();
       int count=0;
       while(itr.hasNext())
       {

           String []a=null;
           Map.Entry<HashSet<String>, LinkedList<String>> entry = itr.next();
           if(Character.isLowerCase(Character.valueOf(entry.getValue().get(0).charAt(0))) ||
                   !(Character.isLetter(entry.getValue().get(0).charAt(0)))||
                   !(Character.isDigit(entry.getValue().get(0).charAt(0)))) {

               a = entry.getValue().get(0).split(" ");
               First[count]=a[0];

               try {
                   if (entry.getValue().get(1) != null) {
                       a = entry.getValue().get(1).split(" ");
                       First[count++]+=" "+a[0];
                   }
               }
               catch (Exception ex){count++;}


           }
       }

       for(int i=0;i<First.length;i++)
           System.out.println(First[i]);

   }


   /*private String A1()
   {
       return "print";
   }

   private String A2()
   {
       return "\" ,(";
   }

   private String A3()
   {
       return "\",)";
   }
   private String A4()
   {
       return ";";
   }
*/


}
