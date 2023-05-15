package ru.deelter.cryptomus.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentList {

	@SerializedName("items")
	private List<CryptoPayment> items;
	@SerializedName("paginate")
	private Pagination pagination;

	public List<CryptoPayment> getItems() {
		return items;
	}

	public Pagination getPagination() {
		return pagination;
	}
}
