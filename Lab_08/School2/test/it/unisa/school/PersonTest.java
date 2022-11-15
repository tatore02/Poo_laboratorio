package it.unisa.school;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void toStringTest() {
        Person p = new Person("Alice", "Rossi", 1997, "aliros", "testPassword");
        Assert.assertEquals("Nome='Alice', Cognome='Rossi', Anno di nascita=1997",
                p.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void scapeInUserIdTest(){
        Person p = new Person("Giuseppe","Cattaneo",2002,"pipp 8","Rosina");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shortPasswordTest(){
        Person p = new Person("Giuseppe","Cattaneo",2002,"pipp8","Rosi");
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooOldTest(){
        Person p = new Person("Giuseppe","Cattaneo",1899,"pipp8","Rosina");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNameTest(){
        Person p = new Person(null,"Cattaneo",2002,"pipp8","Rosina");
    }
}