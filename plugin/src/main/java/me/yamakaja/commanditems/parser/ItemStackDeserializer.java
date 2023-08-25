package me.yamakaja.commanditems.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.base.Preconditions;
import me.yamakaja.commanditems.util.EnchantmentGlow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ItemStackDeserializer extends StdDeserializer<ItemStack> {

    protected ItemStackDeserializer() {
        super(ItemStack.class);
    }

    @Override
    public ItemStack deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Material material = null;
        String name = null;
        List<String> lore = null;
        boolean glow = false;
        short damage = 0;
        boolean unbreakable = false;
        Integer customModelData = null;

        while (p.nextToken() == JsonToken.FIELD_NAME) {
            switch (p.getCurrentName()) {
                case "type":
                    try {
                        material = Material.valueOf(p.nextTextValue());
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException("Invalid material type!", e);
                    }
                    break;
                case "name":
                    name = p.nextTextValue();
                    break;
                case "lore":
                    p.nextToken();
                    String[] loreArray = p.readValueAs(String[].class);
                    for (int i = 0; i < loreArray.length; i++)
                        loreArray[i] = ChatColor.translateAlternateColorCodes('&', loreArray[i]);
                    lore = Arrays.asList(loreArray);
                    break;
                case "glow":
                    glow = p.nextBooleanValue();
                    break;
                case "damage":
                    damage = (short) p.nextIntValue(0);
                    break;
                case "unbreakable":
                    unbreakable = p.nextBooleanValue();
                    break;
                case "customModelData":
                    customModelData = p.nextIntValue(0);
                    break;
            }
        }

        Preconditions.checkNotNull(material, "No material specified!");

        ItemStack stack = new ItemStack(material, 1, damage);
        ItemMeta meta = stack.getItemMeta();

        Preconditions.checkNotNull(meta, "ItemMeta is null! (Material: " + material + ")");

        if (name != null)
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        if (lore != null && !lore.isEmpty())
            meta.setLore(lore);

        meta.setUnbreakable(unbreakable);
        if (customModelData != null)
            meta.setCustomModelData(customModelData);

        stack.setItemMeta(meta);

        if (glow)
            stack.addEnchantment(EnchantmentGlow.getGlow(), 1);

        return stack;
    }

}
