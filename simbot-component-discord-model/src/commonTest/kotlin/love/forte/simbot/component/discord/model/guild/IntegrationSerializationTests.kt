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
 * Verifies the minimal bot-integration shape documented by Discord's
 * [Integration Object](https://docs.discord.com/developers/resources/guild#integration-object).
 * Discord does not currently publish a complete JSON example for this object.
 */
class IntegrationSerializationTests {
    @Test
    fun decodeMinimalDiscordBotIntegration() {
        val integration = Json.decodeFromString<Integration>(
            """
            {
              "id": "111",
              "name": "Example Bot",
              "type": "discord",
              "enabled": true,
              "account": {
                "id": "222",
                "name": "Example Account"
              },
              "application": {
                "id": "333",
                "name": "Example App",
                "icon": null,
                "description": "Example integration application"
              },
              "scopes": ["bot", "applications.commands"]
            }
            """.trimIndent(),
        )

        assertEquals("111", integration.id.stringValue)
        assertEquals("discord", integration.type)
        assertTrue(integration.enabled)
        assertEquals("Example Account", integration.account.name)
        assertEquals("333", integration.application?.id?.stringValue)
        assertNull(integration.syncing)
    }
}
