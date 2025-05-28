package com.codehelp.CodeHelp.Controllers;

import com.codehelp.CodeHelp.Services.CommentService;
import com.codehelp.CodeHelp.dtos.CommentRequestDto;
import com.codehelp.CodeHelp.dtos.CommentResponseDto;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {
    private final CommentService commentSvc;
    public CommentController(CommentService c){this.commentSvc=c;}

    @PostMapping
    public CommentResponseDto add(
            @PathVariable Long postId,
            @RequestBody CommentRequestDto req,
            @AuthenticationPrincipal UserDetails user
    ){
        return commentSvc.addComment(postId, req, user.getUsername());
    }
}

