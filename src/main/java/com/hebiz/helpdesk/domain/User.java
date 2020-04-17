package com.hebiz.helpdesk.domain;

import com.hebiz.helpdesk.domain.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String userId;

    @Column
    private String userPw;

    @Column
    private String userName;

    @Column
    private Role userRole;

    @Builder
    public User(String userId, String userPw, String userName, Role userRole) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userRole = userRole;
    }
}
