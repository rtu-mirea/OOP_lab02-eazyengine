package com.company;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Task3 {
    private String data;
    private String DEFAULT_TEXT="Nu i gde tvoi text?";

    public Task3 () {data=DEFAULT_TEXT;}
    public Task3 (String dat){data=dat;}

    public boolean rightRus(String a){
        return Pattern.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$",a);
    }

    public String getData(){return data;}

    public boolean rightUS(String a){
        String dat=a.replaceAll("\\.","/");
        dat=dat.replaceAll("-","/");
        return Pattern.matches("^(((0?[1-9]|1[012])/(0?[1-9]|1\\d|2[0-8])|(0?[13456789]|1[012])/(29|30)|(0?[13578]|1[02])/31)/(19|[2-9]\\d)\\d{2}|0?2/29/((19|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|(([2468][048]|[3579][26])00)))$",dat.toString());
    }


    public String swap(){
        String buf=this.data;
        String[] b=buf.split(" ");
        for (int i=0; i<b.length;i++){
            String[] el=b[i].split("\\.");
            if (el.length==3){b[i]=String.join(".",el);}
            if (rightUS(b[i])&&!rightRus(b[i])){
                String[] elem=b[i].split("\\.");
                String res=elem[1]+"."+elem[0]+"."+elem[2];
                buf=buf.replaceAll(b[i],res);
            }
        }
        return buf;
    }
}
