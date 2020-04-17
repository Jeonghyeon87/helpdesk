package com.hebiz.helpdesk.repository;

import com.hebiz.helpdesk.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
