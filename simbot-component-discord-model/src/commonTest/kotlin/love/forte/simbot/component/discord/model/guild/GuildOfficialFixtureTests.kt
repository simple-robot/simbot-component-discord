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

package love.forte.simbot.component.discord.model.guild

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Covers compact top-level guild payloads published in Discord's
 * [Guild Resource](https://docs.discord.com/developers/resources/guild).
 */
class GuildOfficialFixtureTests {
    private val json = Json

    @Test
    fun decodeOfficialGuildPreviewExample() {
        val preview = json.decodeFromString<GuildPreview>(
            """
            {
              "id": "197038439483310086",
              "name": "Discord Testers",
              "icon": "f64c482b807da4f539cff778d174971c",
              "splash": null,
              "discovery_splash": null,
              "emojis": [],
              "features": [
                "DISCOVERABLE",
                "VANITY_URL",
                "ANIMATED_ICON",
                "INVITE_SPLASH",
                "NEWS",
                "COMMUNITY",
                "BANNER",
                "VERIFIED",
                "MORE_EMOJI"
              ],
              "approximate_member_count": 60814,
              "approximate_presence_count": 20034,
              "description": "The official place to report Discord Bugs!",
              "stickers": []
            }
            """.trimIndent(),
        )

        assertEquals("Discord Testers", preview.name)
        assertNull(preview.splash)
        assertEquals(60814, preview.approximateMemberCount)
        assertTrue(GuildFeature.Community in preview.features)
        assertEquals(GuildFeature.of("MORE_EMOJI"), preview.features.last())
    }

    @Test
    fun decodeOfficialUnavailableGuildExample() {
        val guild = json.decodeFromString<UnavailableGuild>(
            """{"id":"41771983423143937","unavailable":true}""",
        )

        assertEquals("41771983423143937", guild.id.stringValue)
        assertEquals(true, guild.unavailable)
    }
}
