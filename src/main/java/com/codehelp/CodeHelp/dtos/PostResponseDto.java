package com.codehelp.CodeHelp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostResponseDto {
    private Long id;
    private String title, body, codeSnippet;
    private Instant createdAt;
    private String authorUsername;
    private Set<String> tags;
    private List<CommentResponseDto> comments;
}