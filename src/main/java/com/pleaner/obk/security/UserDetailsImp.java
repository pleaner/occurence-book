package com.pleaner.obk.security;

import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
public record UserDetailsImp(
    String username,
    String passwordHash,
    long activeProfile,
    List<String> authorities
) implements UserDetails {

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (authorities == null) return List.of();
    return this.authorities.stream()
        .map(SimpleGrantedAuthority::new)
        .toList();
  }

  @Override
  public String getPassword() {
    return this.passwordHash;
  }

  @Override
  public String getUsername() {
    return this.username;
  }
}
