package me.syus.diettracker.extend.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    private String tokenHeader = "TokenAuthorization";
    private String bear = "Bearer ";

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        // 1. extract token
        String tokenHeader = httpServletRequest.getHeader(this.tokenHeader);
        if (tokenHeader != null && tokenHeader.startsWith(bear)) {
            String authToken = tokenHeader.substring(7);

            // 2. verify token

            String username = jwtTokenUtil.getUsernameFromToken(authToken);



            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // 3. verify token payload whether it is legit username in database

            UsernamePasswordAuthenticationToken fullyAuthenticated = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(fullyAuthenticated);

        }
        filterChain.doFilter(httpServletRequest, httpServletResponse); // filter go head


    }
}
