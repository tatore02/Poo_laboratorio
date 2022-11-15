package it.unisa.school;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void toStringTest() {
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        Assert.assertEquals("Nome='Roberto', Cognome='Bianchi', Anno di nascita=2005, Numero di assenze=3",
                s.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addExamTest(){
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        s.addExam("SO",17);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullMatricolaTest(){
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", null, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooOldTest(){
        Student s = new Student("Roberto", "Bianchi", 1899, "robbia", "testPassword", "0522500103", 3);
    }

    @Test
    public void averageTest(){
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        s.addExam("SO",20);
        s.addExam("POO",31);
        s.addExam("BD",25);

        Assert.assertEquals(25,s.getAverageGrade(),0);
    }

}