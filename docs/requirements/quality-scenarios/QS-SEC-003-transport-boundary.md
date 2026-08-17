---
id: QS-SEC-003
title: Transport Boundary
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by: []
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-SEC-003: Transport Boundary

- Source: Deployment Operator.
- Stimulus: Configures a public or private deployment.
- Environment: Production installation.
- Response: Public mode requires HTTPS. Private HTTP requires explicit insecure opt-in and
  persistent warnings; it cannot be enabled accidentally by a default public configuration.
- Measure: Deployment verification distinguishes and tests both modes. Exact technical controls
  remain an architecture decision.
