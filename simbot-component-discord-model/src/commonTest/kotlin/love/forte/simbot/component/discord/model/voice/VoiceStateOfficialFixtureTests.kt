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

package love.forte.simbot.component.discord.model.voice

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Uses Discord's
 * [Example Voice State](https://docs.discord.com/developers/resources/voice#voice-state-object).
 */
class VoiceStateOfficialFixtureTests {
    @Test
    fun decodeOfficialVoiceStateExample() {
        val state = Json.decodeFromString<VoiceState>(
            """
            {
              "channel_id": "157733188964188161",
              "user_id": "80351110224678912",
              "session_id": "90326bd25d71d39b9ef95b299e3872ff",
              "deaf": false,
              "mute": false,
              "self_deaf": false,
              "self_mute": true,
              "self_video": false,
              "suppress": false,
              "request_to_speak_timestamp": "2021-03-31T18:45:31.297561+00:00"
            }
            """.trimIndent(),
        )

        // self_video is documented as required but omitted by the official example.
        // The fixture supplies the non-video value without changing the other fields.
        assertEquals("157733188964188161", state.channelId?.stringValue)
        assertEquals("80351110224678912", state.userId.stringValue)
        assertTrue(state.selfMute)
        assertFalse(state.selfVideo)
        assertFalse(state.suppress)
    }
}
