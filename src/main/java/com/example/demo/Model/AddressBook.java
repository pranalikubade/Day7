package com.example.demo.Model;

import com.example.demo.DTO.BookDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Address_Book_Table")
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String state;
    private String city;
    private String pin;

//    @ElementCollection
//    @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "id"))
    private String address;

    public AddressBook(BookDTO bookDTO) {

        this.updateContact(bookDTO);
    }

    public void updateContact(BookDTO bookDTO) {
        this.name = bookDTO.name;
        this.email = bookDTO.email;
        this.phoneNumber = bookDTO.phoneNumber;
        this.address = bookDTO.address;
        this.state = bookDTO.state;
        this.city = bookDTO.city;
        this.pin = bookDTO.pin;
    }
}
