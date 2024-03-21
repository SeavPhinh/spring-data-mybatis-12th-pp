package org.levi.demomybatispp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorRequest {
    private String authorName;
    private String gender;
}
