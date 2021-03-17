package org.iesfm.library;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class BookTest {

    @Test
    public void hasGenreTest(){
        List<String> genres = new LinkedList<>();
        for (int i=0; i < 1000; i++){
            genres.add("genre" +i);
        }
        Book book = new Book(1,"a", "b",genres);
    }
}
