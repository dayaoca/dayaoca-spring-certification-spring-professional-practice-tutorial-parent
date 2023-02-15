package com.spring.professional.exam.tutorial.module01.question02.after1;

import com.spring.professional.exam.tutorial.module01.question02.after.TextRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.color.RedColorRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.weight.BoldFontWeightRenderer;

public class Runner1 {

    public static void main(String[] args){
        TextRenderer1 textRenderer1 = new TextRenderer1
                .TextRendererBuilder().build();
        textRenderer1.render("default");
        TextRenderer1 redRenderer1 = new TextRenderer1
                .TextRendererBuilder()
                .withFontColorRenderer(new RedColorRenderer())
                .build();
        redRenderer1.render("red color");
        TextRenderer1 boldRenderer1 = new TextRenderer1
                .TextRendererBuilder()
                .withFontWeightRenderer(new BoldFontWeightRenderer())
                .build();
        boldRenderer1.render("bold render");


    }
}
