<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Book" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .form-container {
            margin-bottom: 20px;
        }
        .form-container input, .form-container button {
            margin: 5px 0;
        }
    </style>
</head>
<body>
    <h1>Book List</h1>

    <!-- Форма для добавления книги -->
    <div class="form-container">
        <h2>Add New Book</h2>
        <form action="addBook" method="post">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required />
            <label for="author">Author:</label>
            <input type="text" id="author" name="author" required />
            <label for="publishedYear">Published Year:</label>
            <input type="number" id="publishedYear" name="publishedYear" required />
            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" required />
            <button type="submit">Add Book</button>
        </form>
    </div>

    <!-- Таблица с книгами -->
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Published Year</th>
                <th>ISBN</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<com.example.model.Book> books = (List<com.example.model.Book>) request.getAttribute("books");
                if (books != null) {
                    for (com.example.model.Book book : books) {
            %>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getPublishedYear() %></td>
                <td><%= book.getIsbn() %></td>
                <td>
                    <!-- Ссылка для удаления книги -->
                    <a href="deleteBook?id=<%= book.getId() %>">Delete</a>
                </td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="6">No books available.</td>
            </tr>
            <% 
                }
            %>
        </tbody>
    </table>
</body>
</html>>	