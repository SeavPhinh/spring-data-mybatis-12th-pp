package org.levi.demomybatispp.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    private Integer id;
    private String authorName;
    private String gender;
}
