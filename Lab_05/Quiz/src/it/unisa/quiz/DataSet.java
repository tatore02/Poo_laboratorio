package it.unisa.quiz;

public class DataSet {

    private double sum;
    private Measurable minimum;
    private Measurable maximum;
    private int count;

    public DataSet() {
        this.sum = 0;
        this.count = 0;
        this.minimum = null;
        this.maximum = null;
    }

    public double getAverage() {
        if(this.sum == 0)   return 0;
        return sum/count;
    }

    public Measurable getMaximum() {
        return maximum;
    }

    public Measurable getMinimum() {
        return minimum;
    }

    public void add(Measurable x) {
        this.sum += x.getMeasure();
        this.count++;

        if(count == 1) {
            this.maximum = x;
            this.minimum = x;
        }
        if(maximum.getMeasure() < x.getMeasure())
            maximum = x;

        if(minimum.getMeasure() > x.getMeasure())
            minimum = x;

    }
}