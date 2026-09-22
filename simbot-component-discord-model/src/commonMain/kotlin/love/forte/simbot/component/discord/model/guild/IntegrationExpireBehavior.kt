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
 * [Integration Expire Behaviors](https://docs.discord.com/developers/resources/guild#integration-object-integration-expire-behaviors).
 *
 * Represents the action Discord applies when an integration subscriber expires.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord integration expiration behavior value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class IntegrationExpireBehavior private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw value for [RemoveRole].
         */
        public const val REMOVE_ROLE_VALUE: Int = 0

        /**
         * Raw value for [Kick].
         */
        public const val KICK_VALUE: Int = 1

        /**
         * Remove the integration's subscriber role.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val RemoveRole: IntegrationExpireBehavior =
            IntegrationExpireBehavior(REMOVE_ROLE_VALUE)

        /**
         * Remove the expired subscriber from the guild.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Kick: IntegrationExpireBehavior = IntegrationExpireBehavior(KICK_VALUE)

        /**
         * Creates a behavior from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): IntegrationExpireBehavior =
            IntegrationExpireBehavior(value)
    }

    override fun toString(): String = "IntegrationExpireBehavior(value=$value)"
}
