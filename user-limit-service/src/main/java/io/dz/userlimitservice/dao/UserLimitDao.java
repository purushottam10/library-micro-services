package io.dz.userlimitservice.dao;

import io.dz.userlimitservice.model.UserLimit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserLimitDao extends CrudRepository<UserLimit,String> {
}
