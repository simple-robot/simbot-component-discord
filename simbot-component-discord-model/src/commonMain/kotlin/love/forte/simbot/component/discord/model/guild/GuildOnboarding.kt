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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Guild Onboarding Object](https://docs.discord.com/developers/resources/guild#guild-onboarding-object).
 *
 * Represents the onboarding flow and default channels configured for a guild.
 *
 * @property guildId The guild that owns this onboarding configuration.
 * @property prompts The onboarding prompts.
 * @property defaultChannelIds Channels selected for every new member.
 * @property enabled Whether onboarding is enabled.
 * @property mode The onboarding constraint mode.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class GuildOnboarding internal constructor(
    @SerialName("guild_id")
    @get:JvmExposeBoxed
    public val guildId: DiscordId,
    public val prompts: List<OnboardingPrompt>,
    @SerialName("default_channel_ids")
    public val defaultChannelIds: List<DiscordId>,
    public val enabled: Boolean,
    @get:JvmExposeBoxed
    public val mode: OnboardingMode,
) {
    override fun toString(): String =
        "GuildOnboarding(guildId=$guildId, enabled=$enabled, mode=$mode)"
}
