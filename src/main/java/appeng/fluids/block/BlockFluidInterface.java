/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2018, AlgorithmX2, All rights reserved.
 *
 * Applied Energistics 2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Applied Energistics 2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Applied Energistics 2.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.fluids.block;


import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import appeng.api.util.AEPartLocation;
import appeng.block.AEBaseTileBlock;
import appeng.core.sync.GuiBridge;
import appeng.fluids.tile.TileFluidInterface;
import appeng.util.Platform;


public class BlockFluidInterface extends AEBaseTileBlock
{
	public BlockFluidInterface()
	{
		super( Material.IRON );
	}

	@Override
	public boolean onActivated( final World w, final BlockPos pos, final PlayerEntity p, final Hand hand, final @Nullable ItemStack heldItem, final Direction side, final float hitX, final float hitY, final float hitZ )
	{
		if( p.isShiftKeyDown() )
		{
			return false;
		}

		final TileEntity tg = this.getTileEntity( w, pos );
		if( tg instanceof TileFluidInterface )
		{
			if( Platform.isServer() )
			{
				Platform.openGUI( p, tg, AEPartLocation.fromFacing( side ), GuiBridge.GUI_FLUID_INTERFACE );
			}
			return true;
		}
		return false;
	}
}
