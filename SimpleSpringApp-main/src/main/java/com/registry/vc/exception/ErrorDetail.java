package com.registry.vc.exception;

import java.time.LocalDateTime;
import java.util.Objects;

public class ErrorDetail {

	private Integer statusCode;
	private String message;
	private String description;
	private LocalDateTime timestamp;

	private ErrorDetail(Builder builder) {
		this.statusCode = builder.statusCode;
		this.message = builder.message;
		this.description = builder.description;
		this.timestamp = builder.timestamp;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public static class Builder {

		private final int statusCode;
		private final String message;
		private String description;
		private LocalDateTime timestamp;

		public Builder(int statusCode, String message) {
			this.statusCode = statusCode;
			this.message = message;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder timestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public ErrorDetail build() {
			if (Objects.isNull(this.timestamp)) {
				this.timestamp = LocalDateTime.now();
			}
			return new ErrorDetail(this);
		}
	}

}
