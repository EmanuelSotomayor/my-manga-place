package com.my.manga.place.dev.services.impl;

import com.my.manga.place.dev.services.IMessageService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import java.util.Locale;
@Service
public class MessageService implements IMessageService {
    private final MessageSource messageSource;
    public MessageService(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    @Override
    public String getMessageProperty(String messageProperty) {
        return this.messageSource.getMessage(messageProperty, null, Locale.getDefault());
    }
}
