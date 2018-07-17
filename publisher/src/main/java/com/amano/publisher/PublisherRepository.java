package com.amano.publisher;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long> {

    // 출판사명으로 검색한다.
    List<Publisher> findByNameContaining(@Param("name") String name);

    // 홈페이지 주소로 검색한다.
    List<Publisher> findByHomepageContaining(@Param("homepage") String homepage);

    // 이메일로 검색한다.
    List<Publisher> findByEmailContaining(@Param("email") String email);

    // 출판사명으로 검색한 건수를 확인한다.
    Long countByNameContaining(@Param("name") String name);

    // 홈페이지 주소로 검색한 건수를 확인한다.
    Long countByHomepageContaining(@Param("homepage") String homepage);

    // 이메일로 검색한 건수를 확인한다.
    Long countByEmailContaining(@Param("email") String email);

}
