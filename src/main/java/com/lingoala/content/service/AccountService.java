package com.lingoala.content.service;

import com.lingoala.content.domain.Account;
import com.lingoala.content.dto.AccountDto;
import com.lingoala.content.dto.AccountRegistrationDto;

public interface AccountService extends CrudService<AccountDto> {

    AccountDto register(AccountRegistrationDto accountRegistration);

    Account readCurrent();
}
