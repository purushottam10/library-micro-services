package io.dz.memberservice.service.impl;

import io.dz.memberservice.dao.MemberDao;
import io.dz.memberservice.exception.RestException;
import io.dz.memberservice.model.Member;
import io.dz.memberservice.service.MemberService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<Member> getAll() {
        return (List<Member>) memberDao.findAll();
    }

    @Override
    public Member save(Member member) {
        if (Strings.isBlank(member.getMemberId())) {
            member.setMemberId("USR".concat(RandomStringUtils.randomAlphabetic(7).toUpperCase()));
        }
        return memberDao.save(member);
    }

    @Override
    public Member findById(String memberId) {
        return memberDao.findById(memberId).orElseThrow(()->new RestException("Member not found " + memberId,HttpStatus.NOT_FOUND));
    }

    @Override
    public Member update(Member member) {
       if(Objects.nonNull(findById(member.getMemberId()))){
            return memberDao.save(member);
        }
        throw new RestException("Member not updated",HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
