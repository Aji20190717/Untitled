package org.ssp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssp.demo.entity.Bookmark;


public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {

}
