package com.example.ewalletdemo.repository;

import com.example.ewalletdemo.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet , Integer> {

}
