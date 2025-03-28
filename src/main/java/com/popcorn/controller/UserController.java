package com.popcorn.controller;

import com.popcorn.document.UserDocument;
import com.popcorn.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.core.support.RepositoryMethodInvocationListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserRepository userRepository;
    private final RepositoryMethodInvocationListener repositoryMethodInvocationListener;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    /*public ResponseEntity<List<UserDocument>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userRepository.findAll());
    }*/

    public ResponseEntity<List<UserDocument>> getAllUsers(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
        log.info("UserController::getAllUsers page: {}, size: {}", page, size);
        Pageable pageRequest = PageRequest.of(page, size);
        Slice<UserDocument> slice = userRepository.findAll(pageRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(slice.toList());
    }
}
