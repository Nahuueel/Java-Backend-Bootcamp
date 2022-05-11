package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Punto {
    private int x,y;

    @Override
    public String toString() {
        return "Punto [x=" + x + ", y=" + y + "]";
    }
    
}
