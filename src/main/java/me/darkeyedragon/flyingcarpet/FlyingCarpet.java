package me.darkeyedragon.flyingcarpet;

import co.aikar.commands.BukkitCommandManager;
import com.google.common.collect.ImmutableList;
import me.darkeyedragon.flyingcarpet.command.CarpetCommand;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;


public final class FlyingCarpet extends JavaPlugin {

    private BukkitCommandManager manager;
    private final List<Material> materialBlockList = new ArrayList<>();
    private final List<String> materialStringList = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Populate blocklist with all valid placable blocks
        for (Material material : Material.values()) {
            if(material.isBlock() && !material.hasGravity()){
                materialBlockList.add(material);
            }
        }

        manager = new BukkitCommandManager(this);
        manager.getCommandCompletions().registerCompletion("blocklist", context -> ImmutableList.copyOf(getMaterialListAsStringList()));
        manager.registerCommand(new CarpetCommand());
    }

private List<String> getMaterialListAsStringList(){
    //if(!materialStringList.isEmpty()) return materialStringList;
    materialBlockList.forEach((value)->{
        materialStringList.add(value.getData().getSimpleName());
        getLogger().info(value.getData().getSimpleName());
    });
    Object obj;
    return materialStringList;
}

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public BukkitCommandManager getManager() {
        return manager;
    }

    public List<Material> getMaterialBlockList() {
        return materialBlockList;
    }

    public List<String> getMaterialStringList() {
        return materialStringList;
    }
}
