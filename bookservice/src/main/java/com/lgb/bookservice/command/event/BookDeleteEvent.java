package com.lgb.bookservice.command.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDeleteEvent {
    private String bookId;

}
