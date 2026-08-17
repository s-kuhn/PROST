---
id: QS-SEC-001
title: Consumer Isolation
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by: []
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-SEC-001: Consumer Isolation

- Source: Authenticated Consumer or malicious browser client.
- Stimulus: Requests another Consumer's profile, balance, transaction, or correction resource.
- Environment: UI and direct API access.
- Response: PROST denies access without disclosing protected content.
- Measure: Automated authorization tests cover every Consumer-data operation and demonstrate
  ownership enforcement.
