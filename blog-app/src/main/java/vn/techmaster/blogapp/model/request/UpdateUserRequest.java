package vn.techmaster.blogapp.model.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateUserRequest {
    private String name;
    private String avatar;
    private List<Integer> roleIds;
}
