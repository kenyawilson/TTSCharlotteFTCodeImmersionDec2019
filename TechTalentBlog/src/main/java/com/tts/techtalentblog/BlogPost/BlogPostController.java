package com.tts.techtalentblog.BlogPost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BlogPostController {
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	private static List<BlogPost> posts = new ArrayList<> ();
	
	@GetMapping(value="/")
	public String index(BlogPost blogPost, Model model) {
		model.addAttribute("posts", posts);
		return "blogpost/index";
	}
	
	@GetMapping(value = "/blog_posts/new")
	public String newBlog (BlogPost blogPost) {
		return "blogpost/new";
}

	private BlogPost blogPost;
	@PostMapping(value="/blog_posts/new")
	public String create(BlogPost blogPost, Model model) {
		blogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlogEntry()));
		posts.add(blogPost);
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogEntry", blogPost.getBlogEntry());
		return "blogpost/result";
	}
	
	// GET edit blog post page
	@GetMapping(value = "/blog_posts/edit/{id}")
	public String postEditForm(Model model, @PathVariable Long id) {
		model.addAttribute("blog", blogPostRepository.findById(id));
			return "blogPost/edit";
	}
	//POST edit and update blog post by id
	 @PostMapping(value = "/blog_posts/edit")
	   public String postEdit(Model model, BlogPost blogPost) {
		   return "redirect:/";

	 }
	 
	 //DELETE blog post with id
	 @GetMapping(value = " /blog)posts/{id}")
	 public String deletePostWithId(@PathVariable Long id) {
		 blogPostRepository.deleteById(id);
		 return "blogpost/index";
				 
	 }
}
	
	