package com.example.ewalletdemo;

import com.example.ewalletdemo.entity.Account;
import com.example.ewalletdemo.entity.Wallet;
import com.example.ewalletdemo.repository.AccountRepository;
import com.example.ewalletdemo.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EWalletDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EWalletDemoApplication.class, args);
    }
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void run(String... args) throws Exception {

        Account account = new Account();
        account.setUsername("Duong");
        account.setPassword("123");
        account.setId(1);
        accountRepository.save(account);

        Wallet wallet = new Wallet();
        wallet.setId(1);
        wallet.setBalance(100000);
        wallet.setAccount(account);

        walletRepository.save(wallet);
    }
}
