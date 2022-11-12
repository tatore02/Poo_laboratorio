package it.unisa.medicaltests;

public class Echocardiogram extends MedicalTest {

    public enum Variants {
        SIMPLE,
        WITH_CONTRAST,
        STRESS
    }

    private final Variants type;
    private final int patientAge;

    public Echocardiogram(String doctorName, Variants type, int patientAge) {
        super(doctorName,0);
        this.type = type;
        this.patientAge = patientAge;

        if(this.type.equals(Variants.WITH_CONTRAST))
            super.setCost(45);
        else super.setCost(30);

        if(this.patientAge >= 65) {
            float sconto = (float) ((super.getCost()/100) * 20);
            super.setCost((float) (super.getCost() - sconto));
        }
    }

    public Variants getType() {
        return type;
    }

    public int getPatientAge() {
        return patientAge;
    }

    @Override
    public String toString() {
        return "Echocardiogram{" +
                "doctorName='" + this.getDoctorName() + '\'' +
                ", cost=" + this.getCost() +
                ", report='" + this.getReport() + '\'' +
                ", date=" + this.getDate() +
                ", type=" + type +
                ", patientAge=" + patientAge +
                '}';
    }
}
