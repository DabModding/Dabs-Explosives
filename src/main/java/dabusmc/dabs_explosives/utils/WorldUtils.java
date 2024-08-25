package dabusmc.dabs_explosives.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class WorldUtils
{
    public static void explode(World world, Entity entity, Vec3d position, float power)
    {
        if(!world.isClient())
        {
            world.createExplosion(
                    entity,
                    Explosion.createDamageSource(world, entity),
                    null,
                    position.x,
                    position.y,
                    position.z,
                    power,
                    false,
                    World.ExplosionSourceType.MOB
            );
        }
    }

    public static void summonLightning(World world, Vec3d position)
    {
        LightningEntity entity = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        entity.setPosition(position);
        world.spawnEntity(entity);
    }
}
