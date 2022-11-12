package it.unisa.medicaltests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class MedicalTestList {

    private final List<MedicalTest> medicalTestList;

    public MedicalTestList() {
        this.medicalTestList = new ArrayList<>();
    }

    public void addMedicalTest(MedicalTest mt) {
        medicalTestList.add(mt);
        Collections.sort(medicalTestList);
    }

    public List<MedicalTest> getMedicalTestByDate(GregorianCalendar date) {
        List<MedicalTest> byDate = new ArrayList<>();
        for(MedicalTest search : medicalTestList)
            if(search.getDate() != null && search.getDate().equals(date))
                byDate.add(search);

        return byDate;
    }

    public List<MedicalTest> getMedicalTestByDoctor(String doctorName) {
        List<MedicalTest> byDoctor = new ArrayList<>();
        for(MedicalTest search : medicalTestList)
            if(search.getDoctorName().equals(doctorName))
                byDoctor.add(search);

        return byDoctor;
    }

    public double getAverageCost() {
        double tot = 0;

        for(MedicalTest search : medicalTestList)
            tot += search.getCost();

        tot = tot/medicalTestList.size();
        return tot;
    }

    public List<MedicalTest> getMedicalTestList() {
        return medicalTestList;
    }
}
