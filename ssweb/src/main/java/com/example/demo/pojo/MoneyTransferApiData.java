package com.example.demo.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MoneyTransferApiData {
	
	@Schema(description = "Source bank account number. MOney will be deducted from this number.", example = "213254687974")
	private String fromAccount;
	
	@Schema(description = "Money will be credited to this account. ", example = "135466454567")
	private String toAccount;
	
	@Schema( description = "This amount(INR) will be debited form source account and will be credited to destination account.", example = "99.99")
	private Double amount;

}
