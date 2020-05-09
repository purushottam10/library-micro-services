package io.dz.userlimitservice.service.impl;

import io.dz.userlimitservice.dao.UserLimitDao;
import io.dz.userlimitservice.model.UserLimit;
import io.dz.userlimitservice.service.UserLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLimitServiceImpl implements UserLimitService {
    @Autowired
    private UserLimitDao userLimitDao;

    @Override
    public UserLimit save(UserLimit userLimit) {
        return userLimitDao.save(userLimit);
    }

    @Override
    public UserLimit update(UserLimit userLimit) {
        return save(userLimit);
    }

    @Override
    public UserLimit getById(String id) {
        return userLimitDao.findById(id).orElse( null);
    }
}
