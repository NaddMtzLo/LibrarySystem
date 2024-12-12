package org.test.library.model;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private User user;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;

    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
        this.loanDate = LocalDate.now();
        this.dueDate = loanDate.plusDays(15);
        this.returned = false;
    }

    public boolean isOverDue (){
        return !returned && LocalDate.now().isAfter(dueDate);
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}