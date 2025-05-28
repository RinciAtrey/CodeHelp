package com.codehelp.CodeHelp.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.*;

@Entity @Getter @Setter @NoArgsConstructor
public class Post {
    @Id @GeneratedValue private Long id;
    private String title;
    @Column(columnDefinition="TEXT") private String body;
    @Column(columnDefinition="TEXT") private String codeSnippet;
    private Instant createdAt = Instant.now();

    @ManyToOne(fetch=FetchType.LAZY) private User author;

    @OneToMany(mappedBy="post", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="post_tags",
            joinColumns=@JoinColumn(name="post_id"),
            inverseJoinColumns=@JoinColumn(name="tag_id"))
    private Set<Tag> tags = new HashSet<>();
}
