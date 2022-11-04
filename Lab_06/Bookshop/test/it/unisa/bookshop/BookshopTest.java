package it.unisa.bookshop;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookshopTest {

    @Test
    public void readLibraryTest() {
        /* TODO */
    }

    @Test
    public void findByAuthorTest() {
        Bookshop bookshop = new Bookshop();
        File file = Path.of("test/").resolve("File").toFile();
        try {
            bookshop.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Book> l = bookshop.findByAuthor("Camilleri Andrea");
        Assert.assertEquals("Una voce di notte",l.get(0).getTitle());
    }

    @Test
    public void findByTitleContentTest() {
        Bookshop bookshop = new Bookshop();
        File file = Path.of("test/").resolve("File").toFile();
        try {
            bookshop.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Book> l = bookshop.findByTitleContent("sogni");
        Assert.assertEquals(3,l.size());
        Assert.assertEquals("Mo Yan",l.get(0).getAuthor());
        Assert.assertEquals("Gramellini Massimo",l.get(1).getAuthor());
        Assert.assertEquals("Gramellini Massimo",l.get(2).getAuthor());
    }

    @Test
    public void findMaxAvailabilityTest() {
        Bookshop bookshop = new Bookshop();
        File file = Path.of("test/").resolve("File").toFile();
        try {
            bookshop.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Book> l = bookshop.findMaxAvailable();
        Assert.assertEquals(1,l.size());
        Assert.assertEquals("Il corpo umano",l.get(0).getTitle());
    }

    @Test
    public void findBelowAvailabilityTest() {
        Bookshop bookshop = new Bookshop();
        File file = Path.of("test/").resolve("File").toFile();
        try {
            bookshop.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Book> l = bookshop.findBelowAvailability(15);
        Assert.assertEquals(2,l.size());
        Assert.assertEquals("Sogni rossi",l.get(0).getTitle());
        Assert.assertEquals("Fai bei sogni",l.get(1).getTitle());
    }

}