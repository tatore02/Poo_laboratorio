package it.unisa.SMS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SMSOrganizer {

    private List<SMS> smsList;

    public SMSOrganizer(){
        this.smsList = new ArrayList<>();
    }

    public void add(SMS sms){
        this.smsList.add(sms);
    }

    public List<SMS> getListByDate(){
        this.smsList.sort(new Comparator<>() {
            @Override
            public int compare(SMS sms1, SMS sms2) {
                return sms1.getDate().compareTo(sms2.getDate());
            }
        });
        return this.smsList;
    }

    public List<SMS> getListBySender(){
        this.smsList.sort(new Comparator<SMS>() {
            @Override
            public int compare(SMS sms1, SMS sms2) {
                return sms1.getSender().compareTo(sms2.getSender());
            }
        });
        return this.smsList;
    }
}
