package org.ssp.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@SequenceGenerator(
        name="gen_seq_bookmark", //시퀀스 제너레이터 이름
        sequenceName="seq_bookmark",//시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈(증가값?)
        )
@Entity
@Table(name = "bookmark")
public class Bookmark {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen_seq_bookmark")
    @Column(unique = true, nullable = false)
    private Long bkNo;//즐겨찾기 번호
    
//    @ManyToOne
//    @JoinColumn(name = "bno")
//    @Column(nullable = false)
//    private Board bno;//게시글 번호_다대일(N:1)
    @Column(nullable = false)
    private Long bno;//글번호
    
//    @ManyToOne
//    @JoinColumn(name = "memNo")
//    @Column(nullable = false)
//    private Member memNo;//작성자번호_다대일(N:1)
    @Column(nullable = false)
	private Long memNo;//작성자번호
    
//    @ManyToOne
//    @JoinColumn(name = "category")
//    @Column(nullable = false)
//    private Board category;//카테고리_다대일(N:1)
    @Column(nullable = false)
    private String category;//카테고리
    
    //빌더
    @Builder
    public Bookmark(Long bkNo, Long bno, Long memNo, String category) {
		this.bkNo = bkNo;
		this.bno = bno;
		this.memNo = memNo;
		this.category = category;
	}
    
//    public static Bookmark createBookmark(Long bkNo, Long bno, Long memNo, String category) {
//    	Bookmark b=new Bookmark();
//    	b.bkNo = bkNo;
//		b.bno = bno;
//		b.memNo = memNo;
//		b.category = category;
//		return b;    
//	}

	
}
