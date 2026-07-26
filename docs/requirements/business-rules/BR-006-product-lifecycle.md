---
id: BR-006
title: Product Lifecycle
status: draft
source: Product-owner interview on 2026-07-26
---

# BR-006: Product Lifecycle

## Rules

1. A Product has a display name, EUR price, active state, positive relative column-width weight, and
   manager-defined print position.
2. A newly created Product is appended to the current print order.
3. An unused Product created by mistake may be deleted.
4. A Product that has appeared on an Issued Tally cannot be deleted.
5. A used Product may be renamed, deactivated, and later reactivated.
6. Renaming or other catalog changes do not alter historical Tally Snapshots.
7. Only active Products appear on a newly issued Tally.
8. All Products remain on the same horizontal page; product headers may wrap across lines.
9. Relative width weights divide the available marking area. Preview must expose an illegible
   configuration before issuance.

## Open Questions

- What minimum physical marking width is legible?
- What Product-name length is supported before preview must reject issuance?
