package me.syus.diettracker.extend.security;

import me.syus.diettracker.Service.UserService;
import me.syus.diettracker.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.debug(s + " is trying to login from spring security");
        User domainUser = null;
        try {
            domainUser = userService.findByEmailOrUsername(s);
        } catch (Exception repositoryProblem) {
            logger.debug("catch AuthenticationServiceException from AuthenticationProvider");
        }
        return domainUser;
    }
}

