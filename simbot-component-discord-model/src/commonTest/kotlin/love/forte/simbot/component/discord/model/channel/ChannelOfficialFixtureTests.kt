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

package love.forte.simbot.component.discord.model.channel

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * Verifies channel variants with the examples from Discord's
 * [Channel Object](https://docs.discord.com/developers/resources/channel#channel-object).
 */
class ChannelOfficialFixtureTests {
    private val json = Json

    @Test
    fun decodeOfficialGuildTextChannelExample() {
        val channel = json.decodeFromString<Channel>(
            """
            {
              "id": "41771983423143937",
              "guild_id": "41771983423143937",
              "name": "general",
              "type": 0,
              "position": 6,
              "permission_overwrites": [],
              "rate_limit_per_user": 2,
              "nsfw": true,
              "topic": "24/7 chat about how to gank Mike #2",
              "last_message_id": "155117677105512449",
              "parent_id": "399942396007890945",
              "default_auto_archive_duration": 60
            }
            """.trimIndent(),
        )

        assertEquals("41771983423143937", channel.id.stringValue)
        assertEquals(ChannelType.GuildText, channel.type)
        assertEquals("general", channel.name)
        assertEquals(AutoArchiveDuration.OneHour, channel.defaultAutoArchiveDuration)
    }

    @Test
    fun decodeOfficialThreadChannelExample() {
        val channel = json.decodeFromString<Channel>(
            """
            {
              "id": "41771983423143937",
              "guild_id": "41771983423143937",
              "parent_id": "41771983423143937",
              "owner_id": "41771983423143937",
              "name": "don't buy dota-2",
              "type": 11,
              "last_message_id": "155117677105512449",
              "message_count": 1,
              "member_count": 5,
              "rate_limit_per_user": 2,
              "thread_metadata": {
                "archived": false,
                "auto_archive_duration": 1440,
                "archive_timestamp": "2021-04-12T23:40:39.855793+00:00",
                "locked": false
              },
              "total_message_sent": 1
            }
            """.trimIndent(),
        )

        assertEquals(ChannelType.PublicThread, channel.type)
        assertEquals(5, channel.memberCount)
        assertFalse(channel.threadMetadata?.archived ?: true)
        assertEquals(1, channel.totalMessageSent)
    }
}
