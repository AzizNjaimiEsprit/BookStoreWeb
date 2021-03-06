package tn.esprit.BookStore.service;

import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.Library;
import tn.esprit.BookStore.model.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface LibraryService {

    Library addLibrary(Library library);

    void addBookLibrary(Library library);

    void editLibrary(Library library);

    void readBook(Library library,HttpServletResponse response) throws IOException;

    public List<Library> findLibraryByUserId(Library library);

    public Book suggestBook(User user);
}
