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

import kotlinx.serialization.json.Json
import love.forte.simbot.component.discord.model.application.ApplicationEventWebhookStatus
import love.forte.simbot.component.discord.model.application.ApplicationIntegrationType
import love.forte.simbot.component.discord.model.channel.AutoArchiveDuration
import love.forte.simbot.component.discord.model.channel.ChannelFlags
import love.forte.simbot.component.discord.model.channel.ChannelType
import love.forte.simbot.component.discord.model.channel.ForumLayoutType
import love.forte.simbot.component.discord.model.channel.PermissionOverwriteType
import love.forte.simbot.component.discord.model.channel.SortOrderType
import love.forte.simbot.component.discord.model.channel.VideoQualityMode
import love.forte.simbot.component.discord.model.permission.Permissions
import love.forte.simbot.component.discord.model.stage.StagePrivacyLevel
import love.forte.simbot.component.discord.model.sticker.StickerFormatType
import love.forte.simbot.component.discord.model.sticker.StickerType
import love.forte.simbot.component.discord.model.team.TeamMembershipState
import love.forte.simbot.component.discord.model.user.UserPremiumType
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Ensures resource value wrappers retain values introduced by future Discord
 * API versions instead of failing like closed Kotlin enums would.
 */
class ResourceUnknownValueTests {
    @Test
    fun unknownIntegerResourceValuesArePreserved() {
        assertUnknownInt { Json.decodeFromString<ApplicationEventWebhookStatus>(it).value }
        assertUnknownInt { Json.decodeFromString<ApplicationIntegrationType>(it).value }
        assertUnknownInt { Json.decodeFromString<TeamMembershipState>(it).value }
        assertUnknownInt { Json.decodeFromString<UserPremiumType>(it).value }

        assertUnknownInt { Json.decodeFromString<AutoArchiveDuration>(it).value }
        assertUnknownInt { Json.decodeFromString<ChannelType>(it).value }
        assertUnknownInt { Json.decodeFromString<ForumLayoutType>(it).value }
        assertUnknownInt { Json.decodeFromString<PermissionOverwriteType>(it).value }
        assertUnknownInt { Json.decodeFromString<SortOrderType>(it).value }
        assertUnknownInt { Json.decodeFromString<VideoQualityMode>(it).value }

        assertUnknownInt { Json.decodeFromString<StickerType>(it).value }
        assertUnknownInt { Json.decodeFromString<StickerFormatType>(it).value }
        assertUnknownInt { Json.decodeFromString<StagePrivacyLevel>(it).value }
    }

    @Test
    fun unknownResourceFlagBitsArePreserved() {
        assertUnknownLong { Json.decodeFromString<ChannelFlags>(it).value }

        // Discord permissions are encoded as decimal strings to avoid numeric
        // precision loss on JavaScript targets.
        val permissions = Json.decodeFromString<Permissions>("\"$UNKNOWN_LONG\"")
        assertEquals(UNKNOWN_LONG, permissions.value)
    }

    private companion object {
        private const val UNKNOWN_INT: Int = 999
        private const val UNKNOWN_LONG: Long = 1L shl 60

        private fun assertUnknownInt(decodeValue: (String) -> Int) {
            assertEquals(UNKNOWN_INT, decodeValue(UNKNOWN_INT.toString()))
        }

        private fun assertUnknownLong(decodeValue: (String) -> Long) {
            assertEquals(UNKNOWN_LONG, decodeValue(UNKNOWN_LONG.toString()))
        }
    }
}
