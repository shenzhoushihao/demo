package com.fly.tx.serviceb.config;

public class BRPCException extends RuntimeException {

	private static final long serialVersionUID = -6920277825072261353L;

	private final BRPCError bRPCError;

	public BRPCException() {
		this.bRPCError = null;
	}

	public BRPCException(BRPCError bRPCError) {
		this.bRPCError = bRPCError;
	}

	public BRPCException(String msg, BRPCError bRPCError) {
		super(msg);
		this.bRPCError = bRPCError;
	}

	public BRPCError getARPCError() {
		return this.bRPCError;
	}
}
