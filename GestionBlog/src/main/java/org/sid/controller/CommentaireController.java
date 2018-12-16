package org.sid.controller;

import org.sid.dao.CommentaireRepository;
import org.sid.dao.PostRepository;
import org.sid.dto.CommentaireDto;
import org.sid.entities.Commentaire;
import org.sid.entities.Post;
import org.sid.mapper.CommentaireMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentaireController {
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentaireMapper commentaireMapper;
	
	// Ajouter un commentaire à une post
		@RequestMapping(value = "/createCommentaire", method = RequestMethod.POST)
		public CommentaireDto saveCommentaire(@RequestBody CommentaireDto commentaireDto) throws Exception {
			Assert.notNull(commentaireDto.getIdPost(), "post idPost is mandatory");
			Post post = this.postRepository.findById(commentaireDto.getIdPost())
					.orElseThrow(() -> new Exception("post idPost=" + commentaireDto.getIdPost() + " not found"));
			Commentaire commentaire = commentaireMapper.toCommentaire(commentaireDto);
			commentaire.setPost(post);
			commentaire = commentaireRepository.save(commentaire);
			return commentaireMapper.toCommentaireDto(commentaire);
		}
		
		//Modifier un commentaire
		@RequestMapping(value = "/updateCommentaire", method = RequestMethod.PUT)
		public CommentaireDto updateCommentaire(@RequestBody CommentaireDto commentaireDto) throws Exception {
			Assert.notNull(commentaireDto.getIdCommentaire(), "the commentaire idCommentaire is mandatory");
			return saveCommentaire(commentaireDto);
		}
		
		//Supprimer un commentaire
		@RequestMapping(value = "/deleteCommentaire/{idCommentaire}", method = RequestMethod.DELETE)
		public void deleteCommentaire(@PathVariable Long idCommentaire) {
			commentaireRepository.deleteById(idCommentaire);
		}

}
