package com.micro.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.bank.entity.Account;
import com.micro.bank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository repo;
	public Account createAccount(Account account) {
		return repo.save(account);

	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account>account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new RuntimeException("Account is not found");
		}
		Account accountFound=account.get();
		return accountFound;
	}
	

	@Override
	public List<Account> getAllAccountDetails() {
		return repo.findAll();
	}

	@Override
	public Account depositMoney(Long accountNumber, Double amount) {
		 Optional<Account>account=repo.findById(accountNumber);
		    if(account.isEmpty()) {
		    	throw new RuntimeException("Account is not present");
		    }
		    	Account  accountPresent=account.get();
		    	Double totalBalance= accountPresent.getAccountBalance()+amount;
		    	accountPresent.setAccountBalance(totalBalance);
		    	repo.save(accountPresent);
		    	return accountPresent;
			}

	

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		 Optional<Account>account=repo.findById(accountNumber);
		    if(account.isEmpty()) {
		    	throw new RuntimeException("Account is not present");
		    }
		    Account accountPresent=account.get();
		    Double accountBalance=accountPresent.getAccountBalance()-amount;
		  accountPresent.setAccountBalance(accountBalance);
		  repo.save(accountPresent);
		  return accountPresent;
	}

	@Override
	public String closeAccount(Long accountNumber) {
		getAccountDetailsByAccountNumber(accountNumber);
		 repo.deleteById(accountNumber);
		 return "account deleted successfully";
		
   
}
}
