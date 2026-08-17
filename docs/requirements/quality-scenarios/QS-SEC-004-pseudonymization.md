---
id: QS-SEC-004
title: Pseudonymization
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by:
  - OQ-003
  - OQ-006
  - OQ-007
  - OQ-036
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-SEC-004: Pseudonymization

- Source: Zero-balance Inactive Consumer.
- Stimulus: Requests pseudonymization.
- Environment: Normal operation with existing financial and audit records.
- Response: PROST irreversibly removes or unlinks direct profile and login identifiers, changes the
  Consumer to Pseudonymized, and retains non-identifying records required for consistency.
- Measure: The former Consumer cannot authenticate. Ordinary-view, historical Tally, and backup
  treatment must satisfy the policies resolved through `OQ-003`, `OQ-006`, and `OQ-007` before this
  scenario is acceptance-ready.
