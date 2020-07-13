package io.dz.librarydb.controller;

import io.dz.librarydb.model.Book;
import io.dz.librarydb.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity status(){
        return new ResponseEntity("run",HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Book book){
       return new ResponseEntity(bookService.save(book),HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity findById(@PathVariable String bookId){
     return new ResponseEntity(bookService.getById(bookId),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        return new ResponseEntity(bookService.getAllBook(),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity  update(@Valid @RequestBody Book book){
      return new ResponseEntity(bookService.update(book),HttpStatus.OK);
    }

    @PutMapping("/borrow/{memberId}")
    public ResponseEntity borrowBook(@PathVariable String memberId, @RequestBody List<String> bookIds ){
       return new ResponseEntity(bookService.borrowBook(memberId,bookIds),HttpStatus.OK);
    }

    @PutMapping("/return")
    public ResponseEntity returnBook(@RequestParam String bookId,@RequestParam String memberId){
      return new ResponseEntity(bookService.returnBook(bookId,memberId),HttpStatus.OK);
    }
}
