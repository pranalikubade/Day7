package com.example.demo.Repository;

import com.example.demo.Model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookRepository  extends JpaRepository<AddressBook,Long> {

    boolean existsByEmail(String email);

}



