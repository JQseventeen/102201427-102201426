# Find You Team
#### 我们的项目主要希望用户能够在“Find Your Team”上发布自己的项目或者找到心仪的项目，与自己的项目成员进行实时交流，沟通项目的实施方案。
 
### 目录组织
```markdown
- app
  - manifests
    - AndroidManifest.xml
  - java
    - com.example.fyt
      - adapters
      - data
      - database
      - models
      - ui
        - AllStoreActivity
        - CertifyActivity
        - CertifyDetailsActivity
        - ChatActivity1
        - CreateprojectActivity
        - EditForestActivity
        - EditProjectActivity
        - FirstActivity
        - ForestDetailsActivity
        - GeniusForestActivity
        - HomeActivity
        - ProjectDetailActivity
        - RegisterActivity
        - SetpasswordActivity
        - SettingsHelpActivity
        - StoreActivity
        - TeamActivity
    - com.example.fyt (androidTest)
    - com.example.fyt (test)
  - java (generated)
  - res
    - drawable
    - layout
    - menu
    - mipmap
    - navigation
    - values
    - xml
  - res (generated)
- Gradle Scripts
```
### 目录说明：
- **app**
  - **manifests**
    - **AndroidManifest.xml**：应用的配置文件，定义应用的包名、组件（如活动、服务）、权限等。
  - **java**
    - **com.example.fyt**：包含应用的源代码。
      - **adapters**：适配器类，用于将数据绑定到视图组件。
      - **data**：数据处理相关的类。
      - **database**：数据库操作相关的类。
      - **models**：数据模型类。
      - **ui**：界面相关的类，包括各个Activity。
        - 各种Activity类：定义应用的不同界面和交互逻辑。
    - **com.example.fyt (androidTest)**：存放用于Android测试的代码。
    - **com.example.fyt (test)**：存放单元测试代码。
  - **java (generated)**：自动生成的代码，如视图绑定代码。
  - **res**
    - **drawable**：图片资源。
    - **layout**：布局文件，定义界面的结构。
    - **menu**：菜单资源文件。
    - **mipmap**：图标资源。
    - **navigation**：导航资源文件，用于支持导航组件。
    - **values**：存放资源文件，如字符串、颜色定义。
    - **xml**：通用XML文件资源。
  - **res (generated)**：自动生成的资源文件。

- **Gradle Scripts**：构建脚本，通常包含`build.gradle`等文件，定义项目的构建配置和依赖。

### 使用说明

1. **安装应用**：
   - 在安卓手机上下载并安装APK文件。

2. **注册与认证**：
   - 打开应用，进入登录页面并选择注册。
   - 注册成功后，返回登录页面并登录。
   - 进入认证页面，如实填写个人信息和身份信息，完成认证。

3. **探索首页**：
   - 认证完成后，进入应用首页。

4. **编辑个人资料**：
   - 在首页下方导航栏中点击“我的”。
   - 进入“我的”页面后，选择“编辑我的人才林”。
   - 填写相关个人信息。

5. **探索功能**：
   - 在“我的”页面中，您可以查看以下功能：
     - **设置**：管理应用设置。
     - **好友聊天**：与好友进行聊天。
     - **修改身份认证**：更新您的身份认证信息。

6. **创建项目**：
   - 通过下方导航栏进入“仓库”。
   - 在“仓库”页面中，点击“创建项目”。
   - 填写项目相关信息，完成项目创建。

7. **浏览项目和人才**：
   - 返回首页，浏览推荐的项目和人才。
   - 点击“人才林”或“项目总库”，分别进入对应的页面，查找您感兴趣的项目和人才。

8. **查看您的项目**：
   - 再次进入“仓库”，您将看到自己创建的项目已经出现在列表中。
