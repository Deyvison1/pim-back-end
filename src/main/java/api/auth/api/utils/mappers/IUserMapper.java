package api.auth.api.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import api.auth.api.domain.dtos.UserDTO;
import api.auth.api.domain.entity.User;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper extends BaseEntityMapper<User, UserDTO> {
		
}
