package poc.example.Deposit.service;

import java.util.List;

import poc.example.Deposit.entity.Deposit;

public interface DepositService {

	Deposit createDeposit(Deposit deposit);

	Deposit getDeposit(Long id);

	List<Deposit> getAllDeposits();
}
