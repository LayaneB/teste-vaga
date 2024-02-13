package org.rethink.challenge.service;

import org.rethink.challenge.model.client.ConvertRequest;

public interface IBookService {

    ConvertRequest convert (Long bookId, String currency);
}
