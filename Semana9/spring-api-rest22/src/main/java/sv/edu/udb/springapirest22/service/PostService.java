package sv.edu.udb.springapirest22.service;

import sv.edu.udb.springapirest22.controller.request.PostRequest;
import sv.edu.udb.springapirest22.controller.response.PostResponse;

import java.util.List;
public interface PostService {
    List<PostResponse> findAll();
    PostResponse findById(final Long id);
    PostResponse save(final PostRequest postRequest);
    PostResponse update(final Long id, final PostRequest postRequest);
    void delete(final Long id);
}