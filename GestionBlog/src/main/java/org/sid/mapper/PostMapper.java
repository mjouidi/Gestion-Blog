package org.sid.mapper;

import org.mapstruct.Mapper;
import org.sid.dto.PostDto;
import org.sid.entities.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {
	Post toPost(PostDto postDto);
	PostDto toPostDto(Post post);

}
