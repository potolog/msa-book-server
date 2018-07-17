package com.amano.sharedmodel;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "publisher")
public class Publisher {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    // 출판사명
    @Column(length = 100, nullable = false)
    private String name;

    // 홈페이지
    @Column(length = 255)
    private String homepage;

    // 홈페이지
    @Column(length = 255)
    private String email;

    // 전화번호
    @Column(length = 255)
    private String telephone;

    // 등록일시
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

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

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homepage='" + homepage + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", regist_datetime=" + regist_datetime +
                '}';
    }

}
