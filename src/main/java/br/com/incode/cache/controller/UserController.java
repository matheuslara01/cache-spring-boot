package br.com.incode.cache.controller;

import br.com.incode.cache.dto.UserDTO;
import br.com.incode.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PatchMapping
    UserDTO update(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/getCache")
    Cache getCache() {
        return userService.getCache();
    }

    @PostMapping("/clearCache")
    void clearCache() {
        userService.clearCache();
    }
}
