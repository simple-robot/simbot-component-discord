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

package love.forte.simbot.component.discord.model.stage

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Stage Instance Privacy Level](https://docs.discord.com/developers/resources/stage-instance#stage-instance-object-privacy-level).
 *
 * Represents who can access a live stage instance. Unknown values are
 * preserved for forward compatibility.
 *
 * @property value The raw Discord stage privacy level value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class StagePrivacyLevel private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw deprecated public privacy level value.
         */
        public const val PUBLIC_VALUE: Int = 1

        /**
         * Raw guild-only privacy level value.
         */
        public const val GUILD_ONLY_VALUE: Int = 2

        /**
         * A deprecated publicly visible stage.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Public: StagePrivacyLevel = StagePrivacyLevel(PUBLIC_VALUE)

        /**
         * A stage visible only to guild members.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildOnly: StagePrivacyLevel = StagePrivacyLevel(GUILD_ONLY_VALUE)

        /**
         * Creates a level from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): StagePrivacyLevel = StagePrivacyLevel(value)
    }

    override fun toString(): String = "StagePrivacyLevel(value=$value)"
}
