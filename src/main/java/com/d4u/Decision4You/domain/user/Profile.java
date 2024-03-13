package com.d4u.Decision4You.domain.user;

import lombok.Getter;

import static com.d4u.Decision4You.foundation.AssertUtil.hasMaxText;

@Getter
public class Profile {
    private String firstName;
    private String lastName;

    // private Media avatar;

    public Profile(String firstName, String lastName /*Media avatar*/) {
        this.firstName = hasMaxText(firstName, 255, "firstName");
        this.lastName = hasMaxText(lastName, 255, "lastName");
        // That means the user has to upload an avatar if not we can make it nullable.
        // this.avatar = isNotNull(avatar, "avatar");
    }
}
