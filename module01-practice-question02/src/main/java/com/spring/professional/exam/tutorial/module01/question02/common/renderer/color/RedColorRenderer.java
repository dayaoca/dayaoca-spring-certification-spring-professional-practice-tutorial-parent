package com.spring.professional.exam.tutorial.module01.question02.common.renderer.color;


import com.spring.professional.exam.tutorial.module01.question02.common.renderer.Renderer;

public class RedColorRenderer implements FontColorRenderer {
    @Override
    public String render(String text) {
        return "<red-color>" + text + "</red-color>";
    }
}
