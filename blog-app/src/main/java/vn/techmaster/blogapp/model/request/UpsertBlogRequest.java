package vn.techmaster.blogapp.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertBlogRequest {
    @NotNull(message = "Tên bài viết không được để trống")
    private String title;
    @NotNull(message = "Mô tả bài viết không được để trống")
    @Min(10)
    private String description;
    @NotNull(message = "Nội dung bài viết không được để trống")
    @Min(10)
    private String content;
    private String thumbnail;
    private Boolean status;
    private List<Integer> categoryIds; // Danh sách id của các category áp dụng
}
