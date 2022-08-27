package halq.jukebox;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Jukebox extends JavaPlugin implements Listener {

    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onPlayer(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        Block block = event.getClickedBlock();
        if (p.isInsideVehicle()) {
            if (block.getType().equals(Material.JUKEBOX) && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (p.leaveVehicle()) {
                    if (0 + (int) (Math.random() * ((100 - 0) + 1)) <= getConfig().getInt("probability", 10)) {
                        p.getWorld().dropItemNaturally(p.getLocation().add(0, 1, 0), p.getInventory().getItemInMainHand());
                    }
                }
            }
        }
    }

}






