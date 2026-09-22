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

package love.forte.simbot.component.discord.model.permission

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * A Discord permission bit field.
 *
 * [plus] combines flags, [minus] removes flags, and [contains] checks whether
 * another flag is included in this bit field.
 *
 * @property value The raw Discord permission bit field.
 *
 * @see Permission
 * @see [Discord permissions](https://docs.discord.com/developers/topics/permissions)
 * @author Forte Scarlet
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmExposeBoxed
@JvmInline
@Serializable(with = DiscordPermissionFlagSerializer::class)
public value class Permissions private constructor(public val value: Long) {
    /**
     * The raw permission bit field serialized as a decimal string.
     */
    public val stringValue: String get() = value.toString()

    /**
     * An empty permission bit field.
     */
    public companion object {
        @JvmStatic
        @get:JvmExposeBoxed
        public val None: Permissions = Permissions(0L)

        /**
         * Create a [Permissions] instance.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Long): Permissions = Permissions(value)
    }

    /**
     * Combines this bit field with [other].
     *
     * This is a bitwise OR, so adding an already-present permission has no
     * effect.
     */
    @JvmExposeBoxed
    public operator fun plus(other: Permissions): Permissions =
        Permissions(value or other.value)

    /**
     * Removes all bits present in [other] from this bit field.
     *
     * This is a bitwise clear operation; it is not arithmetic subtraction.
     */
    @JvmExposeBoxed
    public operator fun minus(other: Permissions): Permissions =
        Permissions(value and other.value.inv())

    /**
     * Returns `true` when every bit in [other] is present in this bit field.
     *
     * This makes expressions such as `required in granted` possible.
     */
    @JvmExposeBoxed
    public operator fun contains(other: Permissions): Boolean =
        contains(other, exactly = false)

    /**
     * Checks whether [other] is included in this bit field.
     *
     * When [exactly] is `true`, this bit field must equal [other]. Otherwise,
     * every bit in [other] only needs to be present in this bit field.
     */
    @JvmExposeBoxed
    public fun contains(other: Permissions, exactly: Boolean): Boolean =
        if (exactly) {
            value == other.value
        } else {
            value and other.value == other.value
        }

    /**
     * Returns `true` when this bit field and [other] share at least one bit.
     *
     * Unlike [contains], this does not require all bits in [other] to be
     * present.
     */
    @JvmExposeBoxed
    public fun intersects(other: Permissions): Boolean =
        value and other.value != 0L

    /**
     * Whether this bit field contains no bits.
     */
    public val isEmpty: Boolean
        get() = value == 0L

    override fun toString(): String =
        "Permissions(value=$value)"
}


/**
 * Combines this bit field with the flag represented by [other].
 */
public operator fun Permissions.plus(other: Permission): Permissions = this + other.flag


/**
 * Removes the flag represented by [other] from this bit field.
 */
public operator fun Permissions.minus(other: Permission): Permissions = this - other.flag


/**
 * Returns `true` when the flag represented by [other] is present in this
 * bit field.
 */
public operator fun Permissions.contains(other: Permission): Boolean = contains(other.flag)


/**
 * Checks whether the flag represented by [other] is included in this bit
 * field, with the same [exactly] semantics as [contains].
 */
public fun Permissions.contains(other: Permission, exactly: Boolean): Boolean =
    contains(other.flag, exactly)


/**
 * Returns `true` when this bit field and the flag represented by [other]
 * share at least one bit.
 */
public fun Permissions.intersects(other: Permission): Boolean = intersects(other.flag)


internal object DiscordPermissionFlagSerializer : KSerializer<Permissions> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor(
            "DiscordPermissionFlag",
            PrimitiveKind.STRING
        )

    override fun serialize(
        encoder: Encoder,
        value: Permissions
    ) {
        encoder.encodeString(value.value.toString())
    }

    override fun deserialize(
        decoder: Decoder
    ): Permissions {
        return Permissions.of(decoder.decodeString().toLong())
    }
}
