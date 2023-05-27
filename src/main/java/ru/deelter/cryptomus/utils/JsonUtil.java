package ru.deelter.cryptomus.utils;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

public class JsonUtil {

	private static final Gson GSON = new Gson();

	public static String toJson(@NotNull Object object) {
		return GSON.toJson(object);
	}

	public static <T> T fromJson(@NotNull String json, @NotNull Class<T> clazz) {
		return GSON.fromJson(json, clazz);
	}
}
