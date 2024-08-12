package com.micro.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.bank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
