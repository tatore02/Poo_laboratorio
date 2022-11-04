package it.unisa.company;

public class Manager extends Employee {

    private String expertiseArea;
    private int workedHours;

    public Manager(String name,String lastName,String jobTitle,float hourlyWage,String expertiseArea){
        super(name, lastName, jobTitle, hourlyWage);
        this.salary(workedHours,hourlyWage);
        this.expertiseArea = expertiseArea;
    }

    public String getExpertiseArea() {
        return expertiseArea;
    }

    public void setExpertiseArea(String expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours){
        this.workedHours = workedHours;
        this.salary(workedHours,getHourlyWage());
    }

    @Override
    public void setHourlyWage(float hourlyWage) {
        super.setHourlyWage(hourlyWage);
        this.salary(getWorkedHours(),hourlyWage);
    }


    private void salary(int workedHours,float hourlyWage){
        this.workedHours = workedHours;
        super.setHourlyWage(hourlyWage);

        if(workedHours <= 40)
            super.setWage(workedHours * hourlyWage);
        else{
            int extraHours = workedHours - 40;
            float tot;
            tot = 40 * hourlyWage;
            tot += extraHours * hourlyWage * 1.5;
            super.setWage(tot);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Area di competenza='" + expertiseArea + '\'';
    }
}
