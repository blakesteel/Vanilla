/*
 * This file is part of Vanilla (http://www.spout.org/).
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spout.vanilla.protocol.codec;

import java.io.IOException;

import org.spout.api.protocol.MessageCodec;
import org.spout.vanilla.protocol.msg.CreateEntityMessage;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public final class CreateEntityCodec extends MessageCodec<CreateEntityMessage> {
	public CreateEntityCodec() {
		super(CreateEntityMessage.class, 0x1E);
	}

	@Override
	public CreateEntityMessage decode(ChannelBuffer buffer) throws IOException {
		int id = buffer.readInt();
		return new CreateEntityMessage(id);
	}

	@Override
	public ChannelBuffer encode(CreateEntityMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(4);
		buffer.writeInt(message.getId());
		return buffer;
	}
}