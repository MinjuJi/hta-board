package com.sample.post;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;
	
	/**
	 * 전체 게시글을 조회해서 반환한다.
	 * @return 전체 게시글 목록
	 */
	public List<Post> getPosts(){
		return postRepository.findAll();
	}
	
	/**
	 * 지정된 게시글 아이디에 해당하는 게시글 정보를 반환한다.
	 * @param id 게시글 아이디
	 * @return 게시글 정보가 포함된 Post 객체, 게시글 정보가 존재하지 않으면 예외를 발생시킨다.
	 */
	public Post getPostDetail(Long id) {
		Optional<Post> optional = postRepository.findById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("게시글 정보가 존재하지 않습니다.");
		}
		
		return optional.get();
	}
}
