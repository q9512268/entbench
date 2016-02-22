package net.javacoding.jspider;


import net.javacoding.jspider.core.*;
import net.javacoding.jspider.core.impl.CLI;
import net.javacoding.jspider.core.util.config.ConfigurationFactory;

import java.net.URL;

import jrapl.EnergyCheckUtils;

modes {low <: mid; mid <: high; }

/**
 * Main startup class.
 *
 * $Id: JSpider.java,v 1.27 2003/04/10 16:19:03 vanrogu Exp $
 *
 * @author Günther Van Roey
 * @todo support commandline input for proxy password
 * @todo implement Swing-based monitor UI ( threading, progress, ...)
 */
public class JSpider {
    protected Spider spider;
    protected SpiderContext context;

    public JSpider ( URL baseURL ) throws Exception {
        SpiderNest nest = new SpiderNest();
        context = SpiderContextFactory.createContext(baseURL);
        spider = nest.breedSpider(context);
    }

    public void start ( ) throws Exception {
        spider.crawl(context);
    }

    public SpiderContext getContext() {
        return context;
    }

    public static void main(String[] args) throws Exception {
        CLI.printSignature();

        if (args.length != 1 && args.length != 2 ) {
            System.out.println("Usage: JSpider baseURL [config]");
            return;
        }

        if (args.length > 1) {
            ConfigurationFactory.getConfiguration(args[1]);
        } else {
            ConfigurationFactory.getConfiguration();
        }

        ENT_Util.initModeFile();
        double energyTotal = 0.0;

        int PANDA_RUNS = Integer.parseInt(System.getenv("PANDA_RUNS"));

        for (int i = 0; i < PANDA_RUNS; i++) {
          double[] before = EnergyCheckUtils.getEnergyStats();

          URL baseURL = new URL(args[0]);

          JSpider jspider = new JSpider ( baseURL );
          jspider.start ( );

          double[] after = EnergyCheckUtils.getEnergyStats();
          ENT_Util.writeModeFile(String.format("ERun %d: %f %f %f\n", i, after[0]-before[0], after[1]-before[1], after[2]-before[2]));
          energyTotal += after[2]-before[2];
        }

        ENT_Util.writeModeFile(String.format("Energy: %f %f %f\n", 0.0, 0.0, energyTotal));

        ENT_Util.closeModeFile();
        EnergyCheckUtils.DeallocProfile();
    }

}
