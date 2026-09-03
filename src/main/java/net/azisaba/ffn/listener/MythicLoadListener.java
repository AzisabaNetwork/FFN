package net.azisaba.ffn.listener;

import io.lumine.mythic.bukkit.events.MythicMechanicLoadEvent;
import io.lumine.mythic.core.skills.SkillExecutor;
import net.azisaba.ffn.FFN;
import net.azisaba.ffn.mechanic.Body;
import net.azisaba.ffn.mechanic.CustomDamage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MythicLoadListener implements Listener {

    private final FFN plugin;

    public MythicLoadListener(FFN plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMechanicLoad(MythicMechanicLoadEvent event) {
        String mechanicName = event.getMechanicName();
        SkillExecutor manager = event.getContainer().getManager();
        if (mechanicName.equalsIgnoreCase("CustomDamage")) {
            event.register(new CustomDamage(manager, event.getConfig()));
        } else if (mechanicName.equalsIgnoreCase("body")) {
            event.register(new Body(manager, event.getConfig()));
        }
    }
}
