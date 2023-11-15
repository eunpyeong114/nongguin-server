package com.nongguin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nongguin.model.dto.Payment;
import com.nongguin.model.service.MatchService;
import com.nongguin.model.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/payment")
@Api(tags = "결제 컨트롤러")
public class PaymentController {
	@Autowired
	PaymentService paymentService;

 	@Autowired
	MatchService matchService;

	// 매치 결제
	@PostMapping("/payment")
	@ApiOperation("매치 결제")
	public ResponseEntity<String> payForMatch(@RequestBody Payment payment, int userId, int matchId) {
		// 농구장 최대수용인원
		int courtCapacity = matchService.getCourtCapacity(matchId);
		// 해당 매치 실제 참가자수
		int appliedCnt = matchService.getMatchApplicantCnt(matchId);
		// 남은 자리
		int remainingCnt = courtCapacity - appliedCnt;
		// 남은자리가 0이하인 경우
		if (remainingCnt <= 0)
			// full
			return new ResponseEntity<String>("full", HttpStatus.NOT_ACCEPTABLE);
		// 결제 & match_user 데이터 추가 & match 데이터 변경(매치 신청인원+1)
		boolean result = paymentService.payForMatch(payment, userId, matchId);
		if (result)
			return new ResponseEntity<String>("false", HttpStatus.NO_CONTENT);
		return new ResponseEntity<String>("true", HttpStatus.OK);
	}
	
	// 매치 결제 취소
//	@PostMapping("/payment/cancel")
//	@ApiOperation("매치 결제 취소")
//	public ResponseEntity<String> cancelPayment(){
//		
//	}
}
