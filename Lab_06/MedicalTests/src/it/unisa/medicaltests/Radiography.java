package it.unisa.medicaltests;

public class Radiography extends MedicalTest {
    private String imgFileName;
    private final String organName;
    private final boolean medicalRequest;

    public Radiography(String doctorName, boolean medicalRequest, String organName) {
        super(doctorName,20);
        this.medicalRequest = medicalRequest;
        this.organName = organName;

        if(this.medicalRequest == true)
            super.setCost(13);
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public String getOrganName() {
        return organName;
    }

    public boolean isMedicalRequest() {
        return medicalRequest;
    }

    @Override
    public String toString() {
        return "Radiography{" +
                "doctorName='" + this.getDoctorName() + '\'' +
                ", cost=" + this.getCost() +
                ", report='" + this.getReport() + '\'' +
                ", date=" + this.getDate() +
                ", imgFileName='" + imgFileName + '\'' +
                ", organName='" + organName + '\'' +
                ", medicalRequest=" + medicalRequest +
                '}';
    }
}
