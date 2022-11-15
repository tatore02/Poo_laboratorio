import java.util.*;

public class TryAgain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sum = 0;
        int trials = 0;
        while(true){
            System.out.println("Inserire un double:");
            try{
                sum += in.nextDouble();
                trials = 0;
            }catch (InputMismatchException e){
                trials++;
                if(trials == 2)
                    break;
            }finally {
                in.nextLine();
            }
        }

        System.out.println("Il totale dei valori inseriti è " + sum);
    }
}