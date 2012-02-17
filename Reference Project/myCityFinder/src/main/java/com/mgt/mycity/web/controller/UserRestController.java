/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/web/controller/restController.e.vm.java
 */
package com.mgt.mycity.web.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mgt.mycity.web.util.AutoCompleteResult;
import com.mgt.mycity.web.util.SearchParameters;
import com.mgt.mycity.domain.User;
import com.mgt.mycity.service.UserService;

@Controller
@RequestMapping("domain/rest/user/")
public class UserRestController {
    @Autowired
    public FormattingConversionService formattingConversionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = POST)
    @ResponseBody
    public User create(@Valid User user) {
        userService.save(user);
        return user.copy();
    }

    @RequestMapping(value = "/", method = POST, headers = "content-type:application/json")
    @ResponseBody
    public User jsonCreate(@Valid @RequestBody User user) {
        userService.save(user);
        return user.copy();
    }

    @RequestMapping(value = "/", method = GET)
    @ResponseBody
    public List<User> list(User user, SearchParameters searchParameters) {
        List<User> users = userService.find(user, searchParameters.toSearchTemplate());
        List<User> ret = new ArrayList<User>();
        for (User _user : users) {
            ret.add(_user.copy());
        }
        return ret;
    }

    @RequestMapping(value = "/{pk}", method = GET)
    @ResponseBody
    public User get(@PathVariable("pk") User user) {
        return user.copy();
    }

    @RequestMapping(value = "/{pk}", method = PUT)
    @ResponseBody
    public User update(@PathVariable("pk") User userToUpdate, @Valid User user) {
        user.copyTo(userToUpdate);
        userService.save(userToUpdate);
        return userToUpdate.copy();
    }

    @RequestMapping(value = "/{pk}", method = DELETE)
    @ResponseBody
    public boolean delete(@PathVariable("pk") User user) {
        userService.delete(user);
        return true;
    }

    @RequestMapping("/autocomplete")
    @ResponseBody
    public List<AutoCompleteResult> autocomplete(@RequestParam(value = "term", required = false) String searchPattern,
            SearchParameters search) {
        if (searchPattern != null && !searchPattern.isEmpty()) {
            search.setSearchPattern(searchPattern);
        }
        List<AutoCompleteResult> ret = new ArrayList<AutoCompleteResult>();
        for (User user : userService.find(search.toSearchTemplate())) {
            String objectPk = user.getPrimaryKey().toString();
            String objectLabel = formattingConversionService.convert(user, String.class);
            ret.add(new AutoCompleteResult(objectPk, objectLabel));
        }
        return ret;
    }

    @ExceptionHandler()
    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    public void exception(Exception e, PrintWriter out) {
        out.write(e.getMessage());
    }
}