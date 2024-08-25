package dabusmc.dabs_explosives.item.explosives;

import dabusmc.dabs_explosives.entity.explosives.CyanExplosiveEntity;
import dabusmc.dabs_explosives.entity.explosives.ExplosiveEntity;
import dabusmc.dabs_explosives.entity.explosives.GreenExplosiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class CyanExplosiveItem extends ExplosiveItem
{
    public CyanExplosiveItem()
    {
        super(new Settings());
    }

    @Override
    public ExplosiveEntity getExplosiveEntity(World world, PlayerEntity user)
    {
        return new CyanExplosiveEntity(world, user);
    }



    @Override
    public int getCooldown()
    {
        return 30;
    }
}
