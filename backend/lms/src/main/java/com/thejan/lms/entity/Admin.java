package com.thejan.lms.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Admin extends User{
    public Admin(User user) {
        super(user);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
