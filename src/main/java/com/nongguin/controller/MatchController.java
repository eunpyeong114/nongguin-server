package com.nongguin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nongguin.model.dto.Match;
import com.nongguin.model.dto.SearchCondition;
import com.nongguin.model.dto.SearchResult;
import com.nongguin.model.service.MatchService;
import com.nongguin.model.service.Match_UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Match")
@Api(tags = "매치 컨트롤러")
public class MatchController {

	@Autowired
	MatchService matchService;

	@Autowired
	Match_UserService muService;
	
	// 날짜별 매치 정보 조회
	@GetMapping("/search/date/{matchDate}")
	@ApiOperation("날짜별 매치 정보 조회")
	public ResponseEntity<?> getMatchsByDay(@PathVariable(value = "matchDate") String matchDate) {
		List<SearchResult> list = matchService.getMatchsByDay(matchDate);
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<SearchResult>>(list, HttpStatus.OK);
	}

	// 검색 조건별 매치 정보 조회
	@PostMapping("/search/condition")
	@ApiOperation("검색 조건별 매치 정보 조회")
	public ResponseEntity<?> getMatchsBySearchCondition(@RequestBody SearchCondition condition) {
		System.out.println(condition);
		List<Match> list = matchService.getMatchsBySearchCondition(condition);
		
		if(list == null || list.size()==0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Match>>(list,HttpStatus.OK);
	}
	
	// 매치 상세 정보 조회
	@GetMapping("/search/detail/{matchId}")
	@ApiOperation("매치 상세 정보 조회")
	public ResponseEntity<?> getMatchByMatchId(@PathVariable(value="matchId")int matchId){
		SearchResult match = matchService.getMatchByMatchId(matchId);
		if(match == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<SearchResult>(match,HttpStatus.OK);
	}
	
	// 매치 이용 전체 내역 조회 (유저별)
	@GetMapping("/search/user/{userId}")
	@ApiOperation("유저별 매치 전체 내역 조회")
	public ResponseEntity<?> getMatchsByUserId(@PathVariable(value="userId")int userId){
		List<Integer>matchIds = muService.getMatchIdByUserId(userId);
		List<SearchResult>list = matchService.getMatchsByUserId(matchIds);
		if(list == null || list.size()==0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<SearchResult>>(list,HttpStatus.OK);
	}
	
	// 매치 예약 내역 조회
	@GetMapping("/search/reserve/{userId}")
	@ApiOperation("매치 예약 내역(앞으로 예정된 것들만) 조회")
	public ResponseEntity<?> getRemainingMatchsByUserId(@PathVariable(value="userId")int userId){
		// 유저 아이디별로 매치 아이디 찾기
		List<Integer>matchIds = muService.getMatchIdByUserId(userId);
		List<SearchResult>list = matchService.getRemainingMatchsByUserId(matchIds);
		if(list ==null || list.size()==0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<SearchResult>>(list,HttpStatus.OK);
	}

}
