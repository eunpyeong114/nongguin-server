package com.nongguin.controller;

import javax.servlet.http.HttpSession;

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

import com.nongguin.model.dto.User;
import com.nongguin.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(tags = "유저 컨트롤러")
public class UserController {

	@Autowired
	UserService userService;

	// 회원가입
	@PostMapping("/signup")
	@ApiOperation("회원가입")
	public ResponseEntity<String> signUp(@RequestBody User user) {
		Boolean result = userService.signUp(user);
		if (result)
			return new ResponseEntity<String>("true", HttpStatus.ACCEPTED);
		return new ResponseEntity<String>("false", HttpStatus.NOT_ACCEPTABLE);
	}

	// 로그인
	@PostMapping("/signin")
	@ApiOperation("로그인")
	public ResponseEntity<?> signIn(@RequestBody User user, HttpSession session) {
		User dbUser = userService.signIn(user);
		if (dbUser == null)
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		if (dbUser.getUserPass().equals(user.getUserPass())) {
			session.setAttribute("loginUser", dbUser);
			return new ResponseEntity<User>(dbUser, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}

	// 로그아웃
	@GetMapping("logout")
	@ApiOperation("로그아웃")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 회원탈퇴
	@DeleteMapping("/{userId}")
	@ApiOperation("회원탈퇴")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") String userId) {
		boolean result = userService.deleteUser(userId);
		if (!result)
			return new ResponseEntity<String>("false", HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<String>("true", HttpStatus.ACCEPTED);
	}

	// 회원정보조회
	@GetMapping("/{userId}")
	@ApiOperation("회원정보조회")
	public ResponseEntity<?> getUserByUserId(@PathVariable(value = "userId") String userId){
		User user = userService.getUserByUserId(userId);
		if(user==null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	// 회원정보수정
	@PutMapping("/{userId}")
	@ApiOperation("비밀번호, 주소, 전화번호만 수정 가능하다")
	public ResponseEntity<String>modifyUser(@RequestBody User user){
		boolean result = userService.modifyUser(user);
		if(!result)
			return new ResponseEntity<String>("false",HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity<String>("true",HttpStatus.OK);
	}
	
	// 비밀번호 재등록
}
