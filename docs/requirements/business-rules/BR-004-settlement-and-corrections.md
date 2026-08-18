---
id: BR-004
title: Settlement And Corrections
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
source: Product-owner interviews on 2026-07-26 and 2026-08-03
---

# BR-004: Settlement And Corrections

## Settlement Rules

1. A Settlement Draft has no effect on balances.
2. Exactly one Organization Manager may edit a Settlement Draft at a time.
3. The Settlement Draft edit-lock inactivity duration is Organization configuration in whole
   minutes. It defaults to 15 minutes and may be configured from 1 through 1440 minutes, inclusive,
   by an Organization Manager.
4. An edit lock uses the configured inactivity duration current when the lock is acquired. A later
   configuration change does not affect that lock, including when qualifying interaction renews its
   inactivity interval.
5. An edit lock expires after its inactivity duration without a qualifying interaction. Qualifying
   interaction is the manager deliberately moving focus to or modifying an editable Settlement Draft
   field. Automatically assigned focus, merely displaying or scrolling the page, and pointer
   movement do not renew the lock.
6. While an edit lock is held and communication is available, PROST automatically preserves changed
   Settlement Draft field values without requiring an explicit save. Automatic preservation has no
   effect on balances and does not replace the last successful explicit-save checkpoint used when
   the manager deliberately leaves.
7. When an edit lock expires, its latest automatically preserved field values become the resumable
   Settlement Draft. The original editor or another Organization Manager may explicitly acquire a
   new lock and resume those values. PROST does not warn the editing manager before expiry, and
   takeover by a different Organization Manager is audited.
8. Deliberately leaving the Settlement Draft after a successful explicit save releases the edit lock
   immediately.
9. Attempting a detectable departure with changes made after the last successful explicit save
   presents a confirmation. If the manager confirms departure, PROST discards those changes,
   restores the explicit-save checkpoint, and releases the edit lock immediately. If the manager
   remains, PROST preserves the changes and does not release a nonexpired lock. For a newly started
   draft with no explicit save, confirmed departure leaves none of the entered field values.
10. If communication is interrupted without a confirmed departure, PROST retains the latest field
    values it successfully received. When the lock expires, those values become the resumable
    Settlement Draft.
11. Settling or canceling the Tally releases its edit lock.
12. Final confirmation presents itemized Consumer charges, unallocated consumption, and totals.
13. Posting is atomic: either all resulting account effects are applied exactly once or none are.
14. Counts are nonnegative whole numbers.
15. Issued rows, handwritten mapped rows, and unallocated handwritten rows remain distinguishable.
16. A handwritten row with nonzero counts should be mapped to a registered Consumer when possible.
17. An unreadable or unresolved row is recorded as Unallocated Consumption with its transcribed
    label, Product counts, and reason; no Consumer is charged.

## Edit-Lock Acceptance Criteria

1. A new Organization uses a 15-minute inactivity duration until an Organization Manager changes it.
2. Configuration accepts the inclusive boundary values of 1 and 1440 minutes and rejects 0, 1441,
   fractional values, and values without a whole-minute interpretation.
3. Changing the configured duration while a lock is held does not alter that lock's expiry. The next
   acquired lock uses the changed duration.
4. For a selected duration, an unattended open Settlement Draft becomes eligible for explicit
   acquisition when that duration elapses, while qualifying interaction before expiry starts a new
   full inactivity interval using the duration fixed when the lock was acquired.
5. The manager deliberately moving focus to or changing an editable Settlement Draft field renews a
   nonexpired lock. Automatically assigned focus, displaying or scrolling the page, and pointer
   movement do not renew it.
6. With uninterrupted communication, values changed without an explicit save remain available after
   lock expiry and are presented when the original or another Organization Manager acquires a new
   lock.
7. After interrupted communication and lock expiry, the next editor receives the latest values PROST
   successfully received; values that PROST did not receive are not presented as preserved.
8. A manager who successfully saves and then leaves the Settlement Draft does not prevent another
   manager from acquiring its edit lock.
9. When a manager attempts a detectable departure with changes made after the last successful
   explicit save, choosing to remain preserves those changes. Confirming departure discards only
   those changes and permits another manager to acquire the edit lock. If no explicit save occurred
   for a newly started draft, confirming departure retains none of its entered field values.
10. No advance expiry warning is presented.

## Correction Rules

1. An Organization Manager may correct counts and Consumer mappings after Settlement.
2. Every correction requires a reason and records the actor and timestamp.
3. The audit history retains original and revised values.
4. Corrections update affected balances atomically and exactly once.
5. A previously unallocated row may later be mapped to a Consumer through a correction.
6. A Consumer can inspect revision details for changes to their own charges, including the
   responsible Organization Manager.
7. Printed Products and prices cannot be corrected; a separate Adjustment is required for a
   financial exception to the printed price.
8. Manual Account Transactions may be corrected through the same user-visible audited revision
   principles. The exact correctable fields and user-visible revision semantics remain blocked by
   [OQ-026](../open-questions/OQ-026-transaction-correction-semantics.md).
9. A correction based on a stale Settlement or Account Transaction revision is rejected rather than
   overwriting a newer revision.
10. Retrying a correction cannot duplicate its financial effect.

## Open Questions

- See [OQ-006](../open-questions/OQ-006-retention-rules.md) for audit-history retention after
  pseudonymization.
- See [OQ-027](../open-questions/OQ-027-correction-limits.md) for the correction horizon.
- See [OQ-010](../open-questions/OQ-010-settlement-draft-connectivity.md) for interrupted Settlement
  Draft behavior.
- See the resolved [OQ-013](../open-questions/OQ-013-settings-effective-time.md) for settings
  effective-time traceability.
- See [OQ-025](../open-questions/OQ-025-settlement-effective-date.md) for the Settlement effective
  date.
