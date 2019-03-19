package com.microdemo.userservice.domain;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class User {
    private Long id;
    private String lastName;
    private String middleName;
    private String firstName;
}
