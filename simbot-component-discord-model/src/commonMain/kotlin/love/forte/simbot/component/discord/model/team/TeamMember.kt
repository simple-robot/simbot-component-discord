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

package love.forte.simbot.component.discord.model.team

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.model.user.User
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Team Member Object](https://docs.discord.com/developers/topics/teams#data-models-team-member-object).
 *
 * Represents a user and their membership details in a Developer Portal team.
 *
 * @property membershipState The member's invitation state.
 * @property teamId The Discord ID of the team.
 * @property user The team member's user object.
 * @property role The member's team role.
 * @property permissions The member's permissions, when included by Discord.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class TeamMember internal constructor(
    @SerialName("membership_state")
    @get:JvmExposeBoxed
    public val membershipState: TeamMembershipState,
    @SerialName("team_id")
    @get:JvmExposeBoxed
    public val teamId: DiscordId,
    public val user: User,
    public val role: String,
    public val permissions: List<String>? = null,
) {
    override fun toString(): String =
        "TeamMember(teamId=$teamId, userId=${user.id}, role=$role)"
}
