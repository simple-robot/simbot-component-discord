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
 * [Application Integration Types](https://docs.discord.com/developers/resources/application#application-integration-types).
 *
 * Represents an installation context supported by an application.
 *
 * The value is used as a string key in [Application.integrationTypesConfig]
 * because Discord serializes the keys of that JSON object as strings.
 *
 * @property value The raw Discord installation context value.
 *
 * @see Application
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class ApplicationIntegrationType private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw value for the guild installation context.
         */
        public const val GUILD_INSTALL_VALUE: Int = 0

        /**
         * Raw value for the user installation context.
         */
        public const val USER_INSTALL_VALUE: Int = 1

        /**
         * An application installation available to Discord servers.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildInstall: ApplicationIntegrationType = ApplicationIntegrationType(GUILD_INSTALL_VALUE)

        /**
         * An application installation available to individual users.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val UserInstall: ApplicationIntegrationType = ApplicationIntegrationType(USER_INSTALL_VALUE)

        /**
         * Creates an [ApplicationIntegrationType] from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): ApplicationIntegrationType = ApplicationIntegrationType(value)
    }

    override fun toString(): String =
        "ApplicationIntegrationType(value=$value)"
}
