package com.borrowmyangel.hack4good.dao;

import com.borrowmyangel.hack4good.domain.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends CrudRepository<Login, Integer> {

}
