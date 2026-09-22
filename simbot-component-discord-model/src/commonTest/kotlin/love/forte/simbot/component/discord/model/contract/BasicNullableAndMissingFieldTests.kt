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
import love.forte.simbot.component.discord.model.application.Application
import love.forte.simbot.component.discord.model.channel.Channel
import love.forte.simbot.component.discord.model.guild.GuildPreview
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

/**
 * Verifies the distinction between optional nullable fields and required fields
 * in common Discord resource objects.
 */
class BasicNullableAndMissingFieldTests {
    private val json = Json

    @Test
    fun optionalNullableChannelNameAcceptsMissingAndNull() {
        val missing = json.decodeFromString<Channel>(
            """{"id":"1","type":0}""",
        )
        val explicitNull = json.decodeFromString<Channel>(
            """{"id":"1","type":0,"name":null}""",
        )

        assertNull(missing.name)
        assertNull(explicitNull.name)
    }

    @Test
    fun requiredApplicationNameRejectsMissingField() {
        assertFailsWith<SerializationException> {
            json.decodeFromString<Application>(
                """
                {
                  "id": "1",
                  "icon": null,
                  "description": "example",
                  "bot_public": true,
                  "bot_require_code_grant": false,
                  "verify_key": "key",
                  "team": null
                }
                """.trimIndent(),
            )
        }
    }

    @Test
    fun requiredNullableGuildPreviewIconAcceptsNullButRejectsMissing() {
        val withNull = json.decodeFromString<GuildPreview>(guildPreviewWithIconNull)
        assertNull(withNull.icon)

        assertFailsWith<SerializationException> {
            json.decodeFromString<GuildPreview>(guildPreviewWithoutIcon)
        }
    }

    private companion object {
        private val guildPreviewWithIconNull = guildPreviewFields(
            iconField = "\"icon\": null,",
        )

        private val guildPreviewWithoutIcon = guildPreviewFields(iconField = "")

        private fun guildPreviewFields(iconField: String): String =
            """
            {
              "id": "1",
              "name": "Preview",
              $iconField
              "splash": null,
              "discovery_splash": null,
              "emojis": [],
              "features": [],
              "approximate_member_count": 1,
              "approximate_presence_count": 0,
              "description": null,
              "stickers": []
            }
            """.trimIndent()
    }
}
