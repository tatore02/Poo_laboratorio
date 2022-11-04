package it.unisa.school;

public class Student extends Person {

    public Student(String name,String surname,int birthYear,int numberOfAbsences){
        super(name,surname,birthYear);
        this.numberOfAbsences = numberOfAbsences;
    }

    public int getNumberOfAbsences(){
        return this.numberOfAbsences;
    }

    public void addAbsence(){
        this.numberOfAbsences++;
    }

    private int numberOfAbsences;

    @Override
    public String toString() {
        return super.toString() +
                ", Numero di assenze=" + numberOfAbsences;
    }
}
