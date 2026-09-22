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

import kotlin.jvm.JvmExposeBoxed

/**
 * A known [system channel flag](https://docs.discord.com/developers/resources/guild#guild-object-system-channel-flags).
 *
 * Each value suppresses a category of guild system-channel notification or
 * its associated reply control.
 *
 * @property flag The bit represented by this flag.
 */
@OptIn(ExperimentalStdlibApi::class)
public enum class SystemChannelFlag(
    @get:JvmExposeBoxed
    public val flag: SystemChannelFlags,
) {
    /** Suppresses member join notifications. */
    SUPPRESS_JOIN_NOTIFICATIONS(SystemChannelFlags.of(1L shl 0)),

    /** Suppresses Server Boost notifications. */
    SUPPRESS_PREMIUM_SUBSCRIPTIONS(SystemChannelFlags.of(1L shl 1)),

    /** Suppresses server setup tips. */
    SUPPRESS_GUILD_REMINDER_NOTIFICATIONS(SystemChannelFlags.of(1L shl 2)),

    /** Hides member join sticker reply buttons. */
    SUPPRESS_JOIN_NOTIFICATION_REPLIES(SystemChannelFlags.of(1L shl 3)),

    /** Suppresses role subscription purchase and renewal notifications. */
    SUPPRESS_ROLE_SUBSCRIPTION_PURCHASE_NOTIFICATIONS(SystemChannelFlags.of(1L shl 4)),

    /** Hides role subscription sticker reply buttons. */
    SUPPRESS_ROLE_SUBSCRIPTION_PURCHASE_NOTIFICATION_REPLIES(
        SystemChannelFlags.of(1L shl 5)
    )
}
