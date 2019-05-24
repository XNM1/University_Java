package ua.edu.chmnu.fks.oop.Tasks.LibraryTask;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private String number;
    private String author;
    private String title;
    private int countPages;
    private Date date;

    public Book() {
    }

    public Book(String number, String author, String title, int countPages, Date date) throws Exception {
        this.number = number;
        this.author = author;
        this.title = title;
        setCountPages(countPages);
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) throws Exception {
        if(countPages <= 0)
            throw new Exception("invalid value");
        this.countPages = countPages;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getCountPages() != book.getCountPages()) return false;
        if (!getNumber().equals(book.getNumber())) return false;
        if (!getAuthor().equals(book.getAuthor())) return false;
        if (!getTitle().equals(book.getTitle())) return false;
        return getDate().equals(book.getDate());
    }

    @Override
    public int hashCode() {
        int result = getNumber().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getCountPages();
        result = 31 * result + getDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "number='" + number + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", countPages=" + countPages +
                ", date=" + date +
                '}';
    }
}
