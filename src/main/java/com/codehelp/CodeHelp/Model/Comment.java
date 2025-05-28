package com.codehelp.CodeHelp.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity @Getter @Setter @NoArgsConstructor
public class Comment {
    @Id @GeneratedValue private Long id;
    @Column(columnDefinition="TEXT") private String body;
    private Instant createdAt = Instant.now();

    @ManyToOne(fetch=FetchType.LAZY) private User author;
    @ManyToOne(fetch=FetchType.LAZY) private Post post;
}

