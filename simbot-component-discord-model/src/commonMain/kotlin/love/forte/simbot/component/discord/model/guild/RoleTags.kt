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

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import love.forte.simbot.component.discord.common.DiscordId
import love.forte.simbot.component.discord.common.toDiscordSnowflake
import kotlin.jvm.JvmExposeBoxed

/**
 * [Role Tags Structure](https://docs.discord.com/developers/topics/permissions#role-object-role-tags-structure).
 *
 * Describes the bot, integration, subscription, purchase, or linked-role
 * relationship that manages a role. Discord encodes boolean tags by including
 * their JSON key with a null value.
 *
 * @property botId The bot that owns this role.
 * @property integrationId The integration that owns this role.
 * @property premiumSubscriber Whether this is the guild's Booster role.
 * @property subscriptionListingId The role subscription SKU and listing ID.
 * @property availableForPurchase Whether the role is available for purchase.
 * @property guildConnections Whether this is the guild's linked role.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable(with = RoleTagsSerializer::class)
public class RoleTags internal constructor(
    @get:JvmExposeBoxed
    public val botId: DiscordId? = null,
    @get:JvmExposeBoxed
    public val integrationId: DiscordId? = null,
    public val premiumSubscriber: Boolean = false,
    @get:JvmExposeBoxed
    public val subscriptionListingId: DiscordId? = null,
    public val availableForPurchase: Boolean = false,
    public val guildConnections: Boolean = false,
) {
    override fun toString(): String =
        "RoleTags(botId=$botId, integrationId=$integrationId, " +
            "premiumSubscriber=$premiumSubscriber)"
}

internal object RoleTagsSerializer : KSerializer<RoleTags> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("RoleTags")

    override fun deserialize(decoder: Decoder): RoleTags {
        require(decoder is JsonDecoder) { "RoleTags can only be decoded from JSON" }
        val value = decoder.decodeJsonElement().jsonObject

        fun id(name: String): DiscordId? =
            value[name]?.jsonPrimitive?.content?.toDiscordSnowflake()

        return RoleTags(
            botId = id("bot_id"),
            integrationId = id("integration_id"),
            premiumSubscriber = "premium_subscriber" in value,
            subscriptionListingId = id("subscription_listing_id"),
            availableForPurchase = "available_for_purchase" in value,
            guildConnections = "guild_connections" in value,
        )
    }

    override fun serialize(encoder: Encoder, value: RoleTags) {
        require(encoder is JsonEncoder) { "RoleTags can only be encoded to JSON" }
        encoder.encodeJsonElement(
            buildJsonObject {
                value.botId?.let { put("bot_id", JsonPrimitive(it.stringValue)) }
                value.integrationId?.let {
                    put("integration_id", JsonPrimitive(it.stringValue))
                }
                if (value.premiumSubscriber) put("premium_subscriber", JsonNull)
                value.subscriptionListingId?.let {
                    put("subscription_listing_id", JsonPrimitive(it.stringValue))
                }
                if (value.availableForPurchase) put("available_for_purchase", JsonNull)
                if (value.guildConnections) put("guild_connections", JsonNull)
            }
        )
    }
}
