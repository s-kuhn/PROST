# 2. Constraints

Status: draft

## Product Constraints

| Constraint                                                              | Rationale                                                                |
|-------------------------------------------------------------------------|--------------------------------------------------------------------------|
| One Organization per MVP deployment                                     | Multi-organization SaaS isolation is not an MVP goal.                    |
| One Tally in Issued or Settlement Draft state and one physical location | Matches the replacement workflow and limits initial complexity.          |
| Up to 50 Consumers and roughly 2-10 active Products                     | Current expected operating scale.                                        |
| A3 landscape paper                                                      | Required physical format for Consumer rows and Product mark columns.     |
| EUR with cent precision                                                 | MVP monetary scope.                                                      |
| English and German UI, German final fallback                            | Initial usage context and broader accessibility.                         |
| Consumer mobile and desktop; manager desktop                            | MVP device scope. Manager tablet and phone support is a change scenario. |

## Identity And Integration Constraints

- A standalone installation must support locally managed guest identities.
- An operator may additionally configure standards-based OIDC.
- Verified email, email self-service recovery, and MFA for Organization Managers and Treasurers are
  required outcomes.
- SMTP and OIDC integrations must not be hardcoded to an institution or commercial provider.
- One optional Organization-level HTTPS payment link is supported without provider callbacks or
  automatic credit.

## Operational Constraints

- Public deployments require HTTPS.
- Private-network HTTP is available only as explicit insecure mode with operator-owned risk.
- Installation method is not predetermined.
- Installation on a prepared Linux host has an adjustable target of approximately 60 minutes, not a
  release gate.
- Backup and restore must be portable and tested. Backup artifacts are sensitive and require
  operator-controlled access protection; scheduling, storage, encryption mechanism, and retention
  belong to the operator.
- Core operation must not require a particular university or mandatory commercial online service.

## Project Constraints

- Documentation, canonical domain terms, APIs, and code use English.
- Architecture documentation follows Arc42 and uses Mermaid.
- PROST will use AGPL-3.0 network copyleft; `only` versus `or-later` remains open.
- The human product owner alone accepts requirements and ADRs.
- Existing Kotlin, Spring, Angular, Keycloak, PostgreSQL, OpenAPI, Docker, and GitHub Actions
  choices are prototype facts, not target constraints.

## Open Constraints

- Copyright ownership and exact AGPL SPDX expression.
- Legal or Organization-specific retention periods.
- Supported host architectures and minimum resource envelope.
- Browser support policy.
