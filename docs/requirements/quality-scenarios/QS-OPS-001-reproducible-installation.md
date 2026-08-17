---
id: QS-OPS-001
title: Reproducible Installation
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by:
  - OQ-004
  - OQ-014
  - OQ-015
  - OQ-039
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-OPS-001: Reproducible Installation

- Source: Volunteer Deployment Operator.
- Stimulus: Installs PROST on a prepared Linux host with required DNS and SMTP access.
- Environment: Documented supported configuration.
- Response: The operator configures public URLs and secrets, starts the system, and verifies health.
  After a prospective manager has completed registration, email verification, profile completion,
  and privileged-MFA enrollment, the operator completes
  [UC-013](../use-cases/UC-013-bootstrap-first-organization-manager.md) without editing application
  source or directly modifying application data.
- Measure: Approximately 60 minutes is an adjustable target measured with pilot evidence, not a
  release gate; failures provide actionable diagnostics.
