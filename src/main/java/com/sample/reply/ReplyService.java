package com.sample.reply;

import org.springframework.stereotype.Service;

import com.sample.post.Post;
import com.sample.post.PostRepository;
import com.sample.user.User;
import com.sample.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {

	private final ReplyRepository replyRepository;
	private final ReplyVoterRepository replyVoterRepository;
	private final PostRepository postRepository;
	private final UserRepository userRepository;
	
	/**
	 * 댓글내용, 게시글번호, 사용자아이디를 전달받아서 새 댓글을 추가한다.
	 * @param content 댓글내용
	 * @param postId 게시글번호
	 * @param username 사용자아이디
	 */
	public Reply createReply(String content, Long postId, String username) {
		Post post = postRepository.findById(postId).orElseThrow();
		User user = userRepository.findByUsername(username).orElseThrow();
		
		Reply reply = new Reply();
		reply.setContent(content);
		reply.setPost(post);
		reply.setUser(user);
		
		return replyRepository.save(reply);
	}
	
	public Reply getReply(Long replyId) {
		return replyRepository.findById(replyId).orElseThrow();
	}
	
	public void deleteReply(Reply reply) {
		replyRepository.delete(reply);
	}
}
