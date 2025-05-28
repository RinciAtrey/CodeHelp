package com.codehelp.CodeHelp.Services;

import com.codehelp.CodeHelp.dtos.PostRequestDto;
import com.codehelp.CodeHelp.dtos.PostResponseDto;

import java.util.List;

public interface PostService {
    PostResponseDto create(PostRequestDto req, String username);
    List<PostResponseDto> findAll();
    PostResponseDto findById(Long id);
}
