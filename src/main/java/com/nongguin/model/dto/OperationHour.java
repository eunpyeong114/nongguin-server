package com.nongguin.model.dto;

import java.time.LocalTime;

public class OperationHour {
	private int operationHourId;
	private LocalTime operationHourStart;

	public OperationHour() {

	}

	public OperationHour(int operationHourId, LocalTime operationHourStart) {
		super();
		this.operationHourId = operationHourId;
		this.operationHourStart = operationHourStart;
	}

	public int getOperationHourId() {
		return operationHourId;
	}

	public void setOperationHourId(int operationHourId) {
		this.operationHourId = operationHourId;
	}

	public LocalTime getOperationHourStart() {
		return operationHourStart;
	}

	public void setOperationHourStart(LocalTime operationHourStart) {
		this.operationHourStart = operationHourStart;
	}

	@Override
	public String toString() {
		return "OperationHour [operationHourId=" + operationHourId + ", operationHourStart=" + operationHourStart + "]";
	}
}
