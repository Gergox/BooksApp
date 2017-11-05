package com.hifiver.booksApp.controller;

import com.hifiver.booksApp.model.Book;
import com.hifiver.booksApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {

    @Autowired
    BookService bookService;

    //  booklist
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listBooks(ModelMap model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "allbooks";
    }

    //  add a new book
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newBook(ModelMap model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("edit", false);
        return "registration";
    }

    //  validating the user input and save book in database
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveBook(@Valid Book book, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "registration";
        }


        bookService.saveBook(book);

        model.addAttribute("success", "Book " + book.getTitle()
                + " registered successfully");

        return "success";
    }

    @RequestMapping(value = {"/edit-{id}-book"}, method = RequestMethod.GET)
    public String editBook(@PathVariable int id, ModelMap model){
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("edit", true);
        return "registration";
    }


    @RequestMapping(value = {"/edit-{id}-book"}, method = RequestMethod.POST)
    public String updateBook(@Valid Book book, BindingResult result,
                             ModelMap model, @PathVariable int id) {
        if (result.hasErrors()) {
            return "registration";
        }

        bookService.updateBook(book);

        model.addAttribute("success", "Book " + book.getTitle()
                + " updated successfully");
        return "success";
    }

    @RequestMapping(value = "/delete-{id}-book", method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBookById(id);
        return "redirect:/list";
    }

}
