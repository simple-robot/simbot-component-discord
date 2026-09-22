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

package love.forte.simbot.component.discord.model.contract

import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import love.forte.simbot.component.discord.model.event.GuildScheduledEvent
import love.forte.simbot.component.discord.model.voice.VoiceState
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

/**
 * Verifies missing-field and explicit-null semantics whose meaning changes the
 * state represented by a voice connection or scheduled event.
 */
class EventAndVoiceNullableFieldTests {
    private val json = Json

    @Test
    fun requiredNullableVoiceChannelAcceptsNullButRejectsMissing() {
        val disconnected = json.decodeFromString<VoiceState>(
            voiceState(channelField = "\"channel_id\": null,"),
        )
        assertNull(disconnected.channelId)

        assertFailsWith<SerializationException> {
            json.decodeFromString<VoiceState>(voiceState(channelField = ""))
        }
    }

    @Test
    fun scheduledEventOptionalCreatorMayBeMissing() {
        val event = json.decodeFromString<GuildScheduledEvent>(
            scheduledEvent(recurrenceField = "\"recurrence_rule\": null"),
        )

        assertNull(event.creatorId)
        assertNull(event.creator)
    }

    @Test
    fun scheduledEventRequiredNullableRecurrenceRejectsMissing() {
        assertFailsWith<SerializationException> {
            json.decodeFromString<GuildScheduledEvent>(
                scheduledEvent(recurrenceField = ""),
            )
        }
    }

    private companion object {
        private fun voiceState(channelField: String): String =
            """
            {
              $channelField
              "user_id": "1",
              "session_id": "session",
              "deaf": false,
              "mute": false,
              "self_deaf": false,
              "self_mute": false,
              "self_video": false,
              "suppress": false,
              "request_to_speak_timestamp": null
            }
            """.trimIndent()

        private fun scheduledEvent(recurrenceField: String): String =
            """
            {
              "id": "1",
              "guild_id": "2",
              "channel_id": "3",
              "name": "Event",
              "scheduled_start_time": "2026-10-01T12:00:00Z",
              "scheduled_end_time": null,
              "privacy_level": 2,
              "status": 1,
              "entity_type": 2,
              "entity_id": null,
              "entity_metadata": null${if (recurrenceField.isEmpty()) "" else ","}
              $recurrenceField
            }
            """.trimIndent()
    }
}
