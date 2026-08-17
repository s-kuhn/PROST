---
id: QS-COR-002
title: Exact Balance
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by: []
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-COR-002: Exact Balance

- Source: Any balance-changing use case.
- Stimulus: Posts or revises a charge, Deposit, Refund, or Adjustment.
- Environment: Any supported deployment.
- Response: PROST derives the Consumer balance using exact EUR-cent arithmetic.
- Measure: The displayed balance equals the exact sum of effective account entries without
  floating-point rounding drift.
