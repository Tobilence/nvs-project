package at.spengergasse.nvsproject.service;

import at.spengergasse.nvsproject.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The Service which is used by the Authentication Provider
 */
@AllArgsConstructor
public class UserPrincipal implements UserDetails {

    private User user;

    /**
     * Declares the available roles
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("admin"));
        authorities.add(new SimpleGrantedAuthority("user"));

        return authorities;
    }

    /**
     * @return The password of the currently logged in User
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * @return the username of the currently logged in User
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * @return Whether the currently logged in user account is expired or not
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return Whether the currently logged in user account is locked or not
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return Whether the credentials of the currently logged in user are expired or not
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return Whether the currently logged in user is enabled or not
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
