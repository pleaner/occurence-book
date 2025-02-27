package com.pleaner.obk.user;

import com.pleaner.obk.user.dto.UserCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepo {
  private final JdbcClient db;
  private final PasswordEncoder passwordEncoder;

  public int createUser(UserCreate user) {
    String sql = "INSERT INTO users (username, password_hash, active_profile) VALUES (?, ?, ?)";
    return db.sql(sql)
        .param(user.username())
        .param(user.passwordHash())
        .param(user.state().name())
        .param(user.activeProfile())
        .update();
  }
}
