package post.spring_api_project.domain;

import lombok.Getter;

@Getter
public class MemoRequestDto {
    private String username;
    private String contents;
    private String title;
    private String password;
}
