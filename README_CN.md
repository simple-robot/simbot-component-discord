<!--suppress HtmlDeprecatedAttribute -->
<div align="center">
<picture>
  <source media="(prefers-color-scheme: dark)" srcset=".simbot/logo-dark.svg">
  <source media="(prefers-color-scheme: light)" srcset=".simbot/logo.svg">
  <img alt="simbot logo" src=".simbot/logo.svg" width="260" />
</picture>
<h2>
    ~ Simple Robot ~ <br/> <small>Discord 组件</small>
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

_中文_ | [English](README.md)

> [!caution]
> WIP

这是 
[**Simple Robot v4**](https://github.com/simple-robot/simpler-robot/tree/v4-dev)
下的子项目，是针对 
[**Discord Bot**](https://discord.com/developers/docs/intro) 
各方面的 simbot 组件库实现， 
包括对 `API` 内容的实现、事件相关的实现以及BOT对于事件的监听与交互等。

Discord Component 可以作为底层API依赖使用、
轻量级的 Discord 事件调度框架使用，
也可以基于 simbot 核心库的种种快速开发一个功能强大的 Discord Bot！

- 基于 [`Kotlin`](https://kotlinlang.org/) 提供 [KMP 多平台](https://kotlinlang.org/docs/multiplatform.html) 特性，并提供 Java 友好的API。
- 基于 [`Kotlin coroutines`](https://github.com/Kotlin/kotlinx.coroutines) 与 [`Ktor`](https://ktor.io/) 提供轻量高效的API。

> [!Note]
> 下文中 `Simple Robot v4` 简称为 `simbot4`

## 文档

- **Discord组件**手册：(待建设)
- 了解simbot: [**Simple Robot 应用手册**](https://simbot.forte.love)
- **API文档**: [**文档引导站点**](https://docs.simbot.forte.love) 中 Discord 的 [**KDoc站点**](https://docs.simbot.forte.love/components/discord)
- [**社群**](https://simbot.forte.love/communities.html): 与我们和其他开发者愉快地交流！

## 模块引导

### 模型模块

提供 Discord Bot 资源与 payload 的 KMP 可序列化模型。
该模块只依赖公共基础类型和 kotlinx.serialization，不依赖 Ktor 或 simbot 运行时抽象。

👉 [前往模块](simbot-component-discord-model) 了解更多。

### API模块

基于 [模型模块](simbot-component-discord-model) 与 `Ktor` 针对 [Discord API](https://discord.com/developers/docs/intro)
的基本完整的[KMP](https://kotlinlang.org/docs/multiplatform.html)多平台封装实现，
是一个简单高效轻量级的API实现模块。

此模块基本不会提供什么多余的实现，其目标为在提供封装的情况下尽可能地保留原始API的使用手感，不做过多的封装。

👉 [前往模块](simbot-component-discord-api) 了解更多。

### 标准库模块

基于 [API模块](simbot-component-discord-api) 针对 bot 的鉴权、事件订阅等功能的实现。

同样的，其目标为在提供封装的情况下尽可能地保留原始API的使用手感，不做过多的封装。

👉 [前往模块](simbot-component-discord-stdlib) 了解更多。

### 核心组件模块

基于 
[标准库模块](simbot-component-discord-stdlib) 
对 [simbot4核心库](https://github.com/simple-robot/simpler-robot) 
的组件实现，
是一个相对高度封装的模块，并提供simbot4大部分能力，包括事件监听、多组件协同、Spring Boot starter 等。

👉 [前往模块](simbot-component-discord-core) 了解更多。

## 贡献

前往 [贡献指南](docs/CONTRIBUTING_CN.md) 了解更多！

我们欢迎并期望着您的
[反馈](https://github.com/simple-robot/simbot-component-discord/issues)
或
[协助](https://github.com/simple-robot/simbot-component-discord/pulls)，
感谢您的贡献与支持！

## License

`simbot-component-discord` 使用 `LGPLv3` 许可证开源。

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
