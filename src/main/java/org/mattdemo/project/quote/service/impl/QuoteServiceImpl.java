package org.mattdemo.project.quote.service.impl;

import org.mattdemo.project.quote.dao.QuoteDao;
import org.mattdemo.project.quote.model.Quote;
import org.mattdemo.project.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteDao quoteDao;

    @Autowired
    public QuoteServiceImpl(QuoteDao quoteDao) {
        this.quoteDao = quoteDao;
    }

    @Override
    public Quote getQuoteById(Long id) {
        // Business logic could go here (validation, transformation, etc.)
        Quote quote = quoteDao.findById(id);
        if (quote == null) {
            throw new RuntimeException("Quote not found with id: " + id);
        }
        return quote;
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quoteDao.findAll();
    }

    @Override
    public Quote createQuote(Quote quote) {
        // Business logic: validate the quote
        if (quote.getText() == null || quote.getText().isEmpty()) {
            throw new IllegalArgumentException("Quote text cannot be empty");
        }
        return quoteDao.save(quote);
    }
}
