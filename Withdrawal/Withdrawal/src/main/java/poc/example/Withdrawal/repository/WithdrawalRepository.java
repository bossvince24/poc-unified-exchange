package poc.example.Withdrawal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poc.example.Withdrawal.entity.Withdrawal;

@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long>{

}
