package api.auth.api.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import api.auth.api.domain.dtos.VendaDTO;
import api.auth.api.domain.entity.Venda;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IVendaMapper extends BaseEntityMapper<Venda, VendaDTO> {

}
