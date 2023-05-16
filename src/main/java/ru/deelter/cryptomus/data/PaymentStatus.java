package ru.deelter.cryptomus.data;

import com.google.gson.annotations.SerializedName;

public enum PaymentStatus {

	@SerializedName("paid")
	PAID,
	@SerializedName("paid_over")
	PAID_OVER,
	@SerializedName("wrong_amount")
	WRONG_AMOUNT,
	@SerializedName("process")
	PROCESS,
	@SerializedName("confirm_check")
	CONFIRM_CHECK,
	@SerializedName("wrong_amount_waiting")
	WRONG_AMOUNT_WAITING,
	@SerializedName("check")
	CHECK,
	@SerializedName("fail")
	FAIL,
	@SerializedName("cancel")
	CANCEL,
	@SerializedName("system_fail")
	SYSTEM_FAIL,
	@SerializedName("refund_process")
	REFUND_PROCESS,
	@SerializedName("refund_fail")
	REFUND_FAIL,
	@SerializedName("refund_paid")
	REFUND_PAID;

	public boolean isPaid() {
		return this == PAID || this == PAID_OVER;
	}

	public boolean isError() {
		return switch (this) {
			case WRONG_AMOUNT, FAIL, SYSTEM_FAIL, CANCEL -> true;
			default -> false;
		};
	}
}