package poc.example.Withdrawal.service;

import java.util.List;

import poc.example.Withdrawal.entity.Withdrawal;

public interface WithdrawalService {

	Withdrawal createWithdrawal(Withdrawal withdrawal);

	Withdrawal getWithdrawal(Long id);

	List<Withdrawal> getAllWithdrawals();

}
