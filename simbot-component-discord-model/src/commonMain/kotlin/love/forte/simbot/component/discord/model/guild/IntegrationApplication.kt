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

import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.model.user.User
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Integration Application Object](https://docs.discord.com/developers/resources/guild#integration-application-object).
 *
 * Represents the partial application attached to a Discord guild integration.
 *
 * @property id The application ID.
 * @property name The application name.
 * @property icon The application icon hash.
 * @property description The application description.
 * @property bot The bot user associated with the application.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class IntegrationApplication internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    public val name: String,
    public val icon: String?,
    public val description: String,
    public val bot: User? = null,
) {
    override fun toString(): String = "IntegrationApplication(id=$id, name=$name)"
}
