package com.example.rancolorspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    private int type;

    public Color(int r, int g, int b) {
    }
}
