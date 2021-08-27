package br.com.bicmsystems.bicmoauth.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<RoleModel> roles = new HashSet();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return email.equals(userModel.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
