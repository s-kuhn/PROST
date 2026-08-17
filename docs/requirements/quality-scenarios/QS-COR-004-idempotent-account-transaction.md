---
id: QS-COR-004
title: Idempotent Account Transaction
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by: []
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-COR-004: Idempotent Account Transaction

- Source: Organization Manager or retrying browser client.
- Stimulus: Confirms a Deposit, Refund, Adjustment, or revision and repeats the request after an
  ambiguous response.
- Environment: Normal operation or temporary communication failure.
- Response: PROST applies the intended financial effect at most once and returns the existing result
  for a recognized retry.
- Measure: Repeated equivalent confirmation cannot create an additional effective Account
  Transaction; stale revisions are rejected before balance changes.
