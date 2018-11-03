package com.borrowmyangel.hack4good.repository;

import com.borrowmyangel.hack4good.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
}
