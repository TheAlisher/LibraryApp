package com.example.libraryapp.ui.models;

import java.io.Serializable;

public class BookModel implements Serializable {

    private int imageBook;
    private String textBookCategory;
    private String textBookName;
    private String textBookAuthor;
    private String textBookDescription;

    public BookModel(int imageBook, String textBookCategory, String textBookName, String textBookAuthor, String textBookDescription) {
        this.imageBook = imageBook;
        this.textBookCategory = textBookCategory;
        this.textBookName = textBookName;
        this.textBookAuthor = textBookAuthor;
        this.textBookDescription = textBookDescription;
    }

    public int getImageBook() {
        return imageBook;
    }

    public void setImageBook(int imageBook) {
        this.imageBook = imageBook;
    }

    public String getTextBookCategory() {
        return textBookCategory;
    }

    public void setTextBookCategory(String textBookCategory) {
        this.textBookCategory = textBookCategory;
    }

    public String getTextBookName() {
        return textBookName;
    }

    public void setTextBookName(String textBookName)    {
        this.textBookName = textBookName;
    }

    public String getTextBookAuthor() {
        return textBookAuthor;
    }

    public void setTextBookAuthor(String textBookAuthor) {
        this.textBookAuthor = textBookAuthor;
    }

    public String getTextBookDescription() {
        return textBookDescription;
    }

    public void setTextBookDescription(String textBookDescription) {
        this.textBookDescription = textBookDescription;
    }
}
