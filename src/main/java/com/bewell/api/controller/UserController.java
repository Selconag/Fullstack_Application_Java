package com.bewell.api.controller;

import com.bewell.api.entity.User;
import com.bewell.api.entity.enums.Role;
import com.bewell.api.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService _userService) {
        this.userService = _userService;
    }

    @GetMapping
    ResponseEntity<Page<User>> getUsers(@RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(userService.getAll(PageRequest.of(page, pageSize, Sort.by("id"))));
    }

    @GetMapping("/by-role")
    ResponseEntity<List<User>> getUsersByRole(@RequestParam Role role) {
        return ResponseEntity.ok(userService.getUsersByRole(role));
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }
}
