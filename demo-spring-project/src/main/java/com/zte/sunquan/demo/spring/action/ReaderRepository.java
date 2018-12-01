package com.zte.sunquan.demo.spring.action;

import com.zte.sunquan.demo.spring.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReaderRepository extends JpaRepository<Reader,String> {
}
