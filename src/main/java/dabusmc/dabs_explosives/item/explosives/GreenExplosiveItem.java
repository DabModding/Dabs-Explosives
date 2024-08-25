package dabusmc.dabs_explosives.item.explosives;

import dabusmc.dabs_explosives.entity.explosives.ExplosiveEntity;
import dabusmc.dabs_explosives.entity.explosives.GreenExplosiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class GreenExplosiveItem extends ExplosiveItem
{
    public GreenExplosiveItem()
    {
        super(new Settings());
    }

    @Override
    public ExplosiveEntity getExplosiveEntity(World world, PlayerEntity user)
    {
        return new GreenExplosiveEntity(world, user);
    }

    @Override
    public int getCooldown()
    {
        return 20;
    }
}
