package org.iesfm.library;

import org.iesfm.library.exception.InvalidCpException;
import org.iesfm.library.exception.InvalidNifException;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Library implements ILibrary {
    private String name;
    private List<Book> books;
    private List<Member> members;
    private List<BookLend> bookLends;

    public Library(String name, List<Book> books, List<Member> members, List<BookLend> bookLends) {
        this.name = name;
        this.books = books;
        this.members = members;
        this.bookLends = bookLends;
    }


    private Book findBook(int isbn) {
        Book found = null;
        for (Book book : books) {
            if (isbn == book.getIsbn()) {
                found = book;
            }
        }
        return found;
    }


    private Member findMember(String nif) {
        Member found = null;
        for (Member member : members) {
            if (nif.equals(member.getNif())) {
                found = member;
            }
        }
        return found;
    }

    @Override
    public List<Book> getBooksByBooklend(String nif) throws InvalidNifException {
        List<BookLend> memberLends = getBookLends(nif);
        List<Book> books = new LinkedList<>();
        for (BookLend bookLend : bookLends) {
            Book book = findBook(bookLend.getIsbn());
             books.add(book);
        }return books;
    }

    @Override
    public List<BookLend> findBooklend(String nif) throws InvalidNifException {
        Member member = findMember(nif);
        if (member == null) {
            throw new InvalidNifException();
        }
        List<BookLend> nifBooklends = new LinkedList<>();
        for (BookLend bookLend : bookLends) {
            if (bookLend.getMemberNif().equals(nif)) {
                nifBooklends.add(bookLend);
            }
        }
        return nifBooklends;
    }

    @Override
    public List<Book> findBooks(String genre) {
        List<Book> genreBooks = new LinkedList<>();
        for (Book book : books) {
            if (book.hasGenre(genre)) {
                genreBooks.add(book);
            }
        }
        return genreBooks;
    }

    @Override
    public List<Member> findMembers(int cp) throws InvalidCpException {
        if (cp < 1000 || cp > 54000) {
            throw new InvalidCpException();
        }
        LinkedList<Member> cpMembers = new LinkedList<>();
        for (Member member : members) {
            if (member.getCp() == cp) {
                cpMembers.add(member);
            }
        }

        return cpMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<BookLend> getBookLends(String nif) {
        return bookLends;
    }

    public void setBookLends(List<BookLend> bookLends) {
        this.bookLends = bookLends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) && Objects.equals(books, library.books) && Objects.equals(members, library.members) && Objects.equals(bookLends, library.bookLends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books, members, bookLends);
    }
}
