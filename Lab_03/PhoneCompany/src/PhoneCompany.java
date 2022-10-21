import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneCompany {
    List<User> users;

    private final double minutePrice;
    private final double smsPrice;
    private final double gbPrice;

    public PhoneCompany(double minutePrice,double smsPrice,double gbPrice){
        this.minutePrice =  minutePrice;
        this.smsPrice = smsPrice;
        this.gbPrice = gbPrice;

        this.users = new ArrayList<>();
    }

    public void add(User user){
        this.users.add(user);
    }

    public User findUserByCode(int code){
        for(User r : this.users)
            if(r.getCode() == code)
                return r;
        return null;
    }

    public void calculateTotalCost(User user){
        int minutes = user.getUsedMinutes();
        int sms = user.getUsedSMS();
        double mb = user.getUsedMB();

        double total = (minutes * this.minutePrice + sms * this.smsPrice + (mb/1000) * this.gbPrice);
        user.setTotalCost(total);
    }

}
