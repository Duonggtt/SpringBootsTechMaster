package com.example.ewalletdemo.repository;

import com.example.ewalletdemo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
