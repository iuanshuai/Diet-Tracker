package me.syus.diettracker.extend.security;

import me.syus.diettracker.Service.UserService;
import me.syus.diettracker.domain.Authority;
import me.syus.diettracker.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static Collection<GrantedAuthority> getAuthorities(List<Authority> authorities) {
        List<GrantedAuthority> authList = new ArrayList<>();
        for (Authority auth : authorities){
            String ROLE = auth.getAuthority().toUpperCase();
            authList.add(new SimpleGrantedAuthority(ROLE));
        }
        return authList;
    }

    public static List<String> getAuthoritiesAsString(Collection<? extends GrantedAuthority> authorities) {
        List<String> authList = new ArrayList<>();
        for (GrantedAuthority auth : authorities){
            authList.add(auth.getAuthority());
        }
        return authList;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.debug(s + " is trying to login from spring security");
        User domainUser = null;
        try {
            domainUser = userService.findByEmailOrUsername(s);
        } catch (Exception repositoryProblem) {
            logger.debug("catch AuthenticationServiceException from AuthenticationProvider",repositoryProblem);
            throw new UsernameNotFoundException("can't find user record from:"+s);
        }
        List<Authority> userAuthorities = userService.findAuthorities(domainUser);
//        Collection<GrantedAuthority> authorities = getAuthorities(userAuthorities);
        domainUser.setAuthorities(userAuthorities);


        return domainUser;
    }
}

