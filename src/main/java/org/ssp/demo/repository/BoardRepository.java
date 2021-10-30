package org.ssp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssp.demo.entity.Board;


public interface BoardRepository extends JpaRepository<Board,Long> {

}
