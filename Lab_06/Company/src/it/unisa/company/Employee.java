package it.unisa.company;

public class Employee extends Staff {

    private String jobTitle;
    private float hourlyWage;

    public Employee(String name,String lastName,String jobTitle,float hourlyWage){
        super(name, lastName);
        this.setJobTitle(jobTitle);
        this.salary(hourlyWage);
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public float getHourlyWage() {
        return hourlyWage;
    }

    private void salary(float hourlyWage){
        super.setWage((float) (40.0 * hourlyWage));
    }

    public void setHourlyWage(float hourlyWage){
        this.hourlyWage = hourlyWage;
        this.salary(hourlyWage);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Incarico='" + jobTitle + '\'';
    }
}
