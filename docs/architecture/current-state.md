# Current Technical State

Status: descriptive inventory, not target architecture

This document records the repository prototype as of 2026-07-26. It is research input and does not
define product requirements or accepted architecture.

## Summary

PROST is a technical integration skeleton covering application frameworks, authentication
experiments, API generation, database migration, containers, and deployment workflows. It does not
yet implement the PROST domain described in [the requirements](../requirements/README.md).

## Backend Prototype

The `server/` project currently uses Kotlin, Spring Boot, Maven, Spring Security, JPA, Flyway,
Spring Modulith dependencies, and OpenAPI generation.

Implemented production source is limited to:

- application bootstrapping;
- JWT role conversion and a security filter chain;
- delegate implementations for demo endpoints;
- runtime configuration.

There are no accepted domain modules, domain entities, repositories, application services, or
business transactions. Spring Modulith is a dependency rather than a demonstrated module
architecture.

## API Prototype

`server/api/api.yml` is configured as the source for generated Kotlin API interfaces. The current
specification exposes only `/v1/test` and `/v1/sec` demo operations. It has no accepted domain
contract, complete error model, or product authorization model.

Generated sources are written under `server/target/` and must not be edited manually.

## Persistence Prototype

Flyway and PostgreSQL integration exist. `V1__init_schema.sql` creates only a test table and test
data. It is not a product data model.

The current Compose setup gives the application and Keycloak the same PostgreSQL database
configuration. This creates coupling and migration risk and must be reassessed if those components
remain in the target architecture.

## Frontend Prototype

`frontend/prost-frontend/` is an Angular application with standalone components, routing, runtime
configuration, and Keycloak integration. It contains Home, Menu, User Profile, Forbidden, Not Found,
and Books demo pages.

The Books service expects a collection from `/v1/test`, while the backend contract returns a test
response object. This is prototype contract drift, not intended behavior.

Frontend routes refer to roles such as `view-books` and `view-profile`, while the imported realm
primarily defines `USER`, `MANAGER`, and `ADMIN`. No accepted authorization model exists.

## Identity Prototype

The repository contains a Keycloak realm export, frontend login integration, backend JWT validation,
and a Kotlin Keycloak event-listener plugin.

The event listener reacts to email verification but currently performs a token request and calls a
demo secured endpoint. It does not implement a reliable Consumer synchronization contract,
idempotency, retry handling, or domain-account lifecycle.

Keycloak remains an architecture candidate because emerging requirements include local accounts,
optional OIDC, email verification, account recovery, and MFA. Its operational cost must be compared
with alternatives.

## Deployment Prototype

Docker and Compose files model PostgreSQL, Keycloak, backend, frontend, local overlays, and
deployment overlays. GitHub Actions build and deploy container images to development and production
environments.

This is useful infrastructure research, but it does not yet demonstrate the accepted public/private
HTTPS modes, provider-neutral configuration, portable recovery, or adjustable installation target.

## Verification Baseline

- Backend CI runs Maven with `-DskipTests`.
- Frontend tests are commented out in CI and no frontend specifications are present.
- The Keycloak plugin has no tests.
- The backend has only a basic context test and no isolated test database strategy.
- There are no contract, security, module-boundary, migration, or end-to-end tests.

The prototype therefore cannot be considered a verified baseline.

## Documentation And Version Drift

Prior documentation described stale frontend and plugin details. Versions differ among the root
`VERSION`, Maven project, OpenAPI document, frontend package, and environment example. Dependency
manifests remain authoritative until a versioning decision is accepted.

## Candidate Assets

The following may be reusable after architecture evaluation:

- OpenAPI-first server generation and delegate pattern;
- runtime frontend configuration;
- authenticated browser and resource-server experiments;
- database migration tooling;
- container and deployment workflow structure;
- formatter and linter integration.

Reuse requires accepted requirements, explicit ADRs, corrected verification, and removal of demo
assumptions.
