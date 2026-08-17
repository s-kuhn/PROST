---
id: UC-006
title: Settle Tally
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
source: Product-owner interviews on 2026-07-26 and 2026-08-03
---

# UC-006: Settle Tally

## Goal

An Organization Manager transcribes counted marks from the physical sheet and posts the resulting
Consumer charges exactly once.

## Primary Actor

Organization Manager

## Preconditions

- One Issued Tally or Settlement Draft exists.
- The manager has the physical sheet or a reliable manual count.

## Main Flow

1. The manager starts or resumes a Settlement Draft.
2. PROST acquires the single-editor lock.
3. PROST displays issued Consumer rows and Products exactly as printed, plus a separate Pending
   Approval section.
4. The manager enters nonnegative whole-number counts using the keyboard-oriented matrix.
5. The manager maps handwritten rows to registered Consumers when possible.
6. Mapping a Pending Approval Consumer confirms approval; the resulting balance determines whether
   they become Active or Suspended for the next Tally.
7. PROST warns but permits mapping a Suspended or Inactive Consumer without changing that state.
8. The manager records unresolved handwritten rows as distinct Unallocated Consumption with label,
   counts, and reason.
9. PROST automatically preserves entered field values while communication is available. The manager
   may explicitly save a checkpoint and resume the draft as needed.
10. PROST presents itemized Consumer charges, unallocated value, and totals.
11. The manager confirms.
12. PROST atomically posts all charges exactly once, applies automatic debt suspension, records
    audit metadata, and marks the Tally Settled.

## Alternatives

- An expired edit lock may be taken over explicitly; the takeover is audited.
- While a nonexpired lock is held, another manager receives a read-only view and cannot save stale
  counts.
- When the edit lock expires, the latest preserved values remain available for the next Organization
  Manager, including the original editor, who acquires a lock.
- Deliberately leaving after a successful explicit save releases the edit lock immediately.
- Attempting a detectable departure with changes made after the last successful explicit save
  presents a confirmation. Confirming departure restores that checkpoint and releases the edit lock;
  remaining preserves the changes. For a newly started draft without an explicit save, confirmed
  departure leaves none of its entered field values.
- After interrupted communication, the latest field values PROST successfully received remain
  available when the lock expires; values it did not receive cannot be preserved.
- Validation failures return to the draft without changing balances.
- The manager may cancel instead through [UC-005](UC-005-cancel-and-replace-tally.md).

## Business Rules

- [BR-001](../business-rules/BR-001-consumer-lifecycle.md)
- [BR-002](../business-rules/BR-002-tally-lifecycle.md)
- [BR-003](../business-rules/BR-003-product-pricing.md)
- [BR-004](../business-rules/BR-004-settlement-and-corrections.md)
- [BR-005](../business-rules/BR-005-balance-and-suspension.md)

## Quality Scenarios

- [QS-COR-001](../quality-scenarios/QS-COR-001-atomic-settlement.md)
- [QS-COR-002](../quality-scenarios/QS-COR-002-exact-balance.md)
- [QS-COR-003](../quality-scenarios/QS-COR-003-audited-correction.md)
- [QS-USA-002](../quality-scenarios/QS-USA-002-settlement-entry.md)

## Acceptance Criteria

1. Draft saves never change balances.
2. Product headers and Consumer names remain visible during large-table entry.
3. Posting either applies every previewed effect once or applies none.
4. A retry cannot duplicate charges.
5. Itemized charges use the printed price snapshot.
6. Issued, handwritten mapped, and unallocated rows remain distinguishable.
7. A manager cannot overwrite a Settlement Draft held by another manager or based on a newer
   revision.
8. Edit-lock configuration, inactivity, renewal, expiry, takeover, warning, and release behavior
   satisfies the observable criteria
   in [BR-004](../business-rules/BR-004-settlement-and-corrections.md).

## Open Questions

- See `OQ-025` for the Settlement effective date.
