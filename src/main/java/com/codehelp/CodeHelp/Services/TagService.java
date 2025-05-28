package com.codehelp.CodeHelp.Services;

import com.codehelp.CodeHelp.dtos.TagResponseDto;

import java.util.List;

public interface TagService {
    List<TagResponseDto> findAllTags();
}