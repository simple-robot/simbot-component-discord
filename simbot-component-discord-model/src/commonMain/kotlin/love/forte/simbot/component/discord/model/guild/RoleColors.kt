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
 * [Role Colors Object](https://docs.discord.com/developers/topics/permissions#role-object-role-colors-object).
 *
 * Describes a role's primary color and optional gradient or holographic colors.
 *
 * @property primaryColor The role's primary color.
 * @property secondaryColor The optional secondary gradient color.
 * @property tertiaryColor The optional tertiary holographic color.
 */
@Serializable
public class RoleColors internal constructor(
    @SerialName("primary_color")
    public val primaryColor: Int,
    @SerialName("secondary_color")
    public val secondaryColor: Int?,
    @SerialName("tertiary_color")
    public val tertiaryColor: Int?,
) {
    override fun toString(): String =
        "RoleColors(primaryColor=$primaryColor, secondaryColor=$secondaryColor, " +
            "tertiaryColor=$tertiaryColor)"
}
