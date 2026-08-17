# Architecture Decision Records

No target-architecture decision has been accepted yet.

## Naming

```text
ADR-0001-short-title.md
```

## Lifecycle

ADRs follow [Specification Governance](../../governance/specification-governance.md) and use its
independent `revision`, `spec_maturity`, `lifecycle_status`, and `delivery_status` fields.

Architecture options may be researched from draft drivers when clearly marked non-normative. An ADR
may move to `in-review` only when its requirement and quality-scenario drivers are accepted and no
linked open question blocks architecture. Only the human Product Owner may make ADR acceptance or
supersession authoritative through the pull-request process. Materially changing an accepted
decision requires a successor revision or ADR; accepted history is not rewritten.

## Required Content

- Context and decision drivers.
- Linked requirement and quality-scenario IDs.
- Exact open-question blockers.
- Credible options considered.
- Decision and rationale.
- Positive and negative consequences.
- Security, privacy, operation, testing, and migration impact.
- Superseded decisions where applicable.

## Expected Early Decisions

1. System shape and module boundaries.
2. Identity, local accounts, OIDC, MFA, and account linking.
3. Browser frontend technology and localization approach.
4. Persistence and financial audit model.
5. API contract and client-generation strategy.
6. PDF generation and artifact retention.
7. Deployment packaging, TLS termination, and private HTTP mode.
8. Backup and restore architecture.
