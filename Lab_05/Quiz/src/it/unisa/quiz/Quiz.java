package it.unisa.quiz;

public class Quiz implements Measurable {

    private double marks;

    public Quiz(double marks){
        this.marks = marks;
    }

    public double getMeasure(){
        return marks;
    }

}
