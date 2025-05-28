package com.codehelp.CodeHelp.Controllers;

import com.codehelp.CodeHelp.Services.TagService;
import com.codehelp.CodeHelp.dtos.TagResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    private final TagService tagSvc;
    public TagController(TagService t){this.tagSvc=t;}

    @GetMapping
    public List<TagResponseDto> tags() { return tagSvc.findAllTags(); }
}