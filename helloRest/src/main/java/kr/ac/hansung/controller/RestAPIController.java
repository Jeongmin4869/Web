package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import kr.ac.hansung.model.User;
import kr.ac.hansung.service.UserService;

@RestController // @Controller + @ResponseBody
@RequestMapping("/api")
public class RestAPIController {
	
	@Autowired
	UserService userService;
	
	// --- Retrieve All Users 모든 사용자 조회
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){ // header, body(json), HTTP.status
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK); // body에 users.
		
	}

	
	
	// --- Retrieve Single User 한 사용자 조회 // template valuable
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") long id){ 
		User user = userService.FindById(id);
		if(user == null) {
			//do to list : exception (예외처리)
			
		}
		return new ResponseEntity<User>(user, HttpStatus.OK); // body에 users.	
	}
	
	// --- Create a User 
		@RequestMapping(value="/users", method=RequestMethod.POST) // request body(json)
		public ResponseEntity<Void> createUser(@RequestBody User user, // body부분은 없음을 Void로 표시
									UriComponentsBuilder ucBuilder){ // 새롭게 생성된 사용자의 uri를 header정보에 담아서 넘겨주기 위함
			
			if(userService.isUserExist(user)) {
				// to do list : exception
			}
			userService.saveUser(user);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/api/users/{id}")
									.buildAndExpand(user.getId()).toUri());
			
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
	
	
}
