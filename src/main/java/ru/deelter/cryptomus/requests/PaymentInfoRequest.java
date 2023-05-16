package ru.deelter.cryptomus.requests;

import org.jetbrains.annotations.NotNull;
import ru.deelter.cryptomus.data.CryptomusRequest;
import ru.deelter.cryptomus.utils.CryptoRequestUtil;

import java.util.UUID;

public class PaymentInfoRequest extends CryptomusRequest {

	private final UUID paymentId;

	public PaymentInfoRequest(@NotNull UUID paymentId) {
		super(CryptoRequestUtil.PAYMENT_INFO, null);
		this.paymentId = paymentId;
	}

	@Override
	public @NotNull String getDataAsJson() {
		return String.format("{\"uuid\":\"%s\"}", paymentId.toString());
	}
}
