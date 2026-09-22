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

package love.forte.simbot.component.discord.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import love.forte.simbot.component.discord.model.application.Application
import love.forte.simbot.component.discord.model.channel.Channel
import love.forte.simbot.component.discord.model.guild.Guild
import love.forte.simbot.component.discord.model.guild.GuildFeature
import love.forte.simbot.component.discord.model.guild.SystemChannelFlag
import love.forte.simbot.component.discord.model.permission.Permissions
import love.forte.simbot.component.discord.common.DiscordId
import love.forte.simbot.component.discord.common.toDiscordSnowflake
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ModelSerializationTests {
    private val json = Json {
        ignoreUnknownKeys = false
    }

    @Test
    fun snowflakeUsesDiscordStringRepresentation() {
        @Serializable
        data class SnowflakeHolder(val id: DiscordId)

        val encoded = json.encodeToString(SnowflakeHolder(123456789012345678UL.toDiscordSnowflake()))
        assertEquals("{\"id\":\"123456789012345678\"}", encoded)
        assertEquals(
            123456789012345678UL,
            json.decodeFromString<SnowflakeHolder>(encoded).id.value,
        )
    }

    @Test
    fun applicationContainsCurrentNestedModels() {
        val application = json.decodeFromString<Application>(
            """
            {
              "id": "100",
              "name": "example",
              "description": "An example app",
              "bot_public": true,
              "bot_require_code_grant": false,
              "verify_key": "key",
              "bot": {
                "id": "101",
                "username": "example-bot",
                "discriminator": "0001"
              },
              "team": {
                "id": "102",
                "name": "example-team",
                "owner_user_id": "101",
                "members": [
                  {
                    "membership_state": 2,
                    "team_id": "102",
                    "user": {
                      "id": "101",
                      "username": "example-bot",
                      "discriminator": "0001"
                    },
                    "role": "developer",
                    "permissions": ["*"]
                  }
                ]
              },
              "guild": {"id": "103", "name": "support"},
              "flags": 8192,
              "flags_new": "8192",
              "event_webhooks_status": 2,
              "integration_types_config": {
                "0": {
                  "oauth2_install_params": {
                    "scopes": ["applications.commands", "bot"],
                    "permissions": "2048"
                  }
                }
              }
            }
            """.trimIndent(),
        )

        assertEquals("100", application.id.stringValue)
        assertEquals("example-bot", application.bot?.username)
        assertEquals("developer", application.team?.members?.single()?.role)
        assertEquals("support", application.guild?.name)
        assertEquals("8192", application.flagsNew)
        assertEquals(2, application.eventWebhooksStatus?.value)
        assertEquals(
            "2048",
            application.integrationTypesConfig?.get("0")?.oauth2InstallParams?.permissions,
        )
    }

    @Test
    fun channelContainsNestedWireModels() {
        val channel = json.decodeFromString<Channel>(
            """
            {
              "id": "200",
              "type": 15,
              "permission_overwrites": [
                {"id": "201", "type": 0, "allow": "1024", "deny": "0"}
              ],
              "recipients": [
                {"id": "202", "username": "user", "discriminator": "0001"}
              ],
              "thread_metadata": {
                "archived": false,
                "auto_archive_duration": 1440,
                "archive_timestamp": "2026-09-22T00:00:00Z",
                "locked": false
              },
              "member": {
                "id": "200",
                "user_id": "202",
                "join_timestamp": "2026-09-22T00:00:00Z",
                "flags": 0,
                "member": {
                  "nick": "user",
                  "roles": [],
                  "joined_at": "2026-09-21T00:00:00Z",
                  "deaf": false,
                  "mute": false,
                  "flags": 0
                }
              },
              "available_tags": [
                {"id": "203", "name": "help", "moderated": false}
              ],
              "default_reaction_emoji": {"emoji_name": "✅"}
            }
            """.trimIndent(),
        )

        assertEquals("200", channel.id.stringValue)
        assertEquals("201", channel.permissionOverwrites?.single()?.id?.stringValue)
        assertEquals(true, channel.permissionOverwrites?.single()?.allow?.contains(Permissions.of(1024)))
        assertEquals("user", channel.recipients?.single()?.username)
        assertNotNull(channel.threadMetadata)
        assertEquals("help", channel.availableTags?.single()?.name)
        assertEquals("✅", channel.defaultReactionEmoji?.emojiName)
    }

    @Test
    fun guildContainsCurrentNestedModelsAndPreservesUnknownFeatures() {
        val guild = json.decodeFromString<Guild>(
            """
            {
              "id": "300",
              "name": "example-guild",
              "icon": null,
              "splash": null,
              "discovery_splash": null,
              "owner_id": "301",
              "afk_channel_id": null,
              "afk_timeout": 300,
              "verification_level": 1,
              "default_message_notifications": 0,
              "explicit_content_filter": 2,
              "roles": [
                {
                  "id": "300",
                  "name": "@everyone",
                  "color": 0,
                  "colors": {
                    "primary_color": 0,
                    "secondary_color": null,
                    "tertiary_color": null
                  },
                  "hoist": false,
                  "position": 0,
                  "permissions": "1024",
                  "managed": false,
                  "mentionable": false,
                  "tags": {"premium_subscriber": null},
                  "flags": 0
                }
              ],
              "emojis": [{"id": null, "name": "✅"}],
              "features": ["COMMUNITY", "FUTURE_FEATURE"],
              "mfa_level": 1,
              "application_id": null,
              "system_channel_id": null,
              "system_channel_flags": 1,
              "rules_channel_id": null,
              "vanity_url_code": null,
              "description": null,
              "banner": null,
              "premium_tier": 2,
              "preferred_locale": "en-US",
              "public_updates_channel_id": null,
              "nsfw_level": 0,
              "premium_progress_bar_enabled": false,
              "safety_alerts_channel_id": null,
              "incidents_data": null
            }
            """.trimIndent(),
        )

        assertEquals("300", guild.id.stringValue)
        assertEquals("example-guild", guild.name)
        assertEquals(
            true,
            SystemChannelFlag.SUPPRESS_JOIN_NOTIFICATIONS.flag in guild.systemChannelFlags,
        )
        assertEquals(true, guild.roles.single().tags?.premiumSubscriber)
        assertEquals(Permissions.of(1024), guild.roles.single().permissions)
        assertEquals(GuildFeature.Community, guild.features.first())
        assertEquals(GuildFeature.of("FUTURE_FEATURE"), guild.features.last())
        assertEquals("Guild(id=300, name=example-guild, ownerId=301)", guild.toString())
    }
}
