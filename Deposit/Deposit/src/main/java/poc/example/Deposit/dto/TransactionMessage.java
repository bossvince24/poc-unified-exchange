package poc.example.Deposit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionMessage {

	private String username;
	private String transactionDate;
	private String type;
	private String details;
}
