package it.unisa.phonecompany;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;

public class PhoneCompanyTest {
    @Test
    public void testSolution() {
        PhoneCompany phoneCompany = new PhoneCompany(0.10, 0.05, 2);
        try {
            File file = Path.of("test/").resolve("testData.txt").toFile();
            phoneCompany.readUserDataFromFile(file);
            User user1 = phoneCompany.findUserByCode(1);
            phoneCompany.computeUserCost(user1);
            Assert.assertEquals(22.25, user1.getTotalCost(), 0);
            User user2 = phoneCompany.findUserByCode(2);
            phoneCompany.computeUserCost(user2);
            Assert.assertEquals(12.25, user2.getTotalCost(), 0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void writeUserDataToFileTest() {
        PhoneCompany phoneCompany = new PhoneCompany(0.10, 0.05, 2);
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            phoneCompany.readUserDataFromFile(file);
            int originUsedMinutes = phoneCompany.getUsers().get(0).getUsedMinutes();    //salvo i minuti
            phoneCompany.getUsers().get(0).setUsedMinutes(100);
            phoneCompany.writeUserDataToFile(file,true);

            phoneCompany.readUserDataFromFile(file);
            Assert.assertEquals(100,phoneCompany.getUsers().get(0).getUsedMinutes());

            //resetto i minuti
            phoneCompany.getUsers().get(0).setUsedMinutes(originUsedMinutes);
            phoneCompany.writeUserDataToFile(file,true);
        }
        catch (FileNotFoundException | FileAlreadyExistsException ex){
            throw new RuntimeException(ex);
        }
    }

    @Test
    public void writeSerializedDataToFileTest() {
        PhoneCompany phoneCompany = new PhoneCompany(0.10, 0.05, 2);
        File file = Path.of("test/").resolve("testData.txt").toFile();
        File binFile = new File("test/testData.dat");
        try {
            phoneCompany.readUserDataFromFile(file);
            phoneCompany.writeSerializedDataToFile(binFile);

            phoneCompany.readSerializedDataFromFile(binFile);
            Assert.assertEquals(2,phoneCompany.getUsers().size());  //ERRORE

            binFile.delete();
        }
        catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}