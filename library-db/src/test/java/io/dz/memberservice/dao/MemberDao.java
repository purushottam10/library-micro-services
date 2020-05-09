package io.dz.memberservice.dao;

import io.dz.memberservice.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MemberDao extends CrudRepository<Member,String> {

}
