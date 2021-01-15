package tn.esprit.BookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.OnlineBook;
import tn.esprit.BookStore.repository.OnlineBookRepository;

import java.util.ArrayList;

@Service
public class OnlineBookServiceImp implements OnlineBookService {
    @Autowired
    OnlineBookRepository onlineBookRepository;

    @Override
    public OnlineBook addBook(OnlineBook b) {
        return (OnlineBook) onlineBookRepository.save(b);
    }

    @Override
    public void deleteBook(OnlineBook b) {
      onlineBookRepository.delete(b);
    }

    @Override
    public void updateBook(OnlineBook b) {
       onlineBookRepository.save(b);
    }

    @Override
    public ArrayList<OnlineBook> getBookList() {
        return (ArrayList<OnlineBook>) onlineBookRepository.findAll();
    }

    @Override
    public OnlineBook getBook(OnlineBook b) {
        return (OnlineBook) onlineBookRepository.findById(b.getId()).get();
    }

    @Override
    public OnlineBook getBookByID(int id) {
        return (OnlineBook) onlineBookRepository.findById(id).get();
    }
}