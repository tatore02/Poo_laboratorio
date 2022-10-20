import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSeller {
    private final List<Car> cars;

    public CarSeller() {
        this.cars = new ArrayList<>();
    }

    public void readCarFromFile(File file) throws FileNotFoundException{
        Scanner input = new Scanner(file);
        while(input.hasNext()){
            String brand = input.nextLine();
            String model = input.nextLine();
            int manuFacturingYear = Integer.parseInt(input.nextLine());
            int price = Integer.parseInt(input.nextLine());

            Car car = new Car(brand,model,manuFacturingYear,price);
            this.cars.add(car);
        }
    }

    public List<Car> findCarByBrandAndModel(String brand,String model){
        List<Car> searchingCars = new ArrayList<>();
        for(Car search : this.cars){
            if(search.getBrand() == brand && search.getModel() == model)
                searchingCars.add(search);
        }
        return searchingCars;
    }

    public List<Car> findCarByBrand_Model_Year(String brand,String model,int year){
        List<Car> searchingCars = new ArrayList<>();
        searchingCars = findCarByBrandAndModel(brand,model);    //reuse code

        for(Car search : searchingCars){
            if(search.getManufacturingYear() < year)    //se l'auto è vecchia, rimuovi
                searchingCars.remove(search);
        }
        return searchingCars;
    }

    public List<Car> findCarByBrand_Model_Price(String brand,String model,int startPrice,int endPrice){
        List<Car> searchingCars = new ArrayList<>();
        searchingCars = findCarByBrandAndModel(brand,model);    //reuse code

        for(Car search : searchingCars){
            if(search.getPrice() < startPrice || search.getPrice() > endPrice)
                searchingCars.remove(search);
        }
        return searchingCars;
    }
}