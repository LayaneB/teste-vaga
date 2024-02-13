package org.rethink.challenge.controller;

import org.rethink.challenge.model.client.ConvertRequest;
import org.rethink.challenge.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="book-service")
public class BookController {
    @Autowired
    private IBookService service;
    @GetMapping("/{book_id}/{to_currency}")
    ResponseEntity<ConvertRequest> convertBookPrice(@PathVariable("book_id") Long bookId, @PathVariable("to_currency") String currency){
        return  ResponseEntity.ok(service.convert(bookId,currency));
    }


}
