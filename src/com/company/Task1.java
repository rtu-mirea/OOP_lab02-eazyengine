package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Task1 {
    private String text;
    private String DEFAULT_TEXT="Nu i gde tvoi text?";

    public  Task1() {text=DEFAULT_TEXT;}
    public  Task1(String txt) {text=txt;}

    public String getText(){
        return text;
    }

    private String removePunct(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isSpaceChar(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String[] removeDuplicates(String[] array){
        ArrayList<String> res=new ArrayList<>();
        Arrays.stream(array).distinct().forEach(x -> res.add(x));
        return res.stream().toArray(String[]::new);
    }

    public void ToLower(){
        this.text=this.text.toLowerCase();
    }

    public String[] ToArr() { return removePunct(text).split(" ");}

    public void WordAm(){
        ArrayList<String> amounts=new ArrayList();
        String buf=this.text.toLowerCase();
        String[] b=removePunct(buf).split(" ");
        String[] words=removeDuplicates(removePunct(buf).split(" "));
        for(int i=0;i<words.length;i++){
            int a=0;
            for(int j=0;j<b.length;j++){
                if (words[i].equals(b[j])){
                    a++;
                }
            }
            amounts.add(Integer.toString(a));
        }
        String[][] res=new String[2][];
        res[0]=words;
        res[1]=amounts.stream().toArray(String[]::new);
        System.out.println("Слова: ");
        for (int i=0;i<res[0].length;i++){
            System.out.println(res[0][i]+": "+res[1][i]);
        }
    }

    public int prefam(String pref){
        String buf=this.text.toLowerCase();
        String[] b=removePunct(buf).split(" ");
        int am=0;
        char[] pr = pref.toCharArray();
        for (int i=0;i<b.length;i++){
            char[] cur=b[i].toCharArray();
            if (pr.length<=cur.length){
                int f=0;
                for (int j=0;j<pr.length;j++){
                    if (cur[j]==pr[j]){
                        f+=1;
                    }
                }
                if(f==pr.length){
                    am+=1;
                }
            }
        }
        return am;
    }
}
