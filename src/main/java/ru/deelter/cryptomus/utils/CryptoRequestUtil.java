package ru.deelter.cryptomus.utils;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public class CryptoRequestUtil {

	public static final OkHttpClient CLIENT = new OkHttpClient();
	public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
	public static final String PAYMENT_CREATE = "https://api.cryptomus.com/v1/payment";
	public static final String PAYMENT_INFO = "https://api.cryptomus.com/v1/payment/info";
	public static final String PAYMENT_LIST = "https://api.cryptomus.com/v1/payment/list";
}
