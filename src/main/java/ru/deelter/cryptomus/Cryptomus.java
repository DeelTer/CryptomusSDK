package ru.deelter.cryptomus;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.deelter.cryptomus.data.CryptoPayment;
import ru.deelter.cryptomus.data.CryptomusRequest;
import ru.deelter.cryptomus.data.PaymentList;
import ru.deelter.cryptomus.data.requests.PaymentCreateData;
import ru.deelter.cryptomus.exceptions.BadRequestException;
import ru.deelter.cryptomus.requests.PaymentCreateRequest;
import ru.deelter.cryptomus.requests.PaymentInfoRequest;
import ru.deelter.cryptomus.requests.PaymentListRequest;
import ru.deelter.cryptomus.utils.CryptoRequestUtil;
import ru.deelter.cryptomus.utils.EncodeUtil;
import ru.deelter.cryptomus.utils.JsonUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class Cryptomus {

	private final UUID merchantId;
	private final String token;

	protected Cryptomus(@NotNull UUID merchantId, @NotNull String token) {
		this.merchantId = merchantId;
		this.token = token;
	}

	public UUID getMerchantId() {
		return merchantId;
	}

	public String getToken() {
		return token;
	}

	@Contract(value = "_, _ -> new", pure = true)
	public static @NotNull Cryptomus create(UUID merchantId, String token) {
		return new Cryptomus(merchantId, token);
	}

	public CryptoPayment createPayment(@NotNull PaymentCreateData data) throws IOException {
		return parseResponse(CryptoPayment.class, new PaymentCreateRequest(data));
	}

	public CryptoPayment getPayment(@NotNull UUID paymentId) throws IOException {
		return parseResponse(CryptoPayment.class, new PaymentInfoRequest(paymentId));
	}

	public PaymentList getPayments(@Nullable UUID cursor) throws IOException {
		return parseResponse(PaymentList.class, new PaymentListRequest(cursor));
	}

	private <T> @Nullable T parseResponse(@Nullable Class<T> clazz, @NotNull CryptomusRequest cryptomusRequest) throws IOException {
		String json = cryptomusRequest.getDataAsJson();
		Request request = new Request.Builder()
				.url(cryptomusRequest.getUrl())
				.post(RequestBody.create(json, CryptoRequestUtil.MEDIA_TYPE_JSON))
				.header("merchant", merchantId.toString())
				.header("sign", createSign(json))
				.build();

		try (Response response = CryptoRequestUtil.CLIENT.newCall(request).execute(); ResponseBody responseBody = response.body()) {
			if (!response.isSuccessful() || responseBody == null)
				throw new BadRequestException(response.message());

			if (clazz == null)
				return null;

			JsonObject object = JsonParser.parseString(responseBody.string()).getAsJsonObject();
			return JsonUtil.fromJson(object.get("result").toString(), clazz);
		}
	}

	private @NotNull String createSign(@NotNull String json) {
		String jsonBase64 = Base64.getEncoder().encodeToString(json.getBytes(StandardCharsets.UTF_8));
		return EncodeUtil.bytesToHex(
				EncodeUtil.digestMD5((jsonBase64 + token).getBytes(StandardCharsets.UTF_8))
		);
	}

}
