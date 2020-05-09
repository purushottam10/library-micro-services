package io.dz.userlimitservice.service;

import io.dz.userlimitservice.model.UserLimit;

public interface UserLimitService {
    UserLimit save(UserLimit userLimit);
    UserLimit update(UserLimit userLimit);
    UserLimit getById(String id);
}
