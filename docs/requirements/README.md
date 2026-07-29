# PROST Requirements

This directory is the source of truth for detailed product requirements. The existing application
prototype and the legacy DrinkIt system are research inputs only.

## Authority And Status

Each requirement carries one status:

```text
draft -> in-review -> accepted -> implemented -> verified
```

- `draft`: incomplete or not yet reviewed.
- `in-review`: ready for product-owner review.
- `accepted`: approved for implementation by the human product owner.
- `implemented`: implementation claims to satisfy the accepted requirement.
- `verified`: acceptance criteria have been demonstrated at an appropriate observable seam.

Only the human product owner may move a requirement to `accepted`. Agents may draft, review,
implement, and verify requirements but may not approve them.

## Identifier Scheme

| Prefix              | Artifact                                                                                 |
|---------------------|------------------------------------------------------------------------------------------|
| `CAP-###`           | Business capability                                                                      |
| `UC-###`            | Use case                                                                                 |
| `BR-###`            | Reusable business rule                                                                   |
| `QS-<category>-###` | Quality scenario in [Arc42 section 10](../architecture/arc42/10-quality-requirements.md) |
| `ADR-####`          | Architecture decision                                                                    |

## Requirement Index

### Business Capabilities

The [Business Capability catalog](capabilities.md) distinguishes MVP scope from potential future
scope.

### Use Cases

| ID                                                                 | Title                                | Status |
|--------------------------------------------------------------------|--------------------------------------|--------|
| [UC-001](use-cases/UC-001-register-consumer.md)                    | Register Consumer                    | draft  |
| [UC-002](use-cases/UC-002-manage-consumer-status.md)               | Manage Consumer Status               | draft  |
| [UC-003](use-cases/UC-003-manage-products.md)                      | Manage Products                      | draft  |
| [UC-004](use-cases/UC-004-preview-and-issue-tally.md)              | Preview And Issue Tally              | draft  |
| [UC-005](use-cases/UC-005-cancel-and-replace-tally.md)             | Cancel And Replace Tally             | draft  |
| [UC-006](use-cases/UC-006-settle-tally.md)                         | Settle Tally                         | draft  |
| [UC-007](use-cases/UC-007-correct-settlement.md)                   | Correct Settlement                   | draft  |
| [UC-008](use-cases/UC-008-record-account-transaction.md)           | Record Account Transaction           | draft  |
| [UC-009](use-cases/UC-009-view-own-account.md)                     | View Own Account                     | draft  |
| [UC-010](use-cases/UC-010-manage-organization.md)                  | Manage Organization                  | draft  |
| [UC-011](use-cases/UC-011-view-financial-aggregates.md)            | View Financial Aggregates            | draft  |
| [UC-012](use-cases/UC-012-close-and-pseudonymize-account.md)       | Close And Pseudonymize Account       | draft  |
| [UC-013](use-cases/UC-013-bootstrap-first-organization-manager.md) | Bootstrap First Organization Manager | draft  |

### Business Rules

| ID                                                              | Title                        | Status   |
|-----------------------------------------------------------------|------------------------------|----------|
| [BR-001](business-rules/BR-001-consumer-lifecycle.md)           | Consumer Lifecycle           | draft    |
| [BR-002](business-rules/BR-002-tally-lifecycle.md)              | Tally Lifecycle              | draft    |
| [BR-003](business-rules/BR-003-product-pricing.md)              | Product Pricing              | draft    |
| [BR-004](business-rules/BR-004-settlement-and-corrections.md)   | Settlement And Corrections   | draft    |
| [BR-005](business-rules/BR-005-balance-and-suspension.md)       | Balance And Suspension       | accepted |
| [BR-006](business-rules/BR-006-product-lifecycle.md)            | Product Lifecycle            | accepted |
| [BR-007](business-rules/BR-007-privacy-and-pseudonymization.md) | Privacy And Pseudonymization | draft    |

## Writing Rules

- Use the canonical terminology from the [Arc42 glossary](../architecture/arc42/12-glossary.md).
- Keep business requirements independent of implementation technology unless documenting an accepted
  constraint.
- Link reusable rules instead of duplicating them.
- Put unknowns in an `Open Questions` section.
- Make acceptance criteria observable and unambiguous.
- Reference applicable `UC`, `BR`, `QS`, and `ADR` IDs in implementation tasks and tests.

## Open Questions

Acceptance blockers and cross-cutting unresolved decisions are tracked in
the [Open Question Register](open-questions.md).

## Research Inputs

Legacy workflows, the technical prototype, and historical product ideas are documented as
[Research References](references.md). They are not accepted requirements.

## Implementation Gate

Application behavior may change only when the applicable use cases and business rules are accepted,
relevant quality scenarios are defined, and required architecture decisions are accepted.
