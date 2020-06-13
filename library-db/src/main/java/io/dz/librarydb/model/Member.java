package io.dz.librarydb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String memberId;
    private String name;
    private String contactNo;
    @Email
    private String emailId;
    private Date expiryDate;
    private MemberType memberType = MemberType.TEMP;


    public enum MemberType{
     PERMANENT,TEMP
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member that = (Member) o;
        return memberId == that.memberId &&
                Objects.equals(name, that.name) &&
                Objects.equals(expiryDate, that.expiryDate) &&
                Objects.equals(emailId, that.emailId)&&
                Objects.equals(memberType,that.memberType)&&
                Objects.equals(contactNo,that.contactNo);

    }
}
