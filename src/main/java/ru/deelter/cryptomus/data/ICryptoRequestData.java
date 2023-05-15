package ru.deelter.cryptomus.data;

import org.jetbrains.annotations.NotNull;
import ru.deelter.cryptomus.utils.JsonUtil;

public interface ICryptoRequestData {

	@NotNull
	default String toJson() {
		return JsonUtil.toJson(this);
	}
}
