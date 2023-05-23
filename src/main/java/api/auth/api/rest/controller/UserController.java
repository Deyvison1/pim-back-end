package api.auth.api.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import api.auth.api.domain.dtos.UserDTO;
import api.auth.api.domain.entity.User;
import api.auth.api.service.IUserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

	private IUserService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserDTO> add(@RequestBody User user) {
		 return ResponseEntity.ok(userService.add(user));
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok(userService.findAll()); 
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}
	
	
}
