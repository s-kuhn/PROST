---
id: QS-COR-001
title: Atomic Settlement
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by: []
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-COR-001: Atomic Settlement

- Source: Organization Manager.
- Stimulus: Confirms a valid Settlement preview.
- Environment: Normal operation, including retried client requests.
- Response: PROST applies every displayed Consumer charge, Unallocated Consumption record, state
  transition, and audit record as one logical operation.
- Measure: The Settlement is applied exactly once; no observable partial state or duplicate
  financial effect exists after success or failure.
