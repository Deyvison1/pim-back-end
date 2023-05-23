package api.auth.api.service;

import java.util.List;

import api.auth.api.domain.dtos.UserDTO;
import api.auth.api.domain.entity.User;

public interface IUserService {
	UserDTO add(User user);
	
	List<UserDTO> findAll();
	
	UserDTO findById(Long id);
}
