package ru.deelter.cryptomus.data.requests;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.deelter.cryptomus.data.ICryptoRequestData;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class PaymentCreateData implements ICryptoRequestData, JsonSerializer<BigDecimal> {

	@SerializedName("order_id")
	private final UUID id;
	private final String amount;
	private final String currency;
	@SerializedName("url_return")
	private final String redirectUrl;
	private final int lifetime;

	private PaymentCreateData(Builder builder) {
		id = builder.id;
		amount = builder.amount;
		currency = builder.currency;
		redirectUrl = builder.redirectUrl;
		lifetime = builder.lifetime;
	}

	@Contract(value = " -> new", pure = true)
	public static @NotNull Builder builder() {
		return new Builder();
	}

	@Override
	public JsonElement serialize(@NotNull BigDecimal bigDecimal, Type type, JsonSerializationContext jsonSerializationContext) {
		System.out.println("serialize");
		return new JsonPrimitive(bigDecimal.toString());
	}


	public static final class Builder {
		private UUID id;
		private String amount;
		private String currency;
		private String redirectUrl;
		private int lifetime;

		private Builder() {
		}

		public Builder id(UUID id) {
			this.id = id;
			return this;
		}

		public Builder amount(String amount) {
			this.amount = amount;
			return this;
		}

		public Builder amount(@NotNull BigDecimal amount) {
			this.amount = amount.toString();
			return this;
		}

		public Builder currency(@NotNull String currency) {
			this.currency = currency;
			return this;
		}

		public Builder redirectUrl(@NotNull String redirectUrl) {
			this.redirectUrl = redirectUrl;
			return this;
		}

		public Builder lifetime(int lifetime) {
			this.lifetime = lifetime;
			return this;
		}

		public Builder lifetime(long duration, TimeUnit unit) {
			return lifetime((int) unit.toSeconds(duration));
		}

		public PaymentCreateData build() {
			if (id == null)
				id = UUID.randomUUID();
			return new PaymentCreateData(this);
		}
	}
}
