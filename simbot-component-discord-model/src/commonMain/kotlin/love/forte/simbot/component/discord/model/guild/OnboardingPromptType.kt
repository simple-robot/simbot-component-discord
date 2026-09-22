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
 * [Onboarding Prompt Types](https://docs.discord.com/developers/resources/guild#guild-onboarding-object-prompt-types).
 *
 * Represents how Discord displays an onboarding prompt's options.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord onboarding prompt type value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class OnboardingPromptType private constructor(public val value: Int) {
    public companion object {
        /** Raw multiple-choice prompt value. */
        public const val MULTIPLE_CHOICE_VALUE: Int = 0

        /** Raw dropdown prompt value. */
        public const val DROPDOWN_VALUE: Int = 1

        /** A multiple-choice prompt. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val MultipleChoice: OnboardingPromptType =
            OnboardingPromptType(MULTIPLE_CHOICE_VALUE)

        /** A dropdown prompt. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Dropdown: OnboardingPromptType = OnboardingPromptType(DROPDOWN_VALUE)

        /** Creates a type from a raw Discord value. */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): OnboardingPromptType = OnboardingPromptType(value)
    }

    override fun toString(): String = "OnboardingPromptType(value=$value)"
}
