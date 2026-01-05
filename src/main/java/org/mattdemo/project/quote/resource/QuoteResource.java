package org.mattdemo.project.quote.resource;

import org.mattdemo.project.quote.model.Quote;
import org.mattdemo.project.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteResource {

    private final QuoteService quoteService;

    @Autowired
    public QuoteResource(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    // GET /api/quotes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Quote> getQuote(@PathVariable Long id) {
        try {
            Quote quote = quoteService.getQuoteById(id);
            return ResponseEntity.ok(quote);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // GET /api/quotes
    @GetMapping
    public ResponseEntity<List<Quote>> getAllQuotes() {
        List<Quote> quotes = quoteService.getAllQuotes();
        return ResponseEntity.ok(quotes);
    }

    // POST /api/quotes
    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote) {
        try {
            Quote createdQuote = quoteService.createQuote(quote);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdQuote);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
