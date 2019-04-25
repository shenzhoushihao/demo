package com.fly.tx.servicea.config;

public class ARPCException extends RuntimeException {

	private static final long serialVersionUID = -6920277825072261353L;

	private final ARPCError aRPCError;

	public ARPCException() {
		this.aRPCError = null;
	}

	public ARPCException(ARPCError aRPCError) {
		this.aRPCError = aRPCError;
	}

	public ARPCException(String msg, ARPCError aRPCError) {
		super(msg);
		this.aRPCError = aRPCError;
	}

	public ARPCError getARPCError() {
		return this.aRPCError;
	}
}
