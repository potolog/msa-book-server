package com.amano.book;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    // 책제목으로 검색한다.
    List<Book> findByTitleContaining(@Param("title") String title);

    // 저자명으로 검색한다.
    List<Book> findByAuthorContaining(@Param("author") String author);

    // 출판일을 기준으로 검색한다.
    List<Book> findByPublishdateAfter(@Param("after") @DateTimeFormat(iso = ISO.DATE) Date date);

    // 책제목으로 검색한 건수를 확인한다.
    Long countByTitleContaining(@Param("title") String title);

    // 저자명으로 검색한 건수를 확인한다.
    Long countByAuthorContaining(@Param("author") String author);

    // 출판일을 기준으로 검색한 건수를 확인한다.
    Long countByPublishdateAfter(@Param("after") @DateTimeFormat(iso = ISO.DATE) Date date);

}
