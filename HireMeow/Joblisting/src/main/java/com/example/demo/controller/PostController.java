package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.SearchRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController
public class PostController {
	
	@Autowired
    PostRepository repo;
	  @Autowired
	  SearchRepository srepo;
	@ApiIgnore
	// This maps the root URL ("/") of the application
	@RequestMapping(value="/swagger")
	public void redirect(HttpServletResponse response) throws IOException {
	    
	    // When someone visits the root URL, redirect them to the Swagger UI page
	    response.sendRedirect("/swagger-ui.html");
	}
	 @GetMapping("/allposts")
	 @CrossOrigin
	public List<Post> getAllPosts()
	    {
	        return repo.findAll();
	    }
	 @GetMapping("/posts/{text}")
	    @CrossOrigin
	    public List<Post> search(@PathVariable String text)
	    {
		  return srepo.findByText(text);
	    }
	 
	 @PostMapping("/post")
	    @CrossOrigin
	    public Post addPost(@RequestBody Post post)
	    {
	        return repo.save(post);
	    }


}
