package com.sample.post;

import java.util.List;

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
}
