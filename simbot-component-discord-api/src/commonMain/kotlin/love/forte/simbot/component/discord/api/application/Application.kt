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
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * The [Application Object](https://discord.com/developers/docs/resources/application#application-object)
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
 * @property approximateGuildCount Approximate count of guilds the app has been added to
 * @property redirectUris Array of redirect URIs for the app
 * @property interactionsEndpointUrl Interactions endpoint URL for the app
 * @property roleConnectionsVerificationUrl Role connection verification URL for the app
 * @property tags List of tags describing the content and functionality of the app. Max of 5 tags.
 * @property installParams Settings for the app's default in-app authorization link, if enabled
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
    // val bot: partial user object? = null, // TODO bot: partial user object
    @SerialName("terms_of_service_url")
    public val termsOfServiceUrl: String? = null,
    @SerialName("privacy_policy_url")
    public val privacyPolicyUrl: String? = null,
    // val owner: partial user object? = null, // TODO owner: partial user object
    @SerialName("verify_key")
    public val verifyKey: String,
    // val team: team object? = null, // TODO team: team object
    @SerialName("guild_id")
    public val guildId: Long? = null,
    // val guild: partial guild object? = null, // TODO guild: partial guild object
    @SerialName("primary_sku_id")
    public val primarySkuId: Long? = null,
    public val slug: String? = null,
    @SerialName("cover_image")
    public val coverImage: String? = null,
    public val flags: Int? = null,
    @SerialName("approximate_guild_count")
    public val approximateGuildCount: Int? = null,
    @SerialName("redirect_uris")
    public val redirectUris: List<String>? = null,
    @SerialName("interactions_endpoint_url")
    public val interactionsEndpointUrl: String? = null,
    @SerialName("role_connections_verification_url")
    public val roleConnectionsVerificationUrl: String? = null,
    public val tags: List<String>? = null,
    @SerialName("install_params")
    public val installParams: InstallParams? = null,
    @SerialName("custom_install_url")
    public val customInstallUrl: String? = null,
)

/**
 * [Install Params Structure](https://discord.com/developers/docs/resources/application#install-params-object-install-params-structure)
 *
 * @property scopes Scopes to add the application to the server with
 * @property permissions Permissions to request for the bot role
 *
 * @author ForteScarlet
 */
@Serializable
public class InstallParams internal constructor(
    public val scopes: List<String> = emptyList(),
    public val permissions: String
)
