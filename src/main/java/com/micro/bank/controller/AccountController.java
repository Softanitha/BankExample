package com.micro.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.bank.entity.Account;
import com.micro.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService service;
	
	//create the account
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		
		return new ResponseEntity<Account>(service.createAccount(account),HttpStatus.CREATED);
		
	}
	@GetMapping("/{accountNumber}")
	public Account getAccountByAccountNumber(@PathVariable Long accountNumber) {
		return service.getAccountDetailsByAccountNumber(accountNumber);
	}
	
	@GetMapping("/getallaccounts")
	public ResponseEntity<List<Account>>getAllAccountDetails(){
		return new ResponseEntity<List<Account>>(service.getAllAccountDetails(),HttpStatus.CREATED);
	}
	
	@PutMapping("/deposite/{accountNumber}/{amount}")
	public ResponseEntity<Account> depositeAccount(@PathVariable Long accountNumber,@PathVariable double amount) {
		return new ResponseEntity<Account>(service.depositMoney(accountNumber, amount),HttpStatus.CREATED);
	}
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public ResponseEntity<Account>withdrawAccount(@PathVariable Long accountNumber,@PathVariable double amount) {
		return new ResponseEntity<Account>(service.withdrawAmount(accountNumber, amount),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
		return new ResponseEntity<String>(service.closeAccount(accountNumber),HttpStatus.CREATED);
	}
}
