package com.hebiz.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

// refer : https://woowabros.github.io/tools/2017/07/10/java-enum-uses.html
@AllArgsConstructor
@Getter
public enum IssueChild {
    COVISINT("코비전트"),
    GM("지엠"),
    VPN("브이피엔"),
    TEAMCENTER("팀센터"),
    NX("엔엑스"),
    VISUALIZATION("비주얼라이제이션"),
    WINDOW("윈도우"),
    INTERNET("인터넷"),
    SECURITY("보안"),
    ETC("기타");

    private String value;
}
