package com.bewell.api.service.impl;

import com.bewell.api.common.GeneralException;
import com.bewell.api.entity.User;
import com.bewell.api.entity.enums.Role;
import com.bewell.api.repository.IUserRepository;
import com.bewell.api.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public User save(User user) {
        if (user.getId() == null) {
            if (user.getIdentityNo() == null || user.getIdentityNo().length() != 11 )
            {
                throw new GeneralException("Invalid Identity no!");
            }
            if(userRepository.existsByIdentityNo(user.getIdentityNo()))
            {
                throw new GeneralException("Identity no already exists");
            }
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(int id)
    {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new GeneralException("User not found");
        }
        return user.get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new GeneralException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        userRepository.findAllByRole(role);
    }

    @Override
    public List<User> getPotentialUsers(List<Integer> ids) {
        if (ids.isEmpty()) {
            return getUsersByRole(Role.STUDENT);
        }
        return userRepository.findAllByRoleAndIdIsNotIn(Role.STUDENT,ids);
    }
}
