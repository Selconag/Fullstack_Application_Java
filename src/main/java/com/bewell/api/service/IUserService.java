package com.bewell.api.service;

import com.bewell.api.entity.User;
import com.bewell.api.entity.enums.Role;

import java.util.List;

public interface IUserService extends IService<User>{
    List<User> getUsersByRole(Role role);

    List<User> getPotentialUsers(List<Integer> ids );
}
