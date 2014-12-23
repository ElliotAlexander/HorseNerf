package uk.co.ElllzUHC.HorseNerf.ScenarioClasses;

import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import uk.co.ElllzUHC.Scenarios.Scenario;
import uk.co.ElllzUHC.Scenarios.ScenarioInterface;

/**
 * Created by Elliot on 23/12/2014.
 */
public class DisableHorseMount implements ScenarioInterface, Listener {

    public DisableHorseMount(Scenario manager){
        manager.registerScenario(this);
    }

    private boolean state = false;

    @Override
    public void setScenarioState(Boolean aBoolean) {
        state = aBoolean;
    }

    @Override
    public boolean getScenarioState() {
        return state;
    }

    @Override
    public String getScenarioName() {
        return "DisableHorseMount";
    }

    @Override
    public String getScenarioDescription() {
        return "Disables the mounting of horses for all players.";
    }

    @EventHandler
    public void onHorseMount(VehicleEnterEvent e){
        if(e.getVehicle() instanceof Horse && state){
            e.setCancelled(true);
        }
    }
}
