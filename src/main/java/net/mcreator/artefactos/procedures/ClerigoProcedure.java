/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.core.particles.ParticleTypes
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.Container
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 */
package net.mcreator.artefactos.procedures;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import net.mcreator.artefactos.init.ArtefactosModItems;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ClerigoProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        Player _player;
        if (entity == null) {
            return;
        }
        if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            ((ServerLevel)_level).sendParticles((ParticleOptions)ParticleTypes.TOTEM_OF_UNDYING, x, y, z, 1200, 3.0, 3.0, 3.0, 1.0);
        }
        Vec3 _center = new Vec3(x, y, z);
        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10.0), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
        for (Entity entityiterator : _entfound) {
            LivingEntity _entity;
            if (!(entityiterator instanceof Mob) || entity instanceof Player || entityiterator instanceof ServerPlayer) {
                if (entityiterator instanceof LivingEntity) {
                    _entity = (LivingEntity)entityiterator;
                    if (!_entity.level.isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1200, 9, false, true));
                    }
                }
                if (!(entityiterator instanceof LivingEntity)) continue;
                _entity = (LivingEntity)entityiterator;
                if (_entity.level.isClientSide()) continue;
                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 2, false, true));
                continue;
            }
            if (!(entityiterator instanceof Mob) && entityiterator instanceof ServerPlayer && !(entityiterator instanceof Monster)) continue;
            if (entityiterator instanceof LivingEntity) {
                _entity = (LivingEntity)entityiterator;
                _entity.removeEffect(MobEffects.GLOWING);
            }
            if (!(entityiterator instanceof LivingEntity)) continue;
            _entity = (LivingEntity)entityiterator;
            _entity.removeEffect(MobEffects.DAMAGE_BOOST);
        }
        if (entity instanceof Player) {
            _player = (Player)entity;
            ItemStack _stktoremove = new ItemStack((ItemLike)ArtefactosModItems.AMULETODECLERIGO.get());
            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, (Container)_player.inventoryMenu);
        }
        if (entity instanceof Player) {
            _player = (Player)entity;
            _player.getCooldowns().addCooldown(itemstack.getItem(), 6000);
        }
    }
}

