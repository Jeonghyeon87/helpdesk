package com.hebiz.helpdesk.domain.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// refer : https://woowabros.github.io/tools/2017/07/10/java-enum-uses.html
public enum IssueParent {
    ACCOUNT("계정", Arrays.asList(IssueChild.COVISINT, IssueChild.GM)),
    PROGRAM("프로그램", Arrays.asList(IssueChild.VPN, IssueChild.TEAMCENTER, IssueChild.NX)),
    OS("운영체제", Arrays.asList(IssueChild.WINDOW, IssueChild.INTERNET, IssueChild.SECURITY)),
    ETC("기타", Collections.EMPTY_LIST);

    private String value;
    private List<IssueChild> issueChildList;

    IssueParent(String value, List<IssueChild> issueChildList) {
        this.value = value;
        this.issueChildList = issueChildList;
    }

    public static IssueParent findByIssueChild(IssueChild issueChild) {
        return Arrays.stream(IssueParent.values())
                .filter(issue -> issue.hasIssueCode(issueChild))
                .findAny()
                .orElse(ETC);
    }

    public boolean hasIssueCode(IssueChild issueChild) {
        return issueChildList.stream().anyMatch(issue -> issue == issueChild);
    }

    public String getValue() {
        return value;
    }
}
