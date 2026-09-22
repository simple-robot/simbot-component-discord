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

/**
 * [Welcome Screen Object](https://docs.discord.com/developers/resources/guild#welcome-screen-object).
 *
 * Describes the welcome screen shown to new members of a Community guild.
 *
 * @property description The server description shown on the welcome screen.
 * @property welcomeChannels The promoted channels shown on the welcome screen.
 */
@Serializable
public class WelcomeScreen internal constructor(
    public val description: String?,
    @SerialName("welcome_channels")
    public val welcomeChannels: List<WelcomeScreenChannel>,
) {
    override fun toString(): String =
        "WelcomeScreen(description=$description, welcomeChannels=$welcomeChannels)"
}
