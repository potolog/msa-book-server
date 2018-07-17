package com.amano.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private Date regist_datetime;

    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

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

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public void setPublish_date(String publish_date) throws ParseException {
        Long _date = null;
        try {
            _date = Long.parseLong(publish_date);
            this.publish_date = new Date(_date);
            return;
        } catch (Exception ex) {}
        this.publish_date = format.parse(publish_date);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    public Date getRegist_datetime() {
        return regist_datetime;
    }

    public void setRegist_datetime(Date regist_datetime) {
        this.regist_datetime = regist_datetime;
    }

    @PrePersist // Auto created date when it's created
    public void prePersist() {
        regist_datetime = new Date();
    }

    @JsonIgnore
    public String getPublish_dateAsShort() {
        return format.format(publish_date);
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
                ", regist_datetime=" + regist_datetime +
                '}';
    }

}
