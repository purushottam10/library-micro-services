package io.dz.librarydb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
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


}
