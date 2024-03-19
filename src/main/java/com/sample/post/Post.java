package com.sample.post;

import java.time.LocalDateTime;

import com.sample.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "board_posts")
@SequenceGenerator(
		name = "post_pk_generator",
		sequenceName = "board_posts_seq",
		initialValue = 1000,
		allocationSize = 1
)
@Getter
@Setter
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_pk_generator")
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	/*
	 * @ManyToOne
	 * 	- N:1(다대일) 관계를 표현하는 어노테이션이다.
	 *  - @ManyToOne 어노테이션이 붙어있는 엔티티가 N이고, 반대 엔티티가 1이다.
	 *  - 즉, Post(게시글) 엔티티가 N이고, User 엔티티(사용자)가 1이다.
	 *  - 사용자는 게시글을 여러 개 작성할 수 있다.
	 *  - 가장 많이 사용되는 연관관계 표현 어노테이션이다.
	 *  - @JoinColumn(name = "N쪽 테이블의 외래키 컬럼명", 제약조건)을 지정해야 함
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false )
	private User
	user;
	
	@Column(nullable = false)
	private String content;
	
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
}
