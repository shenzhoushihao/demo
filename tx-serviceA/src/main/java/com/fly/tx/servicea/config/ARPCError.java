package com.fly.tx.servicea.config;

public enum ARPCError {

	RPC_ERROR("ERROR_001", "rpc fail."), 
	RPC_BAD_REQUEST("ERROR_002", "rpc bad request."),
	RPC_BAD_SAVE("ERROR_003", "rpc bad save."),
	RPC_BAD_ROLLBACK("ERROR_004", "rpc bad rollback.");

	String errorCode;
	String errorDescription;

	private ARPCError(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
}
