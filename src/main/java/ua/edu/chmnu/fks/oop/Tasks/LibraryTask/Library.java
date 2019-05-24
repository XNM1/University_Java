package ua.edu.chmnu.fks.oop.Tasks.LibraryTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void save() throws Exception {
        try(FileOutputStream fileOutputStream = new FileOutputStream("library.dat", false);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(books);
        }
        catch(Exception ex){
            throw ex;
        }
    }

    public void load() throws Exception {
        try(FileInputStream fileInputStream = new FileInputStream("library.dat");
            ObjectInputStream ois = new ObjectInputStream(fileInputStream))
        {
            setBooks((ArrayList<Book>) ois.readObject());
        }
        catch(Exception ex){
            throw ex;
        }
    }

    public void save(String filename) throws Exception {
        try(FileOutputStream fileOutputStream = new FileOutputStream(filename, false);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream))
        {
            oos.writeObject(books);
        }
        catch(Exception ex){
            throw ex;
        }
    }

    public void load(String filename) throws Exception {
        try(FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream))
        {
            setBooks((ArrayList<Book>) ois.readObject());
        }
        catch(Exception ex){
            throw ex;
        }
    }

    public List<Book> getBooksByAuthor(String author) {
        return books.stream().filter(b -> b.getAuthor() == author).collect(Collectors.toList());
    }

    public List<Book> getBooksByDate(Date date) {
        return books.stream().filter(b -> b.getDate().getDate() == date.getDate()).collect(Collectors.toList());
    }

    public List<Book> getBooksByPageDiapason(int from, int to) throws Exception {
        if (from > to)
            throw new Exception("from is bigger than to");
        return books.stream().filter(b -> b.getCountPages() >= from && b.getCountPages() <= to).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;

        Library library = (Library) o;

        return getBooks() != null ? getBooks().equals(library.getBooks()) : library.getBooks() == null;
    }

    @Override
    public int hashCode() {
        return getBooks() != null ? getBooks().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
