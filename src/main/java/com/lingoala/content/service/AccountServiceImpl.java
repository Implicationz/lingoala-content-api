package com.lingoala.content.service;


import com.lingoala.content.domain.Account;
import com.lingoala.content.dto.AccountDto;
import com.lingoala.content.dto.AccountRegistrationDto;
import com.lingoala.content.exception.ResourceNotFoundException;
import com.lingoala.content.mapper.AccountMapper;
import com.lingoala.content.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final UserService userService;
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountDto create(AccountDto accountDto) {
        var account = accountMapper.toEntity(accountDto);
        var savedAccount = accountRepository.save(account);
        log.info("Account created with id: {}", savedAccount.getId());
        return accountMapper.toDto(savedAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountDto readById(Long id) {
        var account = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        log.info("Account found with id: {}", id);
        return accountMapper.toDto(account);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountDto> readAll() {
        log.info("Reading all accounts");
        return accountRepository.findAll().stream()
                .map(accountMapper::toDto)
                .toList();
    }

    @Override
    public AccountDto update(Long id, AccountDto accountDto) {
        var existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        accountMapper.updateEntityFromDto(accountDto, existingAccount);
        accountRepository.flush();
        log.info("Account updated with id: {}", id);
        return accountMapper.toDto(existingAccount);
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
        log.info("Account deleted with id: {}", id);
    }

    @Override
    public AccountDto register(AccountRegistrationDto accountRegistration) {
        var userId = userService.getCurrentUserId();
        var registeredAccount = accountRepository
                .findByUserId(userId)
                .orElseGet(() -> {
                    var account = Account.builder()
                                .userId(userId)
                                .name(accountRegistration.getName())
                                .accessLevel(accountRegistration.getAccessLevel())
                                .build();
                    var savedAccount = accountRepository.save(account);
                    log.info("Account registered with id: {}", savedAccount.getId());
                    return savedAccount;
                });

        return this.accountMapper.toDto(registeredAccount);
    }

    @Override
    public Account readCurrent() {
        var userId = userService.getCurrentUserId();
        return accountRepository
                .findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for user id: " + userId));
    }
}