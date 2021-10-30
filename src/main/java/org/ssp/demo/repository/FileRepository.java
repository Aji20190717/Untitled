package org.ssp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssp.demo.entity.File;


public interface FileRepository extends JpaRepository<File,Long> {

}
