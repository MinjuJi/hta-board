package com.sample.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Post> posts = postService.getPosts();
		model.addAttribute("posts", posts);
		
		return "post/list"; // "src/main/resources/templates/post/list.html"
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("id") Long id, Model model) {
		Post post = postService.getPostDetail(id);
		model.addAttribute("post", post);
		
		return "post/detail"; // "src/main/resources/templates/post/detail.html"
	}
}