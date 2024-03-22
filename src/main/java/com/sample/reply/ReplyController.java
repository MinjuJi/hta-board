package com.sample.reply;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.post.PostService;
import com.sample.user.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

	private final PostService postService;
	private final ReplyService replyService;
	private final UserService service;
}
