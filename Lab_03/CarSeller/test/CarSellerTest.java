import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CarSellerTest {
    @Test
    public void findCarByBrandAndModelTest(){
        CarSeller carSeller = new CarSeller();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            carSeller.readCarFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Car> l = carSeller.findCarByBrandAndModel("Tesla","Model Y");
        Assert.assertEquals(2,l.size());
    }

    @Test
    public void findCarByBrand_Model_YearTest(){
        CarSeller carSeller = new CarSeller();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            carSeller.readCarFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Car> l = carSeller.findCarByBrand_Model_Year("Tesla","Model Y",2021);
        Assert.assertEquals(1,l.size());
    }

    @Test
    public void findCarByBrand_Model_PriceTest(){
        CarSeller carSeller = new CarSeller();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            carSeller.readCarFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Car> l = carSeller.findCarByBrand_Model_Price("Tesla","Model Y",50000,70000);
        Assert.assertEquals(1,l.size());
    }
}