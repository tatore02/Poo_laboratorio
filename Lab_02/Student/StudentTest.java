import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentTest {
    @Test
    public void registerExamTest(){
        Student student = new Student("Salvatore","Ruocco");
        Assert.assertEquals("Salvatore",student.getFirstName());
        Assert.assertEquals("Ruocco",student.getLastName());
    }

    @Test
    public void registerOneExamTest(){
        Student student = new Student("Salvatore","Ruocco");
        Exam exam = new Exam("MD",new GregorianCalendar(2022,Calendar.JANUARY,10),20);

        student.registerExam(exam);

        Assert.assertEquals(1,student.getExams().size());
        Assert.assertEquals(20,student.computeAverageGrade(),0);
    }

    @Test
    public void computeAverageExamTest(){
        Student student = new Student("Salvatore","Ruocco");
        Exam exam1 = new Exam("MD",new GregorianCalendar(2022,Calendar.JANUARY,10),19);
        Exam exam2 = new Exam("ADE",new GregorianCalendar(2022,Calendar.JANUARY,18),23);
        Exam exam3 = new Exam("P1",new GregorianCalendar(2022,Calendar.FEBRUARY,21),24);

        student.registerExam(exam1);
        student.registerExam(exam2);
        student.registerExam(exam3);

        Assert.assertEquals(3,student.getExams().size());
        Assert.assertEquals(22,student.computeAverageGrade(),0);
    }
}