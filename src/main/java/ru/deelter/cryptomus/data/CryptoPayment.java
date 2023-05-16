package ru.deelter.cryptomus.data;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.UUID;

/*
{
		"uuid": "259ec480-b01c-45ea-9427-f66f5fb2eeb4",
		"order_id": "926d7d57-3c1f-4324-8541-e7eb5e93fb9d",
		"amount": "10.00",
		"payment_amount": null,
		"payer_amount": null,
		"discount_percent": null,
		"discount": "0.00000000",
		"payer_currency": null,
		"currency": "USD",
		"comments": null,
		"network": null,
		"address": null,
		"from": null,
		"txid": null,
		"payment_status": "check",
		"url": "https://pay.cryptomus.com/pay/259ec480-b01c-45ea-9427-f66f5fb2eeb4",
		"expired_at": 1683820147,
		"status": "check",
		"is_final": false,
		"additional_data": null
	}
 */
public class CryptoPayment {

	@SerializedName("uuid")
	private UUID id;
	@SerializedName("order_id")
	private UUID orderId;
	private BigDecimal amount;
	@SerializedName("payment_amount")
	private BigDecimal paymentAmount;
	@SerializedName("payer_amount")
	private BigDecimal payerAmount;
	private String currency;
	@SerializedName("payer_currency")
	private String payerCurrency;
	@SerializedName("payment_status")
	private PaymentStatus paymentStatus;
	private PaymentStatus status;
	@SerializedName("url")
	private String confirmationUrl;
	@SerializedName("expired_at")
	private long expiredAt;
	@SerializedName("is_final")
	private boolean confirmed;
	@SerializedName("additional_data")
	private JsonElement metadata;

	@Override
	public String toString() {
		return "CryptoPayment{" +
				"id=" + id +
				", orderId=" + orderId +
				", amount=" + amount +
				", paymentAmount=" + paymentAmount +
				", payerAmount=" + payerAmount +
				", currency='" + currency + '\'' +
				", payerCurrency='" + payerCurrency + '\'' +
				", paymentStatus=" + paymentStatus +
				", status=" + status +
				", confirmationUrl='" + confirmationUrl + '\'' +
				", expiredAt=" + expiredAt +
				", confirmed=" + confirmed +
				", metadata=" + metadata +
				'}';
	}

	public UUID getId() {
		return id;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public BigDecimal getPayerAmount() {
		return payerAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public String getConfirmationUrl() {
		return confirmationUrl;
	}

	public long getExpiredAt() {
		return expiredAt;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public JsonElement getMetadata() {
		return metadata;
	}
}
