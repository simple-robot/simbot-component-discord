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

package love.forte.simbot.component.discord.model.channel

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Channel Types](https://docs.discord.com/developers/resources/channel#channel-object-channel-types).
 *
 * Represents the type of a Discord channel.
 *
 * Known values:
 *
 * - 0 = GUILD_TEXT
 * - 1 = DM
 * - 2 = GUILD_VOICE
 * - 3 = GROUP_DM
 * - 4 = GUILD_CATEGORY
 * - 5 = GUILD_ANNOUNCEMENT
 * - 10 = ANNOUNCEMENT_THREAD
 * - 11 = PUBLIC_THREAD
 * - 12 = PRIVATE_THREAD
 * - 13 = GUILD_STAGE_VOICE
 * - 14 = GUILD_DIRECTORY
 * - 15 = GUILD_FORUM
 * - 16 = GUILD_MEDIA
 *
 * @property value The raw Discord channel type value.
 *
 * @see Channel
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class ChannelType private constructor(public val value: Int) {
    public companion object {
        /**
         * GUILD_TEXT value constant. 
         */
        public const val GUILD_TEXT_VALUE: Int = 0

        /**
         * DM value constant. 
         */
        public const val DM_VALUE: Int = 1

        /**
         * GUILD_VOICE value constant. 
         */
        public const val GUILD_VOICE_VALUE: Int = 2

        /**
         * GROUP_DM value constant. 
         */
        public const val GROUP_DM_VALUE: Int = 3

        /**
         * GUILD_CATEGORY value constant. 
         */
        public const val GUILD_CATEGORY_VALUE: Int = 4

        /**
         * GUILD_ANNOUNCEMENT value constant. 
         */
        public const val GUILD_ANNOUNCEMENT_VALUE: Int = 5

        /**
         * ANNOUNCEMENT_THREAD value constant. 
         */
        public const val ANNOUNCEMENT_THREAD_VALUE: Int = 10

        /**
         * PUBLIC_THREAD value constant. 
         */
        public const val PUBLIC_THREAD_VALUE: Int = 11

        /**
         * PRIVATE_THREAD value constant. 
         */
        public const val PRIVATE_THREAD_VALUE: Int = 12

        /**
         * GUILD_STAGE_VOICE value constant. 
         */
        public const val GUILD_STAGE_VOICE_VALUE: Int = 13

        /**
         * GUILD_DIRECTORY value constant. 
         */
        public const val GUILD_DIRECTORY_VALUE: Int = 14

        /**
         * GUILD_FORUM value constant. 
         */
        public const val GUILD_FORUM_VALUE: Int = 15

        /**
         * GUILD_MEDIA value constant. 
         */
        public const val GUILD_MEDIA_VALUE: Int = 16

        /**
         * A text channel within a guild. 
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildText: ChannelType = ChannelType(GUILD_TEXT_VALUE)

        /**
         * A direct message between users. 
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Dm: ChannelType = ChannelType(DM_VALUE)

        /**
         * A voice channel within a guild. 
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildVoice: ChannelType = ChannelType(GUILD_VOICE_VALUE)

        /**
         * A direct message between multiple users. 
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GroupDm: ChannelType = ChannelType(GROUP_DM_VALUE)

        /**
         * An organizational category that contains channels. 
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildCategory: ChannelType = ChannelType(GUILD_CATEGORY_VALUE)

        /**
         * A channel that users can follow and crosspost into their own guild.
         *
         * Formerly known as a news channel.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildAnnouncement: ChannelType = ChannelType(GUILD_ANNOUNCEMENT_VALUE)

        /**
         * A temporary sub-channel within a GUILD_ANNOUNCEMENT channel.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val AnnouncementThread: ChannelType = ChannelType(ANNOUNCEMENT_THREAD_VALUE)

        /**
         * A temporary sub-channel within a GUILD_TEXT or GUILD_FORUM channel.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val PublicThread: ChannelType = ChannelType(PUBLIC_THREAD_VALUE)

        /**
         * A temporary sub-channel within a GUILD_TEXT channel that is only
         * viewable by invited users and users with the MANAGE_THREADS permission.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val PrivateThread: ChannelType = ChannelType(PRIVATE_THREAD_VALUE)

        /**
         * A voice channel for hosting events with an audience.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildStageVoice: ChannelType = ChannelType(GUILD_STAGE_VOICE_VALUE)

        /**
         * A channel in a hub containing listed guilds.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildDirectory: ChannelType = ChannelType(GUILD_DIRECTORY_VALUE)

        /**
         * A channel that can only contain threads.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildForum: ChannelType = ChannelType(GUILD_FORUM_VALUE)

        /**
         * A channel that can only contain threads, similar to a GUILD_FORUM channel.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildMedia: ChannelType = ChannelType(GUILD_MEDIA_VALUE)

        /**
         * Creates a [ChannelType] from any integer value.
         *
         * This can be used for channel types introduced by Discord that are not
         * yet known by this library.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): ChannelType = ChannelType(value)
    }

    override fun toString(): String =
        "ChannelType(value=$value)"
}
