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
import love.forte.simbot.component.discord.model.event.GuildScheduledEventEntityType
import love.forte.simbot.component.discord.model.event.GuildScheduledEventPrivacyLevel
import love.forte.simbot.component.discord.model.event.GuildScheduledEventStatus
import love.forte.simbot.component.discord.model.event.RecurrenceRuleFrequency
import love.forte.simbot.component.discord.model.event.RecurrenceRuleMonth
import love.forte.simbot.component.discord.model.event.RecurrenceRuleWeekday
import love.forte.simbot.component.discord.model.guild.DefaultMessageNotificationLevel
import love.forte.simbot.component.discord.model.guild.ExplicitContentFilterLevel
import love.forte.simbot.component.discord.model.guild.GuildFeature
import love.forte.simbot.component.discord.model.guild.GuildMemberFlags
import love.forte.simbot.component.discord.model.guild.GuildNsfwLevel
import love.forte.simbot.component.discord.model.guild.IntegrationExpireBehavior
import love.forte.simbot.component.discord.model.guild.MfaLevel
import love.forte.simbot.component.discord.model.guild.OnboardingMode
import love.forte.simbot.component.discord.model.guild.OnboardingPromptType
import love.forte.simbot.component.discord.model.guild.PremiumTier
import love.forte.simbot.component.discord.model.guild.RoleFlags
import love.forte.simbot.component.discord.model.guild.SystemChannelFlags
import love.forte.simbot.component.discord.model.guild.VerificationLevel
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Covers open guild and scheduled-event values, including unknown feature
 * names and flag bits that Discord may add without a versioned schema change.
 */
class GuildAndEventUnknownValueTests {
    @Test
    fun unknownGuildIntegerValuesArePreserved() {
        assertUnknownInt { Json.decodeFromString<DefaultMessageNotificationLevel>(it).value }
        assertUnknownInt { Json.decodeFromString<ExplicitContentFilterLevel>(it).value }
        assertUnknownInt { Json.decodeFromString<GuildNsfwLevel>(it).value }
        assertUnknownInt { Json.decodeFromString<IntegrationExpireBehavior>(it).value }
        assertUnknownInt { Json.decodeFromString<MfaLevel>(it).value }
        assertUnknownInt { Json.decodeFromString<OnboardingMode>(it).value }
        assertUnknownInt { Json.decodeFromString<OnboardingPromptType>(it).value }
        assertUnknownInt { Json.decodeFromString<PremiumTier>(it).value }
        assertUnknownInt { Json.decodeFromString<VerificationLevel>(it).value }
    }

    @Test
    fun unknownScheduledEventValuesArePreserved() {
        assertUnknownInt { Json.decodeFromString<GuildScheduledEventEntityType>(it).value }
        assertUnknownInt { Json.decodeFromString<GuildScheduledEventPrivacyLevel>(it).value }
        assertUnknownInt { Json.decodeFromString<GuildScheduledEventStatus>(it).value }
        assertUnknownInt { Json.decodeFromString<RecurrenceRuleFrequency>(it).value }
        assertUnknownInt { Json.decodeFromString<RecurrenceRuleMonth>(it).value }
        assertUnknownInt { Json.decodeFromString<RecurrenceRuleWeekday>(it).value }
    }

    @Test
    fun unknownGuildFeatureNameIsPreserved() {
        val feature = Json.decodeFromString<GuildFeature>("\"FUTURE_FEATURE\"")

        assertEquals("FUTURE_FEATURE", feature.value)
    }

    @Test
    fun unknownGuildFlagBitsArePreserved() {
        assertUnknownLong { Json.decodeFromString<GuildMemberFlags>(it).value }
        assertUnknownLong { Json.decodeFromString<RoleFlags>(it).value }
        assertUnknownLong { Json.decodeFromString<SystemChannelFlags>(it).value }
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
