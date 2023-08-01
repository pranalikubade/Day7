package com.example.demo.Controller;

import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.ResponseDTO;
import com.example.demo.Model.AddressBook;
import com.example.demo.Service.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody BookDTO bookDTO) {
        ResponseDTO responseDto = new ResponseDTO("Data added successfully", bookService.addContact(bookDTO));
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> findAllContact() {
        ResponseDTO responseDto = new ResponseDTO("Data retrieve successfully", bookService.findAll());
        return new ResponseEntity<>( responseDto, HttpStatus.OK);
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable long id) {
        ResponseDTO responseDto = new ResponseDTO("Contact Data Fetched Successfully", bookService.getContactById(id));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable long id, @Valid @RequestBody BookDTO bookDTO) {
        ResponseDTO responseDto = new ResponseDTO("Contact Data updated", bookService.updateContact(id, bookDTO));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable long id) {
        boolean deleted = bookService.deleteContact(id);
        if (deleted) {
            ResponseDTO responseDTO = new ResponseDTO("Contact Data Deleted Successfully", id);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            ResponseDTO responseDto = new ResponseDTO("Contact Data Not Found", id);
            return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
        }
    }
}

