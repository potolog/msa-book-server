package com.amano.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

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
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "책제목", required = true)
    @Column(length = 100, nullable = false)
    private String title;

    // 저자
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "저자", required = true)
    @Column(length = 100)
    private String author;

    // 출판사
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "출판사", required = true)
    @Column(length = 100)
    private String publisher;

    // 책분류
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "책분류", required = true)
    @Column(length = 100)
    private String book_classification;

    // 출판일
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "출판일", required = true)
    @Column(name="publish_date", columnDefinition = "출판일")
    private Date publishdate;

    // 가격
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "가격", required = true)
    @Column
    private Double price;

    // 등록일시
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "등록일시", required = true)
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
    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publish_date) {
        this.publishdate = publish_date;
    }

    public void setPublishdate(String publish_date) throws ParseException {
        Long _date = null;
        try {
            _date = Long.parseLong(publish_date);
            this.publishdate = new Date(_date);
            return;
        } catch (Exception ex) {}
        this.publishdate = format.parse(publish_date);
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
        return format.format(publishdate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", book_classification='" + book_classification + '\'' +
                ", publish_date=" + publishdate +
                ", price=" + price +
                ", regist_datetime=" + regist_datetime +
                '}';
    }

}
