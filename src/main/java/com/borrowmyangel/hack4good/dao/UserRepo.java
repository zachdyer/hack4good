package com.borrowmyangel.hack4good.dao;

import com.borrowmyangel.hack4good.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

}
