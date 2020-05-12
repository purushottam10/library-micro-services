package io.dz.librarydb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


@Entity
@Table(name = "book")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book implements Serializable {

    @Id
    //@GeneratedValue(generator="system-uuid")
    //@GenericGenerator(name="system-uuid", strategy = "uuid")
    private String bookId;
    private String author;
    private String price;
    private boolean available;
    private String title;
    private Date dueDate;
    private Date returnDate;
    private Date createdAt;
    private boolean isDeleted = false;
    private Date updatedAt;
    private String memberId;
//   @ManyToOne(cascade = CascadeType.ALL,   targetEntity = Member.class)
//   @JoinColumn(name = "member_id",referencedColumnName = "member_id")
//   private Member memberById;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return Objects.equals(bookId , that.bookId) &&
                Objects.equals(author , that.author)&&
                Objects.equals(price,that.price)&&
                Objects.equals(available,that.available)&&
                Objects.equals(title,that.title)&&
                Objects.equals(dueDate,that.dueDate)&&
               Objects.equals(returnDate,that.returnDate)&&
                Objects.equals(createdAt,that.createdAt)&&
                Objects.equals(isDeleted,that.isDeleted)&&
                Objects.equals(updatedAt,that.updatedAt)&&
                Objects.equals(memberId,that.memberId);
                //Objects.equals(memberById,that.memberById);
    }

//
//    public Member getMemberById() {
//        return memberById;
//    }
//
//    public void setMemberById(Member memberById) {
//        this.memberById = memberById;
//    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
