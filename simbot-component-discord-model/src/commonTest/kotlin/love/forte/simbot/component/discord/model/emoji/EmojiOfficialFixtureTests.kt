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

package love.forte.simbot.component.discord.model.emoji

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * Uses Discord's custom and standard
 * [Emoji examples](https://docs.discord.com/developers/resources/emoji#emoji-object).
 */
class EmojiOfficialFixtureTests {
    private val json = Json

    @Test
    fun decodeOfficialCustomEmojiExample() {
        val emoji = json.decodeFromString<Emoji>(
            """
            {
              "id": "41771983429993937",
              "name": "LUL",
              "roles": ["41771983429993000", "41771983429993111"],
              "user": {
                "username": "Luigi",
                "discriminator": "0002",
                "id": "96008815106887111",
                "avatar": "5500909a3274e1812beb4e8de6631111",
                "public_flags": 131328
              },
              "require_colons": true,
              "managed": false,
              "animated": false
            }
            """.trimIndent(),
        )

        assertEquals("41771983429993937", emoji.id?.stringValue)
        assertEquals("LUL", emoji.name)
        assertEquals(2, emoji.roles?.size)
        assertEquals("Luigi", emoji.user?.username)
    }

    @Test
    fun decodeOfficialStandardEmojiExample() {
        val emoji = json.decodeFromString<Emoji>(
            """{"id":null,"name":"🔥"}""",
        )

        assertNull(emoji.id)
        assertEquals("🔥", emoji.name)
    }
}
