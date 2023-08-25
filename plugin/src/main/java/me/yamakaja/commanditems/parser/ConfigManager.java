package me.yamakaja.commanditems.parser;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import me.yamakaja.commanditems.CommandItems;
import me.yamakaja.commanditems.data.CommandItemsConfig;
import me.yamakaja.commanditems.data.ItemDefinition;
import me.yamakaja.commanditems.data.action.Action;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Yamakaja on 26.05.18.
 */
public class ConfigManager {

    private CommandItems plugin;
    private CommandItemsConfig config;
    private YAMLMapper mapper;

    public ConfigManager(CommandItems plugin) {
        this.plugin = plugin;

        this.mapper = new YAMLMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(ItemStack.class, new ItemStackDeserializer());
        mapper.registerModule(module);
    }

    public void parse() {
        try {
            this.config = mapper.readValue(new File(plugin.getDataFolder(), "config.yml"), CommandItemsConfig.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read config!", e);
        }

        for (Map.Entry<String, ItemDefinition> entry : this.config.getItems().entrySet()) {
            entry.getValue().setKey(entry.getKey());
            try {
                for (Action action : entry.getValue().getActions())
                    action.init();
            } catch (RuntimeException e) {
                plugin.getLogger().severe(ChatColor.RED + "Failed to initialize command item: " + entry.getKey());
                plugin.getLogger().severe(ChatColor.RED + e.getMessage());
                Bukkit.getPluginManager().disablePlugin(plugin);
            }
        }
    }

    public CommandItemsConfig getConfig() {
        return config;
    }

}
