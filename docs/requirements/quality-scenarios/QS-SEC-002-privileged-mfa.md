---
id: QS-SEC-002
title: Privileged MFA
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by:
  - OQ-004
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-SEC-002: Privileged MFA

- Source: Prospective first Organization Manager or user with Organization Manager or Treasurer
  role.
- Stimulus: Requests initial-manager bootstrap or attempts Organization-wide privileged access.
- Environment: Local identity or configured OIDC path.
- Response: PROST accepts access only when the authentication context satisfies the accepted MFA
  policy.
- Measure: Password-only or otherwise insufficient sessions cannot invoke privileged operations or
  aggregate views.
