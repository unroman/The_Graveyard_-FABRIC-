package com.finallion.graveyard.world.structures;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.config.StructureConfigEntry;
import com.finallion.graveyard.init.TGConfiguredStructureFeatures;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import java.util.Arrays;
import java.util.Collections;

public class CryptStructure extends AbstractUndergroundStructure {

    public CryptStructure(Codec<StructurePoolFeatureConfig> codec) {
        super(new StructureConfigEntry(14, 12, 893183913,
                        Arrays.asList("#underground"),
                        Collections.emptyList(), Arrays.asList("#minecraft", "#terralith"), false),
                "crypt");
    }

    @Override
    public ConfiguredStructureFeature<?, ?> getStructureFeature() {
        return TGConfiguredStructureFeatures.CRYPT_STRUCTURE_CONFIG.value();
    }


    public static class CryptGenerator {
        public static final RegistryEntry<StructurePool> STARTING_POOL;

        public CryptGenerator() {
        }

        public static void init() {
        }

        static {
            // TODO: SORT POOLS
            STARTING_POOL = StructurePools.register(new StructurePool(new Identifier(TheGraveyard.MOD_ID, "crypt/corridor_pool"), new Identifier("minecraft:empty"), ImmutableList.of(
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/room_01"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/room_02"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/corner_01"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/corner_02"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/corridor_01"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/corridor_02"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/corridor_03"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/corridor_04"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/corridor_05"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/corridor_06"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/stairs_01"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/stairs_02"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/stairs_03"), 10),
                    Pair.of(StructurePoolElement.ofLegacySingle(TheGraveyard.MOD_ID + ":crypt/corridor_pool/library_01"), 10)
            ), StructurePool.Projection.RIGID));
        }
    }

}