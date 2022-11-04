package it.unisa.bookshop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Bookshop {

    final private List<Book> bookshop;

    public Bookshop() {
        bookshop = new ArrayList<>();
    }

    public List<Book> findByAuthor(String author) {
        List<Book> l = new ArrayList<>();
        for(Book b : bookshop){
            if(b.getAuthor().equals(author))
                l.add(b);
        }
        return l;
    }

    public List<Book> findByTitleContent(String titleContent) {
        List<Book> l = new ArrayList<>();
        for(Book b : bookshop){
            if(b.getTitle().toLowerCase().contains(titleContent.toLowerCase()))
                l.add(b);
        }
        return l;
    }

    public List<Book> findMaxAvailable() {
        int max = bookshop.get(0).getNumberOfCopies();
        for(Book b : bookshop){
            if(b.getNumberOfCopies() > max)
                max = b.getNumberOfCopies();
        }

        List<Book> l = new ArrayList<>();
        for(Book b : bookshop){
            if(b.getNumberOfCopies() == max)
                l.add(b);
        }
        return l;
    }

    public List<Book> findBelowAvailability(int threshold) {
        List<Book> l = new ArrayList<>();
        for(Book b : bookshop){
            if(b.getNumberOfCopies() < threshold)
                l.add(b);
        }
        return l;
    }

    public List<Book> getBookshop() {
        return bookshop;
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        while(in.hasNextLine()){
            String type = in.nextLine();
            String title = in.nextLine();
            String author = in.nextLine();
            String editor = in.nextLine();
            if(type.equals("Book")){
                int numberOfCopies = Integer.parseInt(in.nextLine());
                Book b = new Book(title,author,editor);
                b.setNumberOfCopies(numberOfCopies);

                this.bookshop.add(b);
            }
            else{
                int numberOfCopies = Integer.parseInt(in.nextLine());
                int lenght = Integer.parseInt(in.nextLine());
                String format = in.nextLine();
                AudioBook b = new AudioBook(title,author,editor,lenght,format);
                b.setNumberOfCopies(numberOfCopies);

                this.bookshop.add(b);
            }
        }
    }
}
