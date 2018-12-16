package org.sid.mapper;

import org.mapstruct.Mapper;
import org.sid.dto.CommentaireDto;
import org.sid.entities.Commentaire;

@Mapper(componentModel = "spring")
public interface CommentaireMapper {
	
	Commentaire toCommentaire(CommentaireDto commentaireDto);
	CommentaireDto toCommentaireDto(Commentaire commentaire);

}
