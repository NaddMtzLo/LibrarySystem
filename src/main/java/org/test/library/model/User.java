/**
 * Clase que representa un usuario en el sistema de biblioteca.
 * Contiene información del usuario como su identificador, nombre, correo electrónico y los préstamos activos.
 * Se implementó el principio de encapsulación colocando los atributos de la clase privados para que solo se pueda acceder a ellos a través del uso de getters y setters.
 */
package org.test.library.model;

import java.util.List;

public class User {

    /**
     * Identificador único del usuario.
     */
    private String id;

    /**
     * Nombre del usuario.
     */
    private String name;

    /**
     * Correo electrónico del usuario.
     */
    private String email;

    /**
     * Lista de préstamos activos asociados al usuario.
     */
    private List<Loan> activeLoans;

    /**
     * Constructor que inicializa un usuario con su identificador, nombre y correo electrónico.
     *
     * @param id identificador del usuario.
     * @param name nombre del usuario.
     * @param email correo electrónico del usuario.
     */
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Verifica si el usuario puede realizar más préstamos.
     *
     * @return true si el usuario tiene menos de 3 préstamos activos, false en caso contrario.
     */
    public boolean canBorrowBooks() {
        return activeLoans.size() < 3;
    }

    /**
     * Obtiene el identificador del usuario.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del usuario.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la lista de préstamos activos del usuario.
     */
    public List<Loan> getActiveLoans() {
        return activeLoans;
    }
}
