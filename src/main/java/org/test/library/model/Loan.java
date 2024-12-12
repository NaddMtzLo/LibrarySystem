/**
 * Clase que representa un préstamo en la biblioteca.
 * Contiene información sobre el libro, el usuario, las fechas del préstamo y su estado.
 */
package org.test.library.model;

import java.time.LocalDate;

public class Loan {

    /**
     * Libro asociado al préstamo.
     */
    private Book book;

    /**
     * Usuario que realiza el préstamo.
     */
    private User user;

    /**
     * Fecha en la que se realizó el préstamo.
     */
    private LocalDate loanDate;

    /**
     * Fecha de vencimiento del préstamo.
     */
    private LocalDate dueDate;

    /**
     * Estado del préstamo: true si el libro ha sido devuelto, false en caso contrario.
     */
    private boolean returned;

    /**
     * Constructor que inicializa un préstamo con el libro y el usuario proporcionados.
     * La fecha de préstamo es la fecha actual y el vencimiento 14 días después.
     *
     * @param book el libro que se presta.
     * @param user el usuario que solicita el préstamo.
     */
    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
        this.loanDate = LocalDate.now();
        this.dueDate = loanDate.plusDays(14);
        this.returned = false;
    }

    /**
     * Verifica si el préstamo está vencido.
     *
     * @return true si el préstamo no ha sido devuelto y la fecha actual es posterior a la fecha de vencimiento.
     */
    public boolean isOverDue() {
        return !returned && LocalDate.now().isAfter(dueDate);
    }

    /**
     * Obtiene el libro asociado al préstamo.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Obtiene el usuario que realizó el préstamo.
     */
    public User getUser() {
        return user;
    }

    /**
     * Obtiene la fecha del préstamo.
     */
    public LocalDate getLoanDate() {
        return loanDate;
    }

    /**
     * Obtiene la fecha de vencimiento del préstamo.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Verifica si el libro ha sido devuelto.
     * devuelve true si el libro ha sido devuelto, false en caso contrario.
     */
    public boolean isReturned() {
        return returned;
    }

    /**
     * Establece el estado del préstamo como devuelto o no.
     */
    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
