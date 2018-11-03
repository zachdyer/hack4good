package com.borrowmyangel.hack4good.dao;

import com.borrowmyangel.hack4good.domain.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepo extends CrudRepository<Application, Integer> {


}
