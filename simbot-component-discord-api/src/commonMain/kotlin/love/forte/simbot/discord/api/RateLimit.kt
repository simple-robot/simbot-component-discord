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

package love.forte.simbot.discord.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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

        public const val RATE_LIMIT_SCOPE_USER: String = "user"
        public const val RATE_LIMIT_SCOPE_GLOBAL: String = "global"
        public const val RATE_LIMIT_SCOPE_SHARED: String = "shared"
    }
}


/**
 * [Rate Limit Response Structure](https://discord.com/developers/docs/topics/rate-limits#exceeding-a-rate-limit-rate-limit-response-structure)
 *
 * In the case that a rate limit is exceeded, the API will return a HTTP 429 response code with a JSON body.
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
    val message: String,
    @SerialName("retry_after")
    val retryAfter: Float,
    val global: Boolean = false,
    val code: Int? = null,
)
