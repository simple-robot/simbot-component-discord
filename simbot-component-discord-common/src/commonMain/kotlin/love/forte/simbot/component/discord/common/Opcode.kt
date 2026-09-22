/*
 * Copyright (c) 2026. ForteScarlet.
 *
 * This file is part of simbot-component-discord.
 *
 * simbot-component-discord is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * simbot-component-discord is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with simbot-component-discord.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package love.forte.simbot.component.discord.common


/**
 * [Gateway Opcode](https://docs.discord.com/developers/topics/opcodes-and-status-codes#gateway)
 *
 * @author Forte Scarlet
 */
public class Opcode private constructor(private val value: Long) {
    private constructor(
        code: Int,
        isClientActionSend: Boolean = false,
        isClientActionReceive: Boolean = false
    ) : this(
        (code.toLong() and CODE_MASK) or
                (if (isClientActionSend) ACTION_SEND_FLAG else 0L) or
                (if (isClientActionReceive) ACTION_RECEIVE_FLAG else 0L)
    )

    /**
     * TODO
     */
    public val code: Int
        get() = (value and CODE_MASK).toInt()

    /**
     * TODO
     */
    public val isClientActionSend: Boolean
        get() = value and ACTION_SEND_FLAG == ACTION_SEND_FLAG

    /**
     * TODO
     */
    public val isClientActionReceive: Boolean
        get() = value and ACTION_RECEIVE_FLAG == ACTION_RECEIVE_FLAG

    public companion object {
        private const val ACTION_SEND_FLAG: Long = 1L shl 32
        private const val ACTION_RECEIVE_FLAG: Long = 1L shl 33
        private const val CODE_MASK: Long = 0xFFFF_FFFFL

        /**
         * Opcode number means *'An event was dispatched.'*
         */
        public const val DISPATCH_CODE: Int = 0

        // TODO ...

        /**
         * An event was dispatched.
         */
        public val Dispatch: Opcode = Opcode(DISPATCH_CODE, isClientActionReceive = true)

        // TODO ...
    }
}
