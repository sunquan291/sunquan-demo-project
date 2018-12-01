package com.zte.sunquan.demo.spring.controller;

import com.zte.sunquan.demo.spring.action.ReadingListRepository;
import com.zte.sunquan.demo.spring.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            System.out.println("--------");
            System.out.println(readingList);
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = {"/{reader}"},method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        System.out.println(book);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}";

    }
}
