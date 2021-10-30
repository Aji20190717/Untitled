package org.ssp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssp.demo.entity.CommBoard;


public interface CommBoardRepository extends JpaRepository<CommBoard,Long> {

}
