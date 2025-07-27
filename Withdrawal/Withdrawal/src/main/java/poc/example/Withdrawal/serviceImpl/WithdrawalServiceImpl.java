package poc.example.Withdrawal.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import poc.example.Withdrawal.entity.Withdrawal;
import poc.example.Withdrawal.exception.WithdrawalNotFoundException;
import poc.example.Withdrawal.repository.WithdrawalRepository;
import poc.example.Withdrawal.service.WithdrawalService;

@Service
@Slf4j
public class WithdrawalServiceImpl implements WithdrawalService {

	@Autowired
	private WithdrawalRepository repository;
	
	@Autowired
	private RabbitMQService rabbitMQService;

	@Override
	public Withdrawal createWithdrawal(Withdrawal withdrawal) {
		// TODO Auto-generated method stub
		
		log.info("Creating Withdrawal...");

		if (withdrawal.getReferenceNumber() == null || withdrawal.getReferenceNumber().isBlank()) {
			withdrawal.setReferenceNumber(generateReferenceNumber());
		}

		if (withdrawal.getTimestamp() == null) {
			withdrawal.setTimestamp(LocalDateTime.now());
		}
		Withdrawal saved = repository.save(withdrawal);
		
		rabbitMQService.sendMessage("WithdrawalService");
		
		log.info("Withdrawal saved and sent to RabbitMQ: {}", saved.getReferenceNumber());
		
		return saved;
	}

	private String generateReferenceNumber() {
		return "DEP-" + UUID.randomUUID();
	}

	@Override
	public Withdrawal getWithdrawal(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id)
				.orElseThrow(() -> new WithdrawalNotFoundException("Withdrawal Not Found with ID " + id));
	}

	@Override
	public List<Withdrawal> getAllWithdrawals() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
