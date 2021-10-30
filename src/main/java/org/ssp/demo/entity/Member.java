package org.ssp.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@SequenceGenerator(
        name="gen_seq_member", //시퀀스 제너레이터 이름
        sequenceName="seq_member",//시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈(증가값?)
        )
@Entity
@Table(name = "member")//회원테이블
public class Member {
	// 필드
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen_seq_member")
	@Column(name = "member_no", unique = true, nullable = false)
	private Long memNo;//회원번호

	@Column(nullable = false)
	private String memId;//회원 아이디

	@Column(columnDefinition = "varchar(255) default 'HOME'", nullable = false) // 홈페이지 가입한 사람은 sns가 앖으니까
	private String snsToken;//사용자 인증 토큰

	@Column(nullable = false)
	private String memPw;//비번

	@Column(nullable = false)
	private String memName;//이름

	@Column(nullable = true)
	private String memBirth;//생년월일

	@Column(nullable = false)
	private String memEmail;//이메일

	@Column(nullable = true)
	private String memPhone;//전화번호

	@Column(nullable = false)
	private String snsType;//SNS종휴

	@Column(nullable = false)
	private String snsId;//SNS ID

//    @OneToMany(mappedBy = "member", cascade = CascadeType.MERGE, orphanRemoval = true)
//    private List<Board> board = new ArrayList<>();//member와 Board 일대 다 관계 설정

	// 빌더
	@Builder
	public Member(Long memNo, String memId, String snsToken, String memPw, String memName, String memBirth,
			String memEmail, String memPhone, String snsType, String snsId) {
		this.memNo = memNo;
		this.memId = memId;
		this.snsToken = snsToken;
		this.memPw = memPw;
		this.memName = memName;
		this.memBirth = memBirth;
		this.memEmail = memEmail;
		this.memPhone = memPhone;
		this.snsType = snsType;
		this.snsId = snsId;
	}

}