---
id: QS-OPS-003
title: Portable Recovery
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by:
  - OQ-006
  - OQ-007
  - OQ-038
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-OPS-003: Portable Recovery

- Source: Deployment Operator.
- Stimulus: Restores a valid backup to a clean supported host after failure.
- Environment: Original host unavailable; operator has required configuration and secrets.
- Response: Documented commands validate and restore consistent application and bundled identity
  state, including the initial-manager bootstrap state defined by
  [UC-013](../use-cases/UC-013-bootstrap-first-organization-manager.md), and documentation identifies
  the artifact as sensitive data requiring protected storage.
- Measure: A corrupted or incomplete artifact is rejected before destructive restore, and same-day
  restoration is achievable in a rehearsed supported setup. Operator-selected backup schedules
  determine possible data loss. Privacy reconciliation after restoring older data remains blocked by
  `OQ-007`.
