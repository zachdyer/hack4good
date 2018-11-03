package com.borrowmyangel.hack4good.dao;

import com.borrowmyangel.hack4good.domain.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends CrudRepository<Session, Integer> {
}
