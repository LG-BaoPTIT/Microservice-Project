package com.lgb.bookservice.query.projection;

import com.lgb.bookservice.command.data.Book;
import com.lgb.bookservice.command.data.BookRepository;
import com.lgb.bookservice.query.model.BookResponseModel;
import com.lgb.bookservice.query.queries.GetAllBooksQuery;
import com.lgb.bookservice.query.queries.GetBookQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookProjection {

    @Autowired
    private BookRepository bookRepository;

    @QueryHandler
    public BookResponseModel handle(GetBookQuery getBookQuery){
        BookResponseModel bookResponseModel = new BookResponseModel();
        Book book = bookRepository.getById(getBookQuery.getBookId());
        BeanUtils.copyProperties(book, bookResponseModel);
        return  bookResponseModel;
    }

    @QueryHandler
    public List<BookResponseModel> handle(GetAllBooksQuery getAllBooksQuery){
        List<Book> listEntity = bookRepository.findAll();
        List<BookResponseModel> result = new ArrayList<>();
        listEntity.forEach(e -> {
            BookResponseModel bookResponseModel = new BookResponseModel();
            BeanUtils.copyProperties(e,bookResponseModel);
            result.add(bookResponseModel);
        });
        return result;
    }
}
