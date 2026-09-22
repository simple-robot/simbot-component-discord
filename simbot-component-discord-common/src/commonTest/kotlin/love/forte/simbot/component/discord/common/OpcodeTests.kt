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

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertSame

class OpcodeTests {
    @Test
    fun knownOpcodesMatchDiscordGatewayTable() {
        expectedOpcodes.forEach { expected ->
            assertEquals(expected.expectedCode, expected.codeConstant, "${expected.name} code constant")
            assertEquals(expected.expectedCode, expected.opcode.code, "${expected.name} opcode code")
            assertEquals(expected.canSend, expected.opcode.isClientActionSend, "${expected.name} send action")
            assertEquals(
                expected.canReceive,
                expected.opcode.isClientActionReceive,
                "${expected.name} receive action"
            )
        }
    }

    @Test
    fun knownOpcodeCodesAreUnique() {
        val codes = expectedOpcodes.map { it.opcode.code }

        assertEquals(codes.size, codes.toSet().size)
    }

    @Test
    fun knownOpcodesSerializeAsNumbersAndDeserializeToCanonicalInstances() {
        expectedOpcodes.forEach { expected ->
            val encoded = Json.encodeToString(expected.opcode)
            val decoded = Json.decodeFromString<Opcode>(expected.expectedCode.toString())

            assertEquals(expected.expectedCode.toString(), encoded, "${expected.name} encoded value")
            assertSame(expected.opcode, decoded, "${expected.name} canonical instance")
        }
    }

    @Test
    fun unknownOpcodeRoundTripsWithoutInventingClientActions() {
        val decoded = Json.decodeFromString<Opcode>("999")

        assertEquals(999, decoded.code)
        assertFalse(decoded.isClientActionSend)
        assertFalse(decoded.isClientActionReceive)
        assertEquals("999", Json.encodeToString(decoded))
    }
}

private data class ExpectedOpcode(
    val name: String,
    val expectedCode: Int,
    val codeConstant: Int,
    val opcode: Opcode,
    val canSend: Boolean,
    val canReceive: Boolean
)

private val expectedOpcodes = listOf(
    ExpectedOpcode("Dispatch", 0, Opcode.DISPATCH_CODE, Opcode.Dispatch, canSend = false, canReceive = true),
    ExpectedOpcode("Heartbeat", 1, Opcode.HEARTBEAT_CODE, Opcode.Heartbeat, canSend = true, canReceive = true),
    ExpectedOpcode("Identify", 2, Opcode.IDENTIFY_CODE, Opcode.Identify, canSend = true, canReceive = false),
    ExpectedOpcode(
        "PresenceUpdate",
        3,
        Opcode.PRESENCE_UPDATE_CODE,
        Opcode.PresenceUpdate,
        canSend = true,
        canReceive = false
    ),
    ExpectedOpcode(
        "VoiceStateUpdate",
        4,
        Opcode.VOICE_STATE_UPDATE_CODE,
        Opcode.VoiceStateUpdate,
        canSend = true,
        canReceive = false
    ),
    ExpectedOpcode("Resume", 6, Opcode.RESUME_CODE, Opcode.Resume, canSend = true, canReceive = false),
    ExpectedOpcode("Reconnect", 7, Opcode.RECONNECT_CODE, Opcode.Reconnect, canSend = false, canReceive = true),
    ExpectedOpcode(
        "RequestGuildMembers",
        8,
        Opcode.REQUEST_GUILD_MEMBERS_CODE,
        Opcode.RequestGuildMembers,
        canSend = true,
        canReceive = false
    ),
    ExpectedOpcode(
        "InvalidSession",
        9,
        Opcode.INVALID_SESSION_CODE,
        Opcode.InvalidSession,
        canSend = false,
        canReceive = true
    ),
    ExpectedOpcode("Hello", 10, Opcode.HELLO_CODE, Opcode.Hello, canSend = false, canReceive = true),
    ExpectedOpcode(
        "HeartbeatAck",
        11,
        Opcode.HEARTBEAT_ACK_CODE,
        Opcode.HeartbeatAck,
        canSend = false,
        canReceive = true
    ),
    ExpectedOpcode(
        "RequestSoundboardSounds",
        31,
        Opcode.REQUEST_SOUNDBOARD_SOUNDS_CODE,
        Opcode.RequestSoundboardSounds,
        canSend = true,
        canReceive = false
    ),
    ExpectedOpcode(
        "RequestChannelInfo",
        43,
        Opcode.REQUEST_CHANNEL_INFO_CODE,
        Opcode.RequestChannelInfo,
        canSend = true,
        canReceive = false
    )
)
