---
id: BR-002
title: Tally Lifecycle
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
source: Product-owner interviews on 2026-07-26, 2026-07-29, and 2026-08-03
---

# BR-002: Tally Lifecycle

## States

| State              | Meaning                                                                                    |
|--------------------|--------------------------------------------------------------------------------------------|
| `Issued`           | The Organization Manager confirmed a preview and PROST fixed the printable Tally Snapshot. |
| `Settlement Draft` | A manager is transcribing marks; balances are not yet affected.                            |
| `Settled`          | The confirmed Settlement has atomically affected Consumer accounts.                        |
| `Cancelled`        | A manager superseded the Tally without applying charges and supplied an audit reason.      |

Preview is not a Tally state and has no business effect.

## Invariants

1. At most one Tally may be Issued or in Settlement Draft for an Organization.
2. Issuance stores the Organization title, instruction and contact text, registration destination,
   optional payment-link label and destination, QR-code content and placement, Consumer rows, Product
   display names, prices, ordering, width weights, layout profile, and generation timestamp that appear
   on paper.
3. An Issued Tally has no planned end date and may remain open indefinitely.
4. The printed `Generated at` value is fixed when the confirmed preview is rendered. The internal
   `Issued at` value records when the Organization Manager confirms that preview and is not printed.
5. The final PDF for an Issued Tally may be downloaded again without creating another Tally.
6. A Tally may be canceled whether or not it was physically posted, but cancellation requires a
   reason, confirmation, actor, and timestamp.
7. Cancellation has no financial effect. Transferring surviving marks to a replacement is a human
   responsibility.
8. A replacement is a new Tally with a new snapshot.
9. A Settled or Canceled Tally cannot be settled again.
10. The system cannot recover marks from a lost physical sheet; that loss must remain explicit rather
    than generating estimated Consumer charges.
11. While a Tally is Issued or in Settlement Draft, changes to the Organization display title,
    printed Tally instruction and contact text, and Payment Link label or destination become current
    Organization configuration immediately but do not alter that Tally Snapshot or its final PDF.
    The changed values are first reflected in the next Tally preview.

## Open Questions

- See `OQ-019` for recording whether a Tally was physically posted and its cancellation effect.
