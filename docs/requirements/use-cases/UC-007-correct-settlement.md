---
id: UC-007
title: Correct Settlement
status: draft
source: Product-owner interview on 2026-07-26
---

# UC-007: Correct Settlement

## Goal

An Organization Manager corrects a typo, miscount, or Consumer mapping while preserving a
transparent financial history.

## Primary Actor

Organization Manager

## Preconditions

- The Tally is Settled.

## Main Flow

1. The manager opens the Settled Tally and starts a correction.
2. PROST displays current counts and mappings together with immutable printed Products and prices.
3. The manager changes counts or Consumer mappings and enters a correction reason.
4. PROST previews the original values, revised values, balance deltas, and affected Consumers.
5. The manager confirms.
6. If the Settlement revision changed after preview, PROST rejects confirmation and requires a new
   review.
7. Otherwise, PROST applies all deltas atomically, reevaluates suspension, and records actor and
   timestamp.
8. Affected Consumers can inspect the original and corrected itemization, reason, time, and
   responsible manager.

## Alternatives

- An Unallocated Consumption row may be mapped to a Consumer who has since registered.
- A printed-price exception cannot modify the Tally Snapshot; the manager records a separate
  Adjustment through [UC-008](UC-008-record-account-transaction.md).

## Business Rules

- [BR-004](../business-rules/BR-004-settlement-and-corrections.md)
- [BR-005](../business-rules/BR-005-balance-and-suspension.md)

## Quality Scenarios

- `QS-COR-003`

## Acceptance Criteria

1. A correction cannot modify Product identity or printed unit price.
2. Every correction has a nonempty reason, actor, and timestamp.
3. Balance effects are applied exactly once and match the preview.
4. Original values remain available in audit history.
5. A manager correction to their own Consumer account is highlighted.
6. A correction based on a stale revision cannot overwrite a newer correction.

## Open Questions

- Whether corrections use locking or optimistic version checks is an architecture decision; stale
  changes must be rejected either way.
- Treasurer visibility depends on the anonymity policy in `OQ-002`.
