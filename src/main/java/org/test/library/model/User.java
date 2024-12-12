package org.test.library.model;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String email;
    private List <Loan> activeLoans;

    public User(String id, String name, String identityDocument) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public boolean canBorrowBooks(){
        return activeLoans.size() < 3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Loan> getActiveLoans(){
        return activeLoans;
    }
}
