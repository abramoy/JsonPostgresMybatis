package ie.developer.JsonPostgresMybatis.mappers;

import org.apache.ibatis.annotations.Mapper;

import ie.developer.JsonPostgresMybatis.model.Address;

@Mapper
public interface AddressMapper {
	
	
    Address getAddress(Long id);

}
