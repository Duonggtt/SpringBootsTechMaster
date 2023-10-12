package vn.techmaster.blogapp.model.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateUserRequest {
    private String name;
    private String email;
    private List<Integer> roleIds;
}
