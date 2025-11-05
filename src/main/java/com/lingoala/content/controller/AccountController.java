package com.lingoala.content.controller;

import com.lingoala.content.dto.AccountDto;
import com.lingoala.content.dto.AccountRegistrationDto;
import com.lingoala.content.service.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@Tag(name = "Account API")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> create(@RequestBody @Valid AccountDto account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.create(account));
    }

    @PostMapping("/registration")
    public ResponseEntity<AccountDto> register(@RequestBody @Valid AccountRegistrationDto account) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.register(account));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> readAll() {
        return ResponseEntity.ok(accountService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> update(@PathVariable Long id, @RequestBody @Valid AccountDto account) {
        return ResponseEntity.ok(accountService.update(id, account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}