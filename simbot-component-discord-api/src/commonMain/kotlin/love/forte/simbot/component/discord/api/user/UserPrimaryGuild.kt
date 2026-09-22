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

package love.forte.simbot.component.discord.api.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [User Primary Guild](https://docs.discord.com/developers/resources/user#user-object-user-primary-guild).
 *
 * Contains the identity settings for a user's selected primary guild.
 *
 * @property identityGuildId The guild used for the user's primary identity.
 * @property identityEnabled Whether the primary identity is enabled.
 * @property tag The primary guild tag, when configured.
 * @property badge The primary guild badge, when configured.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class UserPrimaryGuild internal constructor(
    @SerialName("identity_guild_id")
    @get:JvmExposeBoxed
    public val identityGuildId: DiscordId? = null,
    @SerialName("identity_enabled")
    public val identityEnabled: Boolean? = null,
    public val tag: String? = null,
    public val badge: String? = null,
) {
    override fun toString(): String =
        "UserPrimaryGuild(identityGuildId=$identityGuildId, tag=$tag)"
}
