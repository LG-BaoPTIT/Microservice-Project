package com.lgb.bookservice.command.event;

import com.lgb.bookservice.command.data.Book;
import com.lgb.bookservice.command.data.BookRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookEventsHandler {

    @Autowired
    BookRepository bookRepository;

    @EventHandler
    public void on(BookCreatesEvent event){
        Book book = new Book();
        BeanUtils.copyProperties(event, book);
        bookRepository.save(book);
    }

    @EventHandler
    public void on(BookUpdateEvent event){
        Book book = bookRepository.getById((event.getBookId()));
        book.setAuthor(event.getAuthor());
        book.setName(event.getName());
        book.setIsReady(event.getIsReady());
        bookRepository.save(book);
    }

    @EventHandler
    public void on (BookDeleteEvent event){
        bookRepository.deleteById(event.getBookId());
    }
}
