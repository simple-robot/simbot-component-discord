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

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.jvm.JvmStatic


/**
 * A [Gateway Opcode](https://docs.discord.com/developers/topics/opcodes-and-status-codes#gateway-gateway-opcodes)
 * and the actions the Discord Gateway allows a client to perform with it.
 *
 * Every Gateway payload contains an opcode identifying the payload type. The
 * [isClientActionSend] and [isClientActionReceive] properties reflect the
 * `Client Action` column in Discord's Gateway opcode table.
 *
 * @property code The numeric opcode used in the Gateway payload's `op` field.
 * @property isClientActionSend Whether the client sends payloads with this opcode.
 * @property isClientActionReceive Whether the client receives payloads with this opcode.
 *
 * @author Forte Scarlet
 */
@Serializable(OpcodeSerializer::class)
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
     * The numeric opcode used in the Gateway payload's `op` field.
     */
    public val code: Int
        get() = (value and CODE_MASK).toInt()

    /**
     * Whether this opcode can be sent by the client to the Discord Gateway.
     */
    public val isClientActionSend: Boolean
        get() = value and ACTION_SEND_FLAG == ACTION_SEND_FLAG

    /**
     * Whether this opcode can be received by the client from the Discord Gateway.
     */
    public val isClientActionReceive: Boolean
        get() = value and ACTION_RECEIVE_FLAG == ACTION_RECEIVE_FLAG

    public companion object {
        private const val ACTION_SEND_FLAG: Long = 1L shl 32
        private const val ACTION_RECEIVE_FLAG: Long = 1L shl 33
        private const val CODE_MASK: Long = 0xFFFF_FFFFL

        /**
         * Opcode number for [Dispatch].
         */
        public const val DISPATCH_CODE: Int = 0

        /**
         * Opcode number for [Heartbeat].
         */
        public const val HEARTBEAT_CODE: Int = 1

        /**
         * Opcode number for [Identify].
         */
        public const val IDENTIFY_CODE: Int = 2

        /**
         * Opcode number for [PresenceUpdate].
         */
        public const val PRESENCE_UPDATE_CODE: Int = 3

        /**
         * Opcode number for [VoiceStateUpdate].
         */
        public const val VOICE_STATE_UPDATE_CODE: Int = 4

        /**
         * Opcode number for [Resume].
         */
        public const val RESUME_CODE: Int = 6

        /**
         * Opcode number for [Reconnect].
         */
        public const val RECONNECT_CODE: Int = 7

        /**
         * Opcode number for [RequestGuildMembers].
         */
        public const val REQUEST_GUILD_MEMBERS_CODE: Int = 8

        /**
         * Opcode number for [InvalidSession].
         */
        public const val INVALID_SESSION_CODE: Int = 9

        /**
         * Opcode number for [Hello].
         */
        public const val HELLO_CODE: Int = 10

        /**
         * Opcode number for [HeartbeatAck].
         */
        public const val HEARTBEAT_ACK_CODE: Int = 11

        /**
         * Opcode number for [RequestSoundboardSounds].
         */
        public const val REQUEST_SOUNDBOARD_SOUNDS_CODE: Int = 31

        /**
         * Opcode number for [RequestChannelInfo].
         */
        public const val REQUEST_CHANNEL_INFO_CODE: Int = 43

        private val knownOpcodes = mutableListOf<Opcode>()

        private val knownOpcodeMap by lazy {
            knownOpcodes.associateBy { it.code }
        }

        private fun opcode(
            code: Int,
            isClientActionSend: Boolean = false,
            isClientActionReceive: Boolean = false
        ): Opcode {
            val code = Opcode(code, isClientActionSend, isClientActionReceive)
            knownOpcodes.add(code)
            return code
        }

        /**
         * An event was dispatched.
         */
        @JvmStatic
        public val Dispatch: Opcode = opcode(DISPATCH_CODE, isClientActionReceive = true)

        /**
         * Keeps the connection alive. The client sends heartbeats periodically,
         * and the Gateway may request an immediate heartbeat from the client.
         */
        @JvmStatic
        public val Heartbeat: Opcode = opcode(
            HEARTBEAT_CODE,
            isClientActionSend = true,
            isClientActionReceive = true
        )

        /**
         * Starts a new Gateway session during the initial handshake.
         */
        @JvmStatic
        public val Identify: Opcode = opcode(IDENTIFY_CODE, isClientActionSend = true)

        /**
         * Updates the client's presence.
         */
        @JvmStatic
        public val PresenceUpdate: Opcode = opcode(PRESENCE_UPDATE_CODE, isClientActionSend = true)

        /**
         * Joins, leaves, or moves between voice channels.
         */
        @JvmStatic
        public val VoiceStateUpdate: Opcode = opcode(VOICE_STATE_UPDATE_CODE, isClientActionSend = true)

        /**
         * Resumes a previously disconnected Gateway session.
         */
        @JvmStatic
        public val Resume: Opcode = opcode(RESUME_CODE, isClientActionSend = true)

        /**
         * Requests that the client reconnect and immediately attempt to resume.
         */
        @JvmStatic
        public val Reconnect: Opcode = opcode(RECONNECT_CODE, isClientActionReceive = true)

        /**
         * Requests information about offline members of a large guild.
         */
        @JvmStatic
        public val RequestGuildMembers: Opcode = opcode(REQUEST_GUILD_MEMBERS_CODE, isClientActionSend = true)

        /**
         * Reports that the Gateway session is invalid. The client should reconnect
         * and then identify or resume as directed by the payload.
         */
        @JvmStatic
        public val InvalidSession: Opcode = opcode(INVALID_SESSION_CODE, isClientActionReceive = true)

        /**
         * Provides the heartbeat interval immediately after the client connects.
         */
        @JvmStatic
        public val Hello: Opcode = opcode(HELLO_CODE, isClientActionReceive = true)

        /**
         * Acknowledges that the Gateway received a client heartbeat.
         */
        @JvmStatic
        public val HeartbeatAck: Opcode = opcode(HEARTBEAT_ACK_CODE, isClientActionReceive = true)

        /**
         * Requests information about soundboard sounds in a set of guilds.
         */
        @JvmStatic
        public val RequestSoundboardSounds: Opcode =
            opcode(REQUEST_SOUNDBOARD_SOUNDS_CODE, isClientActionSend = true)

        /**
         * Requests ephemeral channel data for channels in a guild.
         */
        @JvmStatic
        public val RequestChannelInfo: Opcode = opcode(REQUEST_CHANNEL_INFO_CODE, isClientActionSend = true)

        internal fun of(code: Int): Opcode {
            return knownOpcodeMap[code] ?: Opcode(code, isClientActionSend = false, isClientActionReceive = false)
        }
    }
}

/**
 * Opcode as Int value.
 */
internal object OpcodeSerializer : KSerializer<Opcode> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Opcode", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: Opcode) {
        encoder.encodeInt(value.code)
    }

    override fun deserialize(decoder: Decoder): Opcode {
        return Opcode.of(decoder.decodeInt())
    }
}
