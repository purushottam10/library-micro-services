package io.dz.librarydb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_limit")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLimit {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String memberId;
    private int total_book;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getTotal_book() {
        return total_book;
    }

    public void setTotal_book(int total_book) {
        this.total_book = total_book;
    }
}
