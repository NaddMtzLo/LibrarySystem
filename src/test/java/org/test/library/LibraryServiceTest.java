package org.test.library;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.test.library.exceptions.LibraryException;
import org.test.library.model.Loan;
import org.test.library.model.User;
import org.test.library.service.LibraryService;
import org.test.library.model.Book;

import java.util.List;

public class LibraryServiceTest {
    private LibraryService service;

    @BeforeEach
    public void setup(){
        service = new LibraryService();

        User nadia = new User("001", "Nadia Martinez", "naddmtz@gmail.com");
        service.getUsers().add(nadia);

        Book losMiserables = new Book("ISBN-001", "Los Miserables", "Victor Hugo", true);
        Book comerRezarAmar = new Book("ISBN-002", "Comer, rezar, amar", "Elizabeth Gilbert", true);
        Book cuatroAcuerdos = new Book("ISBN-003", "Los Cuatro Acuerdos", "Miguel Angel Ruiz", true);
        Book javaFundamentals = new Book("ISBN-004", "Java Fundamentals", "Cay S. Horstmann", true);

        service.getBooks().add(losMiserables);
        service.getBooks().add(comerRezarAmar);
        service.getBooks().add(cuatroAcuerdos);
        service.getBooks().add(javaFundamentals);

        Loan loan1 = new Loan(losMiserables, nadia);
        Loan loan2 = new Loan(comerRezarAmar, nadia);
        Loan loan3 = new Loan(cuatroAcuerdos, nadia);

        nadia.getActiveLoans().add(loan1);
        nadia.getActiveLoans().add(loan2);
        nadia.getActiveLoans().add(loan3);

    }

    @Test
    public void shouldFindBooksByTitle(){
        List<Book> results = service.findBooksByTitle("Los Miserables");
        assertEquals(1, results.size());
    }

    @Test
    public void shouldLoanAvailableBook() throws LibraryException {
        Loan loan = service.loanBook("ISBN-004", "001");
        assertNotNull(loan);
        assertFalse(loan.getBook().isAvailable());
    }

    @Test
    public void shouldNotLoanUnavailableBook(){
        assertThrows(LibraryException.class, () -> {
            service.loanBook("ISBN-002", "001");
        });
    }

    @Test
    public void shouldNotExceedMaxLoans(){
        Assertions.assertThrows(LibraryException.class, () -> {
            service.loanBook("ISBN-004", "Nadia Martinez");
        });
    }
}
