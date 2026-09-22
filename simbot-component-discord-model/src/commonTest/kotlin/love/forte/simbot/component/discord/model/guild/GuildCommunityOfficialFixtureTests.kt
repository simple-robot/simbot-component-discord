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
 * Covers top-level Community guild objects using examples from Discord's
 * [Guild Resource](https://docs.discord.com/developers/resources/guild).
 */
class GuildCommunityOfficialFixtureTests {
    @Test
    fun decodeOfficialWelcomeScreenExample() {
        val welcomeScreen = Json.decodeFromString<WelcomeScreen>(
            """
            {
              "description": "$officialWelcomeDescription",
              "welcome_channels": [
                {
                  "channel_id": "697138785317814292",
                  "description": "Follow for official Discord API updates",
                  "emoji_id": null,
                  "emoji_name": "📡"
                }
              ]
            }
            """.trimIndent(),
        )

        // The official example has five structurally identical channel entries;
        // one entry is sufficient to verify the nested wire contract.
        assertTrue(welcomeScreen.description!!.startsWith("Discord Developers"))
        assertEquals(1, welcomeScreen.welcomeChannels.size)
        assertEquals("📡", welcomeScreen.welcomeChannels.single().emojiName)
    }

    @Test
    fun decodeOfficialGuildOnboardingExample() {
        val onboarding = Json.decodeFromString<GuildOnboarding>(
            """
            {
              "guild_id": "960007075288915998",
              "prompts": [
                {
                  "id": "1067461047608422473",
                  "title": "What do you want to do in this community?",
                  "options": [
                    {
                      "id": "1067461047608422476",
                      "title": "Chat with Friends",
                      "description": "",
                      "emoji": {
                        "id": "1070002302032826408",
                        "name": "chat",
                        "animated": false
                      },
                      "role_ids": [],
                      "channel_ids": ["962007075288916001"]
                    }
                  ],
                  "single_select": false,
                  "required": false,
                  "in_onboarding": true,
                  "type": 0
                }
              ],
              "default_channel_ids": ["998678771706110023"],
              "enabled": true,
              "mode": 1
            }
            """.trimIndent(),
        )

        // The official example omits the documented required mode field and
        // contains additional repeated options and default channel IDs.
        assertEquals("960007075288915998", onboarding.guildId.stringValue)
        assertEquals(OnboardingMode.Advanced, onboarding.mode)
        assertEquals("Chat with Friends", onboarding.prompts.single().options.single().title)
        assertTrue(onboarding.enabled)
    }

    @Test
    fun decodeOfficialIncidentsDataExample() {
        val incidents = Json.decodeFromString<IncidentsData>(
            """
            {
              "invites_disabled_until": "2023-09-01T14:48:02.222000+00:00",
              "dms_disabled_until": null
            }
            """.trimIndent(),
        )

        assertEquals(1693579682, incidents.invitesDisabledUntil?.epochSeconds)
        assertNull(incidents.dmsDisabledUntil)
        assertNull(incidents.raidDetectedAt)
    }

    private companion object {
        private const val officialWelcomeDescription =
            "Discord Developers is a place to learn about Discord's API, " +
                "bots, and SDKs and integrations. This is NOT a general " +
                "Discord support server."
    }
}
