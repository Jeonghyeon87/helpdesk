package com.hebiz.helpdesk.domain;

import com.hebiz.helpdesk.domain.enums.IssueChild;
import com.hebiz.helpdesk.domain.enums.IssueParent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Board {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne(fetch = FetchType.LAZY)
    private User boardUser;

    @OneToOne(fetch = FetchType.LAZY)
    private Client boardClient;

    @Column
    @Enumerated(EnumType.STRING)
    private IssueChild boardIssueChild;

    @Column
    @Enumerated(EnumType.STRING)
    private IssueParent boardIssueParent;

    @Column
    private LocalDateTime boardCreatedDate;

    @Column
    private LocalDateTime boardCompleteDate;

    @Column
    private String boardTitle;

    @Column
    private String boardCause;

    @Column
    private String boardSolution;


    @Builder
    public Board(
            User boardUser, Client boardClient,
            IssueChild boardIssueChild, IssueParent boardIssueParent,
            LocalDateTime boardCreatedDate, LocalDateTime boardCompleteDate,
            String boardTitle, String boardCause, String boardSolution
    ) {
        this.boardUser = boardUser;
        this.boardClient = boardClient;
        this.boardIssueChild = boardIssueChild;
        this.boardIssueParent = boardIssueParent;
        this.boardCreatedDate = boardCreatedDate;
        this.boardCompleteDate = boardCompleteDate;
        this.boardTitle = boardTitle;
        this.boardCause = boardCause;
        this.boardSolution = boardSolution;
    }



}
