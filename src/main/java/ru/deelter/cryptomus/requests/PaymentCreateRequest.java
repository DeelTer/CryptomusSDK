package ru.deelter.cryptomus.requests;

import org.jetbrains.annotations.NotNull;
import ru.deelter.cryptomus.data.CryptomusRequest;
import ru.deelter.cryptomus.data.requests.PaymentCreateData;
import ru.deelter.cryptomus.utils.CryptoRequestUtil;

public class PaymentCreateRequest extends CryptomusRequest {

	public PaymentCreateRequest(@NotNull PaymentCreateData data) {
		super(CryptoRequestUtil.PAYMENT_CREATE, data);
	}
}
