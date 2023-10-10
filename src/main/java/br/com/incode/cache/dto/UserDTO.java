package br.com.incode.cache.dto;

import br.com.incode.cache.model.User;

public record UserDTO (Long id, String name, String email){
    public UserDTO(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}
