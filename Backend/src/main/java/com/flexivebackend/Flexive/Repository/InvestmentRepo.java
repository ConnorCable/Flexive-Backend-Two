package com.flexivebackend.Flexive.Repository;

import com.flexivebackend.Flexive.Model.Investment;
import com.flexivebackend.Flexive.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface InvestmentRepo extends JpaRepository<Investment,Integer> {

    Set<Investment> findByUser(User user);

}
