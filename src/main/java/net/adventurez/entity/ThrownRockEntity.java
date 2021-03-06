package net.adventurez.entity;

import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.adventurez.init.EntityInit;
import net.adventurez.init.SoundInit;
import net.adventurez.network.EntitySpawnPacket;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.Packet;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ThrownRockEntity extends ThrownItemEntity {
   public ThrownRockEntity(EntityType<? extends ThrownRockEntity> entityType, World world) {
      super(entityType, world);
   }

   public ThrownRockEntity(World world, LivingEntity owner) {
      super(EntityInit.THROWNROCK_ENTITY, owner, world);
   }

   public ThrownRockEntity(World world, double x, double y, double z) {
      super(EntityInit.THROWNROCK_ENTITY, x, y, z, world);
   }

   @Override
   protected Item getDefaultItem() {
      return Items.BLACKSTONE;
   }

   @Override
   public Packet<?> createSpawnPacket() {
      return EntitySpawnPacket.createPacket(this);
   }

   @Environment(EnvType.CLIENT)
   private ParticleEffect getParticleParameters() {
      BlockState state = this.getLandingBlockState();
      return new BlockStateParticleEffect(ParticleTypes.BLOCK, state);
   }

   @Override
   @Environment(EnvType.CLIENT)
   public void handleStatus(byte status) {
      if (status == 3) {
         ParticleEffect particleEffect = this.getParticleParameters();

         for (int i = 0; i < 32; ++i) {
            this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
         }
      }

   }

   @Override
   protected void onCollision(HitResult hitResult) {
      super.onCollision(hitResult);
      BlockState state = this.getLandingBlockState();
      if (!this.world.isClient) {
         this.world.playSound(null, this.getBlockPos(), SoundInit.ROCK_IMPACT_EVENT, SoundCategory.BLOCKS, 0.7F, 1F);
         this.world.sendEntityStatus(this, (byte) 3);
         this.remove();
      } else {
         for (int i = 0; i < 32; ++i) {
            this.world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, state), this.getX(), this.getY(),
                  this.getZ(), 0.0D, 0.0D, 0.0D);
         }
      }

   }

   @Override
   protected void onEntityHit(EntityHitResult entityHitResult) {
      super.onEntityHit(entityHitResult);
      if (!this.world.isClient) {
         Entity entity = entityHitResult.getEntity();
         Entity entity2 = this.getOwner();
         boolean bl2;
         if (entity2 instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity2;
            bl2 = entity.damage(DamageSource.FALLING_BLOCK, 16F);
            if (bl2) {
               if (entity.isAlive()) {
                  this.dealDamage(livingEntity, entity);
               } else {
                  livingEntity.heal(5.0F);
               }
            }
         } else {
            bl2 = entity.damage(DamageSource.FALLING_BLOCK, 16F);
         }

         if (bl2 && entity instanceof LivingEntity) {
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 2000, 2));
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 50, 0));
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 0));
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 1));
         }

      }
   }
}