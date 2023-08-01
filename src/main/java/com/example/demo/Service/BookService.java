package com.example.demo.Service;

import com.example.demo.DTO.BookDTO;
import com.example.demo.Exception.CustomException;
import com.example.demo.Model.AddressBook;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
@Autowired
private BookRepository bookRepository;

    public  AddressBook addContact(BookDTO bookDTO) {
        String email = bookDTO.email;
        if (bookRepository.existsByEmail(email)) {
            throw new CustomException("Email ID'" + email + "' is already in use. Please enter unique email ID.");
        }
        AddressBook contactData = new AddressBook(bookDTO);
        return bookRepository.save(contactData);
    }
    public   AddressBook getContactById(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new CustomException("Message With Id:"+id + " Not Present"));
    }
    public  AddressBook updateContact(long id, BookDTO bookDTO) {
        AddressBook contactData = getContactById(id);
        if (contactData != null){

        }
//            String newEmail = BookDTO.email();
//            if (!newEmail.equals(contactData.getEmail()) && bookRepository.existsByEmail(newEmail)) {
//                throw new CustomException("Email address (Gmail) already exists in database: " + newEmail);
           contactData.updateContact(bookDTO);
            return bookRepository.save(contactData);
        }


    public List<AddressBook> findAll() {
        return bookRepository.findAll();
    }
    public  boolean deleteContact(long id) {
            if (bookRepository.existsById(id)) {
                bookRepository.deleteById(id);
                return true;
            }
        return false;
    }

}
