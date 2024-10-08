package dabusmc.dabs_explosives.item.explosives;

import dabusmc.dabs_explosives.entity.explosives.ExplosiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ExplosiveItem extends Item
{
    public ExplosiveItem(Settings settings)
    {
        super(settings);
    }

    public ExplosiveEntity getExplosiveEntity(World world, PlayerEntity user)
    {
        return new ExplosiveEntity(world, user);
    }

    public int getCooldown()
    {
        return 20;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                SoundEvents.ENTITY_SNOWBALL_THROW,
                SoundCategory.NEUTRAL,
                0.5F,
                0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        //user.getItemCooldownManager().set(this, getCooldown());
        if (!world.isClient) {
            ExplosiveEntity explosiveEntity = getExplosiveEntity(world, user);
            explosiveEntity.setItem(itemStack);
            explosiveEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(explosiveEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        itemStack.decrementUnlessCreative(1, user);
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
