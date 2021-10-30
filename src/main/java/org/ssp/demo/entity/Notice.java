package org.ssp.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@SequenceGenerator(
        name="gen_seq_notice", //시퀀스 제너레이터 이름
        sequenceName="seq_notice",//시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈(증가값?)
        )
@Entity
@Table(name = "notice")
public class Notice {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen_seq_notice")
    @Column(unique = true, nullable = false)
    private Long noNo;//글번호
    
//    @ManyToOne
//    @JoinColumn(name = "memNo")
//    @Column(nullable = false)
//    private Member memNo;//작성자번호_다대일(N:1)
    @Column(nullable = false)
	private Long memNo;//작성자번호
    
//    @ManyToOne
//    @JoinColumn(name = "memId")
//    @Column(nullable = false)
//    private Member memId;//작성자 아이디_다대일(N:1)
    @Column(nullable = false)
	private String memId;//회원 아이디
    
    @Column(nullable = false)
    private String noTitle;//공지제목
    
    @Column(nullable = false)
    private String noContent;//공지내용
    
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime noDate;//작성일

    //빌더
    @Builder
    public Notice(Long noNo, Long memNo, String memId, String noTitle, String noContent, LocalDateTime noDate) {
		this.noNo = noNo;
		this.memNo = memNo;
		this.memId = memId;
		this.noTitle = noTitle;
		this.noContent = noContent;
		this.noDate = noDate;
	}

//    public static Notice createNotice(Long noNo, Long memNo, String memId, String noTitle, String noContent, LocalDateTime noDate) {
//    	Notice n=new Notice();
//    	n.noNo = noNo;
//		n.memNo = memNo;
//		n.memId = memId;
//		n.noTitle = noTitle;
//		n.noContent = noContent;
//		n.noDate = noDate;
//		return n;    
//	}

	
}