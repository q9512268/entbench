package com.juankysoriano.materiallife.world.life;

import com.openca.Automata;
import com.openca.bi.discrete.AutomataDiscrete2D;

public class GameOfLifeCreator@mode<?->X> {
    attributor {
      return @mode<full>;
    }


    private static final String GAME_OF_LIFE_RULE = "8-24";
    private static final int GAME_OF_LIFE_RADIUS = 1;
    private static final int GAME_OF_LIFE_STATES = 2;

    private String rule = "";

    private Automata.Builder builder;

    protected GameOfLifeCreator(Automata.Builder builder) {
        this.builder = builder;
        int choice = ((Integer) ENT_Properties.getProperty("LIFE_RULE_CHOICE"));
        if (choice == 0) {
          this.rule = "8-28";
        } else if (choice == 1) {
          this.rule = "8-24";
        } else {
          this.rule = "8-20";
        }


        String choicer = ((String) ENT_Properties.getProperty("LIFE_RULE"));
        this.rule = choicer;
    }

    public static @mode<Y> GameOfLifeCreator@mode<Y> newInstance() {
        return new GameOfLifeCreator@mode<Y>(new Automata.Builder());
    }

    public AutomataDiscrete2D createGameOfLife(int width, int height) {
        /*
        AutomataDiscrete2D automata = builder.width(width)
                .height(height)
                .radius(GAME_OF_LIFE_RADIUS)
                .states(GAME_OF_LIFE_STATES)
                .rule(GAME_OF_LIFE_RULE)
                .type(Automata.Type.OUTER_TOTALISTIC)
                .domain(Automata.Domain.DISCRETE)
                .dimension(Automata.Dimension.BIDIMENSIONAL)
                .build();
                */

        AutomataDiscrete2D automata = builder.width(width)
                .height(height)
                .radius(GAME_OF_LIFE_RADIUS)
                .states(GAME_OF_LIFE_STATES)
                .rule(this.rule)
                .type(Automata.Type.OUTER_TOTALISTIC)
                .domain(Automata.Domain.DISCRETE)
                .dimension(Automata.Dimension.BIDIMENSIONAL)
                .build();


        automata.randomiseConfiguration();
        return automata;
    }
}
