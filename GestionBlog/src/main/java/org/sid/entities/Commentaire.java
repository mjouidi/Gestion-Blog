package org.sid.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "post" })
public class Commentaire implements Serializable {
	@Id
	@GeneratedValue
	private Long idCommentaire;
	private String contenuCommentaire;
	@ManyToOne
	@JoinColumn(name = "id_POST")
	private Post post;

	
}