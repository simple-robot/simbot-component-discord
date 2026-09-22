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
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Followed Channel Object](https://docs.discord.com/developers/resources/channel#followed-channel-object).
 *
 * Identifies the webhook created when an announcement channel is followed.
 *
 * @property channelId The followed channel's Discord ID.
 * @property webhookId The Discord ID of the following webhook.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class FollowedChannel internal constructor(
    @SerialName("channel_id")
    @get:JvmExposeBoxed
    public val channelId: DiscordId,
    @SerialName("webhook_id")
    @get:JvmExposeBoxed
    public val webhookId: DiscordId,
) {
    override fun toString(): String =
        "FollowedChannel(channelId=$channelId, webhookId=$webhookId)"
}
