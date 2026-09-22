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

package love.forte.simbot.component.discord.model.application

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * Verifies the wire contract using Discord's
 * [Example Application Object](https://docs.discord.com/developers/resources/application#application-object).
 */
class ApplicationOfficialFixtureTests {
    private val json = Json

    @Test
    fun decodeOfficialApplicationExample() {
        val application = json.decodeFromString<Application>(
            """
            {
              "bot_public": true,
              "bot_require_code_grant": false,
              "cover_image": "31deabb7e45b6c8ecfef77d2f99c81a5",
              "description": "Test",
              "flags": 8192,
              "flags_new": "8192",
              "guild_id": "290926798626357260",
              "icon": null,
              "id": "172150183260323840",
              "integration_types_config": {
                "0": {
                  "oauth2_install_params": {
                    "scopes": ["applications.commands", "bot"],
                    "permissions": "2048"
                  }
                },
                "1": {
                  "oauth2_install_params": {
                    "scopes": ["applications.commands"],
                    "permissions": "0"
                  }
                }
              },
              "name": "Baba O-Riley",
              "interactions_endpoint_url": null,
              "role_connections_verification_url": null,
              "event_webhooks_url": null,
              "event_webhooks_status": 1,
              "owner": {
                "avatar": null,
                "discriminator": "1738",
                "flags": 1024,
                "id": "172150183260323840",
                "username": "i own a bot"
              },
              "primary_sku_id": "172150183260323840",
              "slug": "test",
              "team": {
                "name": "A team",
                "icon": "dd9b7dcfdf5351b9c3de0fe167bacbe1",
                "id": "531992624043786253",
                "owner_user_id": "511972282709709995",
                "members": [
                  {
                    "membership_state": 2,
                    "permissions": ["*"],
                    "team_id": "531992624043786253",
                    "role": "owner",
                    "user": {
                      "avatar": "d9e261cd35999608eb7e3de1fae3688b",
                      "discriminator": "0001",
                      "id": "511972282709709995",
                      "username": "Mr Owner"
                    }
                  }
                ]
              },
              "verify_key": "1e0a356058d627ca38a5c8c9648818061d49e49bd9da9e3ab17d98ad4d6bg2u8"
            }
            """.trimIndent(),
        )

        // Discord's Application example predates the documented team role field.
        // The fixture adds only that field and otherwise keeps the official payload.
        assertEquals("172150183260323840", application.id.stringValue)
        assertEquals("Baba O-Riley", application.name)
        assertNull(application.icon)
        assertEquals("i own a bot", application.owner?.username)
        assertEquals("owner", application.team?.members?.single()?.role)
        assertEquals(
            "2048",
            application.integrationTypesConfig
                ?.get("0")
                ?.oauth2InstallParams
                ?.permissions,
        )
        assertEquals(1, application.eventWebhooksStatus?.value)
    }
}
