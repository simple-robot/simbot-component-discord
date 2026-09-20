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

package love.forte.simbot.component.discord.api.channel;

import kotlin.jvm.JvmExposeBoxed

/**
 * A known [channel flag](https://docs.discord.com/developers/resources/channel#channel-object-channel-flags).
 *
 * @property flag The bit represented by this channel flag.
 *
 * @author Forte Scarlet
 */
@OptIn(ExperimentalStdlibApi::class)
public enum class ChannelFlag(
    @get:JvmExposeBoxed
    public val flag: ChannelFlags
) {
    /**
     * This thread is pinned to the top of its parent GUILD_FORUM
     * or GUILD_MEDIA channel.
     */
    PINNED(ChannelFlags.of(1L shl 1)),

    /**
     * Whether a tag is required to be specified when creating a thread
     * in a GUILD_FORUM or GUILD_MEDIA channel.
     */
    REQUIRE_TAG(ChannelFlags.of(1L shl 4)),

    /**
     * Hides embedded media download options.
     *
     * Available only for media channels.
     */
    HIDE_MEDIA_DOWNLOAD_OPTIONS(ChannelFlags.of(1L shl 15)),

    /**
     * The channel's metadata has been obfuscated because the current
     * user cannot view it.
     *
     * This flag is only set on channels received over Gateway.
     */
    CHANNEL_OBFUSCATED(ChannelFlags.of(1L shl 17)),

    /**
     * This channel is a Spoiler Channel and users must opt in to view
     * its contents.
     */
    IS_SPOILER_CHANNEL(ChannelFlags.of(1L shl 21));

    /**
     * The [Long] value of [flag].
     */
    public val flagValue: Long
        get() = flag.value
}
