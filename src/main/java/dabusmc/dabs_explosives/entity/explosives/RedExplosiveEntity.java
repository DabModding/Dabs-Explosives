package dabusmc.dabs_explosives.entity.explosives;

import dabusmc.dabs_explosives.item.ModItems;
import dabusmc.dabs_explosives.utils.WorldUtils;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class RedExplosiveEntity extends ExplosiveEntity
{
    public RedExplosiveEntity(EntityType<? extends SnowballEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public RedExplosiveEntity(World world, LivingEntity owner)
    {
        super(world, owner);
    }

    public RedExplosiveEntity(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    protected Item getDefaultItem()
    {
        return ModItems.RED_EXPLOSIVE;
    }

    @Override
    public float getPower()
    {
        return 4.0f;
    }

    @Override
    public void performSpecialAction(HitResult hitResult)
    {

    }

    @Override
    public void performSpecialActionOnEntity(EntityHitResult entityHitResult)
    {

    }
}
