package dabusmc.dabs_explosives;

import dabusmc.dabs_explosives.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DabsExplosives implements ModInitializer
{
	public static final String MOD_ID = "dabs-explosives";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModItems.registerItems();
	}
}