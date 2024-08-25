package dabusmc.dabs_explosives.entity.explosives;

import dabusmc.dabs_explosives.item.ModItems;
import dabusmc.dabs_explosives.utils.WorldUtils;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ProjectileDeflection;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class GreenExplosiveEntity extends ExplosiveEntity
{
    private int bounces = 0;
    private Vec3d previousVelocity = Vec3d.ZERO;
    private static final int MAX_BOUNCES = 3;
    private static final float DAMPENING_FACTOR = 0.75f;

    public GreenExplosiveEntity(EntityType<? extends SnowballEntity> entityType, World world)
    {
        super(entityType, world);
    }

    public GreenExplosiveEntity(World world, LivingEntity owner)
    {
        super(world, owner);
    }

    public GreenExplosiveEntity(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    @Override
    public void tick()
    {
        previousVelocity = getVelocity();

        super.tick();
    }

    @Override
    protected Item getDefaultItem()
    {
        return ModItems.GREEN_EXPLOSIVE;
    }

    @Override
    protected void onCollision(HitResult hitResult)
    {
        if(!this.getWorld().isClient())
        {
            if(bounces < MAX_BOUNCES)
            {
                double prevXAbs = Math.abs(previousVelocity.x);
                double prevYAbs = Math.abs(previousVelocity.y);
                double prevZAbs = Math.abs(previousVelocity.z);

                Vec3d vel = this.getVelocity();

                if(prevYAbs > prevXAbs && prevYAbs > prevZAbs)
                {
                    this.setVelocity(vel.x * DAMPENING_FACTOR, -1 * vel.y * DAMPENING_FACTOR, vel.z * DAMPENING_FACTOR);
                    this.velocityModified = true;
                }
                else if(prevXAbs > prevYAbs && prevXAbs > prevZAbs)
                {
                    this.setVelocity(-1 * vel.x * DAMPENING_FACTOR, vel.y * DAMPENING_FACTOR, vel.z * DAMPENING_FACTOR);
                    this.velocityModified = true;
                }
                else if(prevZAbs > prevYAbs && prevZAbs > prevXAbs)
                {
                    this.setVelocity(vel.x * DAMPENING_FACTOR, vel.y * DAMPENING_FACTOR, -1 * vel.z * DAMPENING_FACTOR);
                    this.velocityModified = true;
                }

                bounces += 1;

                this.getWorld().playSound(
                        null,
                        getX(),
                        getY(),
                        getZ(),
                        SoundEvents.ENTITY_SLIME_JUMP,
                        SoundCategory.NEUTRAL,
                        0.5F,
                        0.4F / (this.getWorld().getRandom().nextFloat() * 0.4F + 0.8F)
                );
            }
            else
            {
                WorldUtils.explode(this.getWorld(), this, hitResult.getPos(), 4.0f);
                this.discard();
            }
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult)
    {
    }
}
