package dabusmc.dabs_explosives.item;

import dabusmc.dabs_explosives.DabsExplosives;
import dabusmc.dabs_explosives.item.explosives.LightBlueExplosiveItem;
import dabusmc.dabs_explosives.item.explosives.RedExplosiveItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems
{
    public static final Item RED_EXPLOSIVE = registerItem("red_explosive",
            new RedExplosiveItem());
    public static final Item LIGHT_BLUE_EXPLOSIVE = registerItem("light_blue_explosive",
            new LightBlueExplosiveItem());

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM,
                Identifier.of(DabsExplosives.MOD_ID, name),
                item);
    }

    public static void registerItems()
    {
        DabsExplosives.LOGGER.info("Registered Mod Items for " + DabsExplosives.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(RED_EXPLOSIVE);
            entries.add(LIGHT_BLUE_EXPLOSIVE);
        });
    }
}
