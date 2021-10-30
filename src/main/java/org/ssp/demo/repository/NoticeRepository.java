package org.ssp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssp.demo.entity.Notice;


public interface NoticeRepository extends JpaRepository<Notice,Long> {

}
