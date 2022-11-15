package it.unisa.school;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Hashtable;

public class Student extends Person {

    private Hashtable<String,Integer> libretto;
    private int numberOfAbsences;
    private String matricola;

    public Student(String name, String surname, int birthYear, String userId,String password,String matricola,int numberOfAbsences) {
        super(name, surname, birthYear,userId,password);
        if(matricola == null || matricola.isEmpty()){
            throw new IllegalArgumentException("Matricola dello studente con formato errato");
        }
        this.numberOfAbsences = numberOfAbsences;
        this.matricola = matricola;
        this.libretto = new Hashtable<>();
    }

    public String getMatricola(){
        return this.matricola;
    }

    public void addAbsence() {
        this.numberOfAbsences++;
    }

    public void removeAbsence() {
        this.numberOfAbsences--;
    }

    public int getNumberOfAbsences() {
        return numberOfAbsences;
    }

    public void addExam(String examName, int grade) {
        if(grade < 18 || grade > 31){
            throw new IllegalArgumentException("Voto non valido");
        }
        this.libretto.put(examName,grade);
    }

    public int getNumberOfPassedExams() {
        return this.libretto.size();
    }

    public Hashtable<String, Integer> getPassedExams() {
        return libretto;
    }

    public double getAverageGrade() {
        if(this.getNumberOfPassedExams() == 0) {
            return 0;
        }
        int tot = 0;
        for(int a : libretto.values()){
            if(a == 31)
                a--;
            tot += a;
        }
        double media = tot/libretto.size();
        return media;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Numero di assenze=" + numberOfAbsences;
    }
}
