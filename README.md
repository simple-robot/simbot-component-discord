<!--suppress HtmlDeprecatedAttribute -->
<div align="center">
<img src=".simbot/logo.png" alt="logo" style="width:230px; height:230px; border-radius:50%; " />
<h2>
    ~ Simple Robot ~ <br/> <small>Discord Component</small>
</h2>
<a href="https://github.com/simple-robot/simbot-component-discord/releases/latest"><img alt="release" src="https://img.shields.io/github/v/release/simple-robot/simbot-component-discord" /></a>
<a href="https://repo1.maven.org/maven2/love/forte/simbot/component/simbot-component-discord-api/" target="_blank">
  <img alt="release" src="https://img.shields.io/maven-central/v/love.forte.simbot.component/simbot-component-discord-api" /></a>
   <hr>
   <img alt="stars" src="https://img.shields.io/github/stars/simple-robot/simbot-component-discord" />
   <img alt="forks" src="https://img.shields.io/github/forks/simple-robot/simbot-component-discord" />
   <img alt="watchers" src="https://img.shields.io/github/watchers/simple-robot/simbot-component-discord" />
   <img alt="repo size" src="https://img.shields.io/github/repo-size/simple-robot/simbot-component-discord" />
   <img alt="lines" src="https://img.shields.io/tokei/lines/github/simple-robot/simbot-component-discord" />
   <img alt="issues" src="https://img.shields.io/github/issues-closed/simple-robot/simbot-component-discord?color=green" />
   <img alt="last commit" src="https://img.shields.io/github/last-commit/simple-robot/simbot-component-discord" />
   <a href="./COPYING"><img alt="copying" src="https://img.shields.io/github/license/simple-robot/simbot-component-discord" /></a>

</div>

[中文](README_CN.md) | _English_

> This content is machine-translated.

This is a subproject of  
[**Simple Robot v4**][simbot4 gh] (simbot),
which is a simbot component library implementation for 
[**Discord Bot**][discord bot doc].
This includes the implementation of the API, 
the implementation of events and the bots listening and interaction with events.

The Discord Component can be used as a low-level API dependency,
The lightweight Discord event scheduling framework uses,
It is also possible to quickly develop a powerful Discord Bot based on the simbot core library!

- Based on [`Kotlin`](https://kotlinlang.org/) and [KMP][KMP], and provide friendly Java API.
- Based on [`Kotlin coroutines`](https://github.com/Kotlin/kotlinx.coroutines) and [`Ktor`](https://ktor.io/) provides efficient and easy to use API;

## Documentation

- Learn about simbot: [**The Simple Robot Reference Manual**][simbot doc]
- **Discord Component** Reference Manual: (to be built)
- **API Documentation**: [**The KDoc of Discord Component**](https://docs.simbot.forte.love/components/discord) in the [**document guide site**](https://docs.simbot.forte.love). 

---

We welcome you and look forward to it
[feed back](https://github.com/simple-robot/simbot-component-discord/issues)
or
[pull request](https://github.com/simple-robot/simbot-component-discord/pulls),
Thank you for your contribution and support!

## 模块引导
### API module

Based on `Ktor`'s [KMP][KMP] implementation for [Discord API][discord bot doc],
is a simple, efficient and lightweight API implementation module.

This module provides very little extra implementation.
The goal is to preserve the feel of the original API as much as possible without overwrapping it.

👉 [Go to Modules](simbot-component-discord-api) to learn more.

### Stdlib module

Based on [API module](simbot-component-discord-api), 
for the implementation of authentication, subscription events and other related functions in bot.

This module provides an implementation of event-related functionality based on the API module, 
including the ability to subscribe to events.

Again, the goal is to provide as much of the feel of the original API as possible without overwrapping it.

👉 [Go to Modules](simbot-component-discord-stdlib) to learn more.

### Core Component module

A component implementation of the [simbot4 core library][simbot4 gh] based on [standard library module](simbot-component-discord-stdlib).

Is a relatively highly encapsulated module that provides most of the capabilities of simbot4, 
including event listeners, multi-component coordination, Spring Boot starter, and more.

👉 [Go to Modules](simbot-component-discord-core) to learn more.


## License

`simbot-component-discord` is open source under the `LGPLv3` licence。

```
This program is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General 
Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) 
any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied 
warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more 
details.

You should have received a copy of the GNU Lesser General Public License along with this program. 
If not, see <https://www.gnu.org/licenses/>.
```

[simbot4 gh]: https://github.com/simple-robot/simpler-robot/tree/v4-dev
[simbot doc]: https://simbot.forte.love
[discord bot doc]: https://discord.com/developers/docs/intro
[KMP]: https://kotlinlang.org/docs/multiplatform.html
