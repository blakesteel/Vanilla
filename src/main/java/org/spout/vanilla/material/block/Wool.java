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
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.vanilla.material.block;

import org.spout.api.material.source.DataSource;
import org.spout.vanilla.material.MovingBlock;
import org.spout.vanilla.material.generic.GenericBlock;

public class Wool extends GenericBlock implements MovingBlock {
	public static final Wool WHITE = new Wool("White Wool");
	public static final Wool ORANGE = new Wool("Orange Wool", WoolColor.ORANGE, WHITE).register();
	public static final Wool MAGENTA = new Wool("Magenta Wool", WoolColor.MAGENTA, WHITE).register();
	public static final Wool LIGHTBLUE = new Wool("Light Blue Wool", WoolColor.LIGHTBLUE, WHITE).register();
	public static final Wool YELLOW = new Wool("Yellow Wool", WoolColor.YELLOW, WHITE).register();
	public static final Wool LIME = new Wool("Lime Wool", WoolColor.LIME, WHITE).register();
	public static final Wool PINK = new Wool("Pink Wool", WoolColor.PINK, WHITE).register();
	public static final Wool GRAY = new Wool("Gray Wool", WoolColor.GRAY, WHITE).register();
	public static final Wool SILVER = new Wool("Silver Wool", WoolColor.SILVER, WHITE).register();
	public static final Wool CYAN = new Wool("Cyan Wool", WoolColor.CYAN, WHITE).register();
	public static final Wool PURPLE = new Wool("Purple Wool", WoolColor.PURPLE, WHITE).register();
	public static final Wool BLUE = new Wool("Blue Wool", WoolColor.BLUE, WHITE).register();
	public static final Wool BROWN = new Wool("Brown Wool", WoolColor.BROWN, WHITE).register();
	public static final Wool GREEN = new Wool("Green Wool", WoolColor.GREEN, WHITE).register();
	public static final Wool RED = new Wool("Red Wool", WoolColor.RED, WHITE).register();
	public static final Wool BLACK = new Wool("Black Wool", WoolColor.BLACK, WHITE).register();
	
	public static enum WoolColor implements DataSource {
		WHITE(0),
		ORANGE(1),
		MAGENTA(2),
		LIGHTBLUE(3),
		YELLOW(4),
		LIME(5),
		PINK(6),
		GRAY(7),
		SILVER(8),
		CYAN(9),
		PURPLE(10),
		BLUE(11),
		BROWN(12),
		GREEN(13),
		RED(14),
		BLACK(15);

		private final short data;

		private WoolColor(int data) {
			this.data = (short) data;
		}

		@Override
		public short getData() {
			return this.data;
		}
	}

	private final WoolColor color;

	public Wool(String name) {
		super(name, 35);
		this.setDefault();
		this.color = WoolColor.WHITE;
	}

	public Wool(String name, WoolColor color, Wool parent) {
		super(name, 35, color.getData(), parent);
		this.setDefault();
		this.color = color;
	}

	private void setDefault() {
		this.setHardness(0.8F).setResistance(1.3F);
	}

	@Override
	public boolean isMoving() {
		return false;
	}

	public WoolColor getColor() {
		return color;
	}

	@Override
	public short getData() {
		return color.getData();
	}
	
	@Override
	public Wool getParentMaterial() {
		return (Wool) super.getParentMaterial();
	}
}
