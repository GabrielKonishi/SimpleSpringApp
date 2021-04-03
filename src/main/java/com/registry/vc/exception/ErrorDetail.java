package com.registry.vc.exception;


import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class ErrorDetail {
	
	private int statusCode;
	private String message;
	private String description;
	private LocalDateTime errorTime;
	private Set<ItemErrorDetail> errors;
	
    private ErrorDetail() {
        throw new AssertionError();
    }
    

    private ErrorDetail(Builder builder) {
        this.statusCode = builder.statusCode;
        this.message = builder.message;
        this.description = builder.description;
        this.errorTime = builder.errorTime;
        this.errors = builder.errors;
    }
    
    public int getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getTimestamp() {
        return errorTime;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public Set<ItemErrorDetail> getErrors() {
        return errors;
    }
	
    public static class Builder {

        private final int statusCode;
        private final String message;
        private String description;
        private LocalDateTime errorTime;
        private Set<ItemErrorDetail> errors;

        public Builder(int statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder timestamp(LocalDateTime errorTime) {
            this.errorTime = errorTime;
            return this;
        }

        public Builder errors(Set<ItemErrorDetail> errors) {
            this.errors = errors;
            return this;
        }

        public ErrorDetail build() {
            if (Objects.isNull(this.errorTime)) {
                this.errorTime = LocalDateTime.now();
            }
            return new ErrorDetail(this);
        }
    }
    
}
