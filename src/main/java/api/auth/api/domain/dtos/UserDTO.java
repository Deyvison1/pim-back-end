package api.auth.api.domain.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String email;
	private String password;
	private String role;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
