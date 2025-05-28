package com.codehelp.CodeHelp.ServiceImp;

import com.codehelp.CodeHelp.Repositories.TagRepository;
import com.codehelp.CodeHelp.Services.TagService;
import com.codehelp.CodeHelp.dtos.TagResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepo;
    public TagServiceImpl(TagRepository t) { this.tagRepo = t; }
    @Override
    public List<TagResponseDto> findAllTags() {
        return tagRepo.findAll().stream()
                .map(t -> new TagResponseDto(t.getName())).toList();
    }
}
