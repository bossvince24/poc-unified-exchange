package poc.example.Deposit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poc.example.Deposit.entity.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {

}
