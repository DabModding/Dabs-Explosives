package dabusmc.dabs_explosives.item.explosives;

import dabusmc.dabs_explosives.entity.explosives.ExplosiveEntity;
import dabusmc.dabs_explosives.entity.explosives.LightBlueExplosiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class LightBlueExplosiveItem extends ExplosiveItem
{
    public LightBlueExplosiveItem()
    {
        super(new Settings());
    }

    @Override
    public ExplosiveEntity getExplosiveEntity(World world, PlayerEntity user)
    {
        return new LightBlueExplosiveEntity(world, user);
    }

    @Override
    public int getCooldown()
    {
        return 40;
    }
}
