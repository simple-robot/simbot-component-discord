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
import love.forte.simbot.component.discord.model.emoji.Emoji
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Onboarding Prompt Option Structure](https://docs.discord.com/developers/resources/guild#guild-onboarding-object-prompt-option-structure).
 *
 * Represents one selectable onboarding answer and the channels or roles that
 * Discord assigns when a member chooses it.
 *
 * @property id The prompt option ID.
 * @property channelIds Channels selected for members choosing this option.
 * @property roleIds Roles assigned to members choosing this option.
 * @property emoji The response emoji object, when included.
 * @property emojiId The request-form custom emoji ID, when included.
 * @property emojiName The request-form custom name or Unicode emoji.
 * @property emojiAnimated Whether the request-form emoji is animated.
 * @property title The option title.
 * @property description The option description.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class OnboardingPromptOption internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    @SerialName("channel_ids")
    public val channelIds: List<DiscordId>,
    @SerialName("role_ids")
    public val roleIds: List<DiscordId>,
    public val emoji: Emoji? = null,
    @SerialName("emoji_id")
    @get:JvmExposeBoxed
    public val emojiId: DiscordId? = null,
    @SerialName("emoji_name")
    public val emojiName: String? = null,
    @SerialName("emoji_animated")
    public val emojiAnimated: Boolean? = null,
    public val title: String,
    public val description: String?,
) {
    override fun toString(): String =
        "OnboardingPromptOption(id=$id, title=$title)"
}
