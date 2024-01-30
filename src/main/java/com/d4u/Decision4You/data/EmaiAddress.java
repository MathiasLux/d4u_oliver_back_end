package com.d4u.Decision4You.data;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public record EmaiAddress(@Email String valueForEmail) {
}
