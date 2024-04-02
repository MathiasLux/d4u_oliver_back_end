package com.d4u.Decision4You.presentation.views;

import com.d4u.Decision4You.domain.user.User;
import com.d4u.Decision4You.fixtures.UserFixture;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UserViewMapperTest {

    UserViewMapper mapper = UserViewMapper.INSTANCE;

    @Test
    public void toUserView_shouldMapUserToUserView() {

        // Given
        User user = UserFixture.createUser();

        // When
        Views.UserView userView = mapper.toUserView(user);

        // Then
        assertThat(userView, notNullValue());
        assertThat(userView.id(), equalTo(user.getId()));
    }
}
