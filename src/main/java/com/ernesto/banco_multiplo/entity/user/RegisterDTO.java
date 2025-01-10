package com.ernesto.banco_multiplo.entity.user;

import com.ernesto.banco_multiplo.entity.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
