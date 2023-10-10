package br.com.incode.cache.service;

import br.com.incode.cache.dto.UserDTO;
import br.com.incode.cache.model.User;
import br.com.incode.cache.repository.UserRepository;
import jakarta.persistence.NoResultException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        User user = getCache().get(id, User.class);

        if (user != null) {
            log.info("in cache: {}", user);
            return new UserDTO(user);
        }

        user = userRepository.findById(id).orElseThrow(NoResultException::new);
        getCache().put(id, user);
        return new UserDTO(user);
    }
    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.saveAndFlush(User.builder().id(userDTO.id()).name(userDTO.name()).email(userDTO.email()).build());
        getCache().put(user.getId(), user);
        return new UserDTO(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
        getCache().evict(id);
    }

    public Cache getCache() {
        return cacheManager.getCache("users");
    }

    public void clearCache() {
        Objects.requireNonNull(cacheManager.getCache("users")).clear();
    }
}
