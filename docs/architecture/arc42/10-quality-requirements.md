# 10. Quality Requirements

Status: draft

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

#### QS-COR-001: Atomic Settlement

- Source: Organization Manager.
- Stimulus: Confirms a valid Settlement preview.
- Environment: Normal operation, including retried client requests.
- Response: PROST applies every displayed Consumer charge, Unallocated Consumption record, state
  transition, and audit record as one logical operation.
- Measure: The Settlement is applied exactly once; no observable partial state or duplicate
  financial effect exists after success or failure.

#### QS-COR-002: Exact Balance

- Source: Any balance-changing use case.
- Stimulus: Posts or revises a charge, Deposit, Refund, or Adjustment.
- Environment: Any supported deployment.
- Response: PROST derives the Consumer balance using exact EUR-cent arithmetic.
- Measure: The displayed balance equals the exact sum of effective account entries without
  floating-point rounding drift.

#### QS-COR-003: Audited Correction

- Source: Organization Manager.
- Stimulus: Corrects counts or mappings in a Settled Tally.
- Environment: Normal operation.
- Response: PROST records original and revised values, reason, actor, timestamp, and exact balance
  deltas.
- Measure: Managers and the affected Consumer can reconstruct the applicable revision history; the
  correction effect is applied exactly once.

#### QS-COR-004: Idempotent Account Transaction

- Source: Organization Manager or retrying browser client.
- Stimulus: Confirms a Deposit, Refund, Adjustment, or revision and repeats the request after an
  ambiguous response.
- Environment: Normal operation or temporary communication failure.
- Response: PROST applies the intended financial effect at most once and returns the existing result
  for a recognized retry.
- Measure: Repeated equivalent confirmation cannot create an additional effective Account
  Transaction; stale revisions are rejected before balance changes.

### Security And Privacy

#### QS-SEC-001: Consumer Isolation

- Source: Authenticated Consumer or malicious browser client.
- Stimulus: Requests another Consumer's profile, balance, transaction, or correction resource.
- Environment: UI and direct API access.
- Response: PROST denies access without disclosing protected content.
- Measure: Automated authorization tests cover every Consumer-data operation and demonstrate
  ownership enforcement.

#### QS-SEC-002: Privileged MFA

- Source: Prospective first Organization Manager or user with Organization Manager or Treasurer
  role.
- Stimulus: Requests initial-manager bootstrap or attempts Organization-wide privileged access.
- Environment: Local identity or configured OIDC path.
- Response: PROST accepts access only when the authentication context satisfies the accepted MFA
  policy.
- Measure: Password-only or otherwise insufficient sessions cannot invoke privileged operations or
  aggregate views.

#### QS-SEC-003: Transport Boundary

- Source: Deployment Operator.
- Stimulus: Configures a public or private deployment.
- Environment: Production installation.
- Response: Public mode requires HTTPS. Private HTTP requires explicit insecure opt-in and
  persistent warnings; it cannot be enabled accidentally by a default public configuration.
- Measure: Deployment verification distinguishes and tests both modes. Exact technical controls
  remain an architecture decision.

#### QS-SEC-004: Pseudonymization

- Source: Zero-balance Inactive Consumer.
- Stimulus: Requests pseudonymization.
- Environment: Normal operation with existing financial and audit records.
- Response: PROST irreversibly removes or unlinks direct profile and login identifiers, changes the
  Consumer to Pseudonymized, and retains non-identifying records required for consistency.
- Measure: The former Consumer cannot authenticate. Ordinary-view, historical Tally, and backup
  treatment must satisfy the policy accepted through `OQ-003`, `OQ-006`, and `OQ-007` before this
  scenario is acceptance-ready.

#### QS-SEC-005: Anonymous Treasurer Aggregates

- Source: Treasurer.
- Stimulus: Requests Organization-level financial or consumption totals.
- Environment: Any supported Organization size, including sparse cohorts and repeated observations.
- Response: PROST suppresses data that could identify an individual under the accepted cohort and
  differencing policy.
- Measure: No aggregate is returned unless it satisfies the policy resolved through `OQ-002`; this
  scenario is not acceptance-ready until that policy is defined.

### Operability

#### QS-OPS-001: Reproducible Installation

- Source: Volunteer Deployment Operator.
- Stimulus: Installs PROST on a prepared Linux host with required DNS and SMTP access.
- Environment: Documented supported configuration.
- Response: The operator configures public URLs and secrets, starts the system, and verifies health.
  After a prospective manager has completed registration, email verification, profile completion,
  and privileged-MFA enrollment, the operator completes `UC-013` without editing application source
  or directly modifying application data.
- Measure: Approximately 60 minutes is an adjustable target measured with pilot evidence, not a
  release gate; failures provide actionable diagnostics.
- Detailed
  requirement: [UC-013: Bootstrap First Organization Manager](../../requirements/use-cases/UC-013-bootstrap-first-organization-manager.md).

#### QS-OPS-002: Provider-Neutral Integration

- Source: Deployment Operator.
- Stimulus: Selects local identity, an external OIDC provider, an SMTP service, or a payment URL.
- Environment: Initial setup or reconfiguration.
- Response: PROST uses documented standard integration points without institution-specific source
  changes.
- Measure: No mandatory university or commercial provider appears in the core product contract.

#### QS-OPS-003: Portable Recovery

- Source: Deployment Operator.
- Stimulus: Restores a valid backup to a clean supported host after failure.
- Environment: Original host unavailable; operator has required configuration and secrets.
- Response: Documented commands validate and restore consistent application and bundled identity
  state, including the initial-manager bootstrap state defined by
  [UC-013](../../requirements/use-cases/UC-013-bootstrap-first-organization-manager.md), and
  documentation identifies the artifact as sensitive data requiring protected storage.
- Measure: A corrupted or incomplete artifact is rejected before destructive restore, and same-day
  restoration is achievable in a rehearsed supported setup. Operator-selected backup schedules
  determine possible data loss. Privacy reconciliation after restoring older data remains blocked by
  `OQ-007`.

### Maintainability And Extensibility

#### QS-MNT-001: Organizational Units And Coordinated Ordering

- Source: Product Owner.
- Stimulus: Adds Organizational Units whose coordinators submit order needs for consolidation by an
  Organization-level coordinator.
- Environment: Post-MVP evolution.
- Response: The architecture can introduce scoped products, roles, and procurement workflows without
  rewriting the established Tally and account invariants.
- Measure: A future ADR must identify bounded changes and migrations before implementation; a
  quantitative effort limit remains open.

#### QS-MNT-002: Mobile Manager Workflows

- Source: Product Owner.
- Stimulus: Extends manager workflows from desktop to tablet and phone.
- Environment: Post-MVP frontend evolution.
- Response: Domain and application contracts remain usable without changing financial rules or
  duplicating business logic in a client.
- Measure: No quantitative effort target is accepted; architecture evaluation must compare client
  coupling explicitly.

#### QS-MNT-003: Increase Supported Tally Products

- Source: Product Owner.
- Stimulus: Increases the supported number of active paper-Tally Products beyond five or introduces
  a digital point-of-consumption terminal.
- Environment: Post-MVP evolution.
- Response: Settlement and account rules continue to operate on a variable Product collection
  without assuming the MVP limit or duplicating financial logic.
- Measure: The change may replace or extend the presentation workflow but does not require rewriting
  accepted Product-pricing, Settlement, or balance invariants.

### Usability And Accessibility

#### QS-USA-001: Consumer Device And Language

- Source: Consumer.
- Stimulus: Registers or views account information on a supported mobile or desktop browser.
- Environment: German or English preference.
- Response: The interface uses the saved preference, otherwise a supported browser locale, otherwise
  German.
- Measure: All Consumer MVP flows work at supported mobile and desktop viewport sizes in both
  languages.

#### QS-USA-002: Settlement Entry

- Source: Organization Manager.
- Stimulus: Enters counts for up to 50 Consumers and 5 Products.
- Environment: Supported desktop browser.
- Response: Sticky headings, empty zero values, keyboard navigation, validation, draft save, and
  mouse input preserve context and prevent lost work.
- Measure: Acceptance tests demonstrate complete keyboard operation and lock/takeover behavior. No
  completion-time target is accepted.

#### QS-USA-003: Accessibility Baseline

- Source: Keyboard or assistive-technology user.
- Stimulus: Uses an MVP workflow.
- Environment: Supported browser.
- Response: Controls have semantic labels, visible focus, keyboard access, adequate contrast, and no
  color-only meaning.
- Measure: These criteria are reviewed and tested for critical flows. PROST does not claim formal
  WCAG conformance in the MVP.

#### QS-USA-004: Printable Tally Legibility

- Source: Organization Manager.
- Stimulus: Previews a Tally containing up to 50 Consumers and 5 active Products with relative width
  weights.
- Environment: A3 landscape output.
- Response: PROST applies the physical layout baseline in
  [BR-006](../../requirements/business-rules/BR-006-product-lifecycle.md), wraps complete Product
  names, shrinks Product headings from 12 pt to no less than 10 pt, keeps the complete repeated
  grid-heading row between 8.5 mm and 25.5 mm, repeats headings on vertical pages, preserves the 6
  mm page margins, 8.5 mm minimum row height, 51 mm Tally Name column, and 17 mm minimum
  Product-column width, keeps all Product columns together, and places labeled registration and
  optional payment QR codes in a dedicated first-page area outside the Tally grid.
- Measure: Except for a non-layout preview indicator, preview and final A3 landscape PDF have
  identical printable content and layout. Issuance is blocked outside the one-to-five active Product
  range, when a Product column would be narrower than 17 mm, or when complete headers cannot fit at
  10 pt within 25.5 mm without clipping or overlap. The Organization Manager confirms practical
  marking space. Each QR code, including its quiet zone, is at least 35 mm square, and its decoded
  payload is no more than 200 bytes. Before a layout profile is used, and after a relevant QR or
  informational-area change, both QR positions are qualified with valid 200-byte HTTPS payloads that
  require QR byte-mode encoding throughout. When printed at actual A3 size in monochrome on plain
  paper at 300 dpi or better, under 300-500 lux illumination and at a distance of 30-50 cm, each
  qualification QR decodes within three seconds in three consecutive attempts on each of one Android
  and one iOS device receiving vendor security updates. A failed qualification prevents use of the
  layout profile. Version-linked evidence records the fixture, environment, devices, attempts, and
  results and demonstrates that only a passing profile is available for issuance.

## Open Quality Questions

- Browser versions and support duration.
- Availability and planned-downtime expectations.
- Minimum host resources and supported CPU architectures.
- Quantitative maintainability targets for future change scenarios.
- Audit and security-log retention periods.
