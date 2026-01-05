package org.mattdemo.project.quote.dao;

import org.mattdemo.project.quote.model.Quote;
import java.util.List;

public interface QuoteDao {
    Quote findById(Long id);
    List<Quote> findAll();
    Quote save(Quote quote);
}
