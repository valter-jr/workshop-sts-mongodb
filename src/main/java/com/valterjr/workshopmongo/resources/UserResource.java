package com.valterjr.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valterjr.workshopmongo.domain.User;
import com.valterjr.workshopmongo.dto.UserDTO;
import com.valterjr.workshopmongo.services.UserService;

@RestController
@RequestMapping(value ="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> DTOlist = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(DTOlist);
	}
}
