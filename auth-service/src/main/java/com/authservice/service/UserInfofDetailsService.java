package com.authservice.service;


import com.authservice.entity.UserInfo;
import com.authservice.dto.UserInfoDetails;
import com.authservice.repository.UserInfoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserInfofDetailsService implements UserDetailsService {


    private UserInfoRepository userInfoRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByUsername(username);
        return userInfo.map(UserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found."));
    }
}
