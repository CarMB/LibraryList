package org.iesfm.library;

import org.iesfm.library.exception.InvalidCpException;
import org.iesfm.library.exception.InvalidNifException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LibraryTests {

    private Library library;
    private List<Book> books;
    private List<Member> members;
    private List<BookLend> booklends;

    @Before
    public void setUp(){
        books = new LinkedList<>();
        List<String> genres = new ArrayList<>();
        genres.add("Terror");
        books.add(new Book(1, "titulo1", "autor", genres));
        books.add(new Book(2, "titulo2", "autor", genres));
        books.add(new Book(3, "titulo3", "autor", genres));
        books.add(new Book(4, "titulo4", "autor", new LinkedList<>()));
        members = new LinkedList<>();
        members.add(new Member(1, "1", "Fulanito", "adsf", 5000));
        members.add(new Member(2, "2", "Fulanito", "adsf", 5000));
        booklends = new LinkedList<>();
        booklends.add(new BookLend(2456,"749387f", "8-9-2020","18-9-2020"));
        booklends.add(new BookLend(2476,"749389f", "3-9-2020","11-9-2020"));
        library = new Library("Mi libre", books, members, booklends);

    }

    @Test
    public void hasGenreTest() {
        List<Book> terrorBooks = library.findBooks("Terror");

        Assert.assertEquals(books.subList(0, 3), terrorBooks);
    }

    @Test
    public void getMembersByCpTest() throws InvalidCpException {
        List<Member> res = library.findMembers(5000);
        Assert.assertEquals(members, res);
    }
    @Test(expected = InvalidCpException.class)
    public void getMembersByCpInvalidTest() throws InvalidCpException {
        library.findMembers(500);
    }


    @Test

    public void getBooklend() throws InvalidNifException{
        List<BookLend> res = library.findBooklend("1");
        Assert.assertEquals(booklends,res);
    }

}
