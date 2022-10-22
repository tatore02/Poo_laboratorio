package it.unisa.SMS;

import java.util.GregorianCalendar;

public class SMS {

    private String sender;
    private int code;
    private GregorianCalendar date;
    private static int totSms;      //variabile condivisa tra tutti gli oggetti SMS
    private String text;

    public SMS(String sender,GregorianCalendar date,String text){
        this.sender = sender;
        this.date = date;
        this.text = text;
        this.code = this.totSms;
        this.totSms++;
    }

    public GregorianCalendar getDate(){
        return this.date;
    }

    public String getSender(){
        return this.sender;
    }

    public String getText(){
        return this.text;
    }

    public int getCode(){
        return this.code;
    }
}