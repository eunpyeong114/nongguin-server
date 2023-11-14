package com.nongguin.model.service;

import com.nongguin.model.dto.Payment;

public interface PaymentService {

	boolean payForMatch(Payment payment, int userId, int matchId);

}
