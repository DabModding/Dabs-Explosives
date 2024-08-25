package dabusmc.dabs_explosives.utils;

import net.minecraft.entity.Entity;
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
}
