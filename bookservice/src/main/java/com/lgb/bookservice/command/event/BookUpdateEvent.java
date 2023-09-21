package com.lgb.bookservice.command.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateEvent {
    private String bookId;
    private String name;
    private String author;
    private Boolean isReady;
}
