package com.juankysoriano.materiallife.world.life;

import com.openca.Automata;
import com.openca.bi.discrete.AutomataDiscrete2D;

public class GameOfLifeCreator@mode<?->X> {

    attributor {
      int nCells = 0;
      for (int i = 0; i < automata.getWidth(); i++) {
        for (int j = 0; j < automata.getHeight(); j++) {
          if (automata.getCells()[i][j] > 0) {
            nCells++;
          }
        }
      } 

      if (nCells < 2000) {
        System.err.format("ENT: data saver\n");
        return @mode<saver>;
      } else if (nCells < 4000) {
        System.err.format("ENT: data managed\n");
        return @mode<managed>;
      } else {
        System.err.format("ENT: data full\n");
        return @mode<full>;
      }
    } 

    private mcase<int> HACK = mcase<int> {
      saver:0;
      managed:0;
      full:0;
    };

    private static final String GAME_OF_LIFE_RULE = "8-24";
    private static final int GAME_OF_LIFE_RADIUS = 1;
    private static final int GAME_OF_LIFE_STATES = 2;

    private String rule = "";

    private Automata.Builder builder;
    private AutomataDiscrete2D automata;

    protected GameOfLifeCreator(Automata.Builder builder, int width, int height) {
        this.builder = builder;
        int choice = ((Integer) ENT_Properties.getProperty("LIFE_RULE_CHOICE"));
        if (choice == 0) {
          this.rule = "8-28";
        } else if (choice == 1) {
          this.rule = "8-24";
        } else {
          this.rule = "8-20";
        }

        this.automata = this.createGameOfLife(width, height);
        for (int i = 0; i < 10; i++) {
          this.automata.evolve();
        }
    }

    public static @mode<Y> GameOfLifeCreator@mode<Y> newInstance(int width, int height) {
        return new GameOfLifeCreator@mode<Y>(new Automata.Builder(),width, height);
    }

    public AutomataDiscrete2D getAutomata() {
      return this.automata;
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
