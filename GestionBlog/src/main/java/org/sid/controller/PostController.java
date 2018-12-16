package org.sid.controller;

import org.sid.dao.PostRepository;
import org.sid.dto.PostDto;
import org.sid.entities.Post;
import org.sid.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private PostMapper postMapper;

//Ajouter un Post
	@RequestMapping(value = "/createPost", method = RequestMethod.POST)
	public PostDto savePost(@RequestBody PostDto postDto) {

		Post post = postMapper.toPost(postDto);
		post = postRepository.save(post);
		return postMapper.toPostDto(post);
	}

//Modifier un Post
	@RequestMapping(value = "/updatePost", method = RequestMethod.PUT)
	public PostDto updatePost(@RequestBody PostDto postDto) throws Exception {
		Assert.notNull(postDto.getIdPost(), "the post id is mandatory");
		Post post = this.postRepository.findById(postDto.getIdPost())
				.orElseThrow(() -> new Exception("post id=" + postDto.getIdPost() + " not found"));
		return savePost(postDto);
	}

//Sprimer un Post
	@RequestMapping(value = "/deletePost/{idPost}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable Long idPost) {
		postRepository.deleteById(idPost);
	}
}
