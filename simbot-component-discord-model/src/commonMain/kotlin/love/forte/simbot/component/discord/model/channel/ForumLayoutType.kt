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
 * [Forum Layout Types](https://docs.discord.com/developers/resources/channel#channel-object-forum-layout-types).
 *
 * Represents the default layout used to display posts in a GUILD_FORUM channel.
 *
 * Known values:
 *
 * - 0 = NOT_SET
 * - 1 = LIST_VIEW
 * - 2 = GALLERY_VIEW
 *
 * @property value The raw Discord forum layout type value.
 *
 * @see Channel
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class ForumLayoutType private constructor(public val value: Int) {
    public companion object {
        /**
         * NOT_SET value constant.
         */
        public const val NOT_SET_VALUE: Int = 0

        /**
         * LIST_VIEW value constant.
         */
        public const val LIST_VIEW_VALUE: Int = 1

        /**
         * GALLERY_VIEW value constant.
         */
        public const val GALLERY_VIEW_VALUE: Int = 2

        /**
         * No default layout has been set for the forum channel.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val NotSet: ForumLayoutType = ForumLayoutType(NOT_SET_VALUE)

        /**
         * Display posts as a list.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val ListView: ForumLayoutType = ForumLayoutType(LIST_VIEW_VALUE)

        /**
         * Display posts as a collection of tiles.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GalleryView: ForumLayoutType = ForumLayoutType(GALLERY_VIEW_VALUE)

        /**
         * Creates a [ForumLayoutType] from any integer value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): ForumLayoutType = ForumLayoutType(value)
    }

}
