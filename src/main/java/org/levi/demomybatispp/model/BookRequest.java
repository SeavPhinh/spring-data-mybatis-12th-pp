package org.levi.demomybatispp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String title;
    private LocalDateTime publishedDate;
    private Integer authorId;
    private List<Integer> categoryId;
}
