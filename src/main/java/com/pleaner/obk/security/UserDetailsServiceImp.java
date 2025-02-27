package com.pleaner.obk.security;

import com.pleaner.obk.user.dto.UserState;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

  private final JdbcClient db;

  private record FullUser(
      long id,
      String username,
      String passwordHash,
      UserState state,
      Instant createdAt) {}

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    String sql = "SELECT * FROM users WHERE username = :username";
    FullUser user = db.sql(sql).param("username", username)
        .query(FullUser.class)
        .optional().orElseThrow(() -> new UsernameNotFoundException(username));



  }
}
