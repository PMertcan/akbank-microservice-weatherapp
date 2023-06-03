package com.akbank.userservice.modal;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPojo {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
}
