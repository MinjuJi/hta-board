package com.sample.reply;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.post.PostService;
import com.sample.user.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

	private final PostService postService;
	private final ReplyService replyService;
	private final UserService userService;
	
	/*
	 * @PathVariable("postId") Long postId : URL로 전달된 값 매개변수로 전달
	 * @RequestParam("content") String content : 폼으로 전달된 값 매개변수로 전달 
	 */
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{postId}")
	public String create(@PathVariable("postId") Long postId, @RequestParam("content") String content, Principal principal) {
		
		replyService.createReply(content, postId, principal.getName());
		
		return String.format("redirect:/post/detail?id=%d", postId);
	}
}
