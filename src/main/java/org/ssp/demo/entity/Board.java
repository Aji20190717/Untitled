package org.ssp.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

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
        name="gen_seq_board", //시퀀스 제너레이터 이름
        sequenceName="seq_board",//시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈(증가값?)
        )
@Entity
@Table(name = "board")//게시판
public class Board {
    //필드
    @Id//pk
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen_seq_board")
    @Column(name = "board_no", unique = true, nullable = false)
    private Long bno;//글번호
    
//    @ManyToOne
//    @JoinColumn(name = "memId")
//    @Column(nullable = false)
//    private Member memId;//작성자 아이디_다대일(N:1)
    @Column(nullable = false)
	private String memId;//회원 아이디
    
    @Column(nullable = false)
    private String title;//제목
   
    @Column(nullable = false)
    private String content;//내용
    
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime writeDate;//작성일
    
    @Column(nullable = false)
    private LocalDateTime reDate;//수정일
    
    @Column(nullable = false)
    private int viewcount;//조회수
    
    @Column(nullable = false)
    private int groupno;//그룹번호
    
    @Column(nullable = false)
    private int step;//그룹순서
    
    @Column(nullable = false)
    private String category;//카테고리

//    @ManyToOne
//    @JoinColumn(name = "fileNo")
//    @Column(nullable = false)
//    private File fileNo;//파일번호_다대일(N:1)
    @Column(nullable = false)
    private Long fileNo;//파일번호
    
    @Column(nullable = true)
    private String bpass;//게시글비번

    //빌더
    @Builder
    public Board(Long bno, String memId, String title, String content, LocalDateTime writeDate, LocalDateTime reDate,
			int viewcount, int groupno, int step, String category, Long fileNo, String bpass) {
		this.bno = bno;
		this.memId = memId;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.reDate = reDate;
		this.viewcount = viewcount;
		this.groupno = groupno;
		this.step = step;
		this.category = category;
		this.fileNo = fileNo;
		this.bpass = bpass;
	}
    
	
}