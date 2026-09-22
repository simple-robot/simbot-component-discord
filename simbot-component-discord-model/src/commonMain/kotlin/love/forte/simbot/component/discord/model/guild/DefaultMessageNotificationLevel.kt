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
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Default Message Notification Level](https://docs.discord.com/developers/resources/guild#guild-object-default-message-notification-level).
 *
 * Represents the notification level applied to guild members by default.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord notification level value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class DefaultMessageNotificationLevel private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw value for [AllMessages].
         */
        public const val ALL_MESSAGES_VALUE: Int = 0

        /**
         * Raw value for [OnlyMentions].
         */
        public const val ONLY_MENTIONS_VALUE: Int = 1

        /**
         * Members receive notifications for all messages by default.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val AllMessages: DefaultMessageNotificationLevel =
            DefaultMessageNotificationLevel(ALL_MESSAGES_VALUE)

        /**
         * Members receive notifications only for messages that mention them.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val OnlyMentions: DefaultMessageNotificationLevel =
            DefaultMessageNotificationLevel(ONLY_MENTIONS_VALUE)

        /**
         * Creates a level from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): DefaultMessageNotificationLevel =
            DefaultMessageNotificationLevel(value)
    }

    override fun toString(): String =
        "DefaultMessageNotificationLevel(value=$value)"
}
