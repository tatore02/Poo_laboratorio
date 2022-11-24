package it.unisa.carseller;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;

public class CarSeller {
    private List<Car> cars;

    public CarSeller() {
        this.cars = new ArrayList<>();
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        this.cars = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            try {
                String brand = input.nextLine();
                String model = input.nextLine();
                int manufacturingYear = Integer.parseInt(input.nextLine());
                double price = Double.parseDouble(input.nextLine());
                Car car = new Car(brand, model, manufacturingYear, price);
                this.cars.add(car);
            } catch (NoSuchElementException | NumberFormatException ex) {
                System.err.println("Il formato del file è errato!");
                ex.printStackTrace();
            }
        }
    }

    public void writeUserDataToFile(File file, boolean overwrite)throws FileAlreadyExistsException,FileNotFoundException {
        if(overwrite == false){
            if(file.exists()){
                new FileAlreadyExistsException("Il file già esiste");
            }
            else writeUserDataToFile(file);
        }
        else {
            file.delete();
            File newFile = new File(file.getParent(),file.getName());
            writeUserDataToFile(newFile);
        }
    }

    public void writeUserDataToFile(File file) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(file);
        for(Car car : this.cars){
            out.println(car.getBrand());
            out.println(car.getModel());
            out.println(car.getManufacturingYear());
            out.println(car.getPrice());
        }
        out.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        this.cars = (List<Car>) in.readObject();
        in.close();
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(this.cars);
        out.close();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> returnCarByBrandAndModel(String brand, String model) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand) && car.getModel().equals(model)) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public List<Car> returnCarByBrandModelAndYear(String brand, String model, int manufacturingYear) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand)
                    && car.getModel().equals(model)
                    && car.getManufacturingYear() >= manufacturingYear) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    public List<Car> returnCarByBrandAModelYearAndPrice(String brand, String model, int manufacturingYear, int minPrice, int maxPrice) {
        List<Car> suitableCars = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.getBrand().equals(brand)
                    && car.getModel().equals(model)
                    && car.getManufacturingYear() >= manufacturingYear
                    && car.getPrice() >= minPrice
                    && car.getPrice() <= maxPrice) {
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }
}