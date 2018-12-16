package org.sid.mapper;

import javax.annotation.Generated;
import org.sid.dto.PostDto;
import org.sid.entities.Post;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-16T12:58:16+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post toPost(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        Post post = new Post();

        post.setIdPost( postDto.getIdPost() );
        post.setContenuPost( postDto.getContenuPost() );

        return post;
    }

    @Override
    public PostDto toPostDto(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDto postDto = new PostDto();

        postDto.setIdPost( post.getIdPost() );
        postDto.setContenuPost( post.getContenuPost() );

        return postDto;
    }
}
