/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/formatter/Formatter.e.vm.java
 */
package com.mgt.mycity.formatter;

import java.text.ParseException;
import java.util.Locale;

import com.mgt.mycity.domain.Photo;
import com.mgt.mycity.service.PhotoService;
import com.mgt.mycity.formatter.support.DiscoverableFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * {@link Formatter} for {@link Photo} that is picked by automatically by {@link CustomFormattingConversionServiceFactory}
 * 
 * @see Formatter
 * @see CustomFormattingConversionServiceFactory
 */
@Component
public class PhotoFormatter implements DiscoverableFormatter<Photo> {

    @Autowired
    private PhotoService photoService;

    @Override
    public Class<Photo> getTarget() {
        return Photo.class;
    }

    @Override
    public String print(Photo photo, Locale locale) {
        if (photo == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // make a nice display string here...

        if (photo.getName() != null) {
            sb.append(photo.getName()).append(" ");
        }

        if (photo.getDesc() != null) {
            sb.append(photo.getDesc()).append(" ");
        }

        if (photo.getLocation() != null) {
            sb.append(photo.getLocation()).append(" ");
        }

        if (sb.length() > 0) {
            return sb.toString();
        } else if (photo.isPrimaryKeySet()) {
            return photo.getPrimaryKey().toString();
        } else {
            return photo.toString();
        }
    }

    @Override
    public Photo parse(String text, Locale locale) throws ParseException {
        if (text == null || text.isEmpty()) {
            return new Photo();
        }
        Photo photo = photoService.getByPrimaryKey(new Integer(text));
        return photo != null ? photo : new Photo();
    }
}
