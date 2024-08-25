package dabusmc.dabs_explosives.item.explosives;

import dabusmc.dabs_explosives.entity.explosives.ExplosiveEntity;
import dabusmc.dabs_explosives.entity.explosives.RedExplosiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class RedExplosiveItem extends ExplosiveItem
{
    public RedExplosiveItem()
    {
        super(new Settings());
    }

    @Override
    public ExplosiveEntity getExplosiveEntity(World world, PlayerEntity user)
    {
        return new RedExplosiveEntity(world, user);
    }
}
