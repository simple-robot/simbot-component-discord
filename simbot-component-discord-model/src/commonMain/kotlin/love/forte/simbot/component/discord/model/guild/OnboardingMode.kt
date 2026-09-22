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
 * [Onboarding Mode](https://docs.discord.com/developers/resources/guild#guild-onboarding-object-onboarding-mode).
 *
 * Defines which onboarding content counts toward Discord's enablement
 * constraints. Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord onboarding mode value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class OnboardingMode private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw default-channel-only mode value.
         */
        public const val DEFAULT_VALUE: Int = 0

        /**
         * Raw advanced mode value.
         */
        public const val ADVANCED_VALUE: Int = 1

        /**
         * Only default channels count toward onboarding constraints.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Default: OnboardingMode = OnboardingMode(DEFAULT_VALUE)

        /**
         * Default channels and questions count toward onboarding constraints.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Advanced: OnboardingMode = OnboardingMode(ADVANCED_VALUE)

        /**
         * Creates a mode from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): OnboardingMode = OnboardingMode(value)
    }

}
