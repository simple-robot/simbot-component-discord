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
import love.forte.simbot.component.discord.model.permission.Permissions
import love.forte.simbot.component.discord.model.user.AvatarDecorationData
import love.forte.simbot.component.discord.model.user.Collectibles
import love.forte.simbot.component.discord.model.user.User
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed
import kotlin.time.Instant

/**
 * [Guild Member Object](https://docs.discord.com/developers/resources/guild#guild-member-object).
 *
 * Represents a user's membership and guild-specific profile. The user field is
 * omitted in some message events, and joinedAt can be null for invited guests.
 *
 * @property user The user represented by this member, when included.
 * @property nick The user's guild nickname.
 * @property avatar The member's guild avatar hash.
 * @property banner The member's guild banner hash.
 * @property roles IDs of roles assigned to the member.
 * @property joinedAt When the user joined the guild.
 * @property premiumSince When the user started boosting the guild.
 * @property deaf Whether the member is server-deafened.
 * @property mute Whether the member is server-muted.
 * @property flags The member's guild-specific state flags.
 * @property pending Whether the member has not passed Membership Screening.
 * @property permissions The member's computed channel permissions, when included.
 * @property communicationDisabledUntil When the member's timeout expires.
 * @property avatarDecorationData The member's guild avatar decoration data.
 * @property collectibles The member's guild collectibles data.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class GuildMember internal constructor(
    public val user: User? = null,
    public val nick: String? = null,
    public val avatar: String? = null,
    public val banner: String? = null,
    public val roles: List<DiscordId>,
    @SerialName("joined_at")
    public val joinedAt: Instant?,
    @SerialName("premium_since")
    public val premiumSince: Instant? = null,
    public val deaf: Boolean,
    public val mute: Boolean,
    @get:JvmExposeBoxed
    public val flags: GuildMemberFlags = GuildMemberFlags.None,
    public val pending: Boolean? = null,
    @get:JvmExposeBoxed
    public val permissions: Permissions? = null,
    @SerialName("communication_disabled_until")
    public val communicationDisabledUntil: Instant? = null,
    @SerialName("avatar_decoration_data")
    public val avatarDecorationData: AvatarDecorationData? = null,
    public val collectibles: Collectibles? = null,
) {
    override fun toString(): String =
        "GuildMember(user=${user?.id}, nick=$nick, roles=${roles.size})"
}
