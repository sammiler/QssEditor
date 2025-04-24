# QssEditor - IntelliJ IDEA 插件

[![构建状态](https://img.shields.io/badge/build-passing-brightgreen.svg)]() <!-- TODO: 如果设置了 CI，添加构建状态徽章 -->
[![版本](https://img.shields.io/badge/version-1.0.0-blue.svg)]() <!-- TODO: 根据需要更新版本号 -->
[![许可证](https://img.shields.io/badge/license-Apache_2.0-blue.svg)]() <!-- TODO: 选择并确认你的许可证 -->

## 概述

QssEditor 是一款 IntelliJ IDEA 插件，旨在提升 **Qt 样式表 (QSS)** 文件的开发体验。Qt 样式表是 Qt 框架用于自定义 Qt Widgets 外观的强大机制，类似于 CSS 之于 HTML。

本插件的目标是在 IntelliJ 生态系统内为主流语言提供的常用功能引入到 QSS 开发中，让你在喜爱的 IDE 中更快速、更轻松、更少出错地进行 QSS 开发。

## 功能特性 ✨

本插件当前提供（或计划提供）以下功能：

*   **语法高亮:** 通过对选择器、属性、值、注释等进行颜色编码，使 QSS 代码更易于阅读和理解。
*   **代码补全:** <!-- TODO: 在这里详细说明 -->
    *   提示 QSS 选择器 (例如 `QPushButton`, `QLabel`)。
    *   提示伪状态 (例如 `:hover`, `:pressed`)。
    *   提示可用的 QSS 属性 (例如 `color`, `background-color`, `border`)。
    *   提示特定属性的常用值或关键字 (例如颜色名称, `transparent`, `solid`)。
*   **错误检查 / 代码巡视:** <!-- TODO: 列出具体的巡视项 -->
    *   高亮显示语法错误。
    *   对可能未知的属性或无效值发出警告（基础检查）。
    *   识别同一规则块内的重复属性。
*   **基础代码格式化:** (可选 - TODO: 如果期望，请实现) 提供简单的代码格式化能力。
*   **颜色预览:** (可选 - TODO: 如果期望，请实现) 在编辑器侧边栏（gutter）显示颜色值的预览。
*   **代码导航:** (可选 - TODO: 如果期望，请实现) 允许在选择器定义或相关元素之间跳转。
*   **(其他功能)** <!-- TODO: 添加你实现的其他任何功能 -->

*(请随着功能的添加或完善更新此列表！)*


## 安装方法 🚀

有多种方式安装 QssEditor 插件：

1.  **通过 JetBrains Marketplace (推荐):**
    *   前往 `Settings/Preferences` (设置/偏好设置) -> `Plugins` (插件)。
    *   切换到 `Marketplace` (市场) 标签页。
    *   搜索 "QssEditor"。
    *   点击 `Install` (安装)。
    *   *(TODO: 发布后添加链接)* `[插件市场链接]`

2.  **手动安装 (通过 .zip 文件):**
    *   从 [Releases](https://github.com/sammiler/QssEditor/releases) 页面下载最新的 `QssEditor-*.zip` 文件。 <!-- TODO: 更新链接 -->
    *   前往 `Settings/Preferences` (设置/偏好设置) -> `Plugins` (插件)。
    *   点击 ⚙️ 图标，选择 `Install Plugin from Disk...` (从磁盘安装插件...)。
    *   选择下载好的 `.zip` 文件。

3.  **从源码构建:** 参考下方的 [开发](#开发-) 部分。

## 开发 🛠️

如果你想参与贡献或自行构建插件：

**先决条件:**

*   **JDK:** Java 开发工具包 17 (与你的 `build.gradle.kts` 中配置的一致)。确保它已在 IntelliJ IDEA 中配置，并且可能需要设置 `JAVA_HOME` 环境变量。
*   **IntelliJ IDEA:** IntelliJ IDEA 社区版或旗舰版 (版本需与 `build.gradle.kts` 中的 `intellij.version` 兼容)。

**步骤:**

1.  **克隆仓库:**
    ```bash
    git clone https://github.com/sammiler/QssEditor.git # TODO: 更新链接
    cd QssEditor
    ```
2.  **在 IntelliJ IDEA 中打开:** 将克隆的目录作为 Gradle 项目打开。IntelliJ 应能自动识别 Gradle 配置。
3.  **构建插件:** 使用 Gradle Wrapper 构建插件的 `.zip` 压缩包。
    ```bash
    ./gradlew buildPlugin
    ```
    生成的 `.zip` 文件将位于 `build/distributions/` 目录下。
4.  **在沙箱 IDE 中运行:** 要在开发过程中测试插件，使用 Gradle 任务：
    ```bash
    ./gradlew runIde
    ```
    这将启动一个独立的 IntelliJ IDEA 实例，并安装了你的插件。

## 参与贡献 🤝

欢迎各种形式的贡献！无论是报告 Bug、建议新功能，还是提交代码更改：

1.  **Bug 报告和功能请求:** 请使用 [GitHub Issues](https://github.com/sammiler/QssEditor/issues) 部分。 <!-- TODO: 更新链接 --> 请尽可能提供详细信息。
2.  **代码拉取请求 (Pull Requests):**
    *   Fork 本仓库。
    *   为你的功能或 Bug 修复创建一个新分支 (`git checkout -b feature/你的功能名称`)。
    *   进行更改并使用清晰的提交信息进行提交 (`git commit`)。
    *   将你的分支推送到你的 Fork (`git push origin feature/你的功能名称`)。
    *   创建一个 Pull Request 到主仓库。

## 许可证 📄

本项目采用 **[Apache License 2.0]** 许可证授权。 <!-- TODO: 确认你选择的许可证 --> 详情请参阅 [LICENSE](LICENSE) 文件。 <!-- TODO: 添加一个 LICENSE 文件 -->

---
