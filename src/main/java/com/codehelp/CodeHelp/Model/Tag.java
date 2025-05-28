package com.codehelp.CodeHelp.Model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity @Getter @Setter @NoArgsConstructor
public class Tag {
    @Id @GeneratedValue private Long id;
    @Column(unique=true) private String name;
    @ManyToMany(mappedBy="tags") private Set<Post> posts = new HashSet<>();

    public Tag(String name) { this.name = name.toLowerCase(); }
}

