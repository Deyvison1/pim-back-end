package api.auth.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import api.auth.api.domain.dtos.UserDTO;
import api.auth.api.domain.entity.User;
import api.auth.api.domain.repository.IUserRepository;
import api.auth.api.exception.NotFoundException;
import api.auth.api.service.IUserService;
import api.auth.api.utils.mappers.IUserMapper;


@Service
public class UserServiceImpl implements IUserService {

	private IUserRepository userRepo;
	private IUserMapper userMapper;
	private PasswordEncoder encoder;

	public UserServiceImpl(IUserRepository userRepo, IUserMapper userMapper, PasswordEncoder encoder) {
		this.userRepo = userRepo;
		this.userMapper = userMapper;
		this.encoder = encoder;
	}

	@Override
	public UserDTO add(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userMapper.toDto(userRepo.save(user));
	}

	@Override
	public List<UserDTO> findAll() {
		return userMapper.toDto(userRepo.findAll());
	}

	@Override
	public UserDTO findById(Long id) {
		Optional<User> user = userRepo.findById(id);
		return userMapper.toDto(user.orElseThrow(() -> new NotFoundException()));
	}
}
