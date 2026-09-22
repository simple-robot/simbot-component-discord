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

package love.forte.simbot.component.discord.model.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [User Object](https://docs.discord.com/developers/resources/user#user-object).
 *
 * Represents a Discord account; optional fields depend on the request context
 * and granted OAuth2 scopes.
 *
 * @property id The user's Discord ID.
 * @property username The user's non-unique username.
 * @property discriminator The user's legacy Discord tag discriminator.
 * @property globalName The user's display name, when set.
 * @property avatar The user's avatar hash, when set.
 * @property bot Whether the user belongs to an OAuth2 application.
 * @property system Whether the user is an official Discord system user.
 * @property mfaEnabled Whether the user has two-factor authentication enabled.
 * @property banner The user's banner hash, when set.
 * @property accentColor The user's banner color as an integer.
 * @property locale The user's selected locale.
 * @property verified Whether the user's email address is verified.
 * @property email The user's email address, when available.
 * @property flags The user's account flags.
 * @property premiumType The user's Nitro subscription type.
 * @property publicFlags The user's public account flags.
 * @property avatarDecorationData Data for the user's avatar decoration.
 * @property collectibles Data for the user's collectibles.
 * @property primaryGuild The user's primary guild identity data.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class User internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    public val username: String,
    public val discriminator: String,
    @SerialName("global_name")
    public val globalName: String? = null,
    public val avatar: String? = null,
    public val bot: Boolean? = null,
    public val system: Boolean? = null,
    @SerialName("mfa_enabled")
    public val mfaEnabled: Boolean? = null,
    public val banner: String? = null,
    @SerialName("accent_color")
    public val accentColor: Int? = null,
    public val locale: String? = null,
    public val verified: Boolean? = null,
    public val email: String? = null,
    public val flags: Int? = null,
    @SerialName("premium_type")
    @get:JvmExposeBoxed
    public val premiumType: UserPremiumType? = null,
    @SerialName("public_flags")
    public val publicFlags: Int? = null,
    @SerialName("avatar_decoration_data")
    public val avatarDecorationData: AvatarDecorationData? = null,
    public val collectibles: Collectibles? = null,
    @SerialName("primary_guild")
    public val primaryGuild: UserPrimaryGuild? = null,
) {
    override fun toString(): String =
        "User(id=$id, username=$username)"
}

