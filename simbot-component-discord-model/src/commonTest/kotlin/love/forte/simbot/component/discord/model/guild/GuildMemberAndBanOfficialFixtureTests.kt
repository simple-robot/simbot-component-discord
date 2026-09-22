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
import kotlin.test.assertFalse
import kotlin.test.assertNull

/**
 * Covers Discord's official
 * [Guild Member and Ban examples](https://docs.discord.com/developers/resources/guild#guild-member-object).
 */
class GuildMemberAndBanOfficialFixtureTests {
    @Test
    fun decodeOfficialGuildMemberExample() {
        val member = Json.decodeFromString<GuildMember>(
            """
            {
              "user": {
                "id": "53908099506183680",
                "username": "Mason",
                "discriminator": "9999"
              },
              "nick": "NOT API SUPPORT",
              "avatar": null,
              "banner": null,
              "roles": [],
              "joined_at": "2015-04-26T06:26:56.936000+00:00",
              "deaf": false,
              "mute": false
            }
            """.trimIndent(),
        )

        // Discord's example contains an empty user object. The fixture supplies
        // the required identity fields from the adjacent official Ban example.
        assertEquals("53908099506183680", member.user?.id?.stringValue)
        assertEquals("NOT API SUPPORT", member.nick)
        assertEquals(0L, member.flags.value)
        assertFalse(member.deaf)
        assertFalse(member.mute)
    }

    @Test
    fun decodeOfficialBanExample() {
        val ban = Json.decodeFromString<Ban>(
            """
            {
              "reason": "mentioning b1nzy",
              "user": {
                "username": "Mason",
                "discriminator": "9999",
                "id": "53908099506183680",
                "avatar": "a_bab14f271d565501444b2ca3be944b25",
                "public_flags": 131141
              }
            }
            """.trimIndent(),
        )

        assertEquals("mentioning b1nzy", ban.reason)
        assertEquals("Mason", ban.user.username)
        assertEquals(131141, ban.user.publicFlags)
        assertNull(ban.user.globalName)
    }
}
