package org.mattdemo.project.quote.service;

import org.mattdemo.project.quote.model.Quote;
import java.util.List;

public interface QuoteService {
    Quote getQuoteById(Long id);
    List<Quote> getAllQuotes();
    Quote createQuote(Quote quote);
}