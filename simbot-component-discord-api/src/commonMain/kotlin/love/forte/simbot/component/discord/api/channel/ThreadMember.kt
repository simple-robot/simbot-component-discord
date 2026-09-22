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

package love.forte.simbot.component.discord.api.channel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed
import kotlin.time.Instant

/**
 * [Thread Member Object](https://docs.discord.com/developers/resources/channel#thread-member-object).
 *
 * Represents a user's membership in a thread; IDs may be omitted by some
 * Gateway events.
 *
 * @property id The thread's Discord ID, when included by Discord.
 * @property userId The member's Discord ID, when included by Discord.
 * @property joinTimestamp When the user joined the thread.
 * @property flags Thread member flags.
 * @property member The associated guild member payload, when included.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class ThreadMember internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId? = null,
    @SerialName("user_id")
    @get:JvmExposeBoxed
    public val userId: DiscordId? = null,
    @SerialName("join_timestamp")
    public val joinTimestamp: Instant,
    public val flags: Int,
    // TODO：这里的 member 是 Guild Member，而当前仓库还没有 Guild/Member 模型；先保留原始对象，避免丢失数据。
    public val member: JsonObject? = null,
) {
    override fun toString(): String =
        "ThreadMember(id=$id, userId=$userId, joinTimestamp=$joinTimestamp)"
}
