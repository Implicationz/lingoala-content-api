package com.lingoala.content.mapper;


import com.lingoala.content.domain.Account;
import com.lingoala.content.dto.AccountDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AccountMapper {
    AccountDto toDto(Account account);
    Account toEntity(AccountDto accountDto);

    void updateEntityFromDto(AccountDto accountDto, @MappingTarget Account existingAccount);
}
