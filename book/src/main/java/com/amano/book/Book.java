package com.amano.book;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 책제목
    @Column(length = 100, nullable = false)
    private String title;

    // 저자
    @Column(length = 100)
    private String author;

    // 출판사
    @Column(length = 100)
    private String publisher;

    // 책분류
    @Column(length = 100)
    private String book_classification;

    // 출판일
//    @Column(columnDefinition = "출판일")
    @Column
    private Date publish_date;

    // 가격
//    @Column(columnDefinition = "가격")
    @Column
    private Double price;

//    @Column(columnDefinition = "등록일시")
    @Column
    private Date regist_date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBook_classification() {
        return book_classification;
    }

    public void setBook_classification(String book_classification) {
        this.book_classification = book_classification;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getRegist_date() {
        return regist_date;
    }

    public void setRegist_date(Date regist_date) {
        this.regist_date = regist_date;
    }

    @PrePersist // Auto created date when it's created
    public void prePersist() {
        regist_date = new Date();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", book_classification='" + book_classification + '\'' +
                ", publish_date=" + publish_date +
                ", price=" + price +
                ", regist_date=" + regist_date +
                '}';
    }

}
