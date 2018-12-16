package org.sid.mapper;

import javax.annotation.Generated;
import org.sid.dto.CommentaireDto;
import org.sid.entities.Commentaire;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-16T12:58:16+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class CommentaireMapperImpl implements CommentaireMapper {

    @Override
    public Commentaire toCommentaire(CommentaireDto commentaireDto) {
        if ( commentaireDto == null ) {
            return null;
        }

        Commentaire commentaire = new Commentaire();

        commentaire.setIdCommentaire( commentaireDto.getIdCommentaire() );
        commentaire.setContenuCommentaire( commentaireDto.getContenuCommentaire() );

        return commentaire;
    }

    @Override
    public CommentaireDto toCommentaireDto(Commentaire commentaire) {
        if ( commentaire == null ) {
            return null;
        }

        CommentaireDto commentaireDto = new CommentaireDto();

        commentaireDto.setIdCommentaire( commentaire.getIdCommentaire() );
        commentaireDto.setContenuCommentaire( commentaire.getContenuCommentaire() );

        return commentaireDto;
    }
}
