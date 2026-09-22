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

package love.forte.simbot.component.discord.model.application

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Application Event Webhook Status](https://docs.discord.com/developers/resources/application#application-event-webhook-status).
 *
 * Represents the status of an application's outgoing event webhooks.
 *
 * Discord reports whether the developer enabled webhook events, or Discord
 * disabled them because of inactivity.
 *
 * @property value The raw Discord webhook status value.
 *
 * @see Application
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class ApplicationEventWebhookStatus private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw value for developer-disabled webhook events.
         */
        public const val DISABLED_VALUE: Int = 1

        /**
         * Raw value for developer-enabled webhook events.
         */
        public const val ENABLED_VALUE: Int = 2

        /**
         * Raw value for webhook events disabled by Discord.
         */
        public const val DISABLED_BY_DISCORD_VALUE: Int = 3

        /**
         * Webhook events are disabled by the developer.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Disabled: ApplicationEventWebhookStatus = ApplicationEventWebhookStatus(DISABLED_VALUE)

        /**
         * Webhook events are enabled by the developer.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Enabled: ApplicationEventWebhookStatus = ApplicationEventWebhookStatus(ENABLED_VALUE)

        /**
         * Webhook events are disabled by Discord, usually because of inactivity.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val DisabledByDiscord: ApplicationEventWebhookStatus =
            ApplicationEventWebhookStatus(DISABLED_BY_DISCORD_VALUE)

        /**
         * Creates an [ApplicationEventWebhookStatus] from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): ApplicationEventWebhookStatus = ApplicationEventWebhookStatus(value)
    }

}
