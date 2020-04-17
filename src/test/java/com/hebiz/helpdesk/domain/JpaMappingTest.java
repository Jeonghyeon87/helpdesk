package com.hebiz.helpdesk.domain;

import com.hebiz.helpdesk.domain.Client;
import com.hebiz.helpdesk.domain.User;
import com.hebiz.helpdesk.domain.enums.IssueChild;
import com.hebiz.helpdesk.domain.enums.IssueParent;
import com.hebiz.helpdesk.domain.enums.Role;
import com.hebiz.helpdesk.repository.BoardRepository;
import com.hebiz.helpdesk.repository.ClientRepository;
import com.hebiz.helpdesk.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

// import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JpaMappingTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BoardRepository boardRepository;

    //given
    private final String userId = "yzpbq2";
    private final String userPw = "Sunday1!";
    private final String userName = "변정현";
    private final Role userRole = Role.ADMIN;

    private final String clientCompanyName = "HUMANEBIZ";
    private final String clientName = "홍길동";
    private final String clientPhoneNumber = "010-0000-0000";

    private final LocalDateTime boardCreatedDate = LocalDateTime.now();
    private final LocalDateTime boardCompleteDate = LocalDateTime.now();
    private final String boardTitle = "IMPORT 방법 문의";
    private final String boardCause = "IMPORT 방법 문의";
    private final String boardSolution = "원격으로 가이드";
    private final IssueChild boardIssueChild = IssueChild.NX;
    private final IssueParent boardIssueParent = IssueParent.findByIssueChild(boardIssueChild);




    @BeforeEach
    public void init() {
        User user = userRepository.save(User.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .build()
        );

        Client client = clientRepository.save(Client.builder()
                .clientCompanyName(clientCompanyName)
                .clientName(clientName)
                .clientPhoneNumber(clientPhoneNumber)
                .build()
        );
        Board board = boardRepository.save(Board.builder()
                .boardUser(user)
                .boardClient(client)
                .boardCreatedDate(LocalDateTime.now())
                .boardCompleteDate(LocalDateTime.now())
                .boardTitle(boardTitle)
                .boardCause(boardCause)
                .boardSolution(boardSolution)
                .boardIssueChild(boardIssueChild)
                .boardIssueParent(boardIssueParent)
                .build()
        );

        //check
        System.out.println("###### USER CHECK ########");
        System.out.println("USER IDX: " + user.getIdx());
        System.out.println("USER ID: " + user.getUserId());
        System.out.println("USER PW: " + user.getUserPw());
        System.out.println("USER NAME: " + user.getUserName());
        System.out.println("USER ROLE: " + user.getUserRole());
        System.out.println("###### CLIENT CHECK ########");
        System.out.println("CLIENT IDX: " + client.getIdx());
        System.out.println("CLIENT COMPANY NAME: " + client.getClientCompanyName());
        System.out.println("CLIENT NAME: " + client.getClientName());
        System.out.println("CLIENT PHONE NUMBER: " + client.getClientPhoneNumber());
        System.out.println("###### BOARD CHECK ########");
        System.out.println("BOARD IDX: " + board.getIdx());
        System.out.println("BOARD CREATED DATE: " + board.getBoardCreatedDate());
        System.out.println("BOARD ISSUE PARENT: " + board.getBoardIssueParent());
        System.out.println("BOARD ISSUE CHILD: " + board.getBoardIssueChild());
        System.out.println("BOARD CLIENT COMPANY NAME: " + board.getBoardClient().getClientCompanyName());
        System.out.println("BOARD CLIENT NAME: " + board.getBoardClient().getClientName());
        System.out.println("BOARD CLIENT PHONE NUMBER: " + board.getBoardClient().getClientPhoneNumber());
        System.out.println("BOARD TITLE " + board.getBoardTitle());
        System.out.println("BOARD USER NAME: " + board.getBoardUser().getUserName());
        System.out.println("BOARD CAUSE: " + board.getBoardCause());
        System.out.println("BOARD SOLUTION: " + board.getBoardSolution());
        System.out.println("BOARD COMPLETE DATE: " + board.getBoardCompleteDate());



    }

    @AfterEach
    public void cleanup() {
        userRepository.deleteAll();
        clientRepository.deleteAll();
        boardRepository.deleteAll();
    }

    @Test
    public void UCB_생성_확인() {
        //when
        List<User> userList = userRepository.findAll();
        List<Client> clientList = clientRepository.findAll();
        List<Board> boardList = boardRepository.findAll();
        User user = userList.get(0);
        Client client = clientList.get(0);
        Board board = boardList.get(0);

        //then
        assertThat(user.getUserId()).isEqualTo(userId);
        assertThat(user.getUserPw()).isEqualTo(userPw);
        assertThat(user.getUserName()).isEqualTo(userName);
        assertThat(user.getUserRole()).isEqualTo(userRole);

        assertThat(client.getClientCompanyName()).isEqualTo(clientCompanyName);
        assertThat(client.getClientName()).isEqualTo(clientName);
        assertThat(client.getClientPhoneNumber()).isEqualTo(clientPhoneNumber);

        assertThat(board.getBoardTitle()).isEqualTo(boardTitle);
        assertThat(board.getBoardCause()).isEqualTo(boardCause);
        assertThat(board.getBoardSolution()).isEqualTo(boardSolution);
        assertThat(board.getBoardIssueParent()).isEqualTo(boardIssueParent);
        assertThat(board.getBoardIssueChild()).isEqualTo(boardIssueChild);




    }

}
