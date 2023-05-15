package ru.deelter.cryptomus.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class CryptomusRequest {

	private final String url;
	private final ICryptoRequestData data;

	protected CryptomusRequest(@NotNull String url, @Nullable ICryptoRequestData data) {
		this.url = url;
		this.data = data;
	}

	protected CryptomusRequest(@NotNull String url) {
		this(url, null);
	}

	@NotNull
	public String getUrl() {
		return url + getUrlParameters();
	}

	@Nullable
	public ICryptoRequestData getData() {
		return data;
	}

	@NotNull
	public String getDataAsJson() {
		if (data == null)
			return "{}";
		return data.toJson();
	}

	public String getUrlParameters() {
		return "";
	}
}
