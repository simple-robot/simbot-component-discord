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
 * [Onboarding Prompt Structure](https://docs.discord.com/developers/resources/guild#guild-onboarding-object-onboarding-prompt-structure).
 *
 * Represents a question shown in onboarding or the Channels and Roles tab.
 *
 * @property id The prompt ID.
 * @property type The prompt display type.
 * @property options The selectable prompt options.
 * @property title The prompt title.
 * @property singleSelect Whether members may select only one option.
 * @property required Whether the prompt is required to complete onboarding.
 * @property inOnboarding Whether the prompt appears in the onboarding flow.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class OnboardingPrompt internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    @get:JvmExposeBoxed
    public val type: OnboardingPromptType,
    public val options: List<OnboardingPromptOption>,
    public val title: String,
    @SerialName("single_select")
    public val singleSelect: Boolean,
    public val required: Boolean,
    @SerialName("in_onboarding")
    public val inOnboarding: Boolean,
) {
    override fun toString(): String =
        "OnboardingPrompt(id=$id, type=$type, title=$title)"
}
