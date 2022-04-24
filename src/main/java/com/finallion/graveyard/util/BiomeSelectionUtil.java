package com.finallion.graveyard.util;

import com.finallion.graveyard.TheGraveyard;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;

import java.util.List;

public class BiomeSelectionUtil {

    public static boolean parseBiomes(List<String> whitelist, List<String> blacklist, RegistryEntry<Biome> biome) throws NullPointerException {
        try {
            String modId = biome.getKey().get().getValue().getNamespace();
            String biomeName = biome.getKey().get().getValue().toString();
            String biomeCategory = BuiltinRegistries.BIOME.get(biome.getKey().get()).getCategory(biome).getName();

            if (whitelist.isEmpty()) {
                return false;
            }

            // no blacklist and biome is allowed
            if (whitelist.contains(biomeName) && blacklist.isEmpty()) {
                return true;
            }

            // no blacklist and biomeCategory is allowed
            if (whitelist.contains("#" + biomeCategory) && blacklist.isEmpty()) {
                return true;
            }

            // blacklist exists and check if biome is on the blacklist
            if (whitelist.contains(biomeName) && !blacklist.isEmpty()) {
                if (blacklist.contains("#" + biomeCategory)) { // whitelist weighs higher than blacklist
                    //TheGraveyard.LOGGER.error("Blacklisted biome category #" + biomeCategory + " contains whitelisted biome " + biomeName + ".");
                    return true;
                } else if (blacklist.contains(biomeName)) {  // blacklist weighs higher than whitelist
                    TheGraveyard.LOGGER.debug("Biome " + biomeName + " is on whitelist and blacklist.");
                    return false;
                } else {
                    return true;
                }
            }


            // blacklist exists and check if biomeCategory is on the blacklist
            if (whitelist.contains("#" + biomeCategory) && !blacklist.isEmpty()) {
                if (blacklist.contains("#" + biomeCategory)) { // blacklist weighs higher than whitelist
                    TheGraveyard.LOGGER.debug("Biome category #" + biomeCategory + " is on whitelist and blacklist.");
                    return false;
                } else if (blacklist.contains(biomeName)) { // blacklist weighs higher than whitelist
                    //TheGraveyard.LOGGER.error("Biome category #" + biomeCategory + " is on whitelist and subsidiary biome " + biomeName + " is on blacklist.");
                    return false;
                } else {
                    return true;
                }
            }

            return false;
        } catch (NullPointerException e) {
            TheGraveyard.LOGGER.error("The Graveyard config file (\"the-graveyard-config.json5\") isn't up to date. Please delete the file and restart the game to create a new config file!");
            return false;
        }
    }

    public static boolean parseWhitelistedMods(List<String> modWhitelist, RegistryEntry<Biome> biome) {
        if (modWhitelist == null) {
            TheGraveyard.LOGGER.error("Error reading from the Graveyard config file: Allowed biome category/biome is null. Try to delete the file and restart the game.");
            return false;
        }

        String modid = biome.getKey().get().getValue().getNamespace();
        return modWhitelist.contains("#" + modid);
    }
}