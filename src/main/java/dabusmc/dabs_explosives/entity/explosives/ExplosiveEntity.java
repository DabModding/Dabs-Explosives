package dabusmc.dabs_explosives.entity.explosives;

import dabusmc.dabs_explosives.item.ModItems;
import dabusmc.dabs_explosives.utils.WorldUtils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ExplosiveEntity extends SnowballEntity
{
    public ExplosiveEntity(EntityType<? extends SnowballEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public ExplosiveEntity(World world, LivingEntity owner)
    {
        super(world, owner);
    }

    public ExplosiveEntity(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    public float getPower()
    {
        return 4.0f;
    }

    public void performSpecialAction(HitResult hitResult)
    {

    }

    public void performSpecialActionOnEntity(EntityHitResult entityHitResult)
    {

    }

    @Override
    protected Item getDefaultItem()
    {
        return ModItems.RED_EXPLOSIVE;
    }

    @Override
    protected void onCollision(HitResult hitResult)
    {
        super.onCollision(hitResult);

        WorldUtils.explode(this.getWorld(), this, hitResult.getPos(), getPower());
        performSpecialAction(hitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult)
    {
        WorldUtils.explode(this.getWorld(), this, entityHitResult.getPos(), getPower());
        performSpecialActionOnEntity(entityHitResult);
    }
}
