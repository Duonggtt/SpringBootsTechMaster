package com.example.libexpress.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateStatusRequest {
    private boolean status;
}
