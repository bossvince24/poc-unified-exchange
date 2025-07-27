package poc.example.Withdrawal.resolver;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import poc.example.Withdrawal.entity.Withdrawal;
import poc.example.Withdrawal.serviceImpl.WithdrawalServiceImpl;

@Controller
public class WithdrawalResolver {

	@Autowired
	private WithdrawalServiceImpl serviceImpl;
	
	@MutationMapping
	public Withdrawal createWithdrawal(@Argument Long accountId, @Argument BigDecimal amount) {
		
		Withdrawal withdrawals = new Withdrawal();
		
		withdrawals.setAccountId(accountId);
		withdrawals.setAmount(amount);
		
		return serviceImpl.createWithdrawal(withdrawals);
	}
	
	@QueryMapping
	public Withdrawal getWithdrawal(@Argument Long id) {
		return serviceImpl.getWithdrawal(id);
	}
	
	@QueryMapping
	public List<Withdrawal> getAllWithdrawals() {
		return serviceImpl.getAllWithdrawals();
	}
}
