package ru.deelter.cryptomus.data;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class Amount {

	private final BigDecimal amount;
	private final String currency;

	public Amount(@NotNull BigDecimal amount, @NotNull String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	@Contract("_, _ -> new")
	public static @NotNull Amount from(double amount, String currency) {
		return new Amount(BigDecimal.valueOf(amount), currency);
	}
}
