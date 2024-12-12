/**
 * Servicio principal para la gestión de una biblioteca.
 * Proporciona funcionalidades para gestionar libros, usuarios y préstamos.
 */
package org.test.library.service;

import org.test.library.exceptions.LibraryException;
import org.test.library.model.Book;
import org.test.library.model.Loan;
import org.test.library.model.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase que gestiona las operaciones principales de la biblioteca, como préstamos y devoluciones de libros.
 */
public class LibraryService {

    /**
     * Lista de todos los libros disponibles en la biblioteca.
     */
    private List<Book> books = new ArrayList<>();

    /**
     * Lista de todos los usuarios registrados en la biblioteca.
     */
    private List<User> users = new ArrayList<>();

    /**
     * Lista de todos los préstamos realizados en la biblioteca.
     */
    private List<Loan> loans = new ArrayList<>();

    /**
     * Obtiene la lista completa de libros disponibles en la biblioteca.
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Obtiene la lista completa de usuarios registrados en la biblioteca..
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Obtiene la lista completa de préstamos realizados en la biblioteca.
     */
    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * Buscador de libros por título.
     *
     * @param title el título o parte del título del libro que se desea buscar.
     *  @return devuelve una lista de libros que coinciden con el título proporcionado.
     *  Se eligió el método stream ya que es más directo que un ciclo for y porque están optimizados para realizar operaciones de filtrado.
     */
    public List<Book> findBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Buscador de libros por autor.
     *
     * @param author el nombre del autor que se desea buscar.
     * @return regresa una lista de libros que coinciden con el autor proporcionado.
     */
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Realiza un préstamo de un libro a un usuario.
     *
     * @param isbn el ISBN del libro que se desea prestar.
     * @param userId el ID del usuario que solicita el préstamo.
     * @return el objeto Loan que representa el préstamo realizado.
     * @throws LibraryException si el libro no está disponible o si el usuario ha alcanzado el límite de préstamos permitidos.
     */
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

    /**
     * Registra la devolución de un libro.
     *
     * @param isbn el ISBN del libro que se desea devolver.
     * @throws LibraryException si no se encuentra un préstamo activo asociado al ISBN proporcionado.
     */
    public void returnBook(String isbn) throws LibraryException {
        Loan loan = loans.stream()
                .filter(l -> l.getBook().getIsbn().equals(isbn) && !l.isReturned())
                .findFirst()
                .orElseThrow(() -> new LibraryException("No se encontró préstamo"));

        loan.setReturned(true);
        loan.getBook().setAvailable(true);
        loan.getUser().getActiveLoans().remove(loan);
    }
}