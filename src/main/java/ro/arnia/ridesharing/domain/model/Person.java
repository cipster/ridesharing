package ro.arnia.ridesharing.domain.model;

//import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;

//@Document(collection="Persons")
public class Person extends BaseEntity implements UserDetails {

    @NotNull(message = "Name cannot be null")
    private String username;

    @NotNull(message = "Name cannot be null")
    private String firstName;

    @NotNull(message = "Name cannot be null")
    private String lastName;

    @NotNull(message = "Name cannot be null")
    @JsonIgnore
    private String password;

    @NotNull(message = "Name cannot be null")
    private String phone;

    @NotNull(message = "Name cannot be null")
    private String email;
    private Type role;

    public Type getRole() {
        return this.role;
    }

    public void setRole(Type role) {
        this.role = role;
    }

    public String getFirstName() {

        return this.firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    public String getPassword() {

        return this.password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getPhone() {

        return this.phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getEmail() {

        return this.email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    private enum Type {
        DRIVER,
        PASSENGER
    }
}