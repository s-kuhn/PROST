---
id: BR-004
title: Settlement And Corrections
status: draft
source: Product-owner interview on 2026-07-26
---

# BR-004: Settlement And Corrections

## Settlement Rules

1. A Settlement Draft has no effect on balances.
2. Exactly one Organization Manager may edit a Settlement Draft at a time.
3. An inactive edit lock expires after a configured duration; takeover is explicit and audited.
4. Final confirmation presents itemized Consumer charges, unallocated consumption, and totals.
5. Posting is atomic: either all resulting account effects are applied exactly once or none are.
6. Counts are nonnegative whole numbers.
7. Issued rows, handwritten mapped rows, and unallocated handwritten rows remain distinguishable.
8. A handwritten row with nonzero counts should be mapped to a registered Consumer when possible.
9. An unreadable or unresolved row is recorded as Unallocated Consumption with its transcribed
   label, Product counts, and reason; no Consumer is charged.

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
   principles. Current ambiguity: The draft does not identify exactly which fields may be corrected,
   such as amount, effective date, transaction type, reference, or comment.
9. A correction based on a stale Settlement or Account Transaction revision is rejected rather than
   overwriting a newer revision.
10. Retrying a correction cannot duplicate its financial effect.

## Open Questions

- How long is audit history retained after account pseudonymization?
- May a correction be corrected without limit, or should old Settlements eventually close
  permanently?
