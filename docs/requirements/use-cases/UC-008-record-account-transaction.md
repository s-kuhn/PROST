---
id: UC-008
title: Record Account Transaction
status: draft
source: Product-owner interview on 2026-07-26
---

# UC-008: Record Account Transaction

## Goal

An Organization Manager manually records money received, money returned, or a justified balance
adjustment.

## Primary Actor

Organization Manager

## Transaction Types

- Deposit: money received from a Consumer.
- Refund: money returned to a Consumer.
- Adjustment: a justified non-payment correction that is not a Settlement count correction.

## Main Flow

1. The manager opens a Consumer account.
2. The manager chooses a transaction type and provides a positive, nonzero amount magnitude and
   effective date.
3. Deposit credits the amount, Refund debits the amount, and Adjustment requires the manager to
   choose credit or debit explicitly.
4. The manager may provide payment method, external reference, and free-text comment.
5. For an Adjustment, the manager provides a reason.
6. PROST previews the old and resulting balance.
7. The manager confirms.
8. PROST records the Account Transaction exactly once, records actor, timestamp, and audit data, and
   reevaluates debt suspension.

## Alternatives

- The manager may record an entry on their own Consumer account; PROST highlights this fact.
- An incorrect Account Transaction may be edited through an audited revision rather than silently
  overwritten.
- A repeated confirmation or retry cannot create a duplicate Account Transaction.
- A correction based on a stale revision is rejected and must be reviewed again.

## Business Rules

- [BR-004](../business-rules/BR-004-settlement-and-corrections.md)
- [BR-005](../business-rules/BR-005-balance-and-suspension.md)

## Quality Scenarios

- `QS-COR-002`
- `QS-COR-004`

## Acceptance Criteria

1. A positive, nonzero amount magnitude and effective date are required; transaction type determines
   whether the account is credited or debited.
2. Money uses exact EUR-cent precision.
3. Payment method, reference, and comment are optional.
4. Actor and system timestamp cannot be supplied by the manager.
5. The Consumer can see the entry and any later revisions.
6. Automatic suspension or reactivation follows the resulting balance.
7. Retry after an ambiguous response cannot duplicate the financial effect.
8. Revision history and effective balance remain consistent after correction.

## Open Questions

- Which structured payment methods are initially offered?
- May future-dated entries be recorded?
- Are direct-edit revisions or explicit void-and-replace records preferred as the persistence model?
  The user-visible behavior and audit outcome remain the same.
