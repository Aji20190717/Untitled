package org.ssp.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@SequenceGenerator(
        name="gen_seq_file", //시퀀스 제너레이터 이름
        sequenceName="seq_file",//시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈(증가값?)
        )
@Entity
@Table(name = "file")
public class File {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen_seq_file")
    @Column(unique = true, nullable = false)
    private Long fileNo;//파일번호
    
    @Column(nullable = false)
    private String fileName;//파일이름
    
    @Column(nullable = false)
    private String filePath;//파일경로명
   
    @Column(nullable = true)
    @CreationTimestamp
    private LocalDateTime fileDate;//업로드날짜

    //빌더
    @Builder
    public File(Long fileNo, String fileName, String filePath, LocalDateTime fileDate) {
		this.fileNo = fileNo;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileDate = fileDate;
	}
    
    
//    public static File createFile(Long fileNo, String fileName, String filePath, LocalDateTime fileDate) {
//    	File f=new File();
//    	f.fileNo = fileNo;
//		f.fileName = fileName;
//		f.filePath = filePath;
//		f.fileDate = fileDate;
//		return f;    
//	}

	

	
}