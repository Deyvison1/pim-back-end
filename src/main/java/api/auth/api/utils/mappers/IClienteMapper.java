package api.auth.api.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import api.auth.api.domain.dtos.ClienteDTO;
import api.auth.api.domain.entity.Cliente;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IClienteMapper extends BaseEntityMapper<Cliente, ClienteDTO> {

}
