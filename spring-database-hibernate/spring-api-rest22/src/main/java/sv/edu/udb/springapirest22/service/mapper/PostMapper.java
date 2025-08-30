package sv.edu.udb.springapirest22.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.springapirest22.controller.request.PostRequest;
import sv.edu.udb.springapirest22.controller.response.PostResponse;
import sv.edu.udb.springapirest22.repository.domain.Post;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PostMapper {
    PostResponse toPostResponse(final Post data);
    List<PostResponse> toPostResponseList(final List<Post> postList);
    Post toPost(final PostRequest postRequest);
}