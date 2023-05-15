package ru.deelter.cryptomus.data;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/*
{
           "count": 15,
           "hasPages": true,
           "nextCursor": "eyJpZCI6MTk3LCJfcG9pbnRzVG9OZXh0SXRlbXMiOnRydWV9",
           "previousCursor": "eyJpZCI6MjExLCJfcG9pbnRzVG9OZXh0SXRlbXMiOmZhbHNlfQ",
           "perPage": 15
       }
 */
public class Pagination implements ICryptoRequestData {

	private int count;
	private boolean hasPages;
	private UUID cursor;
	private int perPage;

	@Contract(pure = true)
	private Pagination(@NotNull Builder builder) {
		count = builder.count;
		hasPages = builder.hasPages;
		cursor = builder.cursor;
		perPage = builder.perPage;
	}

	public int getCount() {
		return count;
	}

	public boolean getHasPages() {
		return hasPages;
	}

	public UUID getCursor() {
		return cursor;
	}

	public int getPerPage() {
		return perPage;
	}

	public static Builder builder() {
		return new Builder();
	}


	public static final class Builder {
		private int count;
		private boolean hasPages;
		private UUID cursor;
		private int perPage;

		private Builder() {
		}

		public Builder count(int count) {
			this.count = count;
			return this;
		}

		public Builder hasPages(boolean hasPages) {
			this.hasPages = hasPages;
			return this;
		}

		public Builder cursor(UUID previousCursor) {
			this.cursor = previousCursor;
			return this;
		}

		public Builder perPage(int perPage) {
			this.perPage = perPage;
			return this;
		}

		public Pagination build() {
			return new Pagination(this);
		}
	}
}
