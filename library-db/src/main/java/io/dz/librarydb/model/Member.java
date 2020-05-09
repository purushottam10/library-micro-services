package io.dz.librarydb.model;

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

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

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
