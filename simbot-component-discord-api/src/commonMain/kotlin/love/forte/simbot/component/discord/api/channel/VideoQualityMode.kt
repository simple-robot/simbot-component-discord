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

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Video Quality Modes](https://docs.discord.com/developers/resources/channel#channel-object-video-quality-modes).
 *
 * Represents the camera video quality mode of a voice channel.
 *
 * Known values:
 *
 * - 1 = AUTO
 * - 2 = FULL
 *
 * @see Channel
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class VideoQualityMode private constructor(public val value: Int) {
    public companion object {
        /**
         * AUTO value constant.
         */
        public const val AUTO_VALUE: Int = 1

        /**
         * FULL value constant.
         */
        public const val FULL_VALUE: Int = 2

        /**
         * Discord chooses the quality for optimal performance.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Auto: VideoQualityMode = VideoQualityMode(AUTO_VALUE)

        /**
         * Full video quality, currently 720p.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Full: VideoQualityMode = VideoQualityMode(FULL_VALUE)

        /**
         * Creates a [VideoQualityMode] from any integer value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): VideoQualityMode = VideoQualityMode(value)
    }
}
