package org.test.library.model;

/**
 * La clase Book representa un libro en el sistema de biblioteca.
 * Se implementó el principio de encapsulación para proteger y controlar el acceso a los datos por lo que los parámetros son privados.
 */
public class Book {
    /**
     * El Número Estándar Internacional del Libro (ISBN).
     */
    private String isbn;

    /**
     * Título del libro.
     */
    private String title;

    /**
     * Autor del libro.
     */
    private String author;

    /**
     * Disponibilidad del libro.
     */
    private boolean available;

    /**
     * Constructor que permite crear nuevos libros en el sistema con las propiedades indicadas.
     *
     * @param isbn      ISBN del libro
     * @param title     título del libro
     * @param author    autor del libro
     * @param available disponibilidad del libro
     */
    public Book(String isbn, String title, String author, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    /**
     * Se implementaron getters y setters para acceder y modificar los atributos de libro.
     */
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Valida si el libro está disponible
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Asigna un status la disponibilidad a un libro
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}