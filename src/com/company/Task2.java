package com.company;

public class Task2 {
    private StringBuilder text;
    private String DEFAULT_TEXT="Nu i gde tvoi text?";

    public  Task2() {text=new StringBuilder(DEFAULT_TEXT);}
    public  Task2(String txt) {text=new StringBuilder(txt);}
    public String getText(){
        return text.toString();
    }

    public void DigitSwaper(){
        int s=0;
        for (int i=0;i<text.length();i++){
            if (Character.isDigit(text.charAt(i))){s+=1;}
            if(s==2 && i==text.length()-1){
                text.setCharAt(i-1,'+');
                text.setCharAt(i,'+');
            }
            else if(s==2 && !Character.isDigit(text.charAt(i+1))){
                text.setCharAt(i-1,'+');
                text.setCharAt(i,'+');
                s=0;
            }
            else if(i==text.length()-1||!Character.isDigit(text.charAt(i+1))){s=0;}
        }
    }

    public void End(){
        String[] sent=text.toString().split("\\.");
        int min=-1;
        int mini=0;
        for (int i=0;i<sent.length;i++){
            if (min>sent[i].split(" ").length){min=sent[i].split(" ").length;mini=i;}
        }
        sent[mini]=sent[mini]+" КОНЕЦ";
        StringBuilder buf=new StringBuilder();
        for (int i=0;i<sent.length;i++){
            buf.append(sent[i]+".");
        }
        this.text=buf;
    }

    public void DigitSwaper3(){
        int s=0;
        for (int i=0;i<text.length();i++){
            if (Character.isDigit(text.charAt(i))){s+=1;}
            if(s==3 && i==text.length()-1){
                char buf=text.charAt(i-2);
                text.setCharAt(i-2,text.charAt(i));
                text.setCharAt(i,buf);
            }
            else if(s==3 && !Character.isDigit(text.charAt(i+1))){
                char buf=text.charAt(i-2);
                text.setCharAt(i-2,text.charAt(i));
                text.setCharAt(i,buf);
                s=0;
            }
            else if(i==text.length()-1||!Character.isDigit(text.charAt(i+1))){s=0;}
        }
    }
}
