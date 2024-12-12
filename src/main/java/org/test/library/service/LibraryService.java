package org.test.library.service;

import org.test.library.exceptions.LibraryException;
import org.test.library.model.Book;
import org.test.library.model.Loan;
import org.test.library.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public List<Book> findBooksByTitle (String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor (String author){
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Loan loanBook(String isbn, String userId) throws LibraryException {
        Book book = books.stream()
                .filter(b -> b.getIsbn().equals(isbn) && b.isAvailable())
                .findFirst()
                .orElseThrow(() -> new LibraryException("Libro no disponible"));

        User user = users.stream()
                .filter(u -> u.getId().equals(userId) && u.canBorrowBooks())
                .findFirst()
                .orElseThrow(() -> new LibraryException("El usuario alcanzó el límite de préstamos permitido"));

        Loan loan = new Loan(book, user);
        loans.add(loan);
        user.getActiveLoans().add(loan);
        book.setAvailable(false);

        return loan;
    }

    public void returnBook (String isbn) throws LibraryException {
        Loan loan = loans.stream()
                .filter(l -> l.getBook().getIsbn().equals(isbn) && !l.isReturned())
                .findFirst()
                .orElseThrow(() -> new LibraryException("No se encontró préstamo"));

        loan.setReturned(true);
        loan.getBook().setAvailable(true);
        loan.getUser().getActiveLoans().remove(loan);
    }

}
