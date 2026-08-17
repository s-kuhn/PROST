---
id: QS-SEC-005
title: Anonymous Treasurer Aggregates
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by:
  - OQ-002
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-SEC-005: Anonymous Treasurer Aggregates

- Source: Treasurer.
- Stimulus: Requests Organization-level financial or consumption totals.
- Environment: Any supported Organization size, including sparse cohorts and repeated observations.
- Response: PROST suppresses data that could identify an individual under the accepted cohort and
  differencing policy.
- Measure: No aggregate is returned unless it satisfies the policy resolved through `OQ-002`; this
  scenario is not acceptance-ready until that policy is defined.
