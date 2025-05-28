package com.codehelp.CodeHelp.ServiceImp;

import com.codehelp.CodeHelp.Model.Comment;
import com.codehelp.CodeHelp.Repositories.CommentRepository;
import com.codehelp.CodeHelp.Repositories.PostRepository;
import com.codehelp.CodeHelp.Repositories.UserRepository;
import com.codehelp.CodeHelp.Services.CommentService;
import com.codehelp.CodeHelp.dtos.CommentRequestDto;
import com.codehelp.CodeHelp.dtos.CommentResponseDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final PostRepository postRepo;
    private final UserRepository userRepo;
    private final CommentRepository commentRepo;
    public CommentServiceImpl(PostRepository p, UserRepository u, CommentRepository c){
        this.postRepo=p; this.userRepo=u; this.commentRepo=c;
    }

    @Override
    public CommentResponseDto addComment(Long postId, CommentRequestDto req, String username) {
        var post = postRepo.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        var user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        var c = new Comment();
        c.setBody(req.getBody());
        c.setPost(post);
        c.setAuthor(user);
        c = commentRepo.save(c);
        return new CommentResponseDto(c.getId(), c.getBody(), c.getCreatedAt(), user.getUsername());
    }
}