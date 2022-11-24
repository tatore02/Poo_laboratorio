package it.unisa.phonecompany;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PhoneCompany {
    List<User> users;

    private final double minutePrice;
    private final double smsPrice;
    private final double gbPrice;

    public PhoneCompany(double minutePrice, double smsPrice, double gbPrice) {
        this.users = new ArrayList<>();
        this.minutePrice = minutePrice;
        this.smsPrice = smsPrice;
        this.gbPrice = gbPrice;
    }

    public List<User> getUsers() {
        return users;
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        while(in.hasNextLine()){
            try{
                int code = Integer.parseInt(in.nextLine());
                String name = in.nextLine();
                String lastName = in.nextLine();
                int usedMinutes = Integer.parseInt(in.nextLine());
                int usedSMS = Integer.parseInt(in.nextLine());
                double usedMB = Double.parseDouble(in.nextLine());
                User user = new User(code,lastName,lastName);
                user.setUsedMinutes(usedMinutes);
                user.setUsedSMS(usedSMS);
                user.setUsedMB(usedMB);
                this.users.add(user);
            }
            catch (NoSuchElementException | NumberFormatException ex){
                System.err.println("Il formato del file è errato!");
                ex.printStackTrace();
            }
        }
    }

    public void writeUserDataToFile(File file, boolean overwrite) throws FileNotFoundException, FileAlreadyExistsException {
        if(overwrite == false){
            if(file.exists())
                throw new FileAlreadyExistsException("Il file già esiste");
            else
                writeUserDataToFile(file);
        }
        else{
            String tmpFileName = file.getParentFile().getName() + File.separator + "tmp_" + file.getName();
            File tmpFile = new File(tmpFileName);
            writeUserDataToFile(tmpFile);
            file.delete();
            tmpFile.renameTo(file);
        }
    }

    public void writeUserDataToFile(File file) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(file);
        for(User user : this.users){
            out.println(user.getCode());
            out.println(user.getName());
            out.println(user.getLastName());
            out.println(user.getUsedMinutes());
            out.println(user.getUsedSMS());
            out.println(user.getUsedMB());
        }
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        this.users = (List<User>) in.readObject();
        in.close();
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(this.users);
        out.close();
    }

    public User findUserByCode(int code) {
        for (User user : this.users) {
            if (user.getCode() == code) {
                return user;
            }
        }
        return null;
    }

    public void computeUserCost(User user) {
        int usedMinutes = user.getUsedMinutes();
        int usedSMS = user.getUsedSMS();
        double usedMB = user.getUsedMB();
        user.setTotalCost(usedMinutes * minutePrice + usedSMS * smsPrice + usedMB * gbPrice / 1000);
    }
}
