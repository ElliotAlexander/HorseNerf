package uk.co.ElllzUHC.HorseNerf.ScenarioClasses;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import uk.co.ElllzUHC.Scenarios.Scenario;
import uk.co.ElllzUHC.Scenarios.ScenarioInterface;

/**
 * Created by Elliot on 23/12/2014.
 */
public class DisableHorseHealing implements ScenarioInterface, Listener {

    private boolean state = false;

    public DisableHorseHealing(Scenario manager){

        manager.registerScenario(this);
    }


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
        return "DisableHorseHealing";
    }

    @Override
    public String getScenarioDescription() {
        return "Disables Horse healing completely.";
    }


    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event){
        if(state){
            if(event.getRightClicked() instanceof Horse){
                if(event.getPlayer().getItemInHand().getType().equals(Material.BREAD)){
                    Horse horse = (Horse)event.getRightClicked();

                    // Healing with bread heals 3.5 hearts. Nulling this.
                    // event.setCancelled seems to have no affect on the horses health. Creating clientside visual glitches.

                    horse.setHealth(horse.getHealth()-3.5);

                    event.getPlayer().sendMessage(ChatColor.RED + "You may not use bread to heal your horse!");
                }
            }
        }
    }
}
