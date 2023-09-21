package com.lgb.bookservice.command.aggregate;

import com.lgb.bookservice.command.command.CreateBookCommand;
import com.lgb.bookservice.command.command.DeleteBookCommant;
import com.lgb.bookservice.command.command.UpdateBookCommand;
import com.lgb.bookservice.command.event.BookCreatesEvent;
import com.lgb.bookservice.command.event.BookDeleteEvent;
import com.lgb.bookservice.command.event.BookUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class BookAggregate {

    @AggregateIdentifier
    private String bookId;
    private String name;
    private String author;
    private Boolean isReady;

    public BookAggregate(){};

    @CommandHandler
    public BookAggregate(CreateBookCommand createBookCommand){

        BookCreatesEvent bookCreatesEvent = new BookCreatesEvent();
        BeanUtils.copyProperties(createBookCommand, bookCreatesEvent);
        AggregateLifecycle.apply(bookCreatesEvent);

    }
    @EventSourcingHandler
    public void on(BookCreatesEvent event){
        this.bookId = event.getBookId();
        this.author = event.getAuthor();
        this.name = event.getName();
        this.isReady = event.getIsReady();
    }

    @CommandHandler
    public void handle(UpdateBookCommand updateBookCommand){
        BookUpdateEvent bookUpdateEvent = new BookUpdateEvent();
        BeanUtils.copyProperties(updateBookCommand, bookUpdateEvent);
        AggregateLifecycle.apply(bookUpdateEvent);
    }

    @EventSourcingHandler
    public void on(BookUpdateEvent event){
        this.bookId = event.getBookId();
        this.author = event.getAuthor();
        this.name = event.getName();
        this.isReady = event.getIsReady();
    }

    @CommandHandler
    public void handle(DeleteBookCommant deleteBookCommant){
        BookDeleteEvent bookDeleteEvent = new BookDeleteEvent();
        BeanUtils.copyProperties(deleteBookCommant, bookDeleteEvent);
        AggregateLifecycle.apply(bookDeleteEvent);
    }

    @EventSourcingHandler
    public void on(BookDeleteEvent event){
        this.bookId = event.getBookId();
    }

}
