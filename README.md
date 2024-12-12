# LibrarySystem
Este proyecto implementa un sistema de gestión de bibliotecas. Incluye clases para representar libros, usuarios, préstamos y la lógica del sistema. A continuación se presenta la documentación completa, ejemplos de uso y configuración.

---

## Índice de Documentación

1. [Descripción General](#descripción-general)
2. [Clases Principales](#clases-principales)
    - [Book](#book)
    - [User](#user)
    - [Loan](#loan)
    - [LibraryService](#libraryservice)
3. [Ejemplos de Configuración](#ejemplos-de-configuración)
4. [Ejemplos de Uso](#ejemplos-de-uso)
5. [Diagrama UML](#diagramas-uml)

---

## Descripción General

El sistema permite realizar las siguientes operaciones:
- Gestionar un catálogo de libros.
- Registrar usuarios.
- Realizar préstamos de libros.
- Verificar el estado de los préstamos (vencidos/devueltos).

---

## Clases Principales

### Book
Representa un libro en la biblioteca.

#### Atributos
- **isbn**: Número Estándar Internacional del libro.
- **title**: Título del libro.
- **author**: Autor del libro.
- **available**: Disponibilidad del libro.

#### Métodos
- Getters y setters para acceder a los atributos de una manera segura.

---

### User
Representa un usuario registrado en el sistema.

#### Atributos
- **id**: Identificador único del usuario.
- **name**: Nombre del usuario.
- **email**: Correo electrónico.
- **activeLoans**: Lista de préstamos activos.

#### Métodos
- Verificar si el usuario puede realizar nuevos préstamos.
- Getters y setters para acceder a los atributos de una manera segura.

---

### Loan
Representa un préstamo de un libro a un usuario.

#### Atributos
- **book**: Libro asociado al préstamo.
- **user**: Usuario que realiza el préstamo.
- **loanDate**: Fecha del préstamo.
- **dueDate**: Fecha de vencimiento.
- **returned**: Estado del préstamo.

#### Métodos
- Verificar si el préstamo está vencido.
- Getters y setters para acceder a los atributos de una manera segura.

---

### LibraryService
Clase que maneja la lógica del sistema.

#### Atributos
- **books**: Lista de libros.
- **users**: Lista de usuarios.
- **loans**: Lista de préstamos.

#### Métodos
- Buscar libros por título o autor.
- Registrar un préstamo.
- Registrar la devolución de un libro.
- Getters para obtener las listas.

---

## Ejemplos de Configuración

1. **Agregar un nuevo libro:**
```java
Book book = new Book("ISBN-008", "El Quijote", "Cervantes", true);
libraryService.getBooks().add(book);
```

2. **Registrar un usuario:**
```java
User user = new User("006", "Nadia Martinez", "nadiamar.mtz@gmail.com");
libraryService.getUsers().add(user);
```

---

## Ejemplos de Uso

1. **Realizar un préstamo:**
```java
Loan loan = libraryService.loanBook("ISBN-014", "001");
System.out.println("Préstamo realizado: " + loan.getLoanDate());
```

2. **Devolver un libro:**
```java
libraryService.returnBook("ISBN-145");
System.out.println("Libro devuelto correctamente.");
```

---

## Diagrama UML

El diagrama UML a continuación representan las relaciones entre las clases principales del sistema:

![image](https://github.com/user-attachments/assets/b862be37-e0c4-4823-ba01-c55db8dca861)

---


