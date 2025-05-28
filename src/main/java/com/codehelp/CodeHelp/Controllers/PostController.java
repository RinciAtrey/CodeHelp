package com.codehelp.CodeHelp.Controllers;

import com.codehelp.CodeHelp.Services.PostService;
import com.codehelp.CodeHelp.dtos.PostRequestDto;
import com.codehelp.CodeHelp.dtos.PostResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postSvc;
    public PostController(PostService p){this.postSvc=p;}

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(
            @RequestBody PostRequestDto req,
            @AuthenticationPrincipal UserDetails user
    ){
        return ResponseEntity.ok(postSvc.create(req, user.getUsername()));
    }

    @GetMapping
    public List<PostResponseDto> all() { return postSvc.findAll(); }

    @GetMapping("/{id}")
    public PostResponseDto get(@PathVariable Long id) { return postSvc.findById(id); }
}
