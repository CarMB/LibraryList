package org.iesfm.library;

import java.util.Objects;

public class BookLend {

    private int isbn;
    private String memberNif;
    private String lendDate;
    private String retriveDate;

    public BookLend(int isbn, String memberNif, String lendDate, String retriveDate) {
        this.isbn = isbn;
        this.memberNif = memberNif;
        this.lendDate = lendDate;
        this.retriveDate = retriveDate;
    }


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getMemberNif() {
        return memberNif;
    }

    public void setMemberNif(String memberNif) {
        this.memberNif = memberNif;
    }

    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public String getRetriveDate() {
        return retriveDate;
    }

    public void setRetriveDate(String retriveDate) {
        this.retriveDate = retriveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLend bookLend = (BookLend) o;
        return isbn == bookLend.isbn && Objects.equals(memberNif, bookLend.memberNif) && Objects.equals(lendDate, bookLend.lendDate) && Objects.equals(retriveDate, bookLend.retriveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, memberNif, lendDate, retriveDate);
    }
}
