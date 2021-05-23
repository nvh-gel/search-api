package com.eden.shop.search.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * MessageFormatter
 *
 * @author nvhien
 */
@Component
public class MessageFormatter {

    private MessageSource messageSource;

    /**
     * Format message from key.
     *
     * @param key message property key
     * @return message
     */
    public String formatMessage(String key) {

        return messageSource.getMessage(key, null, "", Locale.getDefault());
    }

    /**
     * Setter.
     */
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
