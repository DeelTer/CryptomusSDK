package ru.deelter.cryptomus.requests;

import org.jetbrains.annotations.NotNull;
import ru.deelter.cryptomus.data.CryptomusRequest;
import ru.deelter.cryptomus.data.requests.PaymentCreateData;
import ru.deelter.cryptomus.utils.CryptomusUrls;

public class PaymentCreateRequest extends CryptomusRequest {

	public PaymentCreateRequest(@NotNull PaymentCreateData data) {
		super(CryptomusUrls.PAYMENT_CREATE, data);
	}
}
