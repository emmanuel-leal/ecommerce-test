package com.emmanuel.test.users.domain.converter;

import com.emmanuel.test.users.domain.dto.UsersDto;
import com.emmanuel.test.users.domain.model.Users;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersConverter {
    UsersConverter INSTANCE = Mappers.getMapper(UsersConverter.class);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    Users toUsersModel(UsersDto usersDto);
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    UsersDto toUsersDto(Users users);
    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    void updateProductDTO(UsersDto usersDto, @MappingTarget UsersDto users);
}
