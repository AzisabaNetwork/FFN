package net.azisaba.ffn;

import net.azisaba.ffn.listener.BlockBreakListener;
import net.azisaba.ffn.listener.MythicLoadListener;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class FFN extends JavaPlugin {

    public static final Map<LivingEntity, Map<String, Double>> weaknessTags = Collections.synchronizedMap(new WeakHashMap<>());
    public static final Map<LivingEntity, Map<String, Double>> resistanceTags = Collections.synchronizedMap(new WeakHashMap<>());

    @Deprecated
    public static final Map<LivingEntity, Map<String, Double>> damageTag = weaknessTags;
    @Deprecated
    public static final Map<LivingEntity, Map<String, Double>> protectTag = resistanceTags;

    private static FFN instance;

    public static FFN getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new MythicLoadListener(this), this);
        this.getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);

        this.getLogger().info("FFN has been enabled.");
    }

    @Override
    public void onDisable() {
        weaknessTags.clear();
        resistanceTags.clear();
        this.getLogger().info("FFN has been disabled.");
    }
}
