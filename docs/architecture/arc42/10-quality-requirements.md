# 10. Quality Requirements

Documentation coverage: partial

This chapter is a derived architecture view. Individual quality scenarios are controlled
requirements under [`docs/requirements/quality-scenarios/`](../../requirements/quality-scenarios/)
and carry their own revision, maturity, lifecycle, delivery status, and blockers.

The priority order below is a draft summary for architecture discussion. It has no independent
acceptance effect; accepted scenario revisions remain authoritative.

## 10.1 Overview

| Priority | Quality                           | Architectural Consequence                                                                                 |
|----------|-----------------------------------|-----------------------------------------------------------------------------------------------------------|
| 1        | Correctness and auditability      | Exact money, atomic posting, idempotency, revision history, and deterministic balance derivation.         |
| 2        | Security and privacy              | Strong account isolation, privileged MFA, minimal data disclosure, and explicit trust boundaries.         |
| 3        | Operability                       | Reproducible self-hosting, diagnostics, backup, restore, and safe transport defaults.                     |
| 4        | Maintainability and extensibility | Traceable boundaries that accommodate Organizational Units, procurement, and new clients.                 |
| 5        | Usability and accessibility       | Physical-workflow fit, responsive self-service, keyboard efficiency, localization, and accessible basics. |

## 10.2 Quality Scenarios

### Correctness And Auditability

- [QS-COR-001: Atomic Settlement](../../requirements/quality-scenarios/QS-COR-001-atomic-settlement.md)
- [QS-COR-002: Exact Balance](../../requirements/quality-scenarios/QS-COR-002-exact-balance.md)
- [QS-COR-003: Audited Correction](../../requirements/quality-scenarios/QS-COR-003-audited-correction.md)
- [QS-COR-004: Idempotent Account Transaction](../../requirements/quality-scenarios/QS-COR-004-idempotent-account-transaction.md)

### Security And Privacy

- [QS-SEC-001: Consumer Isolation](../../requirements/quality-scenarios/QS-SEC-001-consumer-isolation.md)
- [QS-SEC-002: Privileged MFA](../../requirements/quality-scenarios/QS-SEC-002-privileged-mfa.md)
- [QS-SEC-003: Transport Boundary](../../requirements/quality-scenarios/QS-SEC-003-transport-boundary.md)
- [QS-SEC-004: Pseudonymization](../../requirements/quality-scenarios/QS-SEC-004-pseudonymization.md)
- [QS-SEC-005: Anonymous Treasurer Aggregates](../../requirements/quality-scenarios/QS-SEC-005-anonymous-treasurer-aggregates.md)

### Operability

- [QS-OPS-001: Reproducible Installation](../../requirements/quality-scenarios/QS-OPS-001-reproducible-installation.md)
- [QS-OPS-002: Provider-Neutral Integration](../../requirements/quality-scenarios/QS-OPS-002-provider-neutral-integration.md)
- [QS-OPS-003: Portable Recovery](../../requirements/quality-scenarios/QS-OPS-003-portable-recovery.md)

### Maintainability And Extensibility

- [QS-MNT-001: Organizational Units And Coordinated Ordering](../../requirements/quality-scenarios/QS-MNT-001-organizational-units-and-coordinated-ordering.md)
- [QS-MNT-002: Mobile Manager Workflows](../../requirements/quality-scenarios/QS-MNT-002-mobile-manager-workflows.md)
- [QS-MNT-003: Increase Supported Tally Products](../../requirements/quality-scenarios/QS-MNT-003-increase-supported-tally-products.md)

### Usability And Accessibility

- [QS-USA-001: Consumer Device And Language](../../requirements/quality-scenarios/QS-USA-001-consumer-device-and-language.md)
- [QS-USA-002: Settlement Entry](../../requirements/quality-scenarios/QS-USA-002-settlement-entry.md)
- [QS-USA-003: Accessibility Baseline](../../requirements/quality-scenarios/QS-USA-003-accessibility-baseline.md)
- [QS-USA-004: Printable Tally Legibility](../../requirements/quality-scenarios/QS-USA-004-printable-tally-legibility.md)

The derived [Open Question Index](../../requirements/open-questions.md) links the authoritative
individual records for unresolved quality targets and acceptance blockers. Arc42 does not accept or
complete a quality scenario by summarizing it here.
