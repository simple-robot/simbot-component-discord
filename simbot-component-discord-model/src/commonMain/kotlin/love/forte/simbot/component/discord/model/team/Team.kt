/*
 * Copyright (c) 2024. ForteScarlet.
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

package love.forte.simbot.component.discord.model.team

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Team Object](https://docs.discord.com/developers/topics/teams#data-models-team-object).
 *
 * Represents a Developer Portal team that can own Discord applications.
 *
 * @property icon The team's icon hash, when set.
 * @property id The team's Discord ID.
 * @property members The members of the team.
 * @property name The team's name.
 * @property ownerUserId The Discord ID of the team's owner.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class Team internal constructor(
    public val icon: String? = null,
    @get:JvmExposeBoxed
    public val id: DiscordId,
    public val members: List<TeamMember>,
    public val name: String,
    @SerialName("owner_user_id")
    @get:JvmExposeBoxed
    public val ownerUserId: DiscordId,
) {
    override fun toString(): String =
        "Team(id=$id, name=$name, ownerUserId=$ownerUserId)"
}

