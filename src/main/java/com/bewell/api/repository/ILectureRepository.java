package com.bewell.api.repository;

import com.bewell.api.entity.Lecture;
import com.bewell.api.entity.User;
import com.bewell.api.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILectureRepository extends JpaRepository<Lecture,Integer>
{
    boolean existsByIdentityNo(String identityNo);
    List<Lecture> findAllByRole(Role role);

    List<Lecture> findAllByRoleAndIdIsNotIn(Role role, List<Integer> idList);
}
