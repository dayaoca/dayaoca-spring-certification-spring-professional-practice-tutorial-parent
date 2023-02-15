package com.spring.professional.exam.tutorial.module01.question02.after1;

import com.spring.professional.exam.tutorial.module01.question02.after.TextRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.Renderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.color.DefaultColorRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.color.FontColorRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.style.DefaultFontStyleRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.style.FontStyleRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.weight.DefaultFontWeightRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.weight.FontWeightRenderer;
import org.w3c.dom.Text;

public class TextRenderer1 {
    private final FontStyleRenderer fs;
    private final FontColorRenderer fc;
    private final FontWeightRenderer fw;

    private TextRenderer1(FontStyleRenderer fs, FontColorRenderer fc, FontWeightRenderer fw){
        this.fs = fs;
        this.fc = fc;
        this.fw = fw;
    }

    void render(String text){
        String renderedText = applyRendering(text, fs, fc, fw);
        System.out.println(renderedText);
    }

    private String applyRendering(String text, Renderer... renderers){
        for(Renderer renderer : renderers){
            text = renderer.render(text);
        }
        return text;
    }

    static class TextRendererBuilder{
        private FontStyleRenderer fontStyleRenderer = new DefaultFontStyleRenderer();
        private FontColorRenderer fontColorRenderer = new DefaultColorRenderer();
        private FontWeightRenderer fontWeightRenderer = new DefaultFontWeightRenderer();

        public TextRendererBuilder withFontStyleRenderer(FontStyleRenderer fontStyleRenderer){
            this.fontStyleRenderer = fontStyleRenderer;
            return this;
        }

        public TextRendererBuilder withFontColorRenderer(FontColorRenderer fontColorRenderer){
            this.fontColorRenderer = fontColorRenderer;
            return this;
        }

        public TextRendererBuilder withFontWeightRenderer(FontWeightRenderer fontWeightRenderer){
            this.fontWeightRenderer = fontWeightRenderer;
            return this;
        }

        public TextRenderer1 build(){
            return new TextRenderer1(fontStyleRenderer, fontColorRenderer, fontWeightRenderer);
        }


    }



}
