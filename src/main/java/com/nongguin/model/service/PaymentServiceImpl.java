package com.nongguin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nongguin.model.dao.MatchDao;
import com.nongguin.model.dao.Match_UserDao;
import com.nongguin.model.dao.PaymentDao;
import com.nongguin.model.dto.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	Match_UserDao muDao;

	@Autowired
	MatchDao matchDao;

	@Transactional
	@Override
	public boolean payForMatch(Payment payment, int userId, int matchId) {
		// payment 결제 데이터 저장
		try {
			int result = paymentDao.payForMatch(payment);
			if (result <= 0)
				return false;
		} catch(Throwable err){
			System.out.println(err);
		}
		// 매치 데이터 저장
		try {
			int mResult = matchDao.plusApplicantCnt(matchId);
			if (mResult <= 0)
				return false;
		} catch(Throwable err) {
			System.out.println(err);
		}
		// 매치_유저 중간테이블 저장
		try {
			int muResult = muDao.insertData(userId, matchId);
			if (muResult <= 0)
				return false;
		} catch(Throwable err) {
			System.out.println(err);
		}
		return true;
	}

}
