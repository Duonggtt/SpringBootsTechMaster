package vn.techmaster.course.request;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class    UpsertCourseRequest {
    @NotNull(message = " name ko dc de trong")
    @NotEmpty(message = " name ko dc de trong")
    private String name;

    @NotNull(message = " description ko dc de trong")
    @NotEmpty(message = " description ko dc de trong")
    @Size(min = 10)
    private String description;

    @NotNull(message = " type ko dc de trong")
    @NotEmpty(message = " type ko dc de trong")
    private String type;

    private List<String> topics;

    private String thumbnail;

    @NotNull(message = " userId ko dc de trong")
    private Integer userId;
}
