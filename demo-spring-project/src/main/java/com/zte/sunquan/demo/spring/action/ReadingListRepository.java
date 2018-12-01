package com.zte.sunquan.demo.spring.action;

import com.zte.sunquan.demo.spring.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book,Long> {
    List<Book> findByReader(String reader);
}
