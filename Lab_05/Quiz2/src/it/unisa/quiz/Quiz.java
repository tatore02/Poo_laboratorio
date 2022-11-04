package it.unisa.quiz;

public class Quiz implements Comparable<Quiz> {

    private final double score;

    public Quiz(double score) {
        this.score = score;
    }

    public double getMeasure() {
        return score;
    }

    @Override
    public int compareTo(Quiz quiz) {
        if(this.score < quiz.getMeasure())
            return -1;
        else if(this.score > quiz.getMeasure())
            return 1;
        else return 0;
    }
}
