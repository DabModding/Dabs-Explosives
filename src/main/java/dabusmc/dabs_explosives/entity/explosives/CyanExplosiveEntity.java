package dabusmc.dabs_explosives.entity.explosives;

import dabusmc.dabs_explosives.item.ModItems;
import dabusmc.dabs_explosives.utils.WorldUtils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CyanExplosiveEntity extends ExplosiveEntity
{
    public CyanExplosiveEntity(EntityType<? extends SnowballEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public CyanExplosiveEntity(World world, LivingEntity owner)
    {
        super(world, owner);
    }

    public CyanExplosiveEntity(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    protected Item getDefaultItem()
    {
        return ModItems.CYAN_EXPLOSIVE;
    }

    @Override
    public float getPower()
    {
        return 0.0f;
    }

    @Override
    public void performSpecialAction(HitResult hitResult)
    {
        WorldUtils.summonLightning(this.getWorld(), hitResult.getPos());
    }

    @Override
    public void performSpecialActionOnEntity(EntityHitResult entityHitResult)
    {

    }
}
