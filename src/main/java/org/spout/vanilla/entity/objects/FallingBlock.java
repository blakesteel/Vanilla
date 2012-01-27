/*
 * This file is part of Vanilla (http://www.spout.org/).
 *
 * Vanilla is licensed under the SpoutDev License Version 1.  
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the 
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev license version 1 along with this program.  
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license, 
 * including the MIT license.
 */
package org.spout.vanilla.entity.objects;

import org.spout.api.geo.World;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.geo.discrete.Point;
import org.spout.api.material.BlockMaterial;
import org.spout.api.math.MathHelper;
import org.spout.api.player.Player;
import org.spout.vanilla.VanillaBlocks;
import org.spout.vanilla.entity.MovingEntity;
import org.spout.vanilla.protocol.msg.SpawnVehicleMessage;

public class FallingBlock extends MovingEntity {
	private final BlockMaterial block;
	private final Point start;
	private int fallTicks = 0;
	public FallingBlock(BlockMaterial block, Point position) {
		if (position == null) throw new NullPointerException("Position can not be null");
		this.block = block;
		start = new Point(position);
	}
	
	@Override
	public void onAttached() {
		this.parent.getTransform().setPosition(start);
		super.onAttached();
		int spawnId = -1; //TODO: support for other falling block types?
		if (block == VanillaBlocks.sand){
			spawnId = 70;
		}
		if (block == VanillaBlocks.gravel){
			spawnId = 71;
		}
		if (spawnId > 0) {
			int x = MathHelper.floor(start.getX());
			int y = MathHelper.floor(start.getY());
			int z = MathHelper.floor(start.getZ());
			SpawnVehicleMessage message = new SpawnVehicleMessage(parent.getId(), spawnId, x, y, z);
			for (Player player : start.getWorld().p
		}
	}

	@Override
	public void onTick(float dt) {
		fallTicks++;
		if (fallTicks > 1){
			Point position = parent.getTransform().getPosition();
			World world = position.getWorld();
			int x = MathHelper.floor(position.getX());
			int y = MathHelper.floor(position.getY());
			int z = MathHelper.floor(position.getZ());
			Block pos = world.getBlock(x, y-1, z);
			if (pos.getBlockMaterial() == VanillaBlocks.air){
				getVelocity().add(0, -0.04F, 0);
			}
			else {
				world.setBlockMaterial(x, y, z, block, world);
				this.parent.kill();
			}
		}
		super.onTick(dt);
	}
}