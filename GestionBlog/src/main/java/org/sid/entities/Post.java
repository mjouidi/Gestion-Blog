package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "commentaires" })
public class Post implements Serializable {

	@Id
	@GeneratedValue
	private Long idPost;
	private String contenuPost;
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private Collection<Commentaire> commentaires;

	
}
