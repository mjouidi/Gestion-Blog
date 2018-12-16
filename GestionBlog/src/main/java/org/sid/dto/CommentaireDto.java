package org.sid.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentaireDto implements Serializable{
	
	private Long idCommentaire;
	private String contenuCommentaire;
	private Long idPost;

}
