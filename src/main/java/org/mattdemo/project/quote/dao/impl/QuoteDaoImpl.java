package org.mattdemo.project.quote.dao.impl;

import org.mattdemo.project.quote.dao.QuoteDao;
import org.mattdemo.project.quote.model.Quote;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QuoteDaoImpl implements QuoteDao {

    // Simulating a database with an in-memory Map
    private Map<Long, Quote> database = new HashMap<>();
    private Long currentId = 1L;

    public QuoteDaoImpl() {
        // Pre-populate with some data
        database.put(1L, new Quote(1L, "To be or not to be", "Shakespeare"));
        database.put(2L, new Quote(2L, "I think therefore I am", "Descartes"));
        database.put(3L, new Quote(3L, "The only thing we have to fear is fear itself", "FDR"));
        currentId = 4L;
    }

    @Override
    public Quote findById(Long id) {
        // Simulating a database query
        return database.get(id);
    }

    @Override
    public List<Quote> findAll() {
        // Simulating a SELECT * query
        return new ArrayList<>(database.values());
    }

    @Override
    public Quote save(Quote quote) {
        // Simulating an INSERT
        if (quote.getId() == null) {
            quote.setId(currentId++);
        }
        database.put(quote.getId(), quote);
        return quote;
    }
}