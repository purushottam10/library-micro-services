package io.dz.memberservice.service;

import io.dz.memberservice.model.Member;

import java.util.List;

public interface MemberService {

    List<Member> getAll();

    Member save(Member member);

    Member update(Member member);

    Member findById(String memberId);
}
