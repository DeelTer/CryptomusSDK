package ru.deelter.cryptomus.requests;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.deelter.cryptomus.data.CryptomusRequest;
import ru.deelter.cryptomus.utils.CryptoRequestUtil;
import ru.deelter.cryptomus.utils.EncodeUtil;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class PaymentListRequest extends CryptomusRequest {

	@SerializedName("cursor")
	private final UUID cursor;


	public PaymentListRequest(@Nullable UUID cursor) {
		super(CryptoRequestUtil.PAYMENT_LIST, null);
		this.cursor = cursor;
	}

	public UUID getCursor() {
		return cursor;
	}

	@Override
	public String getUrlParameters() {
		if (getCursor() == null)
			return super.getUrlParameters();

		return "?cursor=" + EncodeUtil.bytesToHex(
				EncodeUtil.digestMD5(getCursor().toString().getBytes(StandardCharsets.UTF_8))
		);
	}

	@Override
	public @NotNull String getDataAsJson() {
		return "{}";
	}
}
