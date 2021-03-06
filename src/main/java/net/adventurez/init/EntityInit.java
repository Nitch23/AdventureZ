package net.adventurez.init;

import net.adventurez.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityInit {
        public static final EntityType<StoneGolemEntity> STONEGOLEM_ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, StoneGolemEntity::new).trackable(74, 2).fireImmune()
                        .dimensions(EntityDimensions.fixed(3.36F, 4.44F)).build();
        public static final EntityType<ThrownRockEntity> THROWNROCK_ENTITY = FabricEntityTypeBuilder
                        .<ThrownRockEntity>create(SpawnGroup.MISC, ThrownRockEntity::new).trackable(74, 2)
                        .dimensions(EntityDimensions.fixed(1.5F, 1.5F)).build();
        public static final EntityType<GildedStoneEntity> GILDEDSTONE_ENTITY = FabricEntityTypeBuilder
                        .<GildedStoneEntity>create(SpawnGroup.MISC, GildedStoneEntity::new).trackable(74, 2)
                        .dimensions(EntityDimensions.fixed(0.4F, 0.7F)).build();
        public static final EntityType<SmallStoneGolemEntity> SMALLSTONEGOLEM_ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, SmallStoneGolemEntity::new).trackable(74, 2).fireImmune()
                        .dimensions(EntityDimensions.fixed(1.2F, 1.2F)).build();
        public static final EntityType<PiglinBeastEntity> PIGLINBEAST_ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, PiglinBeastEntity::new).trackable(74, 2).fireImmune()
                        .dimensions(EntityDimensions.fixed(1.55F, 3.35F)).build();
        public static final EntityType<NightmareEntity> NIGHTMARE_ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, NightmareEntity::new).trackable(74, 2).fireImmune()
                        .dimensions(EntityDimensions.fixed(1.4F, 1.6F)).build();
        public static final EntityType<SoulReaperEntity> SOULREAPER_ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, SoulReaperEntity::new).trackable(74, 2).fireImmune()
                        .dimensions(EntityDimensions.fixed(0.7F, 2.4F)).build();
        public static final EntityType<NecromancerEntity> NECROMANCER_ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, NecromancerEntity::new).trackable(74, 2).fireImmune()
                        .dimensions(EntityDimensions.fixed(0.9F, 2.4F)).build();
        public static final EntityType<WitherPuppetEntity> WITHERPUPPET_ENTITY = FabricEntityTypeBuilder
                        .create(SpawnGroup.MONSTER, WitherPuppetEntity::new).trackable(74, 2).fireImmune()
                        .dimensions(EntityDimensions.fixed(0.7F, 1.32F)).build();
        // public static final EntityType<GryphonEntity> GRYPHON_ENTITY =
        // FabricEntityTypeBuilder
        // .create(SpawnGroup.CREATURE, GryphonEntity::new).trackable(74, 2)
        // .dimensions(EntityDimensions.fixed(1.4F, 1.6F)).build();

        public static void init() {
                Registry.register(Registry.ENTITY_TYPE, new Identifier("adventurez", "stone_golem"), STONEGOLEM_ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("adventurez", "thrown_rock"), THROWNROCK_ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("adventurez", "gilded_stone"),
                                GILDEDSTONE_ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("adventurez", "small_stone_golem"),
                                SMALLSTONEGOLEM_ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("adventurez", "piglin_beast"),
                                PIGLINBEAST_ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("adventurez", "nightmare"), NIGHTMARE_ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("adventurez", "soul_reaper"), SOULREAPER_ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("adventurez", "necromancer"),
                                NECROMANCER_ENTITY);
                Registry.register(Registry.ENTITY_TYPE, new Identifier("adventurez", "wither_puppet"),
                                WITHERPUPPET_ENTITY);
                // Registry.register(Registry.ENTITY_TYPE, new Identifier("adventurez",
                // "gryphon"), GRYPHON_ENTITY);

                // Attributes
                FabricDefaultAttributeRegistry.register(STONEGOLEM_ENTITY,
                                StoneGolemEntity.createStoneGolemAttributes());
                FabricDefaultAttributeRegistry.register(SMALLSTONEGOLEM_ENTITY,
                                SmallStoneGolemEntity.createSmallStoneGolemAttributes());
                FabricDefaultAttributeRegistry.register(PIGLINBEAST_ENTITY,
                                PiglinBeastEntity.createPiglinBeastAttributes());
                FabricDefaultAttributeRegistry.register(NIGHTMARE_ENTITY, NightmareEntity.createNightmareAttributes());
                FabricDefaultAttributeRegistry.register(SOULREAPER_ENTITY,
                                SoulReaperEntity.createSoulReaperAttributes());
                FabricDefaultAttributeRegistry.register(NECROMANCER_ENTITY,
                                NecromancerEntity.createNecromancerAttributes());
                FabricDefaultAttributeRegistry.register(WITHERPUPPET_ENTITY,
                                WitherPuppetEntity.createWitherPuppetAttributes());
                // FabricDefaultAttributeRegistry.register(GRYPHON_ENTITY,
                // GryphonEntity.createGryphonAttributes());

                // Spawn Eggs
                Registry.register(Registry.ITEM, new Identifier("adventurez", "spawn_stone_golem"), new SpawnEggItem(
                                STONEGOLEM_ENTITY, 2956072, 1445648, new Item.Settings().group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("adventurez", "spawn_small_stone_golem"),
                                new SpawnEggItem(SMALLSTONEGOLEM_ENTITY, 4077380, 4400440,
                                                new Item.Settings().group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("adventurez", "spawn_piglin_beast"), new SpawnEggItem(
                                PIGLINBEAST_ENTITY, 5121815, 14192743, new Item.Settings().group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("adventurez", "spawn_nightmare"), new SpawnEggItem(
                                NIGHTMARE_ENTITY, 1381653, 3012863, new Item.Settings().group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("adventurez", "spawn_soul_reaper"), new SpawnEggItem(
                                SOULREAPER_ENTITY, 1381653, 5329747, new Item.Settings().group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("adventurez", "spawn_necromancer"), new SpawnEggItem(
                                NECROMANCER_ENTITY, 1447446, 15514145, new Item.Settings().group(ItemGroup.MISC)));
                Registry.register(Registry.ITEM, new Identifier("adventurez", "spawn_wither_puppet"), new SpawnEggItem(
                                WITHERPUPPET_ENTITY, 1250067, 3092271, new Item.Settings().group(ItemGroup.MISC)));
                // Registry.register(Registry.ITEM, new Identifier("adventurez",
                // "spawn_gryphon"), new SpawnEggItem(
                // GRYPHON_ENTITY, 1381653, 5329747, new
                // Item.Settings().group(ItemGroup.MISC)));
        }
}