package org.iesfm.library;

import org.iesfm.library.exception.InvalidCpException;
import org.iesfm.library.exception.InvalidNifException;

import java.util.List;

public interface ILibrary {

    List<Book> findBooks(String genre);

    List<Member> findMembers(int cp) throws InvalidCpException;

    List<BookLend> findBooklend(String nif) throws  InvalidNifException;

    List<Book> getBooksByBooklend(String nif) throws InvalidNifException;
}
