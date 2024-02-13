package org.rethink.challenge.service;

import org.rethink.challenge.client.IExchangeServiceClient;
import org.rethink.challenge.model.BookModel;
import org.rethink.challenge.model.client.ConvertRequest;
import org.springframework.stereotype.Service;


@Service
public class BookService implements  IBookService{
    private IExchangeServiceClient client;

    @Override
    public ConvertRequest convert(Long bookId, String currency) {
       return null;
    }
}
