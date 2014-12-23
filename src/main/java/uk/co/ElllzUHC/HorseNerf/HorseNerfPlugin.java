package uk.co.ElllzUHC.HorseNerf;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.ElllzUHC.HorseNerf.ScenarioClasses.DisableHorseHealing;
import uk.co.ElllzUHC.HorseNerf.ScenarioClasses.DisableHorseMount;
import uk.co.ElllzUHC.Scenarios.Scenario;

/**
 * Created by Elliot on 23/12/2014.
 */
public class HorseNerfPlugin extends JavaPlugin {

    public void onEnable(){

        Scenario manager = (Scenario) Bukkit.getPluginManager().getPlugin("ScenarioManager");


        getServer().getPluginManager().registerEvents(new DisableHorseHealing(manager), this);
        getServer().getPluginManager().registerEvents(new DisableHorseMount(manager), this);

    }
}
