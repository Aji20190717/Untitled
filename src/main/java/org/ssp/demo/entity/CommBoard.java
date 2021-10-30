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
        name="gen_seq_commBoard", //시퀀스 제너레이터 이름
        sequenceName="seq_commBoard",//시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈(증가값?)
        )
@Entity
@Table(name = "commBoard")
public class CommBoard {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen_seq_commBoard")
    @Column(unique = true, nullable = false)
    private Long cmNo;//글번호
    
//    @ManyToOne
//    @JoinColumn(name = "memId")
//    @Column(nullable = false)
//    private Member memId;//작성자 아이디_다대일(N:1)
    @Column(nullable = false)
	private String memId;//회원 아이디
    
    @Column(nullable = false)
    private String cmTitle;//제목
    
    @Column(nullable = false)
    private String cmContent;//내용
    
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime cmDate;//작성일
    
    @Column(nullable = false)
    private int groupno;//그룹번호
    
    @Column(nullable = false)
    private int step;//그룹순서

    //빌더
    @Builder
    public CommBoard(Long cmNo, String memId, String cmTitle, String cmContent, LocalDateTime cmDate, int groupno,
			int step) {
		this.cmNo = cmNo;
		this.memId = memId;
		this.cmTitle = cmTitle;
		this.cmContent = cmContent;
		this.cmDate = cmDate;
		this.groupno = groupno;
		this.step = step;
	}
    
}
