package org.ssp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssp.demo.entity.Member;


public interface MemberRepository extends JpaRepository<Member,Long> {

}
