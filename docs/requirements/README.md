# PROST Requirements

This directory is the source of truth for detailed product requirements. The existing application
prototype and the legacy DrinkIt system are research inputs only.

## Authority And Lifecycle

Requirements follow [Specification Governance](../governance/specification-governance.md). Each
requirement carries an independent revision, specification maturity, lifecycle status, and delivery
status:

```yaml
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
```

- `draft`: incomplete or blocked from acceptance.
- `in-review`: complete, independently reviewed, and free of known acceptance blockers.
- `accepted`: the exact revision was approved by the human Product Owner.
- `active`, `superseded`, and `withdrawn` describe whether the artifact remains applicable.
- `not-started`, `in-progress`, `implemented`, and `verified` track delivery without replacing
  acceptance.

`main` is authoritative. Only the human Product Owner may make acceptance, supersession, or
withdrawal authoritative through the pull-request process. Requirement acceptance alone does not
authorize implementation.

## Identifier Scheme

| Prefix              | Artifact               |
|---------------------|------------------------|
| `CAP-###`           | Business capability    |
| `UC-###`            | Use case               |
| `BR-###`            | Reusable business rule |
| `QS-<category>-###` | Quality scenario       |
| `ADR-####`          | Architecture decision  |

## Requirement Index

### Business Capabilities

The [Business Capability catalog](capabilities.md) distinguishes MVP scope from potential future
scope.

The controlled [Glossary](glossary.md) defines the working Ubiquitous Language.

### Supporting Specifications

| Artifact                                 | Maturity | Lifecycle | Delivery       |
|------------------------------------------|----------|-----------|----------------|
| [Vision And Scope](vision-and-scope.md)  | draft    | active    | not-applicable |
| [Business Capabilities](capabilities.md) | draft    | active    | not-applicable |
| [Stakeholders](stakeholders.md)          | draft    | active    | not-applicable |
| [Glossary](glossary.md)                  | draft    | active    | not-applicable |

The [Open Question Index](open-questions.md) is a derived view of individually versioned records
under [`open-questions/`](open-questions/).

### Use Cases

| ID                                                                 | Title                                | Maturity | Lifecycle | Delivery    |
|--------------------------------------------------------------------|--------------------------------------|----------|-----------|-------------|
| [UC-001](use-cases/UC-001-register-consumer.md)                    | Register Consumer                    | draft    | active    | not-started |
| [UC-002](use-cases/UC-002-manage-consumer-status.md)               | Manage Consumer Status               | draft    | active    | not-started |
| [UC-003](use-cases/UC-003-manage-products.md)                      | Manage Products                      | draft    | active    | not-started |
| [UC-004](use-cases/UC-004-preview-and-issue-tally.md)              | Preview And Issue Tally              | draft    | active    | not-started |
| [UC-005](use-cases/UC-005-cancel-and-replace-tally.md)             | Cancel And Replace Tally             | draft    | active    | not-started |
| [UC-006](use-cases/UC-006-settle-tally.md)                         | Settle Tally                         | draft    | active    | not-started |
| [UC-007](use-cases/UC-007-correct-settlement.md)                   | Correct Settlement                   | draft    | active    | not-started |
| [UC-008](use-cases/UC-008-record-account-transaction.md)           | Record Account Transaction           | draft    | active    | not-started |
| [UC-009](use-cases/UC-009-view-own-account.md)                     | View Own Account                     | draft    | active    | not-started |
| [UC-010](use-cases/UC-010-manage-organization.md)                  | Manage Organization                  | draft    | active    | not-started |
| [UC-011](use-cases/UC-011-view-financial-aggregates.md)            | View Financial Aggregates            | draft    | active    | not-started |
| [UC-012](use-cases/UC-012-close-and-pseudonymize-account.md)       | Close And Pseudonymize Account       | draft    | active    | not-started |
| [UC-013](use-cases/UC-013-bootstrap-first-organization-manager.md) | Bootstrap First Organization Manager | draft    | active    | not-started |

### Business Rules

| ID                                                              | Title                        | Maturity | Lifecycle | Delivery    |
|-----------------------------------------------------------------|------------------------------|----------|-----------|-------------|
| [BR-001](business-rules/BR-001-consumer-lifecycle.md)           | Consumer Lifecycle           | draft    | active    | not-started |
| [BR-002](business-rules/BR-002-tally-lifecycle.md)              | Tally Lifecycle              | draft    | active    | not-started |
| [BR-003](business-rules/BR-003-product-pricing.md)              | Product Pricing              | draft    | active    | not-started |
| [BR-004](business-rules/BR-004-settlement-and-corrections.md)   | Settlement And Corrections   | draft    | active    | not-started |
| [BR-005](business-rules/BR-005-balance-and-suspension.md)       | Balance And Suspension       | accepted | active    | not-started |
| [BR-006](business-rules/BR-006-product-lifecycle.md)            | Product Lifecycle            | accepted | active    | not-started |
| [BR-007](business-rules/BR-007-privacy-and-pseudonymization.md) | Privacy And Pseudonymization | draft    | active    | not-started |

### Quality Scenarios

| ID                                                                                          | Title                                         | Maturity | Lifecycle | Delivery    |
|---------------------------------------------------------------------------------------------|-----------------------------------------------|----------|-----------|-------------|
| [QS-COR-001](quality-scenarios/QS-COR-001-atomic-settlement.md)                             | Atomic Settlement                             | draft    | active    | not-started |
| [QS-COR-002](quality-scenarios/QS-COR-002-exact-balance.md)                                 | Exact Balance                                 | draft    | active    | not-started |
| [QS-COR-003](quality-scenarios/QS-COR-003-audited-correction.md)                            | Audited Correction                            | draft    | active    | not-started |
| [QS-COR-004](quality-scenarios/QS-COR-004-idempotent-account-transaction.md)                | Idempotent Account Transaction                | draft    | active    | not-started |
| [QS-SEC-001](quality-scenarios/QS-SEC-001-consumer-isolation.md)                            | Consumer Isolation                            | draft    | active    | not-started |
| [QS-SEC-002](quality-scenarios/QS-SEC-002-privileged-mfa.md)                                | Privileged MFA                                | draft    | active    | not-started |
| [QS-SEC-003](quality-scenarios/QS-SEC-003-transport-boundary.md)                            | Transport Boundary                            | draft    | active    | not-started |
| [QS-SEC-004](quality-scenarios/QS-SEC-004-pseudonymization.md)                              | Pseudonymization                              | draft    | active    | not-started |
| [QS-SEC-005](quality-scenarios/QS-SEC-005-anonymous-treasurer-aggregates.md)                | Anonymous Treasurer Aggregates                | draft    | active    | not-started |
| [QS-OPS-001](quality-scenarios/QS-OPS-001-reproducible-installation.md)                     | Reproducible Installation                     | draft    | active    | not-started |
| [QS-OPS-002](quality-scenarios/QS-OPS-002-provider-neutral-integration.md)                  | Provider-Neutral Integration                  | draft    | active    | not-started |
| [QS-OPS-003](quality-scenarios/QS-OPS-003-portable-recovery.md)                             | Portable Recovery                             | draft    | active    | not-started |
| [QS-MNT-001](quality-scenarios/QS-MNT-001-organizational-units-and-coordinated-ordering.md) | Organizational Units And Coordinated Ordering | draft    | active    | not-started |
| [QS-MNT-002](quality-scenarios/QS-MNT-002-mobile-manager-workflows.md)                      | Mobile Manager Workflows                      | draft    | active    | not-started |
| [QS-MNT-003](quality-scenarios/QS-MNT-003-increase-supported-tally-products.md)             | Increase Supported Tally Products             | draft    | active    | not-started |
| [QS-USA-001](quality-scenarios/QS-USA-001-consumer-device-and-language.md)                  | Consumer Device And Language                  | draft    | active    | not-started |
| [QS-USA-002](quality-scenarios/QS-USA-002-settlement-entry.md)                              | Settlement Entry                              | draft    | active    | not-started |
| [QS-USA-003](quality-scenarios/QS-USA-003-accessibility-baseline.md)                        | Accessibility Baseline                        | draft    | active    | not-started |
| [QS-USA-004](quality-scenarios/QS-USA-004-printable-tally-legibility.md)                    | Printable Tally Legibility                    | draft    | active    | not-started |

## Writing Rules

- Use the working terminology from the controlled [Glossary](glossary.md).
- Keep business requirements independent of implementation technology unless documenting an accepted
  constraint.
- Link reusable rules instead of duplicating them.
- Register every unresolved normative uncertainty in an individual, linked `OQ-*` record.
- Make acceptance criteria observable and unambiguous.
- Reference applicable `UC`, `BR`, `QS`, and `ADR` IDs in implementation tasks and tests.

## Open Questions

Acceptance blockers and cross-cutting unresolved decisions are tracked in individual records through
the derived [Open Question Index](open-questions.md).

## Research Inputs

Legacy workflows, the technical prototype, and historical product ideas are documented as
[Research References](references.md). They are not accepted requirements.

## Implementation Gate

Application behavior may change only when a complete work-item gate declaration satisfies
[Specification Governance](../governance/specification-governance.md). Applicability and empty
dependency categories must be explicit; agents may not infer them from missing references.
