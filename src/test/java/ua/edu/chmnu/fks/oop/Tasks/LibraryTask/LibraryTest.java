package ua.edu.chmnu.fks.oop.Tasks.LibraryTask;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private ArrayList<Book> books;

    {
        try {
            library = new Library();
            books = new ArrayList<Book>();
            Book book1 = new Book("1-1", "Роберт Мартин", "Чистый код", 464, new Date("07/17/2008"));
            books.add(book1);
            Book book2 = new Book("1-2", "Стив Макконнелл", "Совершенный код", 914, new Date("01/12/1993"));
            books.add(book2);
            Book book3 = new Book("1-3", "Джошуа Блох", "Java. Эффективное программирование", 340, new Date("03/21/2001"));
            books.add(book3);
            Book book4 = new Book("1-4", "Р. В. Сеттер", "Изучаем Java на примерах и задачах", 240, new Date("02/14/2004"));
            books.add(book4);
            Book book5 = new Book("1-5", "Дональд Кнут", "Искусство программирования", 720, new Date("02/08/2007"));
            books.add(book5);
            library.setBooks(books);
        }
        catch (Exception ex) {}
    }

    @Test
    public void saveLoadTest() throws Exception {
        assertDoesNotThrow(() -> library.save());

        assertDoesNotThrow(() -> library.load());

        assertArrayEquals(books.toArray(), library.getBooks().toArray());
        assertEquals(books.get(0).getAuthor(), library.getBooks().get(0).getAuthor());
        assertEquals(books.get(2).getCountPages(), library.getBooks().get(2).getCountPages());
        assertEquals(books.get(4).getTitle(), library.getBooks().get(4).getTitle());
    }

    @Test
    public void saveLoadFileNameTest() throws Exception {
        assertDoesNotThrow(() -> library.save("library2.dat"));

        assertDoesNotThrow(() -> library.load("library2.dat"));

        assertArrayEquals(books.toArray(), library.getBooks().toArray());
        assertEquals(books.get(0).getAuthor(), library.getBooks().get(0).getAuthor());
        assertEquals(books.get(2).getCountPages(), library.getBooks().get(2).getCountPages());
        assertEquals(books.get(4).getTitle(), library.getBooks().get(4).getTitle());
    }

    @Test
    public void getBooksByAuthorTest() throws Exception {
        List<Book> booksBlox = library.getBooksByAuthor("Джошуа Блох");

        assertEquals("Java. Эффективное программирование", booksBlox.get(0).getTitle());
    }

    @Test
    public void getBooksByDateTest() throws Exception {
        List<Book> booksD = library.getBooksByDate(new Date("07/17/2008"));

        assertEquals("Чистый код", booksD.get(0).getTitle());
    }

    @Test
    public void getBooksByPageDiapasonTest() throws Exception {
        List<Book> booksPageDiap = library.getBooksByPageDiapason(900, 1000);

        assertEquals("Совершенный код", booksPageDiap.get(0).getTitle());

        assertThrows(Exception.class, () -> library.getBooksByPageDiapason(1000, 900));
    }
}