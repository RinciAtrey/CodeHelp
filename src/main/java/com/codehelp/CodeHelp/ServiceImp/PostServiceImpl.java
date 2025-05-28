package com.codehelp.CodeHelp.ServiceImp;

import com.codehelp.CodeHelp.Model.Post;
import com.codehelp.CodeHelp.Model.Tag;
import com.codehelp.CodeHelp.Repositories.CommentRepository;
import com.codehelp.CodeHelp.Repositories.PostRepository;
import com.codehelp.CodeHelp.Repositories.TagRepository;
import com.codehelp.CodeHelp.Repositories.UserRepository;
import com.codehelp.CodeHelp.Services.PostService;
import com.codehelp.CodeHelp.dtos.CommentResponseDto;
import com.codehelp.CodeHelp.dtos.PostRequestDto;
import com.codehelp.CodeHelp.dtos.PostResponseDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepo;
    private final TagRepository tagRepo;
    private final UserRepository userRepo;
    private final CommentRepository commentRepo;
    public PostServiceImpl(PostRepository p, TagRepository t, UserRepository u, CommentRepository c){
        this.postRepo=p; this.tagRepo=t; this.userRepo=u; this.commentRepo=c;
    }

    @Override
    public PostResponseDto create(PostRequestDto req, String username) {
        var user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        var post = new Post();
        post.setTitle(req.getTitle());
        post.setBody(req.getBody());
        post.setCodeSnippet(req.getCodeSnippet());
        post.setAuthor(user);

        var tags = Optional.ofNullable(req.getTags()).orElse(Set.of()).stream()
                .map(name -> tagRepo.findByName(name.toLowerCase())
                        .orElseGet(() -> tagRepo.save(new Tag(name))))
                .collect(Collectors.toSet());
        post.setTags(tags);

        post = postRepo.save(post);
        return map(post);
    }

    @Override
    public List<PostResponseDto> findAll() {
        return postRepo.findAll().stream().map(this::map).toList();
    }

    @Override
    public PostResponseDto findById(Long id) {
        var post = postRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return map(post);
    }

    private PostResponseDto map(Post p) {
        var comments = commentRepo.findByPostId(p.getId()).stream()
                .map(c -> new CommentResponseDto(c.getId(), c.getBody(), c.getCreatedAt(),
                        c.getAuthor().getUsername()))
                .toList();
        var tagNames = p.getTags().stream().map(Tag::getName).collect(Collectors.toSet());
        return new PostResponseDto(p.getId(), p.getTitle(), p.getBody(), p.getCodeSnippet(),
                p.getCreatedAt(), p.getAuthor().getUsername(),
                tagNames, comments);
    }
}