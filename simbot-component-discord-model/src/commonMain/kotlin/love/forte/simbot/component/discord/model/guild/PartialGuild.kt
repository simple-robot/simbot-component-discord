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
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Guild Object](https://docs.discord.com/developers/resources/guild#guild-object).
 *
 * A minimal guild representation used where Discord explicitly returns a
 * partial guild object, such as an application's associated support guild.
 *
 * @property id The guild ID.
 * @property name The guild name, when included.
 * @property icon The guild icon hash, when included.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class PartialGuild internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    public val name: String? = null,
    public val icon: String? = null,
) {
    override fun toString(): String = "PartialGuild(id=$id, name=$name)"
}
