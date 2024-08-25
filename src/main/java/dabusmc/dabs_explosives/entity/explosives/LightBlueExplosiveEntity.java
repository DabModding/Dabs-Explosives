package dabusmc.dabs_explosives.entity.explosives;

import dabusmc.dabs_explosives.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class LightBlueExplosiveEntity extends ExplosiveEntity
{
    public LightBlueExplosiveEntity(EntityType<? extends SnowballEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public LightBlueExplosiveEntity(World world, LivingEntity owner)
    {
        super(world, owner);
    }

    public LightBlueExplosiveEntity(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    protected Item getDefaultItem()
    {
        return ModItems.LIGHT_BLUE_EXPLOSIVE;
    }

    @Override
    public float getPower()
    {
        return 12.0f;
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
