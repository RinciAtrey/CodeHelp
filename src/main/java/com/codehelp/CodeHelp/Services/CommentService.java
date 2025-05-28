package com.codehelp.CodeHelp.Services;

import com.codehelp.CodeHelp.dtos.CommentRequestDto;
import com.codehelp.CodeHelp.dtos.CommentResponseDto;

public interface CommentService {
    CommentResponseDto addComment(Long postId, CommentRequestDto req, String username);
}
