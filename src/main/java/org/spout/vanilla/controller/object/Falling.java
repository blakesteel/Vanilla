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
package org.spout.vanilla.controller.object;

import org.spout.api.math.Vector3;
import org.spout.vanilla.controller.action.GravityAction;

/**
 * Controller that vertically falls. This is used for Sand and Gravel that fall (and anything else that would do so).
 */
public abstract class Falling extends Substance {
	private static float GRAVITY_MULTIPLIER = 23.31f;
	private final boolean gravity;

	public Falling(boolean gravity) {
		this.gravity = gravity;
		if (gravity) {
			registerAction(new GravityAction());
		}
	}

	protected void updateGravity(float dt) {
		setVelocity(getVelocity().add(Vector3.Up.multiply(-(dt * GRAVITY_MULTIPLIER))));
	}

	public boolean hasGravity() {
		return gravity;
	}
}
