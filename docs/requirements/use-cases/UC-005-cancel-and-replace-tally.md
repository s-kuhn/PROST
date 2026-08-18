---
id: UC-005
title: Cancel And Replace Tally
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
source: Product-owner interview on 2026-07-26
---

# UC-005: Cancel And Replace Tally

## Goal

An Organization Manager supersedes an incorrect, unused, damaged, or lost physical Tally without
creating unsupported Consumer charges.

## Primary Actor

Organization Manager

## Preconditions

- An Issued Tally or Settlement Draft exists.
- The Tally has not been Settled.

## Main Flow

1. The manager selects cancellation.
2. PROST explains that cancellation has no financial effect and cannot recover lost marks.
3. The manager enters a reason and confirms whether the sheet may already contain marks.
4. PROST records actor, timestamp, reason, and warning confirmation.
5. PROST marks the Tally Canceled and releases price and issuance locks.
6. The manager may correct configuration, preview, and issue a replacement
   through [UC-004](UC-004-preview-and-issue-tally.md).

## Business Rules

- [BR-002](../business-rules/BR-002-tally-lifecycle.md)
- [BR-003](../business-rules/BR-003-product-pricing.md)

## Acceptance Criteria

1. Cancellation cannot create, change, or reverse a Consumer balance.
2. Cancellation requires an explicit data-loss warning when the manager confirms that the physical
   sheet was posted.
3. A Canceled Tally cannot be settled.
4. The cancellation remains auditable.
5. Existing marks must be copied by humans if they are to appear on a replacement.

## Open Questions

- See [OQ-019](../open-questions/OQ-019-physical-posting-record.md) for posted-state recording and
  cancellation confirmation.
- See [OQ-035](../open-questions/OQ-035-cancellation-reason.md) for a structured cancellation
  reason.
