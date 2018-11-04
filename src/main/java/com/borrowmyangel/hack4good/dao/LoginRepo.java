package com.borrowmyangel.hack4good.dao;

import com.borrowmyangel.hack4good.domain.Login;
import org.springframework.context.annotation.Conditional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends CrudRepository<Login, Integer> {
	Login findLoginByToken(String token);
}
