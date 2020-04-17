package com.hebiz.helpdesk.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Client {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String clientName;

    @Column
    private String clientCompanyName;

    @Column
    private String clientPhoneNumber;

    @Builder
    public Client(String clientName, String clientCompanyName, String clientPhoneNumber) {
        this.clientName = clientName;
        this.clientCompanyName = clientCompanyName;
        this.clientPhoneNumber = clientPhoneNumber;
    }
}
