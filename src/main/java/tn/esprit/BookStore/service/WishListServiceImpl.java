package tn.esprit.BookStore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.BookStore.model.Basket;
import tn.esprit.BookStore.model.Book;
import tn.esprit.BookStore.model.WishList;
import tn.esprit.BookStore.repository.BookRepository;
import tn.esprit.BookStore.repository.WishListRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WishListServiceImpl implements IWishListService<WishList> {
    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    BookRepository bookRepository;


    @Override
    public List<WishList> findAll() {
        return wishListRepository.findAll();
    }

    @Override
    public WishList findById(int id) {
        return wishListRepository.findById(id).get();
    }

    @Override
    public WishList addWishList(WishList wishList) {
        return wishListRepository.save(wishList);
    }

    @Override
    public WishList addBookToWishList(int bookId, int wishListId) {
        WishList wishList1 = wishListRepository.findById(wishListId).get();
        Book book = bookRepository.findById(bookId).get();

        wishList1.getBooks().add(book);
        return wishListRepository.save(wishList1);
    }


    @Override
    public void deleteBookFromWishList(int wishListId, int bookId) {
        try{
            WishList wishList = wishListRepository.findById(wishListId).get();
            Book book = bookRepository.findById(bookId).get();
            wishList.getBooks().remove(book);
            wishListRepository.save(wishList);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int countBestBookInWishList(Book bestBook) {
        int count = 0;
        try {
            System.out.println("The best Book is " +bestBook);

            for (WishList wishList : wishListRepository.findAll()) {
                for (Book book : wishList.getBooks()) {
                    if (book.getId() == bestBook.getId()) {
                        count++;
                    }
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        return count;
    }
}
