# DDD-Base 项目

## 项目简介
`ddd-base` 是一个基于领域驱动设计（Domain-Driven Design, DDD）思想构建的 Java Spring Boot 基础框架。本项目旨在提供一个规范化的、可扩展的 DDD 架构模板，适用于中大型微服务或单体应用的开发。

## 技术栈
- **核心框架**: Spring Boot 3.5.x
- **开发语言**: Java 17
- **持久层**: MyBatis Plus 3.5.7, MySQL
- **工具库**: Lombok, MapStruct, Jakarta Validation
- **构建工具**: Maven

## 核心架构
项目严格遵循 DDD 分层架构设计：

### 1. API 层 (`api`)
- **职责**: 负责接收外部请求（RESTful API），进行参数校验，并将 DTO 转换为应用服务所需的输入。
- **包含**: `UserController`, `Result`, `ResultCode`, `UserLoginRequest`, MapStruct Mappers。

### 2. 应用层 (`application`)
- **职责**: 协调领域层完成业务逻辑，不包含核心业务规则。负责事务控制、安全检查、日志记录等。
- **包含**: `UserApplicationService`。

### 3. 领域层 (`domain`)
- **职责**: 系统的核心，包含业务实体、值对象、领域服务及聚合根。定义了业务的逻辑和规则。
- **包含**: `User` (实体), `UserRepository` (接口)。

### 4. 基础设施层 (`infuastructure`)
- **职责**: 提供通用的技术能力，如数据库持久化实现、消息队列、配置、异常处理等。
- **包含**: `UserRepositoryImpl`, `UserMapper` (MyBatis Plus), `UserException`。

### 5. 通用基础层 (`base`)
- **职责**: 提供全系统通用的基础类和工具类。
- **包含**: `BizException`, `ErrorCode`。

## 快速开始

### 环境依赖
- JDK 17
- MySQL 8.0+
- Maven 3.6+

### 运行
1. 配置 `src/main/resources/application.yml` 中的数据库连接。
2. 执行 Maven 命令编译项目:
   ```bash
   mvn clean install
   ```
3. 启动应用:
   ```bash
   java -jar target/ddd-base-0.0.1-SNAPSHOT.jar
   ```

## 开发规范
1. **领域驱动**: 核心业务逻辑必须保留在领域模型（Entity/Value Object）中，避免贫血模型。
2. **层级隔离**: 严格遵守层级依赖关系（API -> Application -> Domain <- Infrastructure）。
3. **异常处理**: 使用统一的 `Result` 返回格式和 `BizException` 异常机制。
4. **注释规范**: 所有公共类、接口及方法必须包含清晰的 Javadoc 注释。
