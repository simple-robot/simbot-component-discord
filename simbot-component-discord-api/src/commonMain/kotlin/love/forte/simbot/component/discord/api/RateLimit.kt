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

package love.forte.simbot.component.discord.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * The [Rate Limits](https://discord.com/developers/docs/topics/rate-limits#rate-limits).
 *
 * Rate limits exist across Discord's APIs to prevent spam, abuse, and service overload.
 * Limits are applied to individual bots and users both on a per-route basis and globally.
 * Individuals are determined using a request's authentication—for example, a bot token for a bot.
 */
public interface RateLimit {
    /**
     * The number of requests that can be made
     *
     * @see RATE_LIMIT_LIMIT
     */
    public val limit: Int

    /**
     * The number of remaining requests that can be made
     *
     * @see RATE_LIMIT_REMAINING
     */
    public val remaining: Int

    /**
     * Epoch time (seconds since 00:00:00 UTC on January 1, 1970)
     * at which the rate limit resets
     *
     * @see RATE_LIMIT_RESET
     */
    public val reset: Int

    /**
     * Total time (in seconds) of when the current rate limit bucket will reset.
     * Can have decimals to match previous millisecond ratelimit precision
     *
     * @see RATE_LIMIT_RESET_AFTER
     */
    public val resetAfter: Double

    /**
     * A unique string denoting the rate limit being encountered
     * (non-inclusive of top-level resources in the path)
     *
     * @see RATE_LIMIT_BUCKET
     */
    public val bucket: String

    /**
     * Returned only on HTTP 429 responses if the rate limit encountered is the global rate limit (not per-route)
     *
     * @see RATE_LIMIT_GLOBAL
     */
    public val global: String

    /**
     * Returned only on HTTP 429 responses.
     * Value can be `user` (per bot or user limit), `global` (per bot or user global limit), or `shared` (per resource limit)
     *
     * @see RATE_LIMIT_SCOPE
     */
    public val scope: String

    public companion object {
        /**
         * The number of requests that can be made
         */
        public const val RATE_LIMIT_LIMIT: String = "X-RateLimit-Limit"

        /**
         * The number of remaining requests that can be made
         */
        public const val RATE_LIMIT_REMAINING: String = "X-RateLimit-Remaining"

        /**
         * Epoch time (seconds since 00:00:00 UTC on January 1, 1970) at which the rate limit resets
         */
        public const val RATE_LIMIT_RESET: String = "X-RateLimit-Reset"

        /**
         * Total time (in seconds) of when the current rate limit bucket will reset. Can have decimals to match previous millisecond ratelimit precision
         */
        public const val RATE_LIMIT_RESET_AFTER: String = "X-RateLimit-Reset-After"

        /**
         * A unique string denoting the rate limit being encountered (non-inclusive of top-level resources in the path)
         */
        public const val RATE_LIMIT_BUCKET: String = "X-RateLimit-Bucket"

        /**
         * Returned only on HTTP 429 responses if the rate limit encountered is the global rate limit (not per-route)
         */
        public const val RATE_LIMIT_GLOBAL: String = "X-RateLimit-Global"

        /**
         * Returned only on HTTP 429 responses.
         * Value can be `user` (per bot or user limit), `global` (per bot or user global limit), or `shared` (per resource limit)
         */
        public const val RATE_LIMIT_SCOPE: String = "X-RateLimit-Scope"

        /**
         * The `user` scope of [RATE_LIMIT_SCOPE].
         */
        public const val RATE_LIMIT_SCOPE_USER: String = "user"

        /**
         * The `global` scope of [RATE_LIMIT_SCOPE].
         */
        public const val RATE_LIMIT_SCOPE_GLOBAL: String = "global"

        /**
         * The `shared` scope of [RATE_LIMIT_SCOPE].
         */
        public const val RATE_LIMIT_SCOPE_SHARED: String = "shared"
    }
}


/**
 * [Rate Limit Response Structure](https://discord.com/developers/docs/topics/rate-limits#exceeding-a-rate-limit-rate-limit-response-structure)
 *
 * In the case that a rate limit is exceeded, the API will return an HTTP 429 response code with a JSON body.
 * Your application should rely on the `Retry-After` header or `retry_after` field to determine when to retry the request.
 *
 * @property message A message saying you are being rate limited.
 * @property retryAfter The number of seconds to wait before submitting another request.
 * @property global A value indicating if you are being globally rate limited or not
 * @property code An error code for some limits
 *
 */
@Serializable
public data class RateLimitResponse(
    val message: String = "",
    @SerialName("retry_after")
    val retryAfter: Double = 0.0,
    val global: Boolean = false,
    val code: Int? = null,
)

/**
 * The duration to wait before submitting another request.
 * @see RateLimitResponse.retryAfter
 */
public val RateLimitResponse.retryAfterDuration: Duration
    get() = retryAfter.seconds


/**
 * Cached rate-limit response headers for a request route.
 *
 * @property bucket The identifier of the rate limit bucket.
 * @property limit The maximum requests allowed in the bucket.
 * @property remaining The requests remaining in the bucket.
 * @property reset The epoch-second timestamp when the bucket resets.
 * @property resetAfter The seconds until the bucket resets.
 * @property global The global rate-limit response header value.
 * @property scope The rate-limit scope response header value.
 */
@Serializable
internal data class RateLimitData(
    override val bucket: String,
    override val limit: Int,
    override val remaining: Int,
    override val reset: Int,
    override val resetAfter: Double,
    override val global: String,
    override val scope: String
) : RateLimit
