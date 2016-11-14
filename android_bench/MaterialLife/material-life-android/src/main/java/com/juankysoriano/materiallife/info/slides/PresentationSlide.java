package com.juankysoriano.materiallife.info.slides;

import com.juankysoriano.materiallife.R;
import com.juankysoriano.materiallife.world.World;

public class PresentationSlide extends SlideFragmentWithWorld {

    @Override
    protected World@mode<full> instantiateWorld() {
        return World.@mode<full>newInstance();
    }

    @Override
    protected int getSlideLayoutId() {
        return R.layout.intro_presentation;
    }

    @Override
    protected int getWorldViewId() {
        return R.id.life_presentation_world;
    }
}
