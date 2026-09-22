/*
 * Copyright (c) 2024. ForteScarlet.
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

package love.forte.simbot.component.discord.api.application

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import love.forte.simbot.component.discord.api.team.Team
import love.forte.simbot.component.discord.api.user.User
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * The [Application Object](https://discord.com/developers/docs/resources/application#application-object)
 *
 * Represents a Discord developer application and its installation settings.
 *
 * @property id ID of the app
 * @property name Name of the app
 * @property icon Icon hash of the app
 * @property description Description of the app
 * @property rpcOrigins List of RPC origin URLs, if RPC is enabled
 * @property botPublic When false, only the app owner can add the app to guilds
 * @property botRequireCodeGrant When true, the app's bot will only join upon completion of the full OAuth2 code grant flow
 * @property bot Partial user object for the bot user associated with the app
 * @property termsOfServiceUrl URL of the app's Terms of Service
 * @property privacyPolicyUrl URL of the app's Privacy Policy
 * @property owner Partial user object for the owner of the app
 * @property verifyKey Hex encoded key for verification in interactions and the GameSDK's GetTicket
 * @property team If the app belongs to a team, this will be a list of the members of that team
 * @property guildId Guild associated with the app. For example, a developer support server.
 * @property guild Partial object of the associated guild
 * @property primarySkuId If this app is a game sold on Discord, this field will be the id of the "Game SKU" that is created, if exists
 * @property slug If this app is a game sold on Discord, this field will be the URL slug that links to the store page
 * @property coverImage App's default rich presence invite cover image hash
 * @property flags App's public flags
 * @property flagsNew App's complete public flags as a string-serialized bit field
 * @property approximateGuildCount Approximate count of guilds the app has been added to
 * @property approximateUserInstallCount Approximate count of users that have installed the app
 * @property approximateUserAuthorizationCount Approximate count of users that have authorized the app with OAuth2
 * @property redirectUris Array of redirect URIs for the app
 * @property interactionsEndpointUrl Interactions endpoint URL for the app
 * @property roleConnectionsVerificationUrl Role connection verification URL for the app
 * @property eventWebhooksUrl Event webhook URL for the app
 * @property eventWebhooksStatus Whether event webhooks are enabled or disabled
 * @property eventWebhooksTypes Webhook event types the app subscribes to
 * @property tags List of tags describing the content and functionality of the app. Max of 5 tags.
 * @property installParams Settings for the app's default in-app authorization link, if enabled
 * @property integrationTypesConfig Default install configuration for each supported installation context
 * @property customInstallUrl Default custom authorization URL for the app, if enabled
 *
 * @author ForteScarlet
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class Application internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    public val name: String,
    public val icon: String? = null,
    public val description: String,
    @SerialName("rpc_origins")
    public val rpcOrigins: List<String>? = null,
    @SerialName("bot_public")
    public val botPublic: Boolean,
    @SerialName("bot_require_code_grant")
    public val botRequireCodeGrant: Boolean,
    public val bot: User? = null,
    @SerialName("terms_of_service_url")
    public val termsOfServiceUrl: String? = null,
    @SerialName("privacy_policy_url")
    public val privacyPolicyUrl: String? = null,
    public val owner: User? = null,
    @SerialName("verify_key")
    public val verifyKey: String,
    public val team: Team? = null,
    @SerialName("guild_id")
    @get:JvmExposeBoxed
    public val guildId: DiscordId? = null,
    // TODO：应用对象中的 guild 只有部分 Guild 字段，而完整 Guild 模型尚未建立；暂时保留原始对象。
    public val guild: JsonObject? = null,
    @SerialName("primary_sku_id")
    @get:JvmExposeBoxed
    public val primarySkuId: DiscordId? = null,
    public val slug: String? = null,
    @SerialName("cover_image")
    public val coverImage: String? = null,
    public val flags: Int? = null,
    @SerialName("flags_new")
    public val flagsNew: String? = null,
    @SerialName("approximate_guild_count")
    public val approximateGuildCount: Int? = null,
    @SerialName("approximate_user_install_count")
    public val approximateUserInstallCount: Int? = null,
    @SerialName("approximate_user_authorization_count")
    public val approximateUserAuthorizationCount: Int? = null,
    @SerialName("redirect_uris")
    public val redirectUris: List<String>? = null,
    @SerialName("interactions_endpoint_url")
    public val interactionsEndpointUrl: String? = null,
    @SerialName("role_connections_verification_url")
    public val roleConnectionsVerificationUrl: String? = null,
    @SerialName("event_webhooks_url")
    public val eventWebhooksUrl: String? = null,
    @SerialName("event_webhooks_status")
    @get:JvmExposeBoxed
    public val eventWebhooksStatus: ApplicationEventWebhookStatus? = null,
    @SerialName("event_webhooks_types")
    public val eventWebhooksTypes: List<String>? = null,
    public val tags: List<String>? = null,
    @SerialName("install_params")
    public val installParams: InstallParams? = null,
    @SerialName("integration_types_config")
    public val integrationTypesConfig: Map<String, ApplicationIntegrationTypeConfiguration>? = null,
    @SerialName("custom_install_url")
    public val customInstallUrl: String? = null,
) {
    override fun toString(): String =
        "Application(id=$id, name=$name)"
}

