package net.runelite.client.plugins.NQuickEat;

import java.util.Arrays;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
public enum PQuickEatType
{
	BREWS(ItemID.SARADOMIN_BREW1, ItemID.SARADOMIN_BREW2, ItemID.SARADOMIN_BREW3, ItemID.SARADOMIN_BREW4);

	public int[] ItemIDs;

	PQuickEatType(int... ids)
	{
		this.ItemIDs = ids;
	}

	public boolean containsId(int id)
	{
		return Arrays.stream(this.ItemIDs).anyMatch(x -> x == id);
	}

	public WidgetItem getItemFromInventory(Client client)
	{
		Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);

		if (inventoryWidget == null)
		{
			return null;
		}

		for (WidgetItem item : inventoryWidget.getWidgetItems())
		{
			if (Arrays.stream(ItemIDs).anyMatch(i -> i == item.getId()))
			{
				return item;
			}
		}

		return null;
	}
}
