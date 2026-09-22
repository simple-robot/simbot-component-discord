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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.model.user.User
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed
import kotlin.time.Instant

/**
 * [Integration Object](https://docs.discord.com/developers/resources/guild#integration-object).
 *
 * Represents an external service, Discord application, or guild subscription
 * connected to a guild. Sync-related fields are omitted for bot integrations.
 *
 * @property id The integration ID.
 * @property name The integration name.
 * @property type The integration type.
 * @property enabled Whether the integration is enabled.
 * @property syncing Whether the integration is syncing.
 * @property roleId The subscriber role ID.
 * @property enableEmoticons Whether Twitch emoticons are synchronized.
 * @property expireBehavior The action applied to expired subscribers.
 * @property expireGracePeriod The expiration grace period in days.
 * @property user The user that installed the integration.
 * @property account The external integration account.
 * @property syncedAt When the integration was last synchronized.
 * @property subscriberCount The integration subscriber count.
 * @property revoked Whether the integration has been revoked.
 * @property application The application attached to a Discord integration.
 * @property scopes The authorized OAuth2 scopes.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class Integration internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    public val name: String,
    public val type: String,
    public val enabled: Boolean,
    public val syncing: Boolean? = null,
    @SerialName("role_id")
    @get:JvmExposeBoxed
    public val roleId: DiscordId? = null,
    @SerialName("enable_emoticons")
    public val enableEmoticons: Boolean? = null,
    @SerialName("expire_behavior")
    @get:JvmExposeBoxed
    public val expireBehavior: IntegrationExpireBehavior? = null,
    @SerialName("expire_grace_period")
    public val expireGracePeriod: Int? = null,
    public val user: User? = null,
    public val account: IntegrationAccount,
    @SerialName("synced_at")
    public val syncedAt: Instant? = null,
    @SerialName("subscriber_count")
    public val subscriberCount: Int? = null,
    public val revoked: Boolean? = null,
    public val application: IntegrationApplication? = null,
    public val scopes: List<String>? = null,
) {
    override fun toString(): String =
        "Integration(id=$id, name=$name, type=$type, enabled=$enabled)"
}
