package com.amano.author;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

    // 저자명으로 검색한다.
    List<Author> findByNameContaining(@Param("name") String name);

    // 이메일로 검색한다.
    List<Author> findByEmailContaining(@Param("email") String email);

    // 저자명으로 검색한 건수를 확인한다.
    Long countByNameContaining(@Param("name") String name);

    // 이메일로 검색한 건수를 확인한다.
    Long countByEmailContaining(@Param("email") String email);

}
