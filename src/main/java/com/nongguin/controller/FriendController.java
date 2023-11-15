package com.nongguin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nongguin.model.dto.Friend;
import com.nongguin.model.dto.Match;
import com.nongguin.model.dto.User;
import com.nongguin.model.service.FriendService;
import com.nongguin.model.service.MatchService;
import com.nongguin.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/friend")
@Api(tags = "친구 컨트롤러")
public class FriendController {

	@Autowired
	FriendService friendService;

	@Autowired
	UserService userService;

	@Autowired
	MatchService matchService;
	
	// 유저 친구 조회하기
	@GetMapping("/list/{userId}")
	@ApiOperation("친구 목록 조회")
	public ResponseEntity<?> getAllFriends(@PathVariable(value = "userId") int userId) {
		// 내가 신청한 친구 목록들 조회
		List<Friend> MyReqlist = friendService.getFriendsByFrom(userId);
		// 내가 신청한 친구들 중 수락한 친구들(유저아이디) 조회
		List<Integer> FriendRel = new ArrayList<>();
		for (int i = 0; i < MyReqlist.size(); i++) {
			int friendId = MyReqlist.get(i).getFriendToUser();
			Friend friend = new Friend();
			friend.setFriendFromUser(friendId);
			friend.setFriendToUser(userId);
			// 서로 친구인지 확인
			boolean result = friendService.checkIsFriend(friend);
			// 친구라면 리스트에 추가하기
			if (result)
				FriendRel.add(friendId);
		}
		// 친구인 경우 리스트
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < FriendRel.size(); i++) {
			result.add(userService.getUserByUserId(FriendRel.get(i)));
		}
		// 리스트가 없는 경우
		if (result == null || result.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		// 있는 경우
		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}

	// 친구 요청하기
	@PostMapping("/request")
	@ApiOperation("친구 요청하기")
	public ResponseEntity<String> requestFriend(@RequestBody Friend friend) {
		boolean result = friendService.insertReq(friend);
		if (result)
			return new ResponseEntity<String>("success to request", HttpStatus.OK);
		return new ResponseEntity<String>("fail to request",HttpStatus.NOT_ACCEPTABLE);
	}

	// 받은 친구 요청 조회하기
	@GetMapping("/request/list/{userId}")
	@ApiOperation("받은 친구 요청 조회하기")
	public ResponseEntity<?> getRequestsByUserId(@PathVariable(value = "userId") int userId) {
		// 받은 요청 가져오기
		List<Friend> list = friendService.getRequestsByUserId(userId);
		if (list == null || list.size() == 0)
			return new ResponseEntity<String>("no exist request", HttpStatus.NO_CONTENT);
		// 받은 것들 중 유저 정보 찾아주기
		List<User> userList = new ArrayList<User>();
		for (int i = 0; i < list.size(); i++) {
			userList.add(userService.getUserByUserId(list.get(i).getFriendToUser()));
		}
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	// 친구 요청 수락하기
	@PutMapping("/request/accept")
	@ApiOperation("친구 요청 수락하기 from = 수락하는 사람 / to = 수락당하는 사람")
	public ResponseEntity<String> acceptRequest(@RequestBody Friend friend){
		boolean result = friendService.acceptRequest(friend);
		if(!result)
			return new ResponseEntity<String>("fail to accept", HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<String>("success to accept",HttpStatus.OK);
	}
	
	// 친구 요청 거절하기
	@DeleteMapping("/request/refuse")
	@ApiOperation("친구 요청 거절하기")
	public ResponseEntity<String> refuseRequest(@RequestBody Friend friend){
		boolean result = friendService.refuseRequest(friend);
		if(!result)
			return new ResponseEntity<String>("fail to refuse",HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<String>("success to refuse",HttpStatus.OK);
	}
	
	// 친구 매치 내역 조회
	@GetMapping("/match/{userId}")
	@ApiOperation("친구 매치 내역 조회")
	public ResponseEntity<?> getFriendMatch(@PathVariable(value = "userId")int userId){
		List<Match>list = matchService.getRemainingMatchsByUserId(userId);
		if(list ==null || list.size()==0)
			return new ResponseEntity<String>("no content", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Match>>(list,HttpStatus.OK);
	}
	
}
